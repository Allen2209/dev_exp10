# Simple Login and Signup System (Maven + Spring Boot)

## Requirements
- JDK 21
- Maven (or use the included Maven wrapper)

## Run
Windows CMD, from the project folder:
```cmd
mvnw.cmd spring-boot:run
```
Or:
```cmd
mvn spring-boot:run
```
Open http://localhost:8080

## Run Java test cases
```cmd
mvnw.cmd test
```

## API endpoints
- `POST /api/signup` JSON: `{"name":"Allen","email":"allen@example.com","password":"secret123"}`
- `POST /api/login` JSON: `{"email":"allen@example.com","password":"secret123"}`

## Notes
This is a beginner demonstration. Accounts are stored in memory and disappear when the application stops. It is not production authentication: production systems should use a database, Spring Security sessions/tokens, rate limiting, email verification and CSRF protections.
