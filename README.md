# Todeb-Patika-Java-Spring-bootcamp-Credit-Application-Project
## Features

This application has three controllers.
1. CustomerController
2. CreditApplicationController
3. OneTimeTokenController

REST end-point that provides credit-application information.
* GET /customers/search?identityNumber={identityNumber}

## Technologies used

1. Java (Programming Language)
2. Spring Boot (Application Platform)
3. Spring Data JPA (Data persistence)
4. Hibernate
5. PostgreSQL
6. Swagger
7. JUnit, Mockito (Unit Testing)


## Getting Started

The source code can be checked out to your local and then build and run the application either from your IDE after importing to it as a maven project, or just from a command line. Follow these steps for the command-line option:  

### Prerequisites
1. Java 11
2. Maven 4
3. Git
4. PostgreSQL


### Installing & Running

#### Clone this repo into your local: 
	
```
git clone https://github.com/ibrahimkapici/Todeb-Patika-Java-Spring-bootcamp-Credit-Application-Project.git
```

####  Build using maven 
	
```
mvn clean install
```
	
#### Start the app
	
```
mvn spring-boot:run
```
	
#### Access the Home screen

The application will be available at the URL: [Home](http://localhost:8080).

    
## API Documentation

API documentation can be accessed via [Swagger UI](http://localhost:8080/swagger-ui.html) 

Postman Collection
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/ac5e849a2ff2122ad5c1?action=collection%2Fimport)
