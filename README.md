**Movie API**

**Description**
Movie API is a RESTful web service built with Spring Boot 3.3.x, Java 17, and MySQL. The application supports CRUD operations for managing movies and users, role-based authentication and authorization using JWT, and file handling for uploading and downloading movie-related files. The API also includes advanced features such as pagination, sorting, complex validations, and robust exception handling.

**Features**
CRUD Operations: Create, Read, Update, and Delete operations for movies and users.
Authentication and Authorization: Secure endpoints with Spring Security and JWT (JSON Web Tokens).
Role-Based Access Control: Manage user roles and permissions.
File Handling: Upload and download files related to movies.
Pagination and Sorting: Efficient data retrieval with pagination and sorting support.
Validation: DB-level and application-level validations to ensure data integrity.
Exception Handling: Global exception handling to provide meaningful error responses.

**Technologies Used**
Java 17
Spring Boot 3.3.x
Spring Data JPA
Spring Security
JWT (JSON Web Tokens)
MySQL
Jakarta XML Binding
Hibernate
Maven

**Getting Started**
**Prerequisites**
Java 17
Maven
MySQL

**Installation**
**Clone the repository:**

git clone https://github.com/yourusername/movie-api.git
cd movie-api

**Configure the Database:**
Update the application.properties file with your MySQL database configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true

jwt.secret=your-secret-key
jwt.expiration=3600000

**Build the Project:**

mvn clean install

**Run the Application:**

mvn spring-boot:run

**API Endpoints**
**Authentication**
Register User: POST /api/auth/register

json

{
"username": "newuser",
"password": "password",
"role": "USER"
}

Login User: POST /api/auth/login

json

{
"username": "existinguser",
"password": "password"
}

**Movies**

Create Movie: POST /api/movies
Get All Movies: GET /api/movies
Get Movie by ID: GET /api/movies/{id}
Update Movie: PUT /api/movies/{id}
Delete Movie: DELETE /api/movies/{id}

**Users**

Get All Users: GET /api/users
Get User by ID: GET /api/users/{id}
Update User: PUT /api/users/{id}
Delete User: DELETE /api/users/{id}

**File Handling**

Upload File: POST /api/movies/{id}/upload
Download File: GET /api/movies/{id}/download

**Usage**

Using Postman or Insomnia

**Register a new user:**

URL: http://localhost:8080/api/auth/register
Method: POST
Body:
json

{
"username": "newuser",
"password": "password",
"role": "USER"
}

Login as the registered user to get the JWT token:

URL: http://localhost:8080/api/auth/login
Method: POST
Body:
json

{
"username": "newuser",
"password": "password"
}

The response will include a JWT token.
Use the JWT token for authenticated requests:

Add the token to the Authorization header of your requests:

Authorization: Bearer your-jwt-token
