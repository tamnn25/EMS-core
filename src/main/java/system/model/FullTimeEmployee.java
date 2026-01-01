package system.model;

import lombok.Getter;
import lombok.Setter;
import system.constant.EmployeeType;

import java.time.LocalDate;

@Setter
@Getter
public class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;
    private final EmployeeType employeeType;

    public FullTimeEmployee(String id, String name, String email, String phone,
                            LocalDate birthDate, LocalDate hireDate,
                            Department department, double monthlySalary) {
        super(id, name, email, phone, birthDate, hireDate, department, monthlySalary);
        this.monthlySalary = monthlySalary;
        this.bonus = 20;
        this.employeeType = EmployeeType.FULL_TIME;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }

    @Override
    public String getEmployeeType() {
        if (this.employeeType == EmployeeType.FULL_TIME){
            return "Full-Time";
        }
        return "Part-Time";
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