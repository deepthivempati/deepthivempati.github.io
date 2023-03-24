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
* In This example date is already in ISO format (String startDate = "2023-10-03"). If not,then we can use formatter with LocalDate.parse overloaded method.

``` java
String startDate = "2023-10-03"; String endDate = "2023-10-04";

LocalDateTime startLocalDateTime = LocalDateTime.of(LocalDate.parse(startDate), LocalTime.MIN);
LocalDateTime endLocalDateTime   = LocalDateTime.of(LocalDate.parse(startDate), LocalTime.MAX);

//Convert to Sql Timestamp from Datetime
String startDateTime2TimestampString = Timestamp.valueOf(startLocalDateTime).toString();//2023-10-03 00:00:00.0 :: 2023-10-04 23:59:59.999999999
String endDateTime2TimestampString = Timestamp.valueOf(endLocalDateTime).toString();//2023-10-03 23:59:59.999999999
```
