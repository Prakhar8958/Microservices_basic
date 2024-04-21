# Microservices Project

Welcome to our Microservices Project! This project showcases a robust microservices architecture built with Spring Boot, incorporating various components such as service registry, API gateway, and database integration.

## Overview

Our microservices project consists of the following components:

- **Service Registry**: Utilizing Eureka for service registration and discovery, ensuring seamless communication between microservices.
- **API Gateway**: Implemented with Spring Cloud Gateway, providing a unified entry point to our microservices and handling routing and filtering.
- **Microservices**:
  - **User Service**: Manages user-related operations, including registration and profile management. Utilizes MySQL database for data storage.
  - **Hotel Service**: Handles hotel-related functionalities such as searching and management. Utilizes PostgreSQL database for data storage.
  - **Rating Service**: Manages hotel ratings and reviews. Utilizes MongoDB for data storage.
- **Communication**: Implemented communication between microservices using both RestTemplate and Feign Client, ensuring efficient and reliable data exchange.
- **Circuit Breaker**: Implemented circuit breaker patterns using Resilience4j, enhancing the resilience and fault tolerance of our microservices.

## Deployment

Our microservices project can be deployed using Docker containers, with each microservice containerized for easy deployment and scaling. Alternatively, it can be deployed to cloud platforms such as AWS, Azure, or Google Cloud Platform.
