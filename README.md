# DigitalBank Fraud Detection System

A runnable Spring Boot and JPA learning POC for transaction monitoring. It includes Customer, Account, Transaction and Fraud Alert modules; rule-based scoring; validation; RFC 7807 errors; pagination; optimistic locking; H2/PostgreSQL profiles; HTTP Basic security; Actuator; Swagger; Docker; and a unit test.

> Learning POC only. Do not process real customer, card, identity, or banking data. This is not certified for production or regulatory use.

## Requirements
- JDK 21
- Maven 3.6.3+
- Docker Desktop or Podman (optional)

## Run locally
```bash
mvn clean test
mvn spring-boot:run
```
Login: `analyst` / `change-me` (change before sharing). Swagger: `http://localhost:8080/swagger-ui.html`

## Quick API flow
```bash
curl -u analyst:change-me -H "Content-Type: application/json" -d '{"fullName":"Demo User","email":"demo@example.com"}' http://localhost:8080/api/customers
curl -u analyst:change-me -H "Content-Type: application/json" -d '{"customerId":1,"accountNumber":"DB00000001","openingBalance":200000}' http://localhost:8080/api/accounts
curl -u analyst:change-me -H "Content-Type: application/json" -d '{"accountId":1,"amount":150000,"channel":"IMPS","deviceId":"device-1","countryCode":"IN"}' http://localhost:8080/api/transactions
curl -u analyst:change-me http://localhost:8080/api/fraud-alerts
```
The sample transaction is flagged because the amount exceeds 100,000. Rules are educational, deterministic examples only.

## PostgreSQL
```bash
mvn clean package
docker compose up --build
```

## Git setup
```bash
git init
git add .
git commit -m "Initial DigitalBank fraud detection POC"
git branch -M main
git remote add origin YOUR_REPOSITORY_URL
git push -u origin main
```

## Next learning increments
1. Replace HTTP Basic with OAuth2/OIDC or a carefully implemented JWT flow.
2. Add Flyway migrations rather than Hibernate schema updates.
3. Add Redis-backed velocity counters and rate limiting.
4. Publish transaction events with Kafka and implement idempotent consumers.
5. Add Spring Batch reconciliation import, Testcontainers, audit trail, metrics and CI.
