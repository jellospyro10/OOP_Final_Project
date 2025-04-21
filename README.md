# Car Group Event Manager

A command‑line Java application for car enthusiasts to create, list, and register for group events (meets, rallies, shows).

## Table of Contents

- [Project Description](#project-description)
- [Prerequisites](#prerequisites)
- [Build & Run](#build--run)
- [Usage Examples](#usage-examples)
- [Project Structure](#project-structure)
- [Deliverable 1 Contents](#deliverable-1-contents)
- [Contact](#contact)

## Project Description

Car Group Event Manager is a CLI tool that allows organizers to create events with date, time, location, and capacity, and enables members to register their cars and view attendee lists. Data persists across sessions via CSV files.

## Prerequisites

- **Java** 11 or higher  
- **Maven** 3.6+ installed and on your PATH

## Usage Examples
```
> list-events
[1] 2025-04-30 10:00 @ Jukes Garage (capacity: 20)

> create-event
Enter title: Spring Rally
Date (YYYY-MM-DD): 2025-05-15
Time (HH:MM): 09:30
Location: Downtown Park
Capacity: 30
Event created!

> register-member
Name: Alice Smith
Email: alice@example.com
Car Make: Toyota
Car Model: Supra
Year: 2020
Registered for event #1
```
## Project Structure
```
/car-group-event-manager
├─ src
│  ├─ main/java/com/yourorg
│  │  ├─ Main.java
│  │  ├─ model/
│  │  ├─ service/
│  │  └─ util/
│  └─ test/java/com/yourorg
├─ doc
│  └─ Deliverable1.pdf
├─ pom.xml
└─ README.md
```

## Build & Run

```bash
# Compile the project
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="com.yourorg.Main"


