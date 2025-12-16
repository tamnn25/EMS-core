package src.main.java.system.ui;

import src.main.java.system.model.*;
import src.main.java.system.dao.EmployeeDAO;
import java.util.List;
import java.time.LocalDate;

public class ConsoleUI {

    public void start() {
        System.out.println("=== HỆ THỐNG QUẢN LÝ NHÂN VIÊN ===");

        // 1. Khởi tạo DAO
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // 2. Tạo dữ liệu mẫu (Demo OOP)
        createSampleData(employeeDAO);

        // 3. Hiển thị tất cả nhân viên
        displayAllEmployees(employeeDAO);

        // 4. Demo các tính năng OOP
        demonstrateOOPFeatures(employeeDAO);

        System.out.println("\n=== KẾT THÚC CHƯƠNG TRÌNH ===");
    }

    private void createSampleData(EmployeeDAO dao) {
        System.out.println("\n--- TẠO DỮ LIỆU MẪU ---");

        // Tạo phòng ban
        Department itDept = new Department("D001", "IT", "Phòng Công nghệ thông tin");
        Department hrDept = new Department("D002", "HR", "Phòng Nhân sự");

        Department acdept = new Department("Ac01", "Ac", "Phòng kế Toán");

        // Tạo các loại nhân viên khác nhau (Đa hình)
        Employee emp1 = new FullTimeEmployee(
                "E001", "Nguyễn Văn A", "nva@company.com", "0912345678",
                LocalDate.of(1990, 5, 15), LocalDate.of(2020, 1, 10),
                itDept, 15000000
        );

        Employee emp2 = new PartTimeEmployee(
                "E002", "Trần Thị B", "ttb@company.com", "0923456789",
                LocalDate.of(1995, 8, 22), LocalDate.of(2021, 3, 15),
                hrDept, 50000
        );

        Employee empAc = new FullTimeEmployee(
                "AC001", "Nguyễn kế Toán", "ac@gmail.com", "09879877654" ,
                LocalDate.of(1990, 1, 1), LocalDate.of(2025, 1,1), acdept, 40000000
        );
        ((PartTimeEmployee) emp2).addHoursWorked(120);

        Employee emp3 = new Manager(
                "E003", "Lê Văn C", "lvc@company.com", "0934567890",
                LocalDate.of(1985, 3, 30), LocalDate.of(2018, 6, 1),
                itDept, 25000000
        );
        ((Manager) emp3).setTeamSize(5);

        // Thêm vào hệ thống
        dao.addEmployee(emp1);
        dao.addEmployee(emp2);
        dao.addEmployee(emp3);
        dao.addEmployee(empAc);

        System.out.println("Đã tạo 3 nhân viên mẫu thành công!");
    }

    private void displayAllEmployees(EmployeeDAO dao) {
        System.out.println("\n--- DANH SÁCH TẤT CẢ NHÂN VIÊN ---");

        List<Employee> employees = dao.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào!");
            return;
        }

        // Hiển thị dạng bảng đơn giản
        System.out.println("+----+-------+---------------------+----------------+----------------+");
        System.out.println("| STT|   ID  |        Tên          |      Loại      |     Lương      |");
        System.out.println("+----+-------+---------------------+----------------+----------------+");

        int stt = 1;
        for (Employee emp : employees) {
            System.out.printf("| %2d | %-5s | %-19s | %-14s | %,13.0f |\n",
                    stt++,
                    emp.getId(),
                    emp.getName(),
                    emp.getEmployeeType(),
                    emp.calculateSalary()
            );
        }

        System.out.println("+----+-------+---------------------+----------------+----------------+");

        // Thống kê
        System.out.println("\n📊 THỐNG KÊ:");
        System.out.println("• Tổng số nhân viên: " + employees.size());
        System.out.println("• Tổng chi phí lương: " +
                String.format("%,.0f VND", dao.getTotalSalaryExpense()));
    }

    private void demonstrateOOPFeatures(EmployeeDAO dao) {
        System.out.println("\n--- DEMO CÁC TÍNH CHẤT OOP ---");

        List<Employee> employees = dao.getAllEmployees();

        // 1. Tính Đa hình (Polymorphism)
        System.out.println("\n1. TÍNH ĐA HÌNH - Mỗi loại nhân viên tính lương khác nhau:");
        for (Employee emp : employees) {
            System.out.printf("• %s (%s): %,15.0f VND\n",
                    emp.getName(),
                    emp.getEmployeeType(),
                    emp.calculateSalary()
            );
        }

        // 2. Tính Kế thừa (Inheritance)
        System.out.println("\n2. TÍNH KẾ THỪA - Hiển thị thông tin chi tiết:");
        for (Employee emp : employees) {
            emp.displayInfo();
        }

        // 3. Tính Trừu tượng (Abstraction)
        System.out.println("\n3. TÍNH TRỪU TƯỢNG - Tất cả đều là Employee:");
        for (Employee emp : employees) {
            System.out.println("- " + emp.getClass().getSimpleName() +
                    " implements calculateSalary()");
        }

        // 4. Tính Đóng gói (Encapsulation)
        System.out.println("\n4. TÍNH ĐÓNG GÓI - Truy cập thông qua getter/setter:");
        if (!employees.isEmpty()) {
            Employee emp = employees.get(0);
            System.out.println("• Trước: " + emp.getName());
            emp.setName("Nguyễn Văn A (Đã đổi tên)");
            System.out.println("• Sau: " + emp.getName());
        }
    }
}