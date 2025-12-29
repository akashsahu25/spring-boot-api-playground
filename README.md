# spring-boot-api-playground

This repository is created for practicing Spring Boot REST APIs using Postman. It focuses on building, testing, and understanding CRUD operations, request handling, and API responses through hands-on practice.

<h2>🛠 Technologies Used</h2>

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Postman


<H2>🎯 Objectives</H2>

- Practice RESTful API development with Spring Boot
- Understand Controller → Service → Repository flow
- Work with databases using Spring Data JPA
- Test APIs using Postman
- Learn proper request & response handling



<h3>📂 Project Structure</h3>

com.akash.api<br>
 ├── controller   → REST controllers<br>
 ├── service      → Business logic<br>
 ├── repository   → JPA repositories<br>
 ├── entity       → JPA entities<br>
 └── dto          → Request/Response DTOs

<h2>⚙️ How to Run the Project</h2>

<h3>Make sure you have:</h3>

- Java 17+ (or Java 11)
- Maven
- MySQL
- Postman

<h3>2️⃣ Clone the Repository</h3>

- git clone https://github.com/your-username/spring-boot-api-playground.git
- cd spring-boot-api-playground

<h3>3️⃣ Configure Database</h3>

Using MySQL
- spring.datasource.url=jdbc:mysql://localhost:3306/spring_api_db
- spring.datasource.username=root
- spring.datasource.password=your_password
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

<h3>4️⃣ Run the Application</h3>

- Using Maven<br>
  mvn spring-boot:run

- OR using IDE (IntelliJ / STS / VS Code)<br>
  Open project<br>
  Run SpringBootApiPlaygroundApplication.java

<h3>5️⃣ Test APIs Using Postman</h3>

Example endpoints:

- POST   /api/users
- GET    /api/users
- GET    /api/users/{id}
- PUT    /api/users/{id}
- DELETE /api/users/{id}
