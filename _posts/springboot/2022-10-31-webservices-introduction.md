---
title:  "Introduction to Web Services"
date:   2022-10-28 17:26:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---

## overview

* **Web Service** if we say it service delivered over the web the answer is partial no because even with the html we can make simple web page with some elements like buttons login pages etc but html is not for application to application interaction.
* So **Web Service** is the software system designed to support interoperable(exchangable) machine-to-machine interaction over a network.
* if HTML uses the bussiness logic and data to show the response over the web its becomes interactive application.
* webservice should be able to  call from diff diff applications(Java, Python, PHP, etc..)

* 3 rules which makes a web service
* 1) Designed for machine-to-machine(app-to-app) interaction.
* 2) Interoperable (platform independent) --> Accepts applications build using any technologies. s/w that can run on variety of h/w platforms or s/w architectures is called as platform independent. EX: java can be executed on eclipse, intellij and used in springboot framework and microservices.
* 3) Allow Communication over network --> should be deployed over internet or some other system and should be able to interact with application.

* Requests and Responses should be platform independent to achieve webservice. Two popular data exchange platforms are 
* 1) XML(Extensible markup language) --> XML is a s/w and h/w independent tool for storing and transporting data.
* 2) JSON (JavaScript Object Notation) --> JSON is a text format for storing and transporting data. Object notation (key-value pair).

* Application should send request and when it gets response from website it should be able to process the response.
* Application will know that the request  to be sent and what response it receives by **Service Defination**
* Service defination defines about what is request/response format, request structure, response structre, EndPoint.

### Key Terminology
* request and response
* message exchange format --> xml & json
* service provider or server --> web service
* service consumwr or client --> application which uses web service
* service defination
* transport --> HTTP & MQ --> which are exposed over web

### Web Service Groups
* 1) SOAP (Simple Object Access Protocol) 
* In SOAP we use xml for information or data exchange, MQ & HTTP for transport of service, WSDL(web service defination language) for service defination.

* 2) RESTful web service (REpresentational state Transfer)
* In RESTful web service we use json for information or data exchange, only HTTP for transport of service, WSDL, Swagger, Eureka etc for service defination.
* makes use of http methods (GET, POST, PUT, DELETE)
* **GET** --> No request body (gets the data)
* **POST** --> Request Body (creates the data)
* **PUT** --> Request Body (updates the data)
* **DELETE** --> Request Body (deletes the data)
* Http status codes (200 Ok, 400 Bad Request, 400 Bad Request, 401 Unauthorized, 404 Not Found, 406 Not Acceptable,  500 Internal Server Error etc..)