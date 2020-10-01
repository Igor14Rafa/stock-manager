# Requirements
Docker, Maven, Java (>=8)

# How to run

In the stock-manager folder, run 

```bash
mvnw package && java -jar target/stock-manager.jar
```
If you don't have the maven installed, go [here](https://maven.apache.org/install.html).
After this, you need to create the docker image

```bash
docker build -t igorrafa/stock-manager .
```

You can change the image's name, but you must change it in the Dockerfile and docker-compose.yml as well.

# Usage
With all the images created (the [stock-quote-manager](https://github.com/Igor14Rafa/stock-quote-manager) must be created as well), run
```bash
docker-compose up
```
## License
[MIT](https://choosealicense.com/licenses/mit/)
