package employee.management.system.constant;

import employee.management.system.model.Employee;

public abstract class SortableEmployee implements Comparable<Employee> {

    private Object name;

    @Override
    public int compareTo(Employee E){
        return 1;
//        return this.name.compareTo(E.getName());
    }
}
