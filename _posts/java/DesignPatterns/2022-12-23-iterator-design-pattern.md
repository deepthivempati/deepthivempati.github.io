---
title:  "Iterator Design Pattern"
date: 2022-12-23 17:22:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---
{% include toc title="Index" %}

## Overview
* Iterator design pattern is a commonly used design pattern in java and .Net programming. This pattern is used to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation. 
* Iterator pattern falls under Behavioral pattern.
* Instead of programmer writing the code for Iterations and looping, java provides inbuilt iterators which gives implementation and programmers use them.
* Iterators in java are used in the collection framework to retrive elements one by one.

## Syntax
`Iterator iterator = c.iterator();`
* Here c is any collection object. iterator is of type Iterator interface and refers to c.

## Methods of Iterator Interface in java
* hasNext() `public boolean hasNext()`
* next() `public Object next()`. next() method throws 1 exception. **NoSuchElementException** --> if no more element is present.
* remove() `public void remove()`. Remove() method throws 2 exceptions. **UnsupportedOperationException** --> if remove operation is not supported by this Iterator. **IllegalStateException** --> if next method has not yet been called or remove method has already been called after the last call to the next method.

## Example 1
``` java
public class I1Intro {
    public static void main(String ...args) {
        List<Integer> numbers =  List.of(1,2,3,4,5,6);//Arrays.asList()
        Integer sum = 0;//Integer.MIN_VALUE;

        //Declarative Style === what to do, delegate how to do to Java
        int sumTotal = numbers.stream().parallel()
                .mapToInt(number -> number)
                .sum();
        System.out.println(sumTotal);
    }
}
```
## Example 2
* Iterating using forLoop with var
``` java
public class Iterators {
    private static List<String> forLoopWithVar(List<String> list, int count) {
        var ret = new ArrayList<String>();
        var input = list;
        int x = 0;
        for(var name : list){
            var str = name;
            if(str.length() > 4){
                x++;
                ret.add(str.toUpperCase());
            }
            if(x == count){
                break;
            }
        }
        return ret;
    }
```

* Iterating using For loop
``` java
    private static List<String> forLoop(List<String> list, int count) {
        //and then
        //Imperative style === what to do + how to do + Eager Evaluation
        int x = 0;
        List<String> ret = new ArrayList<>();
        //send first 2 string with lenght > 4
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if(str.length() > 4){
                x++;
                ret.add(str.toUpperCase());
            }
            if(x == count){
                break;
            }
        }
        return ret;
    }
    }
```

* Iterating with forLoop using Streams
``` java
    private static List<String> forLoopStreams(List<String> list, int count) {
        var ret = new ArrayList<String>();
        //Functional Style == declarative style
        //Works until now, but stooped all of a sudden
        // Code behaves - erratically with parallel Stream
        ret = (ArrayList<String>) list.stream().parallel()
                //.filter(name -> null != name)
                .filter(Objects::nonNull)
                .filter(name -> name.length() > 2)
                .map(nameInLowerCase -> nameInLowerCase.toUpperCase())
                .limit(count)
                //.forEach(name -> ret.add(name));//BAD IDEA with ParallelStream - due to shared mutability - this is impure
                .collect(Collectors.toList());//Thread safe
        return ret;
    }
```

## Implementation Example 3
* Creating an Iterator interface which includes navigation method and a Container interface which returns the iterator.
* Concrete classes implementing the Container interface will be responsible to implement Iterator interface and use it.
* IteratorPatternDemo main class will use NamesRepository, a concrete class implementation to print Names stored as collection in NamesRepository.

## Creating an interface Iterator.java, Container.java
``` java
public interface Iterator{
public boolean hasNext();
public Object next();
}
```

## Creating concrete class implementing the container interface.
``` java
public class Namerepository implements Container{
public String names[] = {"Deepthi", "Nitin", "Keerthi"};
@Override
public Iterator getIterator(){
return new NameIterator();
}
```

* This class has inner class NameIterator implementing the Iterator interface NameRepository.java

``` java
private class NameIterator implements Iterator{
int index = 0;
@Override
public boolean hasNext(){
if(index < names.length){
return true;
}
return false;
}

@Override
public Object next(){
if(this.hasNext()){
return names[index++];
}
return null;
}
}
```

## Using the NameRepository to get iterator and print names IteratorPatternDemo.java
``` java
public class IteratorPtterndemo{
public ststic void main(String[] args){
NameRepository namesRepository = new NameRepository();
for(Iterator iterator = namesRepository.getIterator();
iterator.hasNext();
)
{
String name = (String)iter.next();
System.out.println("Name:"+name);
}
}
}
```
* The output will be: Name:Deepthi, Name:Keerthi, Name:Nitin

## Advantages of iterator Design pattern
* It provides a way for us to implement the accessibility of elements without exposing the underlying representation of the container.
* lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.). Iterator takes care of which data structure should be implemented internally.
* We can use it for any collection class.
* supports both read and remove operations.