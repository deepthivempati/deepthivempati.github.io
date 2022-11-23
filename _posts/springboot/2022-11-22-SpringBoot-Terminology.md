---
title:  "Spring Boot Terminology"
date:   2022-10-28 17:26:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---

## SpringBoot Terminology Overview
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