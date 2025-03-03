# Gov Data Dashboard | Spring

_This repository is a basis for the technical deep dive interview and not actively updated._

[GovData.de](https://www.govdata.de/) is the data portal for Germany. The federal, state and local governments can share their data. Although the "Open Data Act" makes it obligatory to share data, only about 135,000 data sets are online so far.

This repository contains a small web application that provides a dashboard showing how many data sets each federal ministry has made available on GovData. The goal of the dashboard is to show which ministries have provided the most data. States, municipalities and other institutions are ignored.

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
