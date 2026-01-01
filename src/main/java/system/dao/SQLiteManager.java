package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteManager {

    private static final String DB_URL = "jdbc:sqlite:ems.db";

    // Connect to SQLite database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Initialize the database (create tables)
//    public static void initializeDatabase() {
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement()) {
//
//            // Employee table
//            String employeeTable = "CREATE TABLE IF NOT EXISTS employee (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "name TEXT NOT NULL," +
//                    "email TEXT," +
//                    "phone TEXT," +
//                    "birth_date TEXT," +
//                    "hire_date TEXT," +
//                    "hireDate TEXT," +
//                    "department_id TEXT," +
//                    "base_salary REAL," +
//                    "employee_type TEXT," +
//                    "bonus REAL," +
//                    "birthDate TEXT," +
//                    "hours_worked REAL," +
//                    "FOREIGN KEY(department_id) REFERENCES department(id)" +
//                    ");";
//
//            // Department table
//            String departmentTable = "CREATE TABLE IF NOT EXISTS department (" +
//                    "id TEXT PRIMARY KEY," +
//                    "name TEXT NOT NULL," +
//                    "description TEXT" +
//                    ");";
//
//            stmt.execute(employeeTable);
//            stmt.execute(departmentTable);
//
//            System.out.println("Database initialized.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // Department table (create FIRST because of FK)
            String departmentTable = "CREATE TABLE IF NOT EXISTS department (" +
                    "id TEXT PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "description TEXT" +
                    ");";

            // Employee table
            String employeeTable = "CREATE TABLE IF NOT EXISTS employee (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT," +
                    "phone TEXT," +
                    "birth_date TEXT," +
                    "hire_date TEXT," +
                    "department_id TEXT," +
                    "baseSalary REAL," +
                    "employeeType TEXT," +
                    "bonus REAL," +
                    "hours_worked REAL," +
                    "FOREIGN KEY(department_id) REFERENCES department(id)" +
                    ");";

            stmt.execute(departmentTable);
            stmt.execute(employeeTable);

            System.out.println("Database initialized.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
