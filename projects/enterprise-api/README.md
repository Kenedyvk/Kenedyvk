# Enterprise API

Production-oriented REST API built to demonstrate backend engineering practices for international software engineering roles.

## Stack

- Java 21
- Spring Boot 3.5
- Spring Security / OAuth2 Resource Server
- Spring Data JPA
- PostgreSQL
- Redis
- Flyway
- JWT with RSA signatures
- OpenAPI / Swagger UI
- Docker Compose
- Testcontainers
- Maven
- GitHub Actions

## Implemented

- User persistence with PostgreSQL
- Versioned database schema with Flyway
- Hibernate schema validation instead of automatic schema mutation
- User registration with BCrypt password hashing
- Login with signed JWT access tokens
- Stateless API security
- Protected `/api/me` endpoint
- Domain roles: `USER`, `MANAGER`, `ADMIN`
- JWT role claim mapped to Spring Security authorities
- Admin-only `/api/admin/users` endpoint with bounded pagination
- Bean Validation on authentication requests
- Centralized validation errors using `ProblemDetail`
- PostgreSQL + Redis local infrastructure through Docker Compose
- Actuator health/metrics configuration
- Swagger / OpenAPI integration
- Testcontainers integration tests against a real PostgreSQL container
- Path-scoped GitHub Actions CI
- Environment-based database configuration

## Project structure

```text
src/main/java/com/kenedy/enterprise
├── api
├── auth
├── security
└── user

src/main/resources
└── db/migration
```

The structure is feature-oriented so the application can grow without turning controllers, services and repositories into large global folders.

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

## Testing

Integration tests use Testcontainers, so Docker must be available:

```bash
mvn test
```

The authentication test starts a disposable PostgreSQL container, applies Flyway migrations and exercises the HTTP API through MockMvc.

## Next engineering milestones

- Replace development-time RSA key generation with externally managed keys
- Add refresh-token rotation and token revocation strategy
- Add Redis-backed caching to a real business use case
- Add business resources with pagination, filtering and auditing
- Add repository/service unit tests in addition to HTTP integration tests
- Add container image build and deployment pipeline
- Add observability with structured logs and tracing

## Portfolio goal

The goal is not to pretend this is already a finished enterprise product. Each milestone is implemented explicitly so the repository demonstrates real engineering decisions, incremental delivery and production-readiness concerns.
