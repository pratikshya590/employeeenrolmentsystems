package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeProcessing {
    
    public void insert(Employee employee) { // Insert employee record into the table
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String USER = "root";
        String PASS = "curtainbangs@13";
        String DBNAME = "hrm";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
        String SQL = "INSERT INTO employees (name, department, salary, email, status) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Class.forName(DRIVER); // Loading the Driver class
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected");
            
            PreparedStatement pStat = conn.prepareStatement(SQL);
            pStat.setString(1, employee.getName());
            pStat.setString(2, employee.getDepartment());
            pStat.setDouble(3, employee.getSalary());
            pStat.setString(4, employee.getEmail());
            pStat.setString(5, employee.getStatus());
            
            pStat.executeUpdate(); // Insert the data into the table
            System.out.println("Employee inserted");
            
            conn.close(); // Close the connection
            System.out.println("Connection closed");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        }
     // Update Employee record
        public void update(Employee employee) {
            String DRIVER = "com.mysql.cj.jdbc.Driver";
            String HOST = "localhost";
            int PORT = 3306;
            String USER = "root";
            String PASS = "curtainbangs@13";
            String DBNAME = "hrm";
            String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
            String SQL = "UPDATE employees SET name = ?, department = ?, salary = ?, email = ?, status = ? WHERE id = ?";

            try {
                Class.forName(DRIVER); // Loading the Driver class
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Connected");
                
                PreparedStatement pStat = conn.prepareStatement(SQL);
                pStat.setString(1, employee.getName());
                pStat.setString(2, employee.getDepartment());
                pStat.setDouble(3, employee.getSalary());
                pStat.setString(4, employee.getEmail());
                pStat.setString(5, employee.getStatus());
                pStat.setInt(6, employee.getId()); // Assuming Employee class has getId method
                
                pStat.executeUpdate(); // Update the employee details
                System.out.println("Employee updated");
                
                conn.close(); // Close the connection
                System.out.println("Connection closed");
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            }
        
         // Delete Employee record
            public void delete(int employeeId) {
                String DRIVER = "com.mysql.cj.jdbc.Driver";
                String HOST = "localhost";
                int PORT = 3306;
                String USER = "root";
                String PASS = "curtainbangs@13";
                String DBNAME = "hrm";
                String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
                String SQL = "DELETE FROM employees WHERE id = ?";

                try {
                    Class.forName(DRIVER); // Loading the Driver class
                    Connection conn = DriverManager.getConnection(URL, USER, PASS);
                    System.out.println("Connected");
                    
                    PreparedStatement pStat = conn.prepareStatement(SQL);
                    pStat.setInt(1, employeeId); // Delete the employee based on id
                    
                    pStat.executeUpdate(); // Delete the employee record
                    System.out.println("Employee deleted");
                    
                    conn.close(); // Close the connection
                    System.out.println("Connection closed");
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            
        }
    

}
