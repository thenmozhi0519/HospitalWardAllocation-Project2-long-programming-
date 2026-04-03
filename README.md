# 🏥Hospital Ward Allocation System

## 📌 Use Case

This project simulates a simple hospital scenario where patients are assigned to wards based on their condition.

* Emergency patients → ICU
* Normal patients → General ward
* Bed count is updated automatically during assignment and deletion

---
## 🚀 What I Built

* Connected MySQL with Spring Boot using IntelliJ
* Created REST APIs for basic CRUD operations
* Implemented simple business logic for ward allocation
* Managed database relationships using JPA (Many-to-One)

---

## 🔗 APIs

* POST `/api/patients/assign` → Assign patient to ward
* GET `/api/patients/all` → View all patients
* PUT `/api/patients/update/{id}` → Update patient
* DELETE `/api/patients/delete/{id}` → Delete patient

---

## 🎯 Goal

To understand:

* How to connect MySQL with Spring Boot
* How backend APIs work
* How real-time data is stored and updated in a database

---

## ✨ Note

This is a beginner-level backend project focused on learning core concepts.
