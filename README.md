# DigitalService4Germany Backend-Challenge Typescript

This is a basis for the technical deep dive interview. It provides a solution specifically for the task described below.

It is a basis for discussion and we are looking forward to any aspects that could be improved.


## The Task

[GovData.de](https://www.govdata.de/) is the data portal for Germany. The federal, state and local governments can share their data. Although the "Open Data Act" makes it obligatory to share data, only about 52,000 data sets are online so far.

Create a small web application that provides a dashboard showing how many data sets each federal ministry has made available on GovData. States, municipalities and other institutions should be ignored. It should be easy to tell from the dashboard which ministries have provided the most data.

Use GovData's [CKAN Action API](https://www.govdata.de/ckan/api/3) ([documentation](https://docs.ckan.org/en/2.9/api/index.html#get-able-api-functions)) to solve this challenge. In `departments.json` you will find all federal ministries and their subordinated agencies that have published data on GovData.

## How to run

Use maven to run the application on http://localhost:8080.

### Unix system

```
./mvnw spring-boot:run
```

### Windows system

```
./mvnw.cmd spring-boot:run
```

## How to test

Use maven to run the tests.

### Unix system

```
./mvnw test
```

### Windows system

```
./mvnw.cmd test
```