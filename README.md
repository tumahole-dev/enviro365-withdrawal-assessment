# Enviro365 Investments — Withdrawal Notice System

Full-stack junior developer assessment for Enviro365 Investments. Allows investors to view their portfolio, submit withdrawal requests (with business rule validation), view withdrawal history, and export statements as CSV.

## Tech Stack
- Backend: Java 21, Spring Boot, Spring Data JPA, H2 (in-memory database)
- Frontend: React (Vite)

## Project Structure
backend/ - Spring Boot REST API
frontend/ - React UI

## Setup and Running

### Backend
cd backend
./mvnw spring-boot:run

Runs on http://localhost:8080. H2 console available at http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:enviro365, username: sa, no password).

### Frontend
cd frontend
npm install
npm run dev

Runs on http://localhost:5173.

Both must be running at the same time.

## Business Rules Implemented
- Retirement withdrawals only allowed if investor age is over 65
- Withdrawal amount must not exceed available balance
- Withdrawal amount must not exceed 90% of balance
- Input validation on withdrawal requests

## API Endpoints
- GET /api/investors/{id}/portfolio - investor details and products
- POST /api/withdrawals - create a withdrawal
- GET /api/withdrawals - list all withdrawal notices
- GET /api/reports/withdrawals/csv?start=YYYY-MM-DD&end=YYYY-MM-DD - CSV export with date filtering

## Advanced Features Implemented
- DTO layer
- Global exception handling
- Input validation

## AI Usage Disclosure
This project was built with AI assistance (Claude) for guidance on Spring Boot and React patterns, debugging, and code review. All code was reviewed and understood.

## Screenshots

### Portfolio Dashboard
![Portfolio Dashboard](screenshots/Portfolio%20Dashboard.png)

### Withdrawal Form
![Withdrawal Form](screenshots/Withdrawal%20Form.png)

### Withdrawal History
![Withdrawal History](screenshots/Withdrawal%20History.png)

### Withdrawal Error
![Withdrawal Error](screenshots/Withdrawal%20error.png)