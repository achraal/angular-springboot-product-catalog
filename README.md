# 🛒 Inset App - Full-Stack Product Management Application

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x%20%2F%204.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-Latest-DD0031?style=for-the-badge&logo=angular&logoColor=white)](https://angular.dev/)
[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![TypeScript](https://img.shields.io/badge/TypeScript-5.x-3178C6?style=for-the-badge&logo=typescript&logoColor=white)](https://www.typescriptlang.org/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)](https://getbootstrap.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

A modern full-stack web application for product catalog and inventory management, built with **Spring Boot** (RESTful API, JPA, H2) on the backend and **Angular** (Standalone Components, Reactive Forms, Bootstrap 5) on the frontend.

Developed as part of the **JEE & Angular Practical Labs** (*Activité Pratique N°3*).

---

## 📑 Table of Contents

- [Features](#-features)
- [Architecture & Tech Stack](#-architecture--tech-stack)
- [Repository Structure](#-repository-structure)
- [REST API Endpoints](#-rest-api-endpoints)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Backend Setup (Spring Boot)](#1-backend-setup-spring-boot)
  - [Frontend Setup (Angular)](#2-frontend-setup-angular)
- [Application Flow & Screenshots](#-application-flow)
- [License](#-license)

---

## ✨ Features

### 🖥️ Frontend (Angular)
- **Standalone Components & Control Flow**: Leverages modern Angular architecture (`@if`, `@for`).
- **Product Catalog View**: Displays a table of all products with formatted currency and status badges.
- **Dynamic Search**: Instant client-side search filtering by product name in real time.
- **Status Toggle**: One-click toggle for product selection status (`selected`) synchronized with the backend.
- **Product Creation**: Reactive form with client-side validation (`Validators.required`, `Validators.min`).
- **Product Deletion**: Safe deletion with user confirmation prompt.
- **Modern UI**: Clean and responsive design styled with Bootstrap 5 and Bootstrap Icons.

### ⚙️ Backend (Spring Boot)
- **Layered Architecture**: Clean separation of Controller, Service, DTO, Mapper, and Repository layers.
- **RESTful Endpoints**: Full CRUD support along with search and partial updates (`PATCH`).
- **Data Persistence**: Spring Data JPA with H2 in-memory database for rapid development and testing.
- **CORS Configured**: Configured to seamlessly serve requests from the Angular client (`localhost:4200`).
- **Data Initialization**: Automatic database seeding on startup via `CommandLineRunner`.

---

## 🛠️ Architecture & Tech Stack

| Layer | Technologies |
| :--- | :--- |
| **Frontend** | Angular, TypeScript, RxJS, Bootstrap 5, Bootstrap Icons, HTML5/CSS3 |
| **Backend** | Java 21, Spring Boot, Spring Web MVC, Spring Data JPA, Lombok |
| **Database** | H2 In-Memory Database |
| **Build & Tooling** | Maven (mvnw), npm / Angular CLI |

---

## 📂 Repository Structure

```text
inset-app/
├── inset-app-backend/               # Spring Boot Application
│   ├── src/main/java/com/achraf/insetappbackend/
│   │   ├── dtos/                    # Request and Response DTOs
│   │   ├── entities/                # JPA Entities (Product)
│   │   ├── mappers/                 # Entity-DTO Mappers
│   │   ├── repositories/            # Spring Data JPA Repositories
│   │   ├── services/                # Business Logic & Service Interfaces
│   │   │   └── impl/                # Service Implementations
│   │   └── web/                     # REST Controllers (ProductRestController)
│   ├── src/main/resources/
│   │   └── application.properties   # Port (8083), H2 DB & JPA Configuration
│   └── pom.xml                      # Maven Dependencies
│
├── inset-app-frontend/              # Angular Application
│   ├── src/app/
│   │   ├── home/                    # Home Component
│   │   ├── products/                # Products List Component (Search, Toggle, Delete)
│   │   ├── new-product/             # Add Product Form Component (Reactive Forms)
│   │   ├── services/                # Product HTTP Service
│   │   ├── app.routes.ts            # Application Routing
│   │   └── app.ts                   # Root Component
│   ├── package.json                 # Node Dependencies & Scripts
│   └── angular.json                 # Angular Workspace Configuration
│
└── README.md                        # Project Documentation
```

---

## 🔌 REST API Endpoints

The backend server runs by default on `http://localhost:8083`.

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/products` | Retrieve list of all products |
| `GET` | `/products/{id}` | Retrieve a specific product by ID |
| `POST` | `/products` | Create a new product |
| `PUT` | `/products/{id}` | Update an existing product |
| `PATCH` | `/products/{id}` | Toggle the `selected` status of a product |
| `DELETE` | `/products/{id}` | Remove a product by ID |
| `GET` | `/products/search?kw={keyword}` | Search products by name keyword |

> **H2 Database Console:** Available at `http://localhost:8083/h2-console` (JDBC URL: `jdbc:h2:mem:productsDB`).

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:
- [Java Development Kit (JDK) 21+](https://adoptium.net/)
- [Node.js (v18+ or v20+)](https://nodejs.org/) & [npm](https://www.npmjs.com/)
- [Angular CLI](https://angular.dev/tools/cli) (`npm install -g @angular/cli`)
- [Git](https://git-scm.com/)

---

### 1. Backend Setup (Spring Boot)

1. Navigate to the backend directory:
   ```bash
   cd inset-app-backend
   ```

2. Run the application using the Maven wrapper:
   - **Linux / macOS:**
     ```bash
     ./mvnw spring-boot:run
     ```
   - **Windows:**
     ```cmd
     mvnw.cmd spring-boot:run
     ```

3. The backend will start on `http://localhost:8083`.

---

### 2. Frontend Setup (Angular)

1. Open a new terminal and navigate to the frontend directory:
   ```bash
   cd inset-app-frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the Angular development server:
   ```bash
   npm start
   # or
   ng serve
   ```

4. Open your browser and navigate to:
   ```text
   http://localhost:4200
   ```

---

## 📸 Application Flow

1. **Product Listing**: Displays seeded items (*Ordinateur Portable*, *Imprimante*, *Smartphone*).
2. **Dynamic Search**: Type in the search box to filter products in real time without reloading.
3. **Toggle Status**: Click on the status badge to switch between `Sélectionné` and `Non sélectionné`.
4. **Add Product**: Navigate to **Nouveau Produit**, fill in the form with validation checks, and submit.
5. **Delete Product**: Click the delete button with prompt confirmation to remove items.

---

## 📝 License

Distributed under the MIT License. See `LICENSE` for more information.

