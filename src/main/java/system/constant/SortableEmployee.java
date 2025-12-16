package src.main.java.system.constant;

import src.main.java.system.model.Employee;

public abstract class SortableEmployee implements Comparable<Employee> {

    private Object name;

    @Override
    public int compareTo(Employee E){
        return 1;
//        return this.name.compareTo(E.getName());
    }
}
