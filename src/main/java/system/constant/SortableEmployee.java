package system.constant;

import system.model.Employee;

public abstract class SortableEmployee implements Comparable<Employee> {

    private Object name;

    @Override
    public int compareTo(Employee E){
        return 1;
    }
}
