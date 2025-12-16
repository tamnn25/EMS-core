package src.main.java.system.util.CustomExceptions;

public class EmployeeNotFoundException extends Exception {
	private String employeeId;
	
	public EmployeeNotFoundException(String employeeId) {
        super("Employee not found with ID: " + employeeId);
        this.employeeId = employeeId;
    }
    
    public String getEmployeeId() { return employeeId; }
    
}
