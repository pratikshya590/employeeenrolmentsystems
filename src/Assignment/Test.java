package Assignment;

import mylibs.EmployeeProcessing;
import mylibs.Employee;

public class Test {
    public static void main(String[] args) {
        EmployeeProcessing empProcess = new EmployeeProcessing();

        
        
    // Create and insert a new employee
             Employee newEmployee = new Employee(1, "Prati Shrestha", "IT", 70000.00, "prati@gmail.com", "Active");
    empProcess.insert(newEmployee);
        
        // Update the employee's department and salary
        Employee updatedEmployee = new Employee(1, "Prati Shrestha", "HR", 80000.00, "prati@gmail.com", "Active");
        empProcess.update(updatedEmployee);
        
        // Delete the employee
        empProcess.delete(1);
    }
}