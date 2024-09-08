# Kotlin Clean Architecture Modular Template

This project is a base template for Android applications developed in Kotlin 2.0, using Jetpack Compose as the modern UI framework. It follows a Modularized Clean Architecture approach, dividing the application into feature-based modules to improve scalability and maintainability. Each module encapsulates specific responsibilities within the project.

This project provides a solid and modern structure for starting new Android applications

## Key Technologies
- Modularized Clean Architecture: Organizes the code into layers and independent modules for better separation of concerns.
- Jetpack Compose: Declarative UI framework for building native user interfaces.
- Retrofit: HTTP client for communicating with web services.
- Room: Local database integration with SQLite for data persistence.
- Hilt: Simplified dependency injection for enhanced scalability and testability.

## Modules
- app: The main application module containing the MainActivity and other global configurations.
- domain: The domain layer, responsible for business logic and use cases following Google’s recommendations for Clean Architecture.
- framework: Includes dependencies and integrations with external frameworks and libraries.
- features: Contains feature-specific modules, isolating each feature for better modularity and reusability.

## Example Use Case
The template includes a simple example demonstrating how to fetch data from the Harry Potter API, store wizards locally using Room, and display them in a list on the screen.
