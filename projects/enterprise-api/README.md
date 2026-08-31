# Enterprise API

Production-oriented REST API built to demonstrate backend engineering practices for international software engineering roles.

## Stack

- Java 21
- Spring Boot 3.5
- Spring Security / OAuth2 Resource Server
- Spring Data JPA
- PostgreSQL
- Redis
- JWT with RSA signatures
- OpenAPI / Swagger UI
- Docker Compose
- Maven
- GitHub Actions

## Implemented

- User persistence with PostgreSQL
- User registration with BCrypt password hashing
- Login with signed JWT access tokens
- Stateless API security
- Protected `/api/me` endpoint
- User roles in the domain model (`USER`, `MANAGER`, `ADMIN`)
- Bean Validation on authentication requests
- PostgreSQL + Redis local infrastructure through Docker Compose
- Actuator health/metrics configuration
- Swagger / OpenAPI integration
- Path-scoped GitHub Actions CI
- Environment-based database configuration

## Project structure

```text
src/main/java/com/kenedy/enterprise
├── auth
├── security
└── user
```

The structure is intentionally feature-oriented so the application can grow without turning controllers, services and repositories into large global folders.

## Running locally

Requirements: Java 21, Maven and Docker.

```bash
docker compose up -d
mvn spring-boot:run
```

Useful URLs after startup:

```text
Health:      http://localhost:8080/actuator/health
Swagger UI: http://localhost:8080/swagger-ui.html
```

### Register

```http
POST /api/auth/register
Content-Type: application/json

{
  "email": "developer@example.com",
  "password": "strong-password"
}
```

### Login

```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "developer@example.com",
  "password": "strong-password"
}
```

Use the returned token as `Authorization: Bearer <token>` when calling protected endpoints.

## Next engineering milestones

- Enforce role-based authorization at endpoint/service level
- Replace development-time RSA key generation with externally managed keys
- Add Flyway database migrations and disable Hibernate schema mutation
- Add refresh-token rotation and token revocation strategy
- Implement centralized API error responses
- Add Redis-backed caching to a real business use case
- Add unit, repository and Testcontainers integration tests
- Add pagination, filtering and auditing to business resources
- Add container image build and deployment pipeline

## Portfolio goal

The goal is not to pretend this is already a finished enterprise product. Each milestone is being implemented explicitly so the repository demonstrates real engineering decisions, incremental delivery and production-readiness concerns.
