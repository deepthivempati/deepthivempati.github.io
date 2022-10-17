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
### Add exception to method signature
* Exception in method using throws keyword which extends Exception --> As custom exceptions are always uncheckedExceptions.
### `if stream<T>`
* Don't have to use collect(collectors.toList) after stream since the dataType is expecting as stream not as a list.