# 🐔 Chicken Farm Management System

> A desktop application for managing chicken farm operations built with Java and JavaFX

---

## 👥 Team Members

This project was developed as part of a university Java course by the following team:

| Name                     | Role                                  | GitHub |
|--------------------------|---------------------------------------|--------|
| ELFADILI MOHAMED YACINE  | Chef de Projet (Project Lead)        | [@Medfadili20Dev](https://github.com/Medfadili20Dev) |
| HAMMOU MOHAMED           | Développeur Backend / Base de Données | [@Hmou05](https://github.com/Hmou05) |
| ANSSEM HAFID             | Développeur Frontend / JavaFX         | [@ANSS77](https://github.com/ANSS77) |
| HAIFI MOHAMED AMINE      | Testeur / Documentateur               | [@Mohamadaminehaifi](https://github.com/Mohamadaminehaifi) |
| OUCHRAA ISMAIL           | Architecte Logiciel / Design Patterns | [@ismailouchraa](https://github.com/ismailouchraa) |

---

## 📋 Project Description

A comprehensive desktop chicken farm management system application built with Java and JavaFX. The project follows MVC architecture pattern, uses SQLite for data persistence, and includes comprehensive testing with JUnit.

### 🎯 Development Approach

We are building this application using an **MVP (Minimum Viable Product)** approach. This means we start by creating a simplified but functional version with core features, then iteratively add more advanced functionality based on testing and feedback.

**Why MVP?**
- ✅ Faster initial delivery
- ✅ Early user feedback
- ✅ Focus on core functionality first
- ✅ Iterative improvement process
- ✅ Better risk management

---

## 🚀 MVP Version - Feature Set

The initial MVP release will include the following pages and functionalities:

### 🔐 **Login Page**
- Email and password text inputs
- Simple login button
- No forgot password, no sign up (admin account pre-configured)

### 📊 **Dashboard**
- 3 summary cards:
    - Total chickens count across all houses
    - Eggs produced today
    - Active alerts count
- Simple 7-day egg production bar chart for trend visualization

### 🏠 **Chicken Bay**
- 4 house cards (H1: Day-old, H2: Egg Layers, H3: Meat Females, H4: Meat Males)
- Each card displays:
    - Health status indicator
    - Average age in days
    - Current chicken count
    - Days until transfer to next house
- Mortality tracking card showing:
    - Deaths today
    - Deaths this week
    - Deaths this month

### 🥚 **Eggs Bay**
- 2 production cards for H2 (Egg Layers) and H3 (Meat Females)
- Each card shows:
    - Eggs produced today
    - Dead chickens count per house
- Large total eggs in storage card with cumulative count

### 📦 **Storage**
- **Feed card**: Lists different feed types with current quantities in kg
- **Medications card**: Shows total medication types and low stock count
- **Equipment table**: Displays name, count, and operational status for each equipment item

### ✅ **Tasks**
- List view with status badges (Done/Pending/Missed)
- Each task displays:
    - Task description
    - Cracked eggs count (if applicable)
    - Assigned worker name
- Example: *"Collect eggs from H2 - Cracked: 15, Assigned to: Ahmed Elbagi"*

### 👨‍🌾 **Personnel**
- Simplified personnel cards showing:
    - Full name
    - Age
    - Phone number
    - Email address
    - Job title (Worker or Tracker only)
- No cashier/administration roles in MVP

---

## 🛠️ Technologies Stack

- **Language:** Java 17+
- **UI Framework:** JavaFX 25
- **Build Tool:** Maven
- **Database:** SQLite 3.44.1 with DAO pattern
- **Architecture:** MVC (Model-View-Controller)
- **Testing:** JUnit 5
- **Version Control:** Git & GitHub
- **IDE:** IntelliJ IDEA

---
## 📁 Folder Structure (MVP version)

```txt
Chicken_Farm_Management_System/
├── database/
│   └── farm.db
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ma/
│   │   │       └── farm/
│   │   │           ├── controller/
│   │   │           │   ├── LoginController.java
│   │   │           │   ├── DashboardController.java
│   │   │           │   ├── ChickenBayController.java
│   │   │           │   ├── EggsBayController.java
│   │   │           │   ├── StorageController.java
│   │   │           │   ├── TasksController.java
│   │   │           │   └── PersonnelController.java
│   │   │           │
│   │   │           ├── dao/
│   │   │           │   ├── DatabaseConnection.java
│   │   │           │   ├── UserDAO.java
│   │   │           │   ├── ChickenDAO.java
│   │   │           │   ├── HouseDAO.java
│   │   │           │   ├── EggProductionDAO.java
│   │   │           │   ├── MortalityDAO.java
│   │   │           │   ├── FeedDAO.java
│   │   │           │   ├── MedicationDAO.java
│   │   │           │   ├── EquipmentDAO.java
│   │   │           │   ├── TaskDAO.java
│   │   │           │   └── PersonnelDAO.java
│   │   │           │
│   │   │           ├── model/
│   │   │           │   ├── User.java
│   │   │           │   ├── Chicken.java
│   │   │           │   ├── House.java
│   │   │           │   ├── EggProduction.java
│   │   │           │   ├── Mortality.java
│   │   │           │   ├── Feed.java
│   │   │           │   ├── Medication.java
│   │   │           │   ├── Equipment.java
│   │   │           │   ├── Task.java
│   │   │           │   └── Personnel.java
│   │   │           │
│   │   │           ├── util/
│   │   │           │   ├── NavigationUtil.java
│   │   │           │   ├── ValidationUtil.java
│   │   │           │   └── DateUtil.java
│   │   │           │
│   │   │           ├── view/
│   │   │           │   ├── LoginView.java
│   │   │           │   ├── DashboardView.java
│   │   │           │   ├── ChickenBayView.java
│   │   │           │   ├── EggsBayView.java
│   │   │           │   ├── StorageView.java
│   │   │           │   ├── TasksView.java
│   │   │           │   └── PersonnelView.java
│   │   │           │
│   │   │           └── App.java
│   │   │
│   │   └── resources/
│   │       ├── fxml/
│   │       │   ├── LoginView.fxml
│   │       │   ├── DashboardView.fxml
│   │       │   ├── ChickenBayView.fxml
│   │       │   ├── EggsBayView.fxml
│   │       │   ├── StorageView.fxml
│   │       │   ├── TasksView.fxml
│   │       │   └── PersonnelView.fxml
│   │       │
│   │       ├── css/
│   │       │   └── style.css
│   │       │
│   │       ├── images/
│   │       │   └── icons/
│   │       │   │   └── chicken.png
│   │       │   │   └── egg.png
│   │       │   │   └── storage.png
│   │       │   │   └── task.png
│   │       │   │   └── personnel.png
│   │       │   └── personnel.png
│   │       │
│   │       └── database/
│   │           └── schema.sql
│   │
│   └── test/
│       └── java/
│           └── ma/
│               └── farm/
│                   └── dao/
│                       ├── DatabaseConnectionTest.java
│                       ├── UserDAOTest.java
│                       ├── ChickenDAOTest.java
│                       ├── EggProductionDAOTest.java
│                       ├── TaskDAOTest.java
│                       └── PersonnelDAOTest.java
│
├── .gitignore
├── LICENSE.txt
├── pom.xml
└── README.md

```
---

## 🏗️ Architecture

This project follows the **MVC (Model-View-Controller)** architectural pattern:

- **Model**: Entity classes representing database tables (User, House, Chicken, etc.)
- **View**: FXML files defining the UI layout
- **Controller**: JavaFX controller classes handling user interactions and business logic
- **DAO**: Data Access Objects providing a clean interface to database operations

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE.txt](LICENSE.txt) file for details.

---

## 🤝 Contributing

This is a university project. Contributions from team members are managed through Git branches and pull requests.

---

**Built by the Farm Management Dev Team**

