package src.main.java.system.model;

import java.time.LocalDate;

public abstract class Employee {
    private String id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private Department department;
    private double baseSalary;

    public Employee(String id, String name, String email, String phone,
                    LocalDate birthDate, LocalDate hireDate,
                    Department department, double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    // Abstract method - Tính trừu tượng
    public abstract double calculateSalary();
    public abstract String getEmployeeType();

    // Common method - Có thể override (Đa hình)
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Loại: " + getEmployeeType());
        System.out.println("Lương: " + String.format("%,.0f VND", calculateSalary()));
        if (department != null) {
            System.out.println("Phòng ban: " + department.getName());
        }
        System.out.println("-------------------");
    }

    // Getters và Setters - Tính đóng gói
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
}