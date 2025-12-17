package system.dao;

import system.model.Employee;
import system.model.FullTimeEmployee;
import system.model.Department;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Insert employee
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee (id, name, email, phone, birthDate, hireDate, department, baseSalary, employeeType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLiteManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhone());
            pstmt.setString(5, emp.getBirthDate().toString());
            pstmt.setString(6, emp.getHireDate().toString());
            pstmt.setString(7, emp.getDepartment() != null ? emp.getDepartment().getName() : null);
            pstmt.setDouble(8, emp.getBaseSalary());
            pstmt.setString(9, emp.getEmployeeType());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection conn = SQLiteManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Example: only using FullTimeEmployee for simplicity
                Employee emp = new FullTimeEmployee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        LocalDate.parse(rs.getString("birthDate")),
                        LocalDate.parse(rs.getString("hireDate")),
                        new Department(rs.getString("department"), rs.getString("department"), ""),
                        rs.getDouble("baseSalary")
                );
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Insert sample data
    public void insertSampleData() {
        addEmployee(new FullTimeEmployee(
                "1", "Alice", "alice@email.com", "0123456789",
                LocalDate.of(1990, 1, 1),
                LocalDate.of(2020, 1, 1),
                new Department("D1", "HR", "Human Resources"),
                8000.0
        ));

        addEmployee(new FullTimeEmployee(
                "2", "Bob", "bob@email.com", "0987654321",
                LocalDate.of(1992, 2, 2),
                LocalDate.of(2021, 2, 1),
                new Department("D2", "IT", "Information Technology"),
                5000.0
        ));
    }

    // TODO: add updateEmployee, deleteEmployee, findEmployeeById
}
