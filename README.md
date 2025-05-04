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
