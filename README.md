# Sports Club Management – Backend

This is the backend part of the **Sports Club Management** project, developed as the final exam project for the *Internet Software Architecture* course.

The application provides a RESTful API for managing members, training sessions, attendance, payments, and user roles (admin, coach, member) in a sports club environment.

## 🛠 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- Spring Security + JWT
- MySQL / H2 (configurable)
- Maven
- RESTful Web Services

## 📁 Project Structure
src/
├── config/         # Security and CORS configuration
├── controller/     # REST API controllers
├── dto/            # Data Transfer Objects
├── model/          # Entity classes (JPA)
├── repository/     # Spring Data JPA repositories
├── service/        # Business logic layer
├── util/           # Utility classes (e.g. JWT handling)

## 🔐 Authentication & Authorization

- Role-based access control using Spring Security
- JWT authentication with token validation
- Roles: `ADMIN`, `COACH`, `MEMBER`
- Refresh token functionality included

## 🗃️ Database Schema

The project includes at least **5 entities** with relationships:

- `User` – represents all users (with roles)
- `Member` – club members
- `TrainingSession` – scheduled training sessions
- `Attendance` – attendance tracking per session
- `Payment` – member payments (monthly fees)

### Entity Relationships

- `User` has one `Role`
- `Member` attends many `TrainingSessions`
- `TrainingSession` has many `Attendances`
- `Payment` is linked to a `Member`
- More relations are defined in the `model` package

## 🔄 API Endpoints

Full CRUD is implemented for all major entities:
- `GET /api/members`
- `POST /api/trainings`
- `PUT /api/payments/{id}`
- `DELETE /api/attendance/{id}`
- etc.

You can test the API using Postman or Swagger UI (if enabled).

## 🚀 Running the Application

1. Clone the repository
git clone https://github.com/yourusername/sports-club-backend.git
cd sports-club-backend
# src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/sports_club
spring.datasource.username=root
spring.datasource.password=yourpassword

RUN THE APP:
./mvnw spring-boot:run

📑 Project Purpose

This project demonstrates:
	•	Understanding of RESTful architecture
	•	Secure web services with Spring Security
	•	Database modeling and JPA relationships
	•	Real-world structure for web backend

📜 License
This project is for educational purposes as part of the university course. No license attached.
