---
title:  "Collections"
date:   2022-10-14 18:30:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---

{% include toc title="Index" %}

## Overview
* Grouping of an individual objects as an entity is known as collection.
* Collection framework provides the interfaces and classes for an individual object.
* The drawbacks of using arrays is taken care by collections.
* MemoryAllocation wise collections are peferable but performance wise collections are not.
* Collections are growable in nature, can hold both home and heterogenous elements unlike arrays.
* For every collection readymade method support is high.
* There are 9 interfaces of collection. collection is the root interface for collection framework.
* List(arrayList, linkedList, vector(stack))
* Set(Hashset(LinkedHashset), Sortedset(NavigableSet(TreeSet)))
* Queue(PriorityQueue, BlockingQueue(PriorityBlockingQueue(LinkedBlockingQueue)))
* Map(HashMap(LinkedHashMap), WeakedHashMap, IdentityHashMap, SortedMap(NavigableMap(TreeMap)), HashMap(Properties))
* `Collection.forEach()` uses collections iterator(if one is specified), so the processing order of the items is defined. In contrast, the processing order of `Collection.stream().forEach` is undefined.
