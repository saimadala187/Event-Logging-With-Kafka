# Event Logging Microservices App (Kafka + Spring Boot + React + MySQL)

This is a real-time event logging system using Microservices architecture.

## ✨ Features

- Microservices with Spring Boot
- Kafka-based event streaming
- MySQL for event persistence
- React dashboard UI
- Dockerized using Docker Compose

## 🛠️ Tech Stack

- Java + Spring Boot
- Apache Kafka
- MySQL
- React.js (Vite)
- Docker + Docker Compose

## 📦 Microservices

1. **event-producer**: Generates application events like user login, order creation, etc.
2. **event-consumer**: Listens to Kafka topics and stores events in MySQL.
3. **event-dashboard**: React app to view event logs.

## 🐳 Run with Docker

```bash
docker-compose up --build


![image](https://github.com/user-attachments/assets/20889537-b511-4107-a009-8a4d0852ca4a)

