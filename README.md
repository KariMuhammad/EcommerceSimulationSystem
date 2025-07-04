# 🛒 Simple E-Commerce Console App (Internship Task)

This is a Java-based console application that simulates a minimal e-commerce system.

---

## ✅ Features

- Define products with:
    - Name, price, quantity
    - Optional expiry date
    - Optional weight for shipping
- Enforce validation rules via a rule-based system
- Calculate shipping cost based on product weight
- Print a full checkout invoice with itemized details

---

## 📦 Product Types

- `Product`: Non-expirable, non-shippable
- `ExpirableProduct`: Has expiry date
- `ShippableProduct`: Has shipping weight
- `ExpirableShippableProduct`: Has both expiry and weight

---

## 🧠 Business Rules

The system validates the following:

- Product name must not be empty
- Price must be positive
- Quantity must not be negative
- Expirable products must have a future expiry date
- Shippable products must have weight > 0
- Cart items cannot exceed available product quantity

---

## 🛠 Technologies

- Java 23
- Object-Oriented Design
- Rule-based validation
- Factory pattern for product creation

---

## 📁 Structure Overview

```bash
src/
└─ karim/
    ├─ models/
    ├─ rules/
    ├─ factories/
    ├─ services/user
    ├─ contracts/
    └─ Main.java
```


## 📌 Considerable notes
- Financial precision was considered by using BigDecimal for price calculations where needed.
- All rules are pluggable and reusable.
- Easily extendable for taxes, discounts, and more.


## How to run application
```bash
# clone the repository
git clone https://github.com/yourusername/EcommerceSimulationSystem.git
cd EcommerceSimulationSystem
```

```bash
javac 
```
