# Spring Boot JPA with Multiple DataSources: MySQL and PostgreSQL
* This project demonstrates how to configure and use multiple data sources in a Spring Boot application with JPA, connecting to both MySQL and PostgreSQL databases.

# Features
* Spring Boot 3.x with Spring Data JPA for ORM.
* Integration with two different relational databases:
* MySQL for managing one set of entities.
* PostgreSQL for managing another set of entities.
* Multiple datasource configuration using properties, DataSourceBuilder, and LocalContainerEntityManagerFactoryBean.
* Separate transaction management for each datasource.
* Practical example of using repositories to interact with each datasource independently.

# Project Structure
* Primary DataSource (MySQL): Handles employee data.
* Secondary DataSource (PostgreSQL): Manages employee data.

# Configuration classes for:
* Data source beans
* Entity managers
* Transaction managers
* JPA repositories and entity classes mapped to the respective databases.

# How to Run
* Set up both MySQL and PostgreSQL databases on your local or remote server.
* Update the connection details in the application.properties or application.yml file:
* MySQL connection settings.
* PostgreSQL connection settings.
* Run the Spring Boot application.

# Dependencies
* Spring Boot 3.x
* Spring Data JPA
* MySQL Connector
* PostgreSQL JDBC Driver
* HikariCP (for connection pooling)

# Use Case
* This setup is ideal when you need to interact with multiple databases within the same application, whether due to architectural design, legacy systems, or specific storage requirements.
