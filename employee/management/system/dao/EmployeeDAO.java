package employee.management.system.dao;

import employee.management.system.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private List<Employee> employees;

    public EmployeeDAO() {
        employees = new ArrayList<>();
    }

    // CREATE
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // READ
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee getEmployeeById(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    // UPDATE
    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(updatedEmployee.getId())) {
                employees.set(i, updatedEmployee);
                break;
            }
        }
    }

    // DELETE
    public boolean deleteEmployee(String id) {
        return employees.removeIf(emp -> emp.getId().equals(id));
    }

    // Thống kê đơn giản
    public double getTotalSalaryExpense() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        return total;
    }

    public int getEmployeeCount() {
        return employees.size();
    }
}