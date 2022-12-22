---
title:  "Microservices-V2"
date:   2022-12-22 17:22:00
categories: ['Microservices']
tags: ['Microservices']
---
{% include toc title="Index" %}

## overview
### Microservices V2 - NEW features
* Microservices Evolve Quickly. 
* Important Updates:
* Latest versions of Spring Boot and Spring Cloud
  * Spring cloud LoadBalancer instead of Ribbon
  * Spring cloud Gateway instead of Zuul
  * Resilience4j instead of Hystix
* Docker: Containerize Microservices
  * Run microservices using Docker and Docker Compose
* Kubernetes: Orchestrate(coordinate ) all your Microservices with Kubernetes

## What Is Zuul Api Gateway In Microservices
1. Zuul is an API gateway for microservices.
   An API gateway is a server that acts as a single point of entry for a set of microservices. Zuul is an API gateway for microservices. It provides a single point of entry for a set of microservices. It handles all the requests and routes them to the appropriate microservice. It also provides load balancing, security, and other features.

2. It is used to route requests to the appropriate microservice.
   API Gateway is a microservice that routes requests to the appropriate microservice. It is used to provide a single point of entry for all requests to the microservices. API Gateway is responsible for request routing, API management, and load balancing.

3. Zuul is used to load balance requests among microservices.
   API Gateway is a microservices architecture pattern. It is a service that provides a single point of entry for a microservices application. It is responsible for request routing, API composition, and load balancing. Zuul is a popular open source API Gateway. It is used to load balance requests among microservices.

4. Zuul can also be used for authentication and authorization.
   API Gateway is a type of service in a microservices architecture that provides a single point of entry for a set of microservices. Zuul can also be used for authentication and authorization.

5. Zuul is a critical component of a microservices architecture.
   API Gateway is a critical component of a microservices architecture. It is responsible for routing requests from clients to services. Zuul is a popular API Gateway. It is open source and has a large community of users and developers.

   
## What is the use of ribbon-loadbalancer?
* The Ribbon mainly provides client-side load balancing algorithms. It is a client-side load balancer that provides control over the behavior of HTTP and TCP client. The important point is that when we use Feign, the Ribbon also applies. ribbon-loadbalancer: It is a Load balancer API that can be used independently or with other modules.

## What Is Hystrix?
* Hystrix is a Latency and Fault Tolerance Library for Distributed Systems It is a latency and fault tolerance library designed to isolate points of access to remote systems, services, and 3rd-party libraries in a distributed environment.

* How to handle fault tolerance in microservices with hystrix & How to Implement Hystrix Circuit Breaker in Microservices Application?
* Hystrix implements the Circuit Breaker pattern. You don’t have to write the network or thread programming to handle fault tolerance in the Microservices. You need to use Hystrix library just by giving parameters and that’s it. Hystrix is going to do all the work for you internally. The best part of it is that it works amazingly with Spring Boot.
