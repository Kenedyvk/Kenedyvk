# ADR 001: Transactional Outbox for Domain Events

## Status

Accepted.

## Context

The Order Service must persist an order and publish `order.created.v1`. Writing to PostgreSQL and RabbitMQ in two independent operations creates a dual-write failure mode: the database transaction may commit while message publication fails, or the message may be published before the database transaction is durable.

## Decision

The Order Service will use the transactional outbox pattern.

1. Persist the aggregate change and an outbox row in the same PostgreSQL transaction.
2. A background publisher reads unpublished outbox rows and sends them to RabbitMQ.
3. After broker acknowledgement, the row is marked as published.
4. Consumers remain idempotent because at-least-once delivery can produce duplicates.

Each event includes `eventId`, `correlationId`, event version and occurrence time. Consumers store processed event IDs where duplicate side effects would be harmful.

## Consequences

### Positive

- Removes the database/broker dual-write gap.
- Gives failed publications a durable retry source.
- Supports at-least-once delivery without pretending exactly-once delivery exists end-to-end.
- Creates an auditable trail of domain events awaiting publication.

### Trade-offs

- Adds an outbox table and publisher process.
- Requires cleanup/retention policy for published rows.
- Requires idempotency at consumers.
- Introduces a small delay between transaction commit and broker publication.

## Rejected alternative

Publishing directly to RabbitMQ inside the HTTP request was rejected because a broker failure after database commit can silently lose the domain event.
