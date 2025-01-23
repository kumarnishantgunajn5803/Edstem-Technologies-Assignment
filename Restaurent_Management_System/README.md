# Edstem-Technologies-Assignment
# Restaurant Order Management API

This repository contains the source code for a Restaurant Order Management API.

**Overview**

This API provides endpoints for managing restaurant menu items and orders, enabling efficient online food ordering. 

**Key Features**

* **Menu Management:**
    * Create, read, and update menu items with details like name, price, availability, and category.
    * Filter menu items by category for easy browsing.
* **Order Management:**
    * Create new orders with multiple menu items and customer information.
    * Retrieve order details by ID for tracking and fulfillment.
* **Data Validation:** Enforces data integrity with robust input validation, ensuring accurate and reliable data.
* **Business Logic:** Implements core business rules, such as:
    * Calculating order totals accurately based on item prices and quantities.
    * Updating inventory in real-time to reflect available stock.
    * Preventing orders for items with insufficient stock.
* **Error Handling:** Provides meaningful error messages and appropriate HTTP status codes for various error scenarios.

**Technologies Used**

* Spring Boot, Java, Spring Data JPA, MySql Database

