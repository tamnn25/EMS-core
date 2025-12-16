package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteManager {

    private static final String DB_URL = "jdbc:sqlite:ems.db";

    // Connect to SQLite database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Initialize the database (create table if not exists)
    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                var stmt = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS employee (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT NOT NULL," +
                        "position TEXT," +
                        "salary REAL" +
                        ");";
                stmt.execute(sql);
                System.out.println("Database initialized.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert sample data into the employee table
    public static void insertSampleData() {
        String sql = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Sample employees
            Object[][] employees = {
                    {"Alice", "Manager", 8000.0},
                    {"Bob", "Full-Time", 5000.0},
                    {"Charlie", "Part-Time", 2500.0}
            };

            for (Object[] emp : employees) {
                pstmt.setString(1, (String) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setDouble(3, (Double) emp[2]);
                pstmt.executeUpdate();
            }

            System.out.println("Sample data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for quick testing
    public static void main(String[] args) {
        initializeDatabase();
        insertSampleData();
    }
}
