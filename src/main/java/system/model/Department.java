package system.model;

import java.util.*;

public class Department {
    private String id;
    private String name;
    private String description;

    public Department(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    }

    // Static method to return fake sample data
    public static List<Department> getSampleDepartments() {
        List<Department> list = new ArrayList<>();
        list.add(new Department("D01", "HR", "Human Resources"));
        list.add(new Department("D02", "IT", "Information Technology"));
        list.add(new Department("D03", "FIN", "Finance"));
        list.add(new Department("D04", "MKT", "Marketing"));
        return list;
    }
}