# Bank Transaction Data Analysis

## Introduction
Built a model that helps detect suspicious transactions by using a method called z-score analysis, which compares each transaction to the existing transaction data. Additionally, we factor in the timing of transactions to see if they occur during regular working hours or not. This dual approach helps identify potentially suspicious activities, enhancing the security of financial transactions.

## Technologies Used
- Java Spring Boot
- React JS
- MySQL
- CSS

## Microservice Architecture Diagram
![Microservice Architecture Diagram](Microservice%20Architecture%20Diagram.jpg)<!-- Update with the actual path to your diagram image -->

## API Gateway
Built an API gateway where all requests come to an entry point and these requests are routed to the respective services.

## Eureka Server
Developed a Eureka server facilitating internal communication among microservices. Acting as a registry, the Eureka server allows each microservice to register as a client by providing port details. This enables seamless discovery and interaction between microservices within the system.

## Model Service
Analyzes transaction data by calculating a z-score, flagging transactions as suspicious if the score is over a predefined threshold. Additionally, it assesses transaction timing to further determine suspicion, providing a comprehensive evaluation for identifying potential fraudulent activities.

## User Service
Every transaction detail, including the amount and time it occurred, is transmitted from the user service to the model service for real-time data analysis. This ensures that each transaction undergoes immediate scrutiny for suspicious activity detection. The results of data analysis are fetched from the user service and presented in the form of a graph.


## Zscore chart
![z-score chart](zscore%20chart.png)

## Amount chart
![Amount chart](amount%20chart.png)
