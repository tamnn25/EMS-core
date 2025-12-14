package employee.management.system.constant;

import employee.management.system.model.Employee;

// Interface
public interface Sortable {
    int compareTo(Employee other);
}