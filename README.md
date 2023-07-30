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
- Spring Security
- PostgreSQL
- Jakarta Validation

## Getting Started

### Prerequisites
- Java 17 or higher
- PostgreSQL 9.4 or higher
- Maven 3.6.1 or higher

### Installation
1. Clone the repository: `https://github.com/sallmazakii/Basic-Core-Banking-System`
2. Create a PostgreSQL database named `core_banking_system`
3. Update the `application.properties` file with your PostgreSQL username and password
4. Build the project: `mvn clean package`
5. Run the application: `java -jar target/core-banking-system-0.0.1-SNAPSHOT.war`

The application should now be running on `http://localhost:8080`. You can use a tool like Postman to test the API endpoints.

## API Endpoints
  # Prroduct
- `GET /retrieveAllProducts`: Get all products
- `GET /retrieveProductById/{id}`: Get a product by ID
- `GET /retrieveProductByName/{name}` : Get a product by name
- `POST /createProduct`: Create a new product
- `PUT /updateProduct`: Update a product by ID
- `DELETE /deleteProduct/{id}`: Delete a product by ID
- `DELETE /deleteAllProducts`: Delete all products

  # Customer
- 
- `GET /retrieveAllCustomers`: Get all customers
- `GET /retrieveCustomerById/{id}`: Get a customer by ID
- `POST /createCustomer`: Create a new customer
- `PUT /updateCustomer/{id}`: Update a customer by ID
- `DELETE /deleteCustomer/{id}`: Delete a customer by ID
- `DELETE /deleteAllCustomers`: Delete all customers

  # Office
  
- `GET /retrieveAllOffices`: Get all offices
- `GET /retrieveOfficeById/{id}`: Get an office by ID
- `POST /createOffice`: Create a new office
- `PUT /updateOffice`: Update an office by ID
- `DELETE /deleteOffice/{id}`: Delete an office by ID

  # Loan
  
- `GET /retrieveAllLoans`: Get all loans
- `GET /retrieveLoanById/{id}`: Get a loan by ID
- `POST /createLoan`: Create a new loan
- `PUT /updateLoan`: Update an loan by ID
- `DELETE /deleteLoan/{id}`: Delete a loan by ID


  # Loan Workflow
  
- `POST /firstApprove`: revision approval for a loan 
- `POST /secondApprove/{id}`: Central revision approval for a loan
- `POST /thirdApprove`: Office branch manager approval for a loan
- `POST /issuance`: issue a loan

  # Authentication
- 'POST /signup': sign up
- 'POST /signin': sign in
  


