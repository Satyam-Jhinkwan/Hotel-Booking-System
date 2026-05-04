# Hotel Room Booking System

A Java mini project developed using:

- Java OOP Concepts
- Swing GUI
- JDBC
- MySQL Database
- Interfaces
- Exception Handling

This project allows users to:

- Book hotel rooms
- Store booking data in MySQL
- View all bookings using JTable

---

# 📌 Required Software

Install the following software before running the project:

## 1. Java JDK

Recommended:

- JDK 17 or above

Check installation:

```bash
java -version
javac -version
```

---

## 2. VS Code

Download and install VS Code.

Recommended Extensions:

- Extension Pack for Java
- Debugger for Java

---

## 3. MySQL Server

Install MySQL Server.

Optional:

- MySQL Workbench for easier database management.

---

## 4. MySQL JDBC Driver

Download:

MySQL Connector/J

After extraction you will get:

```text
mysql-connector-j-x.x.x.jar
```

This JAR file is required for JDBC connectivity.

---

# 📁 Project Folder Structure

```text
HotelBookingSystem/
├── src/
│   ├── model/
│   │   ├── Room.java
│   │   ├── Guest.java
│   │   └── Booking.java
│   ├── interfaces/
│   │   └── Manageable.java
│   ├── db/
│   │   ├── DBConnection.java
│   │   └── BookingDAO.java
│   ├── gui/
│   │   ├── MainFrame.java
│   │   ├── BookingForm.java
│   │   └── ViewBookings.java
│   └── Main.java
├── lib/
│   └── mysql-connector-j.jar
└── README.md
```

---

# 🗄️ MySQL Database Setup

Open MySQL Workbench or MySQL Command Line.

Run the following SQL:

```sql
CREATE DATABASE hotel_booking;

USE hotel_booking;

CREATE TABLE bookings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    guest_name VARCHAR(100),
    room_number INT,
    room_type VARCHAR(50),
    days INT,
    total_amount DOUBLE
);
```

If the table is created successfully, database setup is complete.

---

# 🔌 JDBC Driver Setup in VS Code

## Step 1

Open project in VS Code.

---

## Step 2

Go to:

```text
Referenced Libraries
```

---

## Step 3

Click:

```text
+ Add Jar
```

---

## Step 4

Select:

```text
mysql-connector-j-x.x.x.jar
```

JDBC setup completed.

---

# ⚙️ Database Username & Password Configuration

Open:

```text
DBConnection.java
```

Find:

```java
private static final String USER = "root";
private static final String PASSWORD = "root";
```

Change according to your MySQL credentials.

Example:

```java
private static final String USER = "root";
private static final String PASSWORD = "1234";
```

---

# ▶️ How to Run the Project

## Step 1

Setup MySQL database.

---

## Step 2

Add JDBC driver JAR.

---

## Step 3

Open project in VS Code.

---

## Step 4

Run:

```text
Main.java
```

The Swing GUI window will open.

---

# ✨ Features

## 1. Book Room

Users can:

- Enter guest name
- Enter room number
- Select room type
- Enter number of days

Booking is saved in MySQL database.

---

## 2. View Bookings

Displays all bookings using JTable.

Shows:

- Booking ID
- Guest name
- Room number
- Room type
- Days
- Total amount

---

# ⚠️ Common Errors and Fixes

## Error 1

```text
No suitable driver found
```

### Cause

JDBC JAR not added.

### Fix

Add MySQL connector JAR again.

---

## Error 2

```text
Access denied for user
```

### Cause

Wrong MySQL username/password.

### Fix

Correct credentials in:

```text
DBConnection.java
```

---

## Error 3

```text
Unknown database hotel_booking
```

### Cause

Database not created.

### Fix

Run SQL setup query again.

---

## Error 4

```text
ClassNotFoundException
```

### Cause

MySQL JDBC driver missing.

### Fix

Re-add connector JAR.

---

# 🔄 Project Workflow

```text
Swing GUI
   ↓
BookingForm.java
   ↓
Booking Object
   ↓
BookingDAO.java
   ↓
DBConnection.java
   ↓
MySQL Database
```

---

# 🎯 OOP Concepts Used

| Concept            | Usage                       |
| ------------------ | --------------------------- |
| Class & Object     | Room, Guest, Booking        |
| Inheritance        | Booking extends Room        |
| Interface          | Manageable                  |
| Encapsulation      | Private variables + getters |
| Packages           | model, db, gui              |
| Exception Handling | try-catch blocks            |
| JDBC               | Database connectivity       |
| Swing              | GUI creation                |

---

# 👨‍💻 Team Work Distribution

| Person   | Module                  |
| -------- | ----------------------- |
| Anubhava | OOP Classes + Interface |
| Vaibhav  | JDBC + Database         |
| Satyam   | Swing GUI               |

#

---

# ✅ Project Status

This project is designed as a medium-level college Java project.
It is simple enough to explain in viva and advanced enough to cover:

- OOP
- GUI
- JDBC
- Database connectivity

