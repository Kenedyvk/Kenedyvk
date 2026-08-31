# Enterprise API

Production-oriented REST API designed to demonstrate backend engineering skills for international software engineering roles.

## Stack

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Redis
- JWT authentication
- OpenAPI / Swagger
- Docker Compose
- JUnit 5 / Mockito
- GitHub Actions

## Architecture

The project follows a layered architecture with clear boundaries between API, application, domain and infrastructure concerns.

```text
src/main/java/com/kenedy/enterprise
├── api
├── application
├── domain
├── infrastructure
└── security
```

## Core features

- JWT-based authentication
- Role-based access control
- CRUD endpoints with validation and pagination
- Global exception handling
- PostgreSQL persistence
- Redis caching
- Health checks
- Unit and integration test structure
- Containerized local environment

## Running locally

```bash
docker compose up -d
./mvnw spring-boot:run
```

## Portfolio goal

This repository is intentionally structured as an enterprise-style backend project rather than a tutorial application. It is meant to demonstrate maintainable architecture, security, testing, data access and operational concerns.