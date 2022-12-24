---
title:  "Strategy Design Pattern"
date: 2022-12-23 17:22:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---
{% include toc title="Index" %}

## Overview
* Definitionfrom the **‘Gang of Four’** book: “The Strategy Pattern is used to create an interchangeable family of algorithms from which the required process is chosen at run-time”.
* In strategy pattern, a class behaviour or its algorithm can be changed at run time. Its a behaviour pattern.
* In Strategy pattern, we create objects which represent various strategies and a **context object**(A Context is a collection of data, context objects consists of collection of data, often stored in a Map or in a custom class which acts as a struct with accessors and modifiers. 
* It is used for maintaining state and for sharing information within a system) whose behaviour varies as per its **strategy object**(The trategy object determines which algorithm is to be used in a given situation. For example, it enables us to exchange implementation details of an algorithm at run time without requiring us to rewrite it). The strategy object changes the executing algorithm of the context object.
* One of the best example of strategy pattern is Collections.sort () method that takes Comparator parameter. Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.

## When to use Strategy Pattern?
* When you want to be able to change the behavior at run-time dynamically.

## Implementation
* Creating a Strategy interface defining an action and concrete strategy classes implementing the Strategy interface. Context is the class which uses a Strategy.
* StrategyPtternDemo is demo class, will use context and strategy objects to demonstrate change in context behaviour based on strategy it uses.

### Creating an Interface Strategy.java
``` java
public interface Strategy{
public int doOperation(int num1, int num2);
}
```
### Creating concrete classes implementing the same interface OperationAdd.java, OperationSubstract.java, OperationMultiply.java
``` java
public class OperationAdd implements Strategy{
@Override
public int doOperation(int num1, int num2){
return num1+num2;
}
}

public class OperationSubstract implements Strategy{
@Override
public int doOperation(int num1, int num2){
return num1-num2;
}
}

public class OperationMultiply implements Strategy{
@Override
public int doOperation(int num1, int num2){
return num1*num2;
}
}
```
### Creating Context class Context.java
``` java
public class Context{
private Strategy strategy;
public Context(Strategy strategy){
this.strategy = strategy;
}
public int executeStrategy(int num1, int num2){
return strategy.doOperation(num1, num2);
}
}
```
### Using the context to see change in behaviour when it changes its strategy StrategyPatternDemo.java
``` java
public class StrategyPatternDemo{
public static void main(String[] args){
Context context = new Context(new OperationAdd()); // context has instantiated with Context with constructor passing OperationAdd class object  
System.out.println("Addition:" + context.executeStrategy(9, 6)); // context.executeStrategy executes and calls strategy.doOperation which performs addition.

Context context = new Context(new OperationSubstract());
System.out.println("Substraction:" + context.executeStrategy(9, 6));

Context context = new Context(new OperationMultiply());
System.out.println("Multiplication:" + context.executeStrategy(9, 6));
}
}
```
* The outputs will be: Addition:15, Substraction:3, Multiplication:54

## Advantages of Strategic design pattern
* Strategy pattern may improve readability
* Another great benefit of the strategy pattern is, it is reusable throughout your whole project. When using the strategy design pattern, you are very likely to have some kind of an IoC container, from which you are obtaining the desired implementation of an interface.

## Reference
[Link](https://www.edureka.co/blog/design-pattern-exposed-strategy-pattern/)