# Core-Banking-System

The Core-Banking-System is a Java-based web application built using Spring Boot 3.1.1 and PostgreSQL as the database, with Jakarta Validation for input validation. The project contains CRUD operations for products, customers, and offices, allowing users to easily manage their banking system.

## Features
- Create, read, update, and delete products
- Create, read, update, and delete customers
- Create, read, update, and delete offices
- Input validation using Jakarta Validation
- PostgreSQL as the database

## Technologies Used
- Spring Boot 3.1.1
- PostgreSQL
- Jakarta Validation

## Getting Started

### Prerequisites
- Java 8 or higher
- PostgreSQL 9.4 or higher
- Maven 3.6.1 or higher

### Installation
1. Clone the repository: `git clone https://github.com/your-username/Core-Banking-System.git`
2. Create a PostgreSQL database named `core_banking_system`
3. Update the `application.properties` file with your PostgreSQL username and password
4. Build the project: `mvn clean install`
5. Run the application: `java -jar target/core-banking-system-0.0.1-SNAPSHOT.jar`

The application should now be running on `http://localhost:8080`. You can use a tool like Postman to test the API endpoints.

## API Endpoints
  # Prroduct
- `GET /products`: Get all products
- `GET /products/{id}`: Get a product by ID
- `POST /products`: Create a new product
- `PUT /products/{id}`: Update a product by ID
- `DELETE /products/{id}`: Delete a product by ID

  # Customer
- 
- `GET /customers`: Get all customers
- `GET /customers/{id}`: Get a customer by ID
- `POST /customers`: Create a new customer
- `PUT /customers/{id}`: Update a customer by ID
- `DELETE /customers/{id}`: Delete a customer by ID

  # Office
  
- `GET /offices`: Get all offices
- `GET /offices/{id}`: Get an office by ID
- `POST /offices`: Create a new office
- `PUT /offices/{id}`: Update an office by ID
- `DELETE /offices/{id}`: Delete an office by ID

