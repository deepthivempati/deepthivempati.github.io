---
title:  "ClassCastException"
date:   2022-10-14 17:22:00
categories: Java
tags: ['Java']
---

{% include toc title="Index" %}

## Overview
* ClassCastException is a runtime exception. when one Object is Casted to another Object of different dataType ClassCastException persists.
* There are Three Rules for Object TypeCasting.
` A b = (C) d`
* ***RULE-1*** Type of d and C must have some relationship either parent to child or child to parent or same type. If this condition is not satisfied it gives us ***Compiletime error***
* ***RULE-2*** C must be derived type of A. If this condition is not satisfied it gives us ***Compiletime error***
* ***RULE-3*** The Underlying original object type of d must be either same or derived type of C. If this condition is not satisfied it gives us ***Runtime error***

* ### Example
``` java
Class Animal{}
Class Petanimal Extends Animal{}
Class Wildanimal Extends Animal{}
Class Cat Extends Petanimal{}
Class Dog Extends Petanimal{}
Class Lion Extends Wildanimal{}
Class Tiger Extends Wildanimal{}
public class ClassCastException{
public static void main(String[] args){
}
}
```

* `Wildanimal a = new Tiger();` Valid
* `Tiger u = new (Tiger) a;` Valid
* `Petanimal v = (Petanimal)a;` CompileTime Error
* `Wildanimal w = (Wildanimal)a;` Valid
* `Animal x = (Lion)a` RunTime Error
* `Wildanimal y = (Petanimal)a` CompileTime Error
* `IdtRoundingDto idtRoundingDto = (IdtRoundingDto) mappedGeneralResponse` Invalid
* `IdtRoundingDto idtRoundingDto = (IdtRoundingDto) payloadableList` valid

###  IdtRoundingDto Class
``` java
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class IdtRoundingDto implements Paylodable{
private List<IdtRounding> patients;
```

### Paylodable Class
``` java
public interface Payloadable
```

### MappedGeneralResponse Class
``` java
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class MappedGeneralResponse implements Paylodable{
private List<Payloadable> data;
```

``` java
public Payloadable getReport(map<String, Object> request){
MappedGeneralResponse mappedGeneralResponse = service.getDataFromDb(new IdtRoundingDto());
}
```

### getDataFromDb method
``` java
public MappedGeneralResponse getDataFromDb(Payloadable reportData){
}
```

* ***getting data to variable idtRoundingDto of type IdtRoundingDto from mappedGeneralResponse of type Payloadable***
``` java
IdtRoundingDto idtRoundingDto = mappedGeneralResponse.getData.get(0); 
```
* Its shows an compiletime error "Cast to IdtRoundingDto" since mappedGeneralResponse is of type Payloadable type which cannot be assigned to idtRoundingDto which is of IdtRoundingDto type. Required type is IdtRoundingDto but we provided  payloadable.

* ***casting mappedGeneralResponse to IdtRoundingDto***
``` java 
IdtRoundingDto idtRoundingDto = (IdtRoundingDto) mappedGeneralResponse.getData.get(0); 
```
* compile error will be fixed but it gives us runtime error because mappedGeneralResponse is not either same or derived type of IdtRoundingDto Which fails rule 3 of object typeCasting.

* ***explicit casting of mappedGeneralResponse to IdtRoundingDto***
``` java
public Payloadable getReport(map<String, Object> request){
IdtRoundingDto idtRoundingDto = convertToIdtRoundingDto(mappedGeneralResponse);
return idtRoundingDto;
}
```

### convertToIdtRoundingDto method
``` java
private IdtRoundingDto convertToIdtRoundingDto(MappedGeneralResponse mappedGeneralResponse){
List<Payloadable> payloadableList = mappedGeneralResponse.getData();
IdtRoundingDto idtRoundingDto = (IdtRoundingDto) payloadableList.get(0);
return idtRoundingDto;
}
```
* ***payloadableList is retrieving data from mappedGeneralResponse which is child of Payloadable***.
* ***idtRoundingDto is retrieving data from payloadableList by casting to IdtRoundingDto which is child of Payloadable which satisfies rule 1,2,3 of Object TypeCasting.***