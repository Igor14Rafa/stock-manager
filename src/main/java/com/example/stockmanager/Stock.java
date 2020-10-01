package com.example.stockmanager;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Stock {
    @Id
    private String id;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
