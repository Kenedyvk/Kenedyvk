# Architecture

Nexus Platform is designed as a modular monolith first, with boundaries that can later be extracted into services if scaling or team ownership requires it.

## Modules

- Identity: authentication, users, roles and permissions.
- Messaging: conversations, channels and messages.
- Scheduling: rooms, meetings and conflict detection.
- Directory: people, teams and departments.
- Audit: security-sensitive and administrative events.
- Notifications: in-app and asynchronous notifications.

## Design decisions

A modular monolith keeps deployment simple while still demonstrating domain separation. PostgreSQL is the system of record, Redis supports caching and ephemeral state, and WebSocket connections provide real-time updates. Authorization rules must be enforced on the backend rather than relying on frontend visibility.

## Evolution path

If load or organizational boundaries justify it, Messaging and Notifications can be extracted behind asynchronous events while Identity remains the source of authorization data.