# Architecture Notes

## Reliability principles

Consumers should be idempotent so duplicate messages do not corrupt state. Failed deliveries should use bounded retries followed by a dead-letter queue. Every event should carry a correlation ID for end-to-end tracing.

## Consistency model

The system accepts eventual consistency between services. Business workflows should avoid distributed database transactions and instead coordinate state changes through domain events and compensating actions.

## Suggested event contracts

- `OrderCreated`
- `StockReserved`
- `StockRejected`
- `OrderConfirmed`
- `OrderCancelled`

Each event should include an event ID, aggregate ID, timestamp, version and correlation ID.

## Interview topics

This architecture is useful for discussing delivery guarantees, idempotency, retries, dead-letter queues, service ownership, database-per-service, observability and trade-offs between synchronous and asynchronous communication.