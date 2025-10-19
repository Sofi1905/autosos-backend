# AutoSOS Backend Project

AutoSOS_Backend is a Spring Boot 3 REST API that helps drivers submit and manage emergency assistance requests such as accidents, car malfunctions, or roadside needs. It features JWT-based authentication, role-based access control, and an in-memory H2 database for quick testing.

## Requirements
- Java 17
- Maven 3.9+

## Getting Started

1. **Build the project**
   ```bash
   mvn clean install
   ```
2. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:8080` and the H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:autososdb`).

## Authentication
- `POST /api/auth/register` – create a new account (default admin user `admin`/`admin123` is created at startup).
- `POST /api/auth/login` – authenticate and receive a JWT token.

Include the token in the `Authorization: Bearer <token>` header for protected endpoints.

## Emergency Reports
- `POST /api/reports` – create a new emergency report for the authenticated user.
- `GET /api/reports/me` – retrieve reports created by the current user.
- `GET /api/reports` – **ADMIN only**: list all reports.
- `PUT /api/reports/{id}` – **ADMIN only**: update an existing report.

## Testing
Run the default test suite with:
```bash
mvn test
```
