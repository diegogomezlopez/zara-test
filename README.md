# ZARA PRICES SERVICE Web Application
Zara Prices Service Web REST application.

### Dependencies

* [SpringBoot](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* [Lombok](https://projectlombok.org/) - Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
* [H2](https://www.h2database.com/html/main.html) - In memory database.
* [Maven](https://maven.apache.org/) - Apache tool for project management.

### Testing

Testing tools and frameworks:

* [JUnit5](https://junit.org/junit5/) - JUnit5 framework for unit testing.
* [Mockito](https://site.mockito.org/) - For mocking classes.
* [REST-Assured](https://rest-assured.io/) - Testing and validating REST services in Java.

For testing the REST API with REST-Assured you need to have running the service or the connection will fail.

### Installation

In order to run this web application you need JDK version 11+ and Maven version 3.2+

```sh
$ mvn clean install
```