---
title:  "Java Date-Time"
date:   2023-03-23 18:11:00
categories: ['Java']
tags: ['Java']
---
{% include toc title="Index" %}

## DateTime Conversions

* The most common ISO Date Format is YYYY-MM-dd(1998-11-11)
* If the date is not in the ISO Date format (yyyy-MM-dd).Use the java code as below:

``` java
// user defined date : "23-01-2023"

LocalDate treatmentDate = LocalDate.parse(String.valueOf(requestEntity.get("treatmentDate")),
            DateTimeFormatter.ofPattern("dd-MM-yyyy")); //user defined date : "treatmentDate": "23-01-2023",
    requestEntity.put("treatmentDate", treatmentDate.format(DateTimeFormatter.ISO_DATE));//2023-01-23
```

``` java
// user defined date : "23-Jan-2023"

LocalDate treatmentDate = LocalDate.parse(String.valueOf(requestEntity.get("treatmentDate")),
            DateTimeFormatter.ofPattern("dd-MMM-yyyy"));  user defined date : "23-Jan-2023"
    requestEntity.put("treatmentDate", treatmentDate.format(DateTimeFormatter.ISO_DATE));//2023-01-23
```
