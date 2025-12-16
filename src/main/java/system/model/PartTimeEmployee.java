package system.model;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

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