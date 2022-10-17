---
title:  "Short Circuit Operators"
date:   2022-10-14 18:54:00
categories: ['Java']
tags: ['Java']
---

{% include toc title="Index" %}

## Overview
* If the evaluation of a logical expression exists in between, before complete evaluation, then it is known as Short-circuit-operator(`|`(or), `&`(and)).
* True AND True == True
* a) if we use condition where 1st condition is false then without further evaluation we can come to conclusion that the result would be false. Here in this case short circuit operator is used.
* b) if we use condition where 1st condition is true then further evaluation is needed for final result