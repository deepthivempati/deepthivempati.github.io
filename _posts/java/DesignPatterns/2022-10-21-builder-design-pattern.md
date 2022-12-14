---
title:  "Builder design pattern"
date: 2022-10-21 17:22:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---

{% include toc title="Index" %}

## Overview
# @Builder

* Builder pattern is used to build the object step-by-step and provide a method that will actually return the final Object.
#### ***What is the use of @builder in spring boot?***
* Lombok's `@Builder` is a helpful mechanism for using the Builder pattern without writing boilerplate code. We can apply this annotation to a ***Class*** or a ***constructor***  or a ***method***.
* Lombok creates a builder class containing only the constructor parameters.
* `@Builder` needs an `@AllArgsConstructor`

## class level Builder
### Employee class
``` java
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Employee{
private String name;
private int age;
}
```

### EmployeeData class
``` java
public class EmployeeData{
public static void main(String[] args){
    Employee
    .builder()
    .name("deepthi")
    .age(24)
    .build();
    
    Employee e = Employee
    .builder()
    .build()
    System.out.println(e.getName() + " " + e.getAge())
    }
}
```
* e gives result as null 0 which are the default values of String anf integer since we did not provide any values to the name and age constructor.

## Constructor level Builder
### Chocolate class
``` java
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Chocolate{
private String name;
private Double price;
private Boolean isAvailable;

// creating constructor for class Chocolate for name and price variables
@Builder
public Chocolate(String name, Double price){
this.name = name;
this.price = price;
}
}
```

### ChocolateData class
``` java
public class ChocolateData{
public static void main(String[] args){
   Chocolate c = Chocolate
    .builder()
    .name("Kitkat")
    .price(10.0)
    .build();
   
    System.out.println(c.getName() + " " + c.getPrice() + " " + c.getIsAvailable())
    }
}
```
* c gives result as Kitkat 10 false.
* since the constructor is not created for boolean isAvailable variable it gave result as false as it is the default value of boolean.
* we can restrict the builder using constructors. 

## Method level Builder
### Books class
``` java
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Books{
private String author;
private Integer pages;
private Boolean isAvailable;

// creating constructor for class Books for author, pages and isAvailable variables
public Books(String author, Integer pages, Boolean isAvailable){
this.author = author;
this.pages = pages;
this.isAvailable = isAvailable;
}

// creating a  instance method BooksInstance(object of this class)
@Builder
private static Books BooksInstance(String author, Integer pages){
  return new Books(author, pages, true); // creating object of Books class
}
```

### BooksData class
``` java
public class BooksData{
public static void main(String[] args){
   Books c = Books
    .builder()
    .author("Dr Joseph Murphy")
    .pages(270)
    .build();
   
    System.out.println(c.getAuthor() + " " + c.getPages() + " " + c.getIsAvailable())
    }
}
```
* Since builder is applied at the method level we dont have to call the method explicitly. builder calls the method.
* The result will be Dr Joseph Murphy 270 true. isAvailable is true since it is declared as true statically. 

## Example: CodeSample

``` java
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class FluidBloodPressure{
private List<Sections> sections;
}
```

``` java
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public Sections{
private String patient;
private List<Treatment> treatment;
}
```

``` java 
public Interface report{
getReport(fluidBloodPressure);
}
```

``` java
private Interface getReport(FluidBloodPressure fluidBloodPressure){
    FluidBloodPressure fbp = FluidBloodPressure
    .builder()
    .sections(fluidBloodPressure.getSections()
    .stream()
    .map(listItem -> FluidBloodPressure.builder()
    .patient(listItem.getPatient())
    .treatment(listItem.getTreatment())
    .build())
    .collect(Collections.toList()))
    .build();
return fbp;
}
```
# @Builder.Default
* We can set default values to the fields By using @Builder.Default using Builder in the lombok builder design pattern. 

### Without @Builder.Default
``` java
@ToString @Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class BuilderWithoutDefaultValue{
  private Long id;
  private String name = "Deepthi";
  private Boolean merit;
}
```

``` java
public class Test{
public static void main (String[] args){
    BuilderWithoutDefaultValue result = BuilderWithoutDefaultValue.builder().build();
    System.out.println(result);
  }
}
```
* The result will be as null null false as null is default value of Long, String and false is default value of boolean

### With @Builder.Default
``` java
@ToString @Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class BuilderWithDefaultValue{
  private Long id;
  @Default
  private String name = "Deepthi";
  @Builder.Default
  private Boolean merit = true;
}
```

``` java
public class Test{
public static void main (String[] args){
    BuilderWithDefaultValue result = BuilderWithDefaultValue.builder().build();
    System.out.println(result);
  }
}
```
* The result will be as null Deepthi true.
* @Builder.Default can be used at field level as shown in above example.

## Advantages of Builder Design Pattern
* 1) The parameters to the constructor are reduced and are provided in highly readable method calls.
* 2) Builder design pattern also helps in minimizing the number of parameters in the constructor and thus there is no need to pass in null for optional parameters to the constructor.
* 3) Object is always instantiated in a complete state
* 4) Immutable objects can be built without much complex logic in the object building process. 

## Disadvantages of Builder Design Pattern
* 1) The number of lines of code increases at least to double in builder pattern, but the effort pays off in terms of design flexibility and much more readable code.
* 2) Requires creating a separate ConcreteBuilder for each different type of Product.


