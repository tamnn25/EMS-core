package src.main.java.system.model;

import java.time.LocalDate;

public class Manager extends FullTimeEmployee {
    private double managementBonus;
    private int teamSize;

    public Manager(String id, String name, String email, String phone,
                   LocalDate birthDate, LocalDate hireDate,
                   Department department, double monthlySalary) {
        super(id, name, email, phone, birthDate, hireDate, department, monthlySalary);
        this.managementBonus = 2000000;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + managementBonus;
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    public double getManagementBonus() { return managementBonus; }
    public void setManagementBonus(double managementBonus) {
        this.managementBonus = managementBonus;
    }

    // Thêm method setTeamSize() bị thiếu
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTeamSize(){
        return teamSize;
    }
}