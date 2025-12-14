package employee.management.system.test;

import employee.management.system.model.FullTimeEmployee;

import java.time.LocalDate;

public class DemoOOP {
    public static void main(String[] args) {
        System.out.println("DEMO OOP with project");
        demoAbstraction();
    }

    private static void demoAbstraction() {
        System.out.println("'start demo abstraction");
        System.out.println("---------------------------------");

        FullTimeEmployee fullTimeEmp = new FullTimeEmployee(
                "Ac001", "lee ac", "ac@gmail.com", "09879879787",
                LocalDate.of(2000,1,1), LocalDate.of(1999,1,1), null, 20000);
        System.out.println(fullTimeEmp);
        System.out.println("end to add full time emp");
    }
}
