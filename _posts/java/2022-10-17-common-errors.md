---
title:  "Common Errors"
date:   2022-10-14 18:47:00
categories: ['Java']
tags: ['Java']
---
{% include toc title="Index" %}

## Errors
### Non-static method 'method(java.lang.String)' cannot be referenced from a static context 
* You can't call something that doesn't exist. Since you haven't created an object, the non-static method doesn't exist yet. A static method (by defination) always exists.
* EX: 

``` java
public class EmployeeSimple {
    private String name;
    private Integer age;
    private Double salary;
    private char level;
    private int experience;
    }
```

* EmployeeSimple class is of type EmployeeSimple

``` java
 int minAge = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .map(EmployeeSimple::getAge)
                .min(Comparator.comparing(EmployeeSimple::getSalary))
```
* **Here `min(Comparator.comparing(EmployeeSimple::getSalary))` gives this compile time error because in the above line since we performed mapping on EmployeeSimple object where EmployeeSimple object changed its form from EmployeeSimple to age which is an Integer. Now EmployeeSimple no longer exsists to get any field from employeeSimple.**

``` java
 int minAge = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .map(EmployeeSimple::getAge)
                .min(Comparator.comparing(Integer::intValue)) 
```
* **Here we are finally getting an integer value**

### Add exception to method signature
* Exception in method using throws keyword which extends Exception --> As custom exceptions are always uncheckedExceptions.
### `if stream<T>`
* Don't have to use collect(collectors.toList) after stream since the dataType is expecting as stream not as a list.