---
title:  "Java Sorting Comparator"
date:   2022-10-14 17:22:00
categories: ['Java']
tags: ['Java']
---

# Java Sorting Comparator

* Stream sorted(Comparator comparator) returns the stream of elements in natural sorted order and reverse sorted order with the provided Comparator.

# Syntax
`sorted(Comparator<? super T> comparator)`

* Where, Stream is an interface and T is type of stream elements. comparator is used to compare stream elements.

``` java
List<Integer> l = Arrays.asList(6, 9, -6, -9);
l.stream.sorted(Comparator.naturalOrder()).foEach(System.out::println);
l.stream.sorted(Comparator.reverseOrder()).foEach(System.out::println);
```
