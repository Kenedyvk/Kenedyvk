# Event-Driven Commerce

Distributed backend project designed to demonstrate microservices, asynchronous messaging and resilient system design.

## Stack

- Java 21
- Spring Boot
- PostgreSQL
- RabbitMQ
- Redis
- Docker Compose
- OpenTelemetry-ready architecture
- JUnit 5

## Services

- Order Service: creates and tracks customer orders.
- Inventory Service: reserves and releases stock.
- Notification Service: reacts to domain events and sends notifications.

## Event flow

```text
OrderCreated
   ↓
Inventory Service
   ↓
StockReserved / StockRejected
   ↓
Order Service
   ↓
OrderConfirmed / OrderCancelled
   ↓
Notification Service
```

## Engineering topics demonstrated

- Event-driven architecture
- Service boundaries
- Idempotent consumers
- Retry and dead-letter queue strategy
- Eventual consistency
- Database-per-service concept
- Observability and correlation IDs
- Contract-oriented integration
- Containerized development environment

## Portfolio goal

This project is intentionally focused on backend architecture rather than UI. It provides material for technical interviews involving distributed systems, reliability and system design.