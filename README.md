## Purpose
This document provides an overview of the Server Side RAD Project for Bachelor of Science in Software Development program, including a statement of goals and objectives and a general description of my approach. This working document is directed to my supervisor but should be useful to anyone interested in learning more about creating a Spring Boot MVC application. This document is something of an executive summary of the project in its current state and summarise the results in phases.

## Projcet Description
Write a Spring Boot MVC application that allows a user to manage Ships, Shipping Companies and Orders.

## Goals and Objectives
My primary mission is to comprehend and develop an application written in Spring Boot base, and use the Spring MVC N-Tier architecture.
To achieve this overall objective, I have defined following phases.
* As a part of college project, it can be modified at any convenient time as it't required.
* Phase 1: Start with the application skeleton which contains data model and database.
* Phase 2: Create
    * Data Access Layer - Repositories
    * Business Logic - Controllers and Services
* Phase 3: Implement Functionalities
    * Add methods with a Http Get and Post methods.
    * Show method with a Http Get methods.
* Phase 4: Create Presentation Layer - Views 
    * Add page allows to save an object(entity) into the database through a form tag.
    * Show page allows to display data on a table tag.
* Phase 5: Add error handles and invalide input conditions.
* Phase 6: Add a security functionality that allows only a valid user name with password to use the application.

## Challenges and Constraints
* Full integration between Views, Logics, and Database.
### Unable to see data from the database on a show page.
1. Check data are on the database.
2. Investigate a correct connection between Data Access Layer and Database.
3. Ispect a right implementation of Business Logic Layer.
4. Examine a Views that will display data as its requested by a controller. 
### Http request errors
Wrong annotation with incorrect Http request method would cause a bad response. If so, it must be inspected by debuging tools or manually implemented system logs.
### Etc
* Some conditions on Business Logic Layer are ambigus to be implemented on services or controllers.

## Running the tests
### Clone
Create a folder, and move into the folder just created, then use git clone command to download a copy of this project
```
$ mkdir folder
$ cd folder
$ git clone https://github.com/kentkim84/ServerSideRADProject.git
```
### Download
Click [Clone or Download](https://github.com/kentkim84/ServerSideRADProject), then Click 'Download ZIP'

### Test
Run mysql 
Open the project with a suitable IDE
```
$ Visual Studion project folder/VisualTranslator
$ run VisualTranslator.sln file
```

## Authors
* **Yongjin Kim** - *Initial work* - [Kentkim84](https://github.com/kentkim84)

## References
* Original Project written by [Gerard Harrison](Gerard.Harrison@gmit.ie)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Implementation of a login process](https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d)
* [Basic creation of an application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
