---
title:  "Explicit Object Mapping"
date:   2022-10-28 17:26:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---
{::options parse_block_html="true" /}

## overview of mapping one object to other explicitly
* ChairsideParentDto and ChairsideModelDto are two diff objects. Mapping ChairsideParentDto to ChairsideModelDto. 
* Consider ChairsideParentDto has data and ChairsideModelDto has no data. populating data from ChairsideParentDto into ChairsideModelDto with explicit mapping with ChairsideParentDto.

<details>
<summary markdown="span">Example</summary>

``` java
// ChairsideParentDto nested model structure (parent class)
@Data @NoArgsConstructor @AllArgsConstructor
public class ChairsideParentDto{
private ChairsideFiltersDto filters;
private List<ChairsideDto> chairside;
}

@Data @NoArgsConstructor @AllArgsConstructor
public class ChairsideFiltersDto{
private String treatmentDay;
}

@Data @NoArgsConstructor @AllArgsConstructor
public class ChairsideDto{
private String treatmentDate;
private String facilityId;
private List<TotalLabs> totalLabs;
private List<ChairsideData> ChairsideData;
}

@Data @NoArgsConstructor @AllArgsConstructor
public class TotalLabs{
private String totalLabValue;
}

@Data @NoArgsConstructor @AllArgsConstructor
public class ChairsideData {
    private List<String> totalDialyserValue;
}
```

``` java
// ChairsideModelDto -- plain model structure (parent class)
@Data @NoArgsConstructor @AllArgsConstructor
public class ChairsideModelDto {
    private String dayOfTreatment;
    private String dateOfTreatment;
    private String finalLabValues;
    private String finalDialyzerValues;
    private String facilityId;
}
```

``` java
private ChairsideParentDto getData(){
List<Data> data = dbData.getData(); // consider data is of type Chairsidemodel

//chairsidemodel is an object where we store all the data
Function<ChairsideModelDto, ChairsideParentDto> chairsideParent = chairsidemodel -> {
ChairsideParentDto chairsideParentDto =  new ChairsideParentDto(); // creating an object of ChairsideParentDto(Parent object which stores child objects)

ChairsideFiltersDto chairsideFiltersDto = new ChairsideFiltersDto(); // creating an object of ChairsideFilterDto
chairsideFiltersDto.setTreatmentDay(chairsidemodel.getDayOfTreatment());

List<TotalLabs> totalLabsList = new ArrayList<>(); //creating an ArrayList to store the items of TotalLabs
TotalLabs totalLabsObj = new TotalLabs(); //creating an object of TotalLabs
totalLabsObj.setTotalLabValue(ChairsideModelDto.getFinalLabValues()); mapping data totalLabsObj object using getters and setters
totalLabsList.add(totalLabsObj); // adding object items to ArrayList

List<ChairSideData> chairSideDataList = new ArrayList<>();
ChairSideData chairsideDataObj = new ChairSideData();
chairSideDataObj.setTotalDialyserValue(Arrays.asList(ChairsideModelDto.getFinalDialyzerValues())); //when there is no data setting up an empty List
chairSideDataList.add(chairSideDataObj);  // adding chairsideDataObj as 1st element to chairSideDataList

List<ChairsideDto> chairsideDtoList = new ArrayList<>();
ChairsideDto chairsideDtoObj = new ChairsideDto();
chairSideDataObj.setFacilitId(StringUtils.EMPTY); // when there is no data setting an empty String.
chairsideDtoObj.setChairsideData(chairSideDataList);
chairsideDtoObj.setTotalLabs(totalLabsList); 
chairsideDtoList.add(chairSideDataObj);

// adding all the child objects to the parent objects
chairsideParentDto.setFilters(chairsideFiltersDto);
chairsideParentDto.setChairside(chairSideDataList);

return chairsideParentDto;
};
return chairsideParent.apply(data.get(0)); data map from ChairsideParentDto to ChairsideModelDto is done and stored in chairsideParent and returning it.
}
```
</details>

* Note: without disturbing or making operations or manipulating the original list an object is created to set the data.
