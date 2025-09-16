# 📚 Library Management System

A professional Java-based library management system built with clean architecture principles, design patterns, and enterprise-level logging. This project demonstrates practical implementation of Object-Oriented Programming concepts including inheritance, encapsulation, polymorphism, and abstraction.

## 🎯 Project Overview

This system handles the core operations of a library: managing books and patrons, processing checkouts and returns, calculating late fees, and managing book reservations. The codebase follows SOLID principles and incorporates multiple design patterns for maintainability and extensibility.

## ✨ Features

### Core Functionality

* 📖 **Book Management**
  * Add, remove, and search books by title, author, or ISBN

* 👥 **Patron Management**
  * Register library members and track their borrowing history

* 🔄 **Checkout/Return Process**
  * Handle book lending with automatic status tracking

* 💰 **Fine Calculation**
  * Automatic late fee computation based on configurable rates

* 📊 **Inventory Tracking**
  * Real-time monitoring of book availability

### Advanced Features

* 🔖 **Reservation System**
  * Patrons can reserve books that are currently checked out

* 📬 **Notification System**
  * Automatic alerts when reserved books become available

* 📝 **Borrowing History**
  * Complete transaction records for each patron

* 🔍 **Professional Logging**
  * Enterprise-grade logging using SLF4J and Logback

* 🛠️ **Maven Integration**
  * Streamlined dependency management and build process

## 🏗️ Architecture

### Design Patterns

* **Factory Pattern** (LibraryFactory)
  * Centralizes object creation and configuration
  * Makes the system easy to extend and maintain

* **Strategy Pattern** (FineService)
  * Enables flexible fine calculation algorithms
  * Allows easy modification of penalty rules

* **Observer Pattern** (ReservationService, NotificationService)
  * Implements automatic notifications for book availability
  * Decouples reservation management from notification logic

### Technology Stack

* **Java 23**: Latest Java features and language enhancements
* **Maven**: Build automation and dependency management
* **SLF4J**: Simple Logging Facade for Java
* **Logback**: High-performance logging framework
* **Enterprise Logging**: Professional logging configuration with file and console output

## 📂 Project Structure

```
LibraryManagementSystem/
├── library/
│   └── src/
│       ├── constants/          # Configuration enums and constants
│       ├── factory/           # Factory pattern implementations
│       ├── interfaces/        # Core system contracts
│       ├── models/           # Domain entities
│       ├── service/          # Business logic implementations
│       ├── LibraryManagementSystem.java    # Main application entry point
│       └── logback.xml       # Logging configuration
├── logs/
│   └── library.log           # Application log files
├── LibraryUML                # UML diagram
├── target/                   # Maven build output
├── pom.xml                  # Maven project configuration
└── README.md
```

## 📜 Logging Framework

The system implements enterprise-grade logging using SLF4J and Logback:

### Logging Configuration

* **Console Appender**: Real-time log output during development
* **File Appender**: Persistent logging to logs/library.log
* **Configurable Log Levels**: INFO, DEBUG, WARN, ERROR support
* **Structured Log Format**: Timestamp, log level, thread, and class information

### Log File Output Example

```
2025-09-16 20:38:03 INFO [main] LibraryManagementSystem - Starting LibraryManagementSystem
2025-09-16 20:38:03 INFO [main] LibraryManagementSystem - Book borrowed by Alice: true
2025-09-16 20:38:03 INFO [main] LibraryManagementSystem - Book returned by Bob: true
```

## 🔗 Class Relationships

The system is built around several key interfaces that define contracts for different components:

* **Library** - Main library operations
* **Inventory** - Book inventory management
* **Fine** - Fee calculation strategies
* **Notification** - Communication with patrons
* **ReservationObserver** - Reservation event handling

## ⚙️ Configuration

### Fine Calculation

* Grace period: 2 days
* Daily fine rate: $1.50

### Maven Dependencies

* SLF4J API: 2.0.16
* Logback Classic: 1.5.13

## 🚀 Installation and Setup

### Prerequisites

* Java 23 or higher
* Maven 3.6 or higher

### Running from IDE

* Import as Maven project
* Set main class: LibraryManagementSystem
* Ensure Java 23 is configured
* Run the application

## 🔧 Logging Benefits

The integrated logging framework provides:

* **Debugging Support**: Detailed operation tracking for troubleshooting
* **Audit Trail**: Complete record of all library transactions
* **Performance Monitoring**: Ability to track system performance over time
* **Production Ready**: Enterprise-level logging suitable for production deployment
* **Configurable Output**: Easy adjustment of log levels and output destinations

## 🌟 Technical Highlights

* **SOLID Principles**: Each class has a single responsibility and depends on abstractions
* **Dependency Injection**: Services receive dependencies through constructors
* **Immutable Value Objects**: Core entities protect their state appropriately
* **Modern Java Features**: Effective use of Optional, Streams, and lambda expressions
* **Professional Logging**: Industry-standard logging practices with SLF4J and Logback
* **Maven Build System**: Standardized build process with dependency management
