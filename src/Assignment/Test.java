package Assignment;

import mylibs.EmployeeProcessing;
import mylibs.Employee;

public class Test {
    public static void main(String[] args) {
        // Create an employee object and insert it into the database
        new EmployeeProcessing().insert(new Employee(1, "Prati Shrestha", "IT", 70000.00, "prati@gmail.com", "Active"));
        
        // Update the existing employee with ID 1
        Employee updatedEmployee = new Employee(1, "Prati Shrestha Updated", "IT", 75000.00, "prati_updated@gmail.com", "Active");
        new EmployeeProcessing().update(updatedEmployee); // Update employee details
        
     // Try deleting the employee with ID 1
        new EmployeeProcessing().delete(1); // Delete employee with ID 1
    }
    }
