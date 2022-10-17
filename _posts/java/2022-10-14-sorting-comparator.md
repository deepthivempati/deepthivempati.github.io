---
title:  "Java Sorting Comparator"
date:   2022-10-14 17:22:00
categories: ['Java']
tags: ['Java']
---

{% include toc title="Index" %}

`Comparator<T>` is an interface
Stream sorted(Comparator comparator) returns the stream of elements in natural sorted order and reverse sorted order with the provided Comparator.

## Syntax
`sorted(Comparator<? super T> comparator)`

* Where, Stream is an interface and T is type of stream elements. comparator is used to compare stream elements.

``` java
List<Integer> l = Arrays.asList(6, 9, -6, -9);
l.stream.sorted(Comparator.naturalOrder()).forEach(System.out::println);
l.stream.sorted(Comparator.reverseOrder()).forEach(System.out::println);
```

Example: class Medication has medOrderList as the property.
```java
@Data @AllArgsConstructor @NoArgsConstructor @ToString
class Medication {
    private List<MedOrder> medOrderList; 
}
```

class MedOrder has medicationName, medicationDose, startDate as properties.
```java
@Data @AllArgsConstructor @NoArgsConstructor @ToString
class medOrder {
    private String medicationName;
    private Double medicationDose;
    private TimeStamp startDate;
}
```

list of medOrderList needs to be sorted in ascending(natural) order, the list can be sorted this way.
```java
medOrderList.stream()
    .sorted(Comparator.comparing(Medication::medicationName)).collect(Collectors.toList());
return medOrderList;
```

if list of medOrderList needs to be sorted in descending(reverse) order.
```java
medOrderList.stream()
    .sorted(Comparator.comparing(Medication::medicationName).reversed).collect(Collectors.toList()); 
return medOrderList;
```
* reversed() sort the entire list items

list of medOrderList needs to be sorted in descending(reverse) order and if there are same medications then sort on startDate(current date to previous), the list can be sorted this way.
```java
medOrderList.stream()
  .sorted(Comparator.comparing(Medication::medicationName).thenComparing(Medication::startDate, Comparator.reverseOrder()).reversed).collect(Collectors.toList());
  return medOrderList;
```
* Comparator.reverseOrder() does not sort the entire list items. it sort the each element with multiple items based on comparion using a key(ex: startDate).


# Comparator methods

* compare(T,T)
* reversed()
* thenComparing(Comparator<? super T>)
* thenComparing(Function<? super T, ? extends U>, Comparator<? super U>)
* thenComparing(Function<? super YT, ? extends U>)
* thenComparingInt(ToIntFunction<? super T>)
* thenComparingLong(ToLongFunction<? super T>)
* thenComparingDouble(ToDoubleFunction<? super T>)
* reversOrder()
* naturalOrder()
* nullsFirst(Comparator<? super T>)
* nullsLast(Comparator<? super T>)
* comparing(Function<? super T, ? extends U>, Comparator<? super U>)<T,U> : Comparator<T>
* comparing(Function<? super T, ? extends U>)
* comparing(ToIntFunction<? super T>)
* comparing(ToLongFunction<? super T>)
* comparing(ToDoubleFunction<? super T>)

