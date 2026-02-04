# Item REST API

This is a simple Spring Boot REST API for managing items (like ecommerce products).

## Technologies Used
- Java 17
- Spring Boot
- Maven

## How to Run

1. Import project in Eclipse
2. Run ItemApiApplication.java
3. Server starts on port 8080

## API Endpoints

1. Add Item
POST /api/items

Example JSON:
{
  "name": "iPhone 15",
  "description": "Apple smartphone",
  "price": 79999
}

2. Get Item by ID
GET /api/items/{id}

Example:
GET /api/items/1

## Features
- In-memory storage using ArrayList
- Input validation using @Valid
- Proper HTTP status codes
