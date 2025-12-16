package src.main.java.system.model;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;

    public FullTimeEmployee(String id, String name, String email, String phone,
                            LocalDate birthDate, LocalDate hireDate,
                            Department department, double monthlySalary) {
        super(id, name, email, phone, birthDate, hireDate, department, monthlySalary);
        this.monthlySalary = monthlySalary;
        this.bonus = 0;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }
    public double getBonus() { return bonus; }

    @Override
    public String toString(){
        return  this.getId() + " " + this.getName();
    }
}