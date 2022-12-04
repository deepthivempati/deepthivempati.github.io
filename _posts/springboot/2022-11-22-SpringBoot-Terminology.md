---
title:  "Spring Boot Terminology"
date:   2022-10-28 17:26:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---

## SpringBoot Terminology Overview
* setting up spring projects before spring boot was not easy as it includes: Dependency Management(pom.xml), Define Web configuration(web.xml), Manage spring Beans(context.xml), Implement Non functional requirements(NFR's). It takes huge time and effort and hard to maintain consistency.
* **Spring Framework** : Instead of focusing on objects, their dependencies and wiring you can focus on bussiness logic of our application since framework is taking care of dependencies, objects etc and managing lifecycle of objects.
* **Dependency** :  Dependency is nothing but a ‘Library’ that provides specific functionality that we can use in our application. **Dependency Management** is just a way of managing all the required dependencies in one place and efficiently making use of them. 
* **Component Scan** : The process of discovering Spring Components within classpath of the application is called Component Scanning in Spring. Used along with the @Configuration annotation to specify the packages that we want to be scanned. @ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.
* **Dependency injection** : Identifies beans, their dependencies and wire them together(provides IOC- Inversion of Control)
* **Inversion of Control (IOC)** : Spring IoC (Inversion of Control) Container is the core of Spring Framework. It creates the objects, configures and assembles their dependencies, manages their entire life cycle.
* **IOC Container** : Manages the lifecycle of beans and dependencies. Two types of IOC containers: 
* 1) ApplicationContext(Complex - mostly used) 
* 2) BeanFactory(Simpler features - rarely used)
* **Spring Beans** : An object managed by Spring Framework.
* **Autowiring** : Process of wiring in dependencies for a Spring Bean. we use @Autowired Annotation for wiring.
* **Circular Dependency** : A circular dependency occurs when a bean A depends on another bean B, and the bean B depends on bean A as Bean A → Bean B → Bean A. we could have more beans implied. Relying upon circular references is discouraged and they are prohibited by default so, to avoid this error Update application.properties file with `spring.main.allow-circular-references = true` to remove the dependency cycle between beans
* **Spring Dependency** : These are the dependencies for beans. These are at the low level -- class level. ex: one class instance (bean) dependent on other class instance.
* **Maven Dependency** : It's a jar where it downloads spring dependencies. These are at the high level -- jar level.
* **Transitive Dependency** : maven is a jar which consists of many dependencies called as transitive dependencies.
* **pom.xml** : Where we configure all the maven configurations.
* **Maven artifacts** : Identified by a GroupId and ArtifactId.
* **maven** : Spring jar needs other jars. Maven downloads spring Dependencies. Maven manages the jars needed by the apps(application dependencies). When the spring is upgraded need to download upgraded version of hundreds of jars instead maven handles all these. Maven defines simple project structure, consistent across all projects and manages dependency updates and transitive dependencies.
* There are 3 Spring Framework Dependency Injection Types. 
* 1) **Constructor-based** : Dependencies are set by creating the bean using its constructor.
* It is recommended to use constructor-based injection as dependencies are automatically set when an object is created.

``` java
public class MyClass {
    private DogsController controller;
    @Autowired // Constructor-based
    public MyClass(DogsController controller) {
        this.controller = controller;
```
* 2) **Setter-based** : Dependencies are set by calling setter methods on your beans.

``` java
public class MyClass {
    private DogsController controller;
    @Autowired // Setter-based
    public void setController(DogsController controller) {
        this.controller = controller;
    }
```
* 3) **Filed-based** : No setter or constructor. Spring assigns the dependencies directly to the fields. Dependency is injected using reflection.

``` java
public class MyClass {
    @Autowired // Filed-based
    private DogsController controller;
```

* **Spring Modules** : Core (Ioc Container), Testing(Mock Objects, Spring MVC Test etc), DataAccess(To talk to db: Transactions, JDBC JPA), WebServlet(spring provides Spring MVC etc to build web applications), Integration(To Integrate with other Applications: JMS etc), WebReactive(To build Reactive Web application: Spring WebFlux etc).
* Each application can choose the modules they want to make use of. They dont need to make use of all the things everything in sprng framework.
* **Spring Projects** : Spring keeps evolving(REST API to Microservices to Cloud). Different farmeworks are used to build spring projects.
* a) **Spring Boot** : Most Popular framework to build microservies.
* b) **Spring Cloud** : Build cloud native applications.
* c) **Spring Data** : Integrate the same way with different types of databases: NoSQL and Relational.
* d) **Spring Integration** : Address challenges with integration with other applications.
* e) **Spring Security** : Secure web application or REST API or Microservice.
* It's not easy to build a project before spring boot as we need to define maven dependencies, web.xml, installing tomacat and configuring, Spring context XML file and component scan etc etc. deploy and run the application on tomcat.
* **Important Dependencies** : Spring Boot Starter Web(for Web Application and REST API), Spring Boot Starter Data JPA(to talk to db using JPA), Spring Boot Starter Data JDBC(to talk to db using JDBC), Spring Boot Starter Security(to secure Spring Boot Web application or REST API).
* **Spring Boot Auto configuration**: Spring Boot provides Auto Configuration. Its a basic Configuration to run your application using farmeworks defined in your maven or gradle dependencies. Auto configuration is decided based on which frameworks are in class path, what is existing config(Annotations etc) defined in springboot-autoconfigure.jar.
* Ex: Enable debug logging. Few Auto configurations of spring starter web are : Dispatcher Servlet, Embedded Servlet Container, Default Error pages, bean to/fron json conversion etc..
* **Embedded Servers** : The advantage with this is you don’t need the server pre-installed in the deployment environment. With SpringBoot, the default embedded server is **Tomcat**.
* **Spring Boot Actuator**: Monitor and manage your application in your production. provides number of endpoints : beans(store complete list of beans in your application), health(gives application health information), metrices, mappings(gives details around request mappings)
* management.enpoints.web.exposure.include=* enables all the enpoints of actuator by configuring this in application.properties file. need to add the necessary dependency in the pom.xml or build.gradle file.
* Ex: http://localhost:8080/actuator/beans, http://localhost:8080/actuator/caches.
* **Spring Boot** : Its a spring project which builds production ready applications. Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run" with many auto configurations embedded servers, actuators and dependency injections. Its a spring framework core feature.
* **Spring** : Spring is a lightweight framework.
* **Spring MVC**: Its a spring module which build web applications in a decoupled approach. ex: Dispatcher servlet, ModelAndView and View Resolver etc.
* **Spring Framework** : Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application.
* **Profiles**:  Profiles are a core feature of the framework — allowing us to map our beans to different profiles — for example, dev, test, and prod. We can then activate different profiles in different environments to bootstrap only the beans we need.
``` java
//application.properties
logging.level.org.springframework=info
spring.profiles.active=dev
```
``` java
//application-dev.properties
logging.level.org.springframework=debug
```
* In the console log we see debug logs but not info since `spring.profiles.active` in application.properties config file is set to dev and its higher env if the `spring.profiles.active` is set to idev then that properties will take priority since idev is higher env than dev.