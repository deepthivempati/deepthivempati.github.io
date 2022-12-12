---
title:  "JUnit & JUnit Testing"
date:   2022-12-21 17:26:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---
## Overview

* Large applications can have 100s of code files and millions of lines of code, Inorder to checkapp behaviour against expected behaviour we do testing.
* **Integration Testing**: Deploy the Complete application by deploying the war or jar and test. This is also called as system testing.
* **Unit Testing**: Test specific units of application code independently. Ex: Testing a specific method or group of methods.
* **Advantages of Unit testing**: 
  * Find bugs early(run under CI)
  * Easy to fix bugs
  * In Integration testing when the bug arises it difficult to find which method is causing an issue. In unit testing specif method is responsible for the bug and reduces the cost in the long run.
* Note: Integration+Unit testing should be done for better bugfree code.
* 