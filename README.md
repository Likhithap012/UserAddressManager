# UserAddressManager

A Spring Boot REST API that manages users and their associated addresses using DTOs, entity relationships, and MySQL.

---

##  Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven


---

## 📁 Project Structure

```

src/
├── controller
│   └── AddressBookController.java
├── dto
│   └── AddressBookDTO.java
├── entity
│   ├── User.java
│   └── Address.java
├── mapper
│   └── AddressBookMapper.java
├── repository
│   ├── UserRepository.java
│   └── AddressRepository.java
├── service
│   └── AddressBookService.java
└── Application.java

````

---

## Features

- Add a user with multiple addresses
- Retrieve user data through DTOs
- Entity relationships using:
  - `@OneToMany`
  - `@ManyToOne`
- DTO to Entity mapping via a dedicated mapper
- Clean layered architecture: Controller → Service → Repository

---

##  Configuration

### `application.properties`

```properties
# Server
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/useraddress
spring.datasource.username=root
spring.datasource.password=yourpassword

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
````

Make sure you **create the database manually** in MySQL:

```sql
CREATE DATABASE useraddress;
```

---

##  How to Run

1. Clone the project:

   ```bash
   git clone https://github.com/yourusername/user-address-book.git
   cd user-address-book
   ```

2. Open in your IDE and run the `Application.java` class.

3. Make sure MySQL is running and the database is created.

4. Test APIs using Postman.

---


##  Dependencies

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

