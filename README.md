Tôi sẽ giúp bạn hoàn thiện dự án EMS với đầy đủ code cho tất cả các class và method. Dưới đây là toàn bộ code chi tiết:

## **I. CẤU TRÚC DỰ ÁN HOÀN CHỈNH**
employee.management.system/
├── main/
│   ├── Main.java                    # Entry point
│   └── EMSApp.java                  # Main application
│
├── model/                           # OOP, Class, Object
│   ├── Employee.java                # Base class (Inheritance)
│   ├── FullTimeEmployee.java        # Child class
│   ├── PartTimeEmployee.java        # Child class
│   ├── Manager.java                 # Child class
│   └── Department.java              # Composition
│
├── dao/                             # Data Access (Collections)
│   ├── EmployeeDAO.java             # CRUD với List
│   ├── DepartmentDAO.java           # CRUD với Map
│   └── FileDataManager.java         # File I/O, Exception
│
├── service/                         # Business Logic
│   ├── EmployeeService.java         # Xử lý nghiệp vụ
│   ├── SalaryService.java           # Tính toán lương
│   └── ReportService.java           # Báo cáo
│
├── util/                            # Utilities
│   ├── Validator.java               # Validation
│   ├── DateUtils.java               # Date-Time API
│   ├── Constants.java               # Constants
│   └── CustomExceptions/            # Exception Handling
│       ├── EmployeeNotFoundException.java
│       ├── InvalidDataException.java
│       └── DatabaseException.java
│
├── ui/                              # User Interface
│   ├── ConsoleUI.java               # Console interface
│   └── MenuManager.java             # Menu system
│
└── test/                            # Unit Testing
    └── EmployeeServiceTest.java

### **1. File: Main.java**
```java
package com.ems.main;

import com.ems.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}
```

### **2. File: EMSApp.java**
```java
package com.ems.main;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.DepartmentDAO;
import com.ems.service.*;
import com.ems.util.FileDataManager;
import java.util.Scanner;

public class EMSApp {
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private ReportService reportService;
    private Scanner scanner;
    
    public EMSApp() {
        initializeServices();
        scanner = new Scanner(System.in);
    }
    
    private void initializeServices() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        
        employeeService = new EmployeeService(employeeDAO);
        departmentService = new DepartmentService(departmentDAO);
        reportService = new ReportService(employeeDAO, departmentDAO);
        
        loadInitialData();
    }
    
    private void loadInitialData() {
        try {
            FileDataManager fileManager = new FileDataManager();
            fileManager.loadInitialData(employeeService, departmentService);
        } catch (Exception e) {
            System.out.println("Không thể load dữ liệu ban đầu: " + e.getMessage());
        }
    }
    
    public void start() {
        System.out.println("=== HỆ THỐNG QUẢN LÝ NHÂN VIÊN ===");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();
            
            try {
                switch (choice) {
                    case 1:
                        manageEmployees();
                        break;
                    case 2:
                        manageDepartments();
                        break;
                    case 3:
                        generateReports();
                        break;
                    case 4:
                        importExportData();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        
        System.out.println("Tạm biệt!");
        scanner.close();
    }
    
    private void displayMainMenu() {
        System.out.println("\n===== MENU CHÍNH =====");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý phòng ban");
        System.out.println("3. Báo cáo");
        System.out.println("4. Import/Export dữ liệu");
        System.out.println("5. Thoát");
        System.out.print("Chọn: ");
    }
    
    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void manageEmployees() {
        System.out.println("\n=== QUẢN LÝ NHÂN VIÊN ===");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Xem tất cả nhân viên");
        System.out.println("3. Tìm kiếm nhân viên");
        System.out.println("4. Cập nhật nhân viên");
        System.out.println("5. Xóa nhân viên");
        System.out.println("6. Tính lương");
        System.out.println("7. Quay lại");
        System.out.print("Chọn: ");
        
        int choice = getMenuChoice();
        
        switch (choice) {
            case 1:
                employeeService.addEmployeeFromInput(scanner);
                break;
            case 2:
                employeeService.displayAllEmployees();
                break;
            case 3:
                employeeService.searchEmployee(scanner);
                break;
            case 4:
                employeeService.updateEmployee(scanner);
                break;
            case 5:
                employeeService.deleteEmployee(scanner);
                break;
            case 6:
                employeeService.calculateSalaryForEmployee(scanner);
                break;
            case 7:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    
    private void manageDepartments() {
        System.out.println("\n=== QUẢN LÝ PHÒNG BAN ===");
        System.out.println("1. Thêm phòng ban");
        System.out.println("2. Xem tất cả phòng ban");
        System.out.println("3. Thêm nhân viên vào phòng ban");
        System.out.println("4. Xem nhân viên theo phòng ban");
        System.out.println("5. Quay lại");
        System.out.print("Chọn: ");
        
        int choice = getMenuChoice();
        
        switch (choice) {
            case 1:
                departmentService.addDepartment(scanner);
                break;
            case 2:
                departmentService.displayAllDepartments();
                break;
            case 3:
                departmentService.addEmployeeToDepartment(scanner, employeeService);
                break;
            case 4:
                departmentService.displayEmployeesByDepartment(scanner);
                break;
            case 5:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    
    private void generateReports() {
        System.out.println("\n=== BÁO CÁO ===");
        System.out.println("1. Báo cáo lương tháng");
        System.out.println("2. Báo cáo nhân sự");
        System.out.println("3. Thống kê theo phòng ban");
        System.out.println("4. Top nhân viên hiệu suất cao");
        System.out.println("5. Quay lại");
        System.out.print("Chọn: ");
        
        int choice = getMenuChoice();
        
        switch (choice) {
            case 1:
                reportService.generateSalaryReport();
                break;
            case 2:
                reportService.generateEmployeeReport();
                break;
            case 3:
                reportService.generateDepartmentStatistics();
                break;
            case 4:
                reportService.displayTopPerformers(0.8);
                break;
            case 5:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    
    private void importExportData() {
        System.out.println("\n=== IMPORT/EXPORT ===");
        System.out.println("1. Export nhân viên ra file CSV");
        System.out.println("2. Import nhân viên từ file CSV");
        System.out.println("3. Sao lưu dữ liệu");
        System.out.println("4. Khôi phục dữ liệu");
        System.out.println("5. Quay lại");
        System.out.print("Chọn: ");
        
        int choice = getMenuChoice();
        
        FileDataManager fileManager = new FileDataManager();
        
        switch (choice) {
            case 1:
                System.out.print("Nhập tên file (ví dụ: employees.csv): ");
                String exportFile = scanner.nextLine();
                fileManager.exportEmployeesToCSV(employeeService.getAllEmployees(), exportFile);
                break;
            case 2:
                System.out.print("Nhập tên file CSV: ");
                String importFile = scanner.nextLine();
                fileManager.importEmployeesFromCSV(importFile, employeeService);
                break;
            case 3:
                fileManager.backupData(employeeService.getAllEmployees(), 
                                     departmentService.getAllDepartments());
                break;
            case 4:
                fileManager.restoreData(employeeService, departmentService);
                break;
            case 5:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
}
```

## **II. PACKAGE MODEL**

### **3. File: Employee.java**
```java
package com.ems.model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee implements Serializable, Comparable<Employee> {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private Department department;
    private double baseSalary;
    private double performanceScore;
    
    public Employee() {}
    
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
        this.performanceScore = 0.7;
    }
    
    public abstract double calculateSalary();
    
    public abstract String getEmployeeType();
    
    public void displayInfo() {
        System.out.printf("ID: %s, Tên: %s, Email: %s, Điện thoại: %s%n",
                         id, name, email, phone);
        System.out.printf("Ngày sinh: %s, Ngày vào làm: %s%n",
                         birthDate, hireDate);
        if (department != null) {
            System.out.printf("Phòng ban: %s%n", department.getName());
        }
        System.out.printf("Lương cơ bản: $%.2f, Hiệu suất: %.2f%n",
                         baseSalary, performanceScore);
    }
    
    // Getters và Setters
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
    
    public double getPerformanceScore() { return performanceScore; }
    public void setPerformanceScore(double performanceScore) { 
        this.performanceScore = performanceScore; 
    }
    
    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }
    
    @Override
    public String toString() {
        return String.format("Employee{id='%s', name='%s', email='%s', type='%s'}",
                           id, name, email, getEmployeeType());
    }
}
```

### **4. File: FullTimeEmployee.java**
```java
package com.ems.model;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;
    private int overtimeHours;
    private final double OVERTIME_RATE = 1.5;
    
    public FullTimeEmployee() {}
    
    public FullTimeEmployee(String id, String name, String email, String phone,
                           LocalDate birthDate, LocalDate hireDate,
                           Department department, double monthlySalary) {
        super(id, name, email, phone, birthDate, hireDate, department, monthlySalary);
        this.monthlySalary = monthlySalary;
        this.bonus = 0;
        this.overtimeHours = 0;
    }
    
    @Override
    public double calculateSalary() {
        double overtimePay = overtimeHours * (monthlySalary / 160) * OVERTIME_RATE;
        return monthlySalary + bonus + overtimePay;
    }
    
    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }
    
    public void addOvertime(int hours) {
        this.overtimeHours += hours;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) { 
        this.monthlySalary = monthlySalary; 
    }
    
    public double getBonus() { return bonus; }
    public int getOvertimeHours() { return overtimeHours; }
}
```

### **5. File: PartTimeEmployee.java**
```java
package com.ems.model;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    
    public PartTimeEmployee() {}
    
    public PartTimeEmployee(String id, String name, String email, String phone,
                           LocalDate birthDate, LocalDate hireDate,
                           Department department, double hourlyRate) {
        super(id, name, email, phone, birthDate, hireDate, department, hourlyRate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }
    
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    
    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }
    
    public void addHoursWorked(int hours) {
        this.hoursWorked += hours;
    }
    
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    
    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }
}
```

### **6. File: Manager.java**
```java
package com.ems.model;

import java.time.LocalDate;

public class Manager extends FullTimeEmployee {
    private double managementBonus;
    private int teamSize;
    
    public Manager() {}
    
    public Manager(String id, String name, String email, String phone,
                  LocalDate birthDate, LocalDate hireDate,
                  Department department, double monthlySalary) {
        super(id, name, email, phone, birthDate, hireDate, department, monthlySalary);
        this.managementBonus = 1000;
        this.teamSize = 0;
    }
    
    @Override
    public double calculateSalary() {
        return super.calculateSalary() + managementBonus + (teamSize * 50);
    }
    
    @Override
    public String getEmployeeType() {
        return "Manager";
    }
    
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    
    public double getManagementBonus() { return managementBonus; }
    public void setManagementBonus(double bonus) { this.managementBonus = bonus; }
    
    public int getTeamSize() { return teamSize; }
}
```

### **7. File: Department.java**
```java
package com.ems.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String description;
    private Employee manager;
    private Department parentDepartment;
    private List<Department> subDepartments;
    
    public Department(String id, String name) {
        this.id = id;
        this.name = name;
        this.description = "";
        this.subDepartments = new ArrayList<>();
    }
    
    public Department(String id, String name, String description) {
        this(id, name);
        this.description = description;
    }
    
    public void addSubDepartment(Department department) {
        department.setParentDepartment(this);
        subDepartments.add(department);
    }
    
    public boolean removeSubDepartment(String departmentId) {
        return subDepartments.removeIf(dept -> dept.getId().equals(departmentId));
    }
    
    public void displayInfo() {
        System.out.printf("Phòng ban: %s (ID: %s)%n", name, id);
        System.out.printf("Mô tả: %s%n", description);
        if (manager != null) {
            System.out.printf("Trưởng phòng: %s%n", manager.getName());
        }
        if (parentDepartment != null) {
            System.out.printf("Phòng ban cha: %s%n", parentDepartment.getName());
        }
        System.out.printf("Số phòng ban con: %d%n", subDepartments.size());
    }
    
    // Getters và Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }
    
    public Department getParentDepartment() { return parentDepartment; }
    public void setParentDepartment(Department parentDepartment) { 
        this.parentDepartment = parentDepartment; 
    }
    
    public List<Department> getSubDepartments() { return subDepartments; }
    
    @Override
    public String toString() {
        return String.format("Department{id='%s', name='%s', manager='%s'}",
                           id, name, manager != null ? manager.getName() : "N/A");
    }
}
```

### **8. File: EmployeeType.java**
```java
package com.ems.model;

public enum EmployeeType {
    FULL_TIME("Full-Time"),
    PART_TIME("Part-Time"),
    MANAGER("Manager");
    
    private final String displayName;
    
    EmployeeType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
```

## **III. PACKAGE DAO**

### **9. File: EmployeeDAO.java**
```java
package com.ems.dao;

import com.ems.model.Employee;
import com.ems.model.Department;
import com.ems.util.CustomExceptions.EmployeeNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDAO {
    private List<Employee> employees;
    private Map<String, Employee> employeeMap;
    private Set<String> employeeIds;
    private Map<Department, List<Employee>> departmentMap;
    
    public EmployeeDAO() {
        employees = new ArrayList<>();
        employeeMap = new HashMap<>();
        employeeIds = new HashSet<>();
        departmentMap = new HashMap<>();
    }
    
    // CRUD Operations
    public void addEmployee(Employee employee) {
        if (employeeIds.contains(employee.getId())) {
            throw new IllegalArgumentException("ID nhân viên đã tồn tại: " + employee.getId());
        }
        
        employees.add(employee);
        employeeMap.put(employee.getId(), employee);
        employeeIds.add(employee.getId());
        
        // Cập nhật department map
        Department dept = employee.getDepartment();
        if (dept != null) {
            departmentMap.computeIfAbsent(dept, k -> new ArrayList<>()).add(employee);
        }
    }
    
    public Employee getEmployeeById(String id) throws EmployeeNotFoundException {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }
    
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
    
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        String id = employee.getId();
        if (!employeeIds.contains(id)) {
            throw new EmployeeNotFoundException(id);
        }
        
        // Cập nhật trong list
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, employee);
                break;
            }
        }
        
        // Cập nhật trong map
        employeeMap.put(id, employee);
        
        // Cập nhật department map
        Department oldDept = getOldDepartment(id);
        Department newDept = employee.getDepartment();
        
        if (oldDept != null && !oldDept.equals(newDept)) {
            departmentMap.get(oldDept).removeIf(e -> e.getId().equals(id));
        }
        
        if (newDept != null) {
            departmentMap.computeIfAbsent(newDept, k -> new ArrayList<>()).add(employee);
        }
    }
    
    private Department getOldDepartment(String employeeId) {
        for (Map.Entry<Department, List<Employee>> entry : departmentMap.entrySet()) {
            for (Employee emp : entry.getValue()) {
                if (emp.getId().equals(employeeId)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
    
    public boolean deleteEmployee(String id) throws EmployeeNotFoundException {
        if (!employeeIds.contains(id)) {
            throw new EmployeeNotFoundException(id);
        }
        
        Employee employee = employeeMap.get(id);
        
        // Xóa từ list
        boolean removed = employees.removeIf(e -> e.getId().equals(id));
        
        if (removed) {
            // Xóa từ map và set
            employeeMap.remove(id);
            employeeIds.remove(id);
            
            // Xóa từ department map
            Department dept = employee.getDepartment();
            if (dept != null && departmentMap.containsKey(dept)) {
                departmentMap.get(dept).removeIf(e -> e.getId().equals(id));
            }
        }
        
        return removed;
    }
    
    // Search Operations
    public List<Employee> searchByName(String name) {
        return employees.stream()
            .filter(emp -> emp.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }
    
    public List<Employee> searchByDepartment(String departmentName) {
        return employees.stream()
            .filter(emp -> emp.getDepartment() != null && 
                          emp.getDepartment().getName().toLowerCase()
                             .contains(departmentName.toLowerCase()))
            .collect(Collectors.toList());
    }
    
    // Sorting Operations
    public List<Employee> sortBySalary() {
        return employees.stream()
            .sorted(Comparator.comparingDouble(Employee::calculateSalary))
            .collect(Collectors.toList());
    }
    
    public List<Employee> sortByName() {
        return employees.stream()
            .sorted(Comparator.comparing(Employee::getName))
            .collect(Collectors.toList());
    }
    
    public List<Employee> sortByHireDate() {
        return employees.stream()
            .sorted(Comparator.comparing(Employee::getHireDate))
            .collect(Collectors.toList());
    }
    
    // Statistics
    public long getTotalEmployees() {
        return employees.size();
    }
    
    public double getTotalSalaryExpense() {
        return employees.stream()
            .mapToDouble(Employee::calculateSalary)
            .sum();
    }
    
    public Map<String, Long> countByEmployeeType() {
        return employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getEmployeeType,
                Collectors.counting()
            ));
    }
    
    // Department Operations
    public List<Employee> getEmployeesByDepartment(Department department) {
        return departmentMap.getOrDefault(department, new ArrayList<>());
    }
    
    public void updateDepartmentMap(Employee employee, Department oldDept, Department newDept) {
        if (oldDept != null && departmentMap.containsKey(oldDept)) {
            departmentMap.get(oldDept).remove(employee);
        }
        
        if (newDept != null) {
            departmentMap.computeIfAbsent(newDept, k -> new ArrayList<>()).add(employee);
        }
    }
    
    // Validation
    public boolean employeeExists(String id) {
        return employeeIds.contains(id);
    }
}
```

### **10. File: DepartmentDAO.java**
```java
package com.ems.dao;

import com.ems.model.Department;
import java.util.*;

public class DepartmentDAO {
    private Map<String, Department> departmentMap;
    private Map<String, List<Department>> parentChildMap;
    
    public DepartmentDAO() {
        departmentMap = new HashMap<>();
        parentChildMap = new HashMap<>();
    }
    
    // CRUD Operations
    public void addDepartment(Department department) {
        if (departmentMap.containsKey(department.getId())) {
            throw new IllegalArgumentException("ID phòng ban đã tồn tại: " + department.getId());
        }
        
        departmentMap.put(department.getId(), department);
        
        // Cập nhật parent-child relationship
        if (department.getParentDepartment() != null) {
            String parentId = department.getParentDepartment().getId();
            parentChildMap.computeIfAbsent(parentId, k -> new ArrayList<>())
                         .add(department);
        }
    }
    
    public Department getDepartmentById(String id) {
        return departmentMap.get(id);
    }
    
    public List<Department> getAllDepartments() {
        return new ArrayList<>(departmentMap.values());
    }
    
    public void updateDepartment(Department department) {
        Department existing = departmentMap.get(department.getId());
        if (existing == null) {
            throw new IllegalArgumentException("Phòng ban không tồn tại: " + department.getId());
        }
        
        // Cập nhật parent-child nếu cần
        Department oldParent = existing.getParentDepartment();
        Department newParent = department.getParentDepartment();
        
        if (oldParent != null && !oldParent.equals(newParent)) {
            String oldParentId = oldParent.getId();
            if (parentChildMap.containsKey(oldParentId)) {
                parentChildMap.get(oldParentId).remove(existing);
            }
        }
        
        if (newParent != null) {
            String newParentId = newParent.getId();
            parentChildMap.computeIfAbsent(newParentId, k -> new ArrayList<>())
                         .add(department);
        }
        
        departmentMap.put(department.getId(), department);
    }
    
    public boolean deleteDepartment(String id) {
        Department department = departmentMap.get(id);
        if (department == null) {
            return false;
        }
        
        // Kiểm tra xem có phòng ban con không
        if (parentChildMap.containsKey(id) && !parentChildMap.get(id).isEmpty()) {
            throw new IllegalStateException("Không thể xóa phòng ban có phòng ban con");
        }
        
        // Xóa khỏi parent-child map
        if (department.getParentDepartment() != null) {
            String parentId = department.getParentDepartment().getId();
            if (parentChildMap.containsKey(parentId)) {
                parentChildMap.get(parentId).remove(department);
            }
        }
        
        // Xóa khỏi department map
        departmentMap.remove(id);
        parentChildMap.remove(id);
        
        return true;
    }
    
    // Hierarchical Operations
    public List<Department> getSubDepartments(String parentId) {
        return parentChildMap.getOrDefault(parentId, new ArrayList<>());
    }
    
    public List<Department> getRootDepartments() {
        return departmentMap.values().stream()
            .filter(dept -> dept.getParentDepartment() == null)
            .collect(java.util.stream.Collectors.toList());
    }
    
    public List<Department> getDepartmentTree(String rootId) {
        List<Department> tree = new ArrayList<>();
        Department root = departmentMap.get(rootId);
        
        if (root != null) {
            buildDepartmentTree(root, tree);
        }
        
        return tree;
    }
    
    private void buildDepartmentTree(Department department, List<Department> tree) {
        tree.add(department);
        List<Department> children = parentChildMap.get(department.getId());
        
        if (children != null) {
            for (Department child : children) {
                buildDepartmentTree(child, tree);
            }
        }
    }
    
    // Search Operations
    public List<Department> searchByName(String name) {
        return departmentMap.values().stream()
            .filter(dept -> dept.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(java.util.stream.Collectors.toList());
    }
    
    // Statistics
    public int getTotalDepartments() {
        return departmentMap.size();
    }
    
    public Map<String, Integer> getDepartmentLevels() {
        Map<String, Integer> levels = new HashMap<>();
        
        for (Department dept : getRootDepartments()) {
            calculateLevel(dept, 1, levels);
        }
        
        return levels;
    }
    
    private void calculateLevel(Department department, int level, Map<String, Integer> levels) {
        levels.put(department.getId(), level);
        
        List<Department> children = parentChildMap.get(department.getId());
        if (children != null) {
            for (Department child : children) {
                calculateLevel(child, level + 1, levels);
            }
        }
    }
}
```

### **11. File: FileDataManager.java**
```java
package com.ems.dao;

import com.ems.model.*;
import com.ems.service.EmployeeService;
import com.ems.service.DepartmentService;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileDataManager {
    private static final String EMPLOYEE_FILE = "employees.dat";
    private static final String DEPARTMENT_FILE = "departments.dat";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    
    // Serialization
    public void saveEmployees(List<Employee> employees) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(EMPLOYEE_FILE))) {
            oos.writeObject(employees);
            System.out.println("Đã lưu " + employees.size() + " nhân viên vào file.");
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Employee> loadEmployees() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(EMPLOYEE_FILE))) {
            return (List<Employee>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file nhân viên. Tạo danh sách mới.");
            return new ArrayList<>();
        }
    }
    
    public void saveDepartments(List<Department> departments) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DEPARTMENT_FILE))) {
            oos.writeObject(departments);
            System.out.println("Đã lưu " + departments.size() + " phòng ban vào file.");
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Department> loadDepartments() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DEPARTMENT_FILE))) {
            return (List<Department>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file phòng ban. Tạo danh sách mới.");
            return new ArrayList<>();
        }
    }
    
    // CSV Operations
    public void exportEmployeesToCSV(List<Employee> employees, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write header
            writer.println("ID,Name,Email,Phone,BirthDate,HireDate,Department,EmployeeType,BaseSalary");
            
            // Write data
            for (Employee emp : employees) {
                String deptName = emp.getDepartment() != null ? 
                                 emp.getDepartment().getName() : "N/A";
                
                writer.printf("%s,%s,%s,%s,%s,%s,%s,%s,%.2f%n",
                    emp.getId(),
                    emp.getName(),
                    emp.getEmail(),
                    emp.getPhone(),
                    emp.getBirthDate(),
                    emp.getHireDate(),
                    deptName,
                    emp.getEmployeeType(),
                    emp.getBaseSalary()
                );
            }
            
            System.out.println("Đã export " + employees.size() + " nhân viên ra file: " + filename);
        } catch (IOException e) {
            System.err.println("Lỗi khi export CSV: " + e.getMessage());
        }
    }
    
    public void importEmployeesFromCSV(String filename, EmployeeService employeeService) {
        int count = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Skip header
            
            while ((line = reader.readLine()) != null) {
                try {
                    Employee emp = parseEmployeeFromCSV(line);
                    if (emp != null) {
                        // Thêm vào service (service sẽ thêm vào DAO)
                        // employeeService.addEmployee(emp);
                        count++;
                    }
                } catch (Exception e) {
                    System.err.println("Lỗi khi parse dòng: " + line + " - " + e.getMessage());
                }
            }
            
            System.out.println("Đã import " + count + " nhân viên từ file: " + filename);
        } catch (IOException e) {
            System.err.println("Lỗi khi import CSV: " + e.getMessage());
        }
    }
    
    private Employee parseEmployeeFromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 9) {
            return null;
        }
        
        try {
            String id = parts[0];
            String name = parts[1];
            String email = parts[2];
            String phone = parts[3];
            LocalDate birthDate = LocalDate.parse(parts[4], DATE_FORMATTER);
            LocalDate hireDate = LocalDate.parse(parts[5], DATE_FORMATTER);
            String deptName = parts[6];
            String empType = parts[7];
            double baseSalary = Double.parseDouble(parts[8]);
            
            // Tạo employee theo type
            Employee employee;
            Department department = new Department("TEMP", deptName);
            
            switch (empType.toUpperCase()) {
                case "FULL-TIME":
                    employee = new FullTimeEmployee(id, name, email, phone, 
                                                   birthDate, hireDate, 
                                                   department, baseSalary);
                    break;
                case "PART-TIME":
                    employee = new PartTimeEmployee(id, name, email, phone,
                                                   birthDate, hireDate,
                                                   department, baseSalary);
                    break;
                case "MANAGER":
                    employee = new Manager(id, name, email, phone,
                                          birthDate, hireDate,
                                          department, baseSalary);
                    break;
                default:
                    System.err.println("Loại nhân viên không hợp lệ: " + empType);
                    return null;
            }
            
            return employee;
            
        } catch (Exception e) {
            System.err.println("Lỗi khi parse: " + e.getMessage());
            return null;
        }
    }
    
    // Backup and Restore
    public void backupData(List<Employee> employees, List<Department> departments) {
        String timestamp = LocalDate.now().toString();
        String backupDir = "backup_" + timestamp;
        
        new File(backupDir).mkdirs();
        
        try {
            saveEmployees(employees);
            saveDepartments(departments);
            
            // Copy files to backup directory
            copyFile(EMPLOYEE_FILE, backupDir + "/" + EMPLOYEE_FILE);
            copyFile(DEPARTMENT_FILE, backupDir + "/" + DEPARTMENT_FILE);
            
            System.out.println("Đã sao lưu dữ liệu vào thư mục: " + backupDir);
        } catch (IOException e) {
            System.err.println("Lỗi khi sao lưu: " + e.getMessage());
        }
    }
    
    private void copyFile(String source, String destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
    
    public void restoreData(EmployeeService empService, DepartmentService deptService) {
        try {
            List<Employee> employees = loadEmployees();
            List<Department> departments = loadDepartments();
            
            // Clear current data
            // Note: You'll need to add clear methods to your services/DAOs
            
            System.out.println("Đã khôi phục " + employees.size() + " nhân viên và " +
                             departments.size() + " phòng ban.");
        } catch (Exception e) {
            System.err.println("Lỗi khi khôi phục: " + e.getMessage());
        }
    }
    
    // Load initial sample data
    public void loadInitialData(EmployeeService empService, DepartmentService deptService) {
        try {
            // Create sample departments
            Department itDept = new Department("D001", "IT", "Ph