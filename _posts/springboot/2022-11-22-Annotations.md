---
title:  "Annotations"
date:   2022-10-28 17:26:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---

## SpringFrame work Annotations

* **@Component** : Class managed by Spring framework. It is a class-level annotation and is used to denote a class as a Component. We can use @Component across the application to mark the beans(instances or objects) as Spring’s managed components.
@Component is an annotation that allows Spring to automatically detect our custom beans. In other words, without having to write any explicit code, Spring will:
* Scan our application for classes annotated with @Component.
* Instantiate them and inject any specified dependencies into them.
* Inject them wherever needed.
* **@ComponentScan** : This annotation is an alternative to `<context:component-scan>` XML tag. Tells Spring that where to look for Spring Components explicitly. @ComponentScan annotation is used with @Configuration annotation. 
* @ComonentScan without attribute tells that Spring to discover components in current package and within it’s sub packages.
* We can tell Spring to which packages to scan specifically by using basePackages attribute. @ComponentScan(basePackages = "BasePackageName1"), @ComponentScan(basePackages={ "BasePackageName1", "BasePackageName2"}) with multiple packages as attributes.  @ComponentScan("packageName"), @ComponentScan({"packageName1","packageName2"})
* **@Autowired** : @Autowired annotation is performing Dependency Injection. you can turn off the default behavior by using (required=false) option with @Autowired like @Autowired(required=false). @Autowired can be applied to:
* a) field: then the dependency is stored in this field
* b) setter: then the setter is invoked, with the parameter that is determined by the same algorithm like for the field dependency injection
* c) constructor: then the constructor is invoked with the parameters determined by the same algorithm like for the field dependency injection
