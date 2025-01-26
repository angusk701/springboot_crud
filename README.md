# Customer Management API

## Overview

This Customer Management API is a simple Spring Boot application designed for managing customer data. It allows users to perform CRUD operations on customer information stored in a database.

## Features

- **List all customers**: Retrieve a list of all customers in the database.
- **Add a new customer**: Add a new customer's details to the database.
- **Update an existing customer**: Update details for an existing customer.
- **Delete a customer**: Remove a customer's details from the database.
- **Greeting**: Returns a simple greeting message.

## Prerequisites

Before you can run this application, you'll need to have the following installed:
- Java JDK 11 or later
- Maven 3.6 or later (if building from source)
- An instance of a relational database (e.g., MySQL, PostgreSQL) running locally or remotely with the necessary schema and credentials


## API Endpoints

- `GET /api/v1/customers`: Lists all customers.
- `POST /api/v1/customers`: Adds a new customer. Requires a JSON body with `name`, `email`, and `age`.
- `PUT /api/v1/customers/{customerId}`: Updates an existing customer identified by `customerId`. Requires a JSON body with `name`, `email`, and `age`.
- `DELETE /api/v1/customers/{customerId}`: Deletes the customer identified by `customerId`.
- `GET /api/v1/customers/`: Returns a greeting message.


