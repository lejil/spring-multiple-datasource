#   springboot-jpa-multiple-datasources
  
Spring Boot Multiple Datasource  demo is demonstrating how to implement simple CRUD operations with a Employee entity on two different data sources 

What's inside
This project is based on the Spring Boot project and uses these packages :

Maven
Spring Core
Spring Data (Hibernate & MySQL)
Spring MVC (Tomcat)


Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

Database configuration
Create a MySQL database with the name db1 and add the credentials to /resources/application.properties.
The default ones are :

spring.datasource.url=jdbc:mysql://localhost:3306/db1
spring.datasource.username=root
spring.datasource.password=


Create a PostgreSQL database with the name db2 and add the credentials to /resources/application.properties.
The default ones are :

spring.datasource.url=jdbc:postgresql://localhost:5432/db2
spring.datasource.username=postgres
spring.datasource.password=
