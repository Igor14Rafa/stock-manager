package com.example.stockmanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    private List<Host> hosts = new ArrayList<Host>();
    private RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void init(){
        Stock aux = new Stock();
        Stock aux2 = new Stock();
        aux.setId("PETR3");
        aux.setDescription("petr3 test");
        aux2.setId("VALE5");
        aux2.setDescription("vale5 test");
        stockRepository.save(aux);
        stockRepository.save(aux2);
    }

    @PostMapping(path="/stock")
    public @ResponseBody String addNewQuote (@RequestParam String id
            , @RequestParam String description) {
        Stock n = new Stock();
        n.setId(id);
        n.setDescription(description);
        stockRepository.save(n);

        for(Host i: hosts){
            String url = "http://" + i.getHost()
                    + ':' + i.getPort().toString() + "/stockcache";
            restTemplate.delete(url);
        }

        return "Stock " + n.getId() + " created!";
    }

    @GetMapping(path="/stock")
    public @ResponseBody Iterable<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @PostMapping(path="/notification")
    public @ResponseBody String addNotification(@RequestParam String host
            , @RequestParam String port) {
        Host aux = new Host(host, port);
        hosts.add(aux);
        return "Host " + aux.getHost() + " added to notification list!";
    }
}
