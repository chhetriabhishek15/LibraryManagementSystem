[//]: # (**Library Management System**)
A Java-based library management system built with clean architecture principles and design patterns. This project demonstrates practical implementation of Object-Oriented Programming concepts including inheritance, encapsulation, polymorphism, and abstraction.

[//]: # (**Project Overview**)
This system handles the core operations of a library: managing books and patrons, processing checkouts and returns, calculating late fees, and managing book reservations. The codebase follows SOLID principles and incorporates multiple design patterns for maintainability and extensibility.

[//]: # (Features)
Core Functionality
Book Management: Add, remove, and search books by title, author, or ISBN

Patron Management: Register library members and track their borrowing history

Checkout/Return Process: Handle book lending with automatic status tracking

Fine Calculation: Automatic late fee computation based on configurable rates

Inventory Tracking: Real-time monitoring of book availability

[//]: # (Advanced Features)
Reservation System: Patrons can reserve books that are currently checked out

Notification System: Automatic alerts when reserved books become available

Borrowing History: Complete transaction records for each patron

[//]: # (**Architecture Design Patterns Used**)

Factory Pattern (LibraryFactory)

Centralizes object creation and configuration

Makes the system easy to extend and maintain

Strategy Pattern (FineService)

Enables flexible fine calculation algorithms

Allows easy modification of penalty rules

Observer Pattern (ReservationService, NotificationService)

Implements automatic notifications for book availability

Decouples reservation management from notification logic

Package Structure
text
src/
├── constants/          # Configuration enums and constants
├── factory/           # Factory pattern implementations
├── interfaces/        # Core system contracts
├── models/           # Domain entities
├── service/          # Business logic implementations
└── LibraryManagementSystem.java    # Main application entry point
Class Relationships
The system is built around several key interfaces that define contracts for different components:

Library - Main library operations

Inventory - Book inventory management

Fine - Fee calculation strategies

Notification - Communication with patrons

ReservationObserver - Reservation event handling

Configuration
The system uses configurable constants for fine calculation:

Grace period: 2 days

Daily fine rate: $1.50
