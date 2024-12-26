# Microservices Distributed Tracing

## Overview

This class diagram demonstrates the design of a microservice architecture for an e-commerce system, featuring three core services: **Order Microservice**, **Payment Microservice**, and **Product Microservice**. The architecture is intended for handling order processing, payment validation, and product availability checks. Each service communicates through API calls, ensuring a loosely coupled system.

![image](https://github.com/user-attachments/assets/916d5665-9bbb-4000-bb80-a4e1f4e60e24)

---

## Key Classes and Components

### 1. **Order Microservice**

- **`OrderController`**:
  - Handles incoming order processing requests.
  - **Methods**:
    - `processOrder()`: Initiates the order processing flow.
  
- **`OrderService`**:
  - Manages business logic related to order processing.
  - **Methods**:
    - `validateProduct()`: Validates the product being ordered.
    - `processPayment()`: Initiates payment processing by interacting with the **Payment Microservice**.

### 2. **Payment Microservice**

- **`PaymentController`**:
  - Manages payment-related requests.
  - **Methods**:
    - `processPayment()`: Handles payment processing for orders initiated by the **Order Microservice**.

### 3. **Product Microservice**

- **`ProductController`**:
  - Handles requests related to product validation.
  - **Methods**:
    - `validateProduct()`: Ensures the availability and eligibility of the product being ordered.

---

## Relationships

- **`OrderController`** interacts with **`OrderService`** to manage the order flow.
- **`OrderService`** communicates with:
  - **`PaymentController`** to initiate payment processing.
  - **`ProductController`** to validate the product before confirming the order.

---

## How It Works

1. **Order Processing**:
   - A user places an order through the **Order Microservice**. The **OrderController** handles the request by calling the `processOrder()` method.
   
2. **Product Validation**:
   - The **OrderService** calls the **ProductController**'s `validateProduct()` method to check product availability and eligibility.

3. **Payment Processing**:
   - If the product is valid, the **OrderService** calls the **PaymentController**'s `processPayment()` method to handle the payment process.

4. **Transaction Flow**:
   - The **OrderService** coordinates these actions in sequence, ensuring that the product is validated before payment is processed.
