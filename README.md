📚 Library Management System
A simple Library Management System implemented in Java to demonstrate core Object-Oriented Programming (OOP) concepts and common design patterns. 
This project manages books, patrons, and the lending process, including late fee calculation.

✨ Features

Book and Patron Management: Add, update, and remove books and patrons.

Lending Process: Checkout and return books, with a record of each transaction.

Late Fee Calculation: Automatically calculates late fees for overdue books.

SOLID Principles: Designed with a focus on clean, maintainable, and scalable code.

Design Patterns: Utilizes Factory and Strategy patterns for flexible object creation and behavior.


🧩 Design and Architecture

The project is structured to demonstrate key software design principles:

Dependency Injection: Dependencies are provided through constructors to promote flexibility and testability.

Strategy Pattern: The FineCalculator uses this pattern, allowing different fine calculation rules to be easily added without changing core lending logic.

Factory Pattern: The LibraryFactory centralizes the creation of objects, making the system easy to configure and extend.

