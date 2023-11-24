# :construction: README em construção ! :construction:
# 🏛️ Museum Finder API
A museum search API developed as a [Trybe](https://www.betrybe.com) Project.

## 💻 About this project
This is a Java built-in museum search API using Spring framework. The API has endpoints that allow the users to: register new museums, search museums by id or search museums by coordinates and max distance (km). The available endpoints are listed in a section below.


## 🛠️ Built with
<a href="https://www.java.com/en/download/help/whatis_java.html" target="_blank" rel="noreferrer"><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" /></a>
<a href="https://spring.io/quickstart" target="_blank" rel="noreferrer"><img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring" /></a>

## 🎯 Used skills
- Spring Boot;
- Spring Actuator;
- RESTful API development;
- Controller and service layers architecture;
- Java Exceptions handling;
- Tests with JUnit 5 and Spring Boot Test;
- App dockerization.

## 🏁 Getting started
### 🐋 Installing Docker
As the project is containerized, to run the application you will need to install Docker. The Docker version used in this project was 24.0.7. You can see [here](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04) how to install it.


### 🖼️ Creating Docker image
In project root terminal, run:
```
docker build -t museum-finder-image .
```

### 📦🏃‍♀ Creating Docker container and running the application
In project root terminal, run:
```
docker run -p 8080:8080 --name museum-finder-container museum-finder-image
```
Once the container is created (or after starting the container), the application will start running automatically, unless the port 8080 is already in use. You can start the container with `docker start museum-finder-container` after stopping the process using the port 8080.

## 🛣️ Available endpoints
To use the API services you will can use a web browser or a client for APIs testing, like [Thunder Client](https://www.thunderclient.com) or [Insomnia](https://insomnia.rest/download).
The API endpoints are listed in the table below, as well as some examples of request body before the table.

## 🧪 Testing
