package system.dao;

import system.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    // Add department
    public void addDepartment(Department dept) {
        String sql = "INSERT INTO department (id, name, description) VALUES (?, ?, ?)";
        try (Connection conn = SQLiteManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dept.getId());
            pstmt.setString(2, dept.getName());
            pstmt.setString(3, dept.getDescription());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department";

        try (Connection conn = SQLiteManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Department dept = new Department(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
                list.add(dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Insert sample data
    public void insertSampleData() {
        addDepartment(new Department("D01", "IT", "Technology Department"));
        addDepartment(new Department("D02", "HR", "Human Resources"));
        addDepartment(new Department("D03", "Finance", "Finance Department"));
    }

    // TODO: add updateDepartment, deleteDepartment, findDepartmentById
}
