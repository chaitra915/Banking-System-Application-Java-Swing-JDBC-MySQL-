# Banking-System-Application-Java-Swing-JDBC-MySQL

# Banking System Application

## Project Overview

The Banking System Application is a desktop-based application built using Java Swing and MySQL. It simulates real-world banking operations, providing a secure and user-friendly interface for account management, transactions, and bill payments. The project demonstrates GUI development, database connectivity with JDBC, and transaction handling.

## Technologies Used

* Java (JDK 17+)
* Java Swing for GUI
* MySQL for database
* JDBC for database connectivity
* Eclipse IDE
* XAMPP (for MySQL server)

## Features

* **User Authentication:** Register and login securely
* **Dashboard:** Easy navigation for banking operations
* **Add Balance:** Deposit money to your account
* **Transfer Money:** Transfer funds to other users
* **Pay Bills:** Pay utility bills (Electricity, Water, Internet)
* **Transaction History:** View detailed transactions with date and type
* **Logout:** Secure exit from the application

---

## Project Structure

```
BankingSystem-JDBC
│
├─ src/
│   ├─ DBConnection.java
│   ├─ Main.java
│   ├─ Login.java
│   ├─ Register.java
│   ├─ Dashboard.java
│   └─ Transaction.java
│
├─ lib/
│   └─ mysql-connector-java-8.1.0.jar
├─ db.sql
└─ README.md
```

## Database Setup

1. Open MySQL Workbench, phpMyAdmin, or XAMPP's MySQL console.
2. Run the `db.sql` script located in the project root:

   ```sql
   SOURCE path/to/db.sql;
   ```
3. This will create:

   * `bankdb` database
   * `users` table (with `balance` column)
   * `transactions` table

## How to Run the Project

1. Import the project into Eclipse: **File → Import → Existing Projects into Workspace**
2. Add **MySQL Connector/J** (`mysql-connector-java-8.1.0.jar`) to the project classpath.
3. Ensure JDK 17+ is set for the project.
4. Run the **Main.java** class.
5. The login/register window will appear. Register a new user and log in to access the dashboard.

## Role & Learning

Role:Developer / Full-Stack Java Developer

* Designed and implemented GUI using Java Swing
* Integrated MySQL database via JDBC
* Developed modules for transactions, balance management, and bill payments
* Gained experience in database operations, OOP, and modular application design

## Future Enhancements

* Add loan management and account statements
* Generate PDF reports for transactions
* Implement multi-currency support
* Enhance security with password encryption


