package mylibs;



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeProcessing {

    // Database connection constants
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String USER = "root";
    private static final String PASS = "curtainbangs@13";
    private static final String DBNAME = "hrm";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;

    // Logger for exception logging
    private static final Logger logger = Logger.getLogger(EmployeeProcessing.class.getName());

    
    
    public void insert(Employee employee) {
        String checkSQL = "SELECT COUNT(*) FROM employees WHERE email = ?";
        String insertSQL = "INSERT INTO employees (name, department, salary, email, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            Class.forName(DRIVER);
            System.out.println("Connected");

            boolean emailExists = true;
            String newEmail = employee.getEmail();
            int count = 1;

            // Step 1: Generate a unique email if needed
            while (emailExists) {
                try (PreparedStatement checkStat = conn.prepareStatement(checkSQL)) {
                    checkStat.setString(1, newEmail);
                    ResultSet rs = checkStat.executeQuery();
                    emailExists = rs.next() && rs.getInt(1) > 0;
                }

                if (emailExists) {
                    newEmail = employee.getEmail().split("@")[0] + count + "@" + employee.getEmail().split("@")[1];
                    count++;
                }
            }

            employee.setEmail(newEmail); // Set the unique email

            // Step 2: Insert new employee
            try (PreparedStatement insertStat = conn.prepareStatement(insertSQL)) {
                insertStat.setString(1, employee.getName());
                insertStat.setString(2, employee.getDepartment());
                insertStat.setDouble(3, employee.getSalary());
                insertStat.setString(4, employee.getEmail());
                insertStat.setString(5, employee.getStatus());

                insertStat.executeUpdate();
                System.out.println("Employee inserted successfully with email: " + employee.getEmail());
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Error during insert", ex);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "JDBC Driver not found", ex);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Unexpected Error", ex);
        }
        System.out.println("Connection closed"); // This will print after the try block
    }

    public void update(Employee employee) {
        String SQL = "UPDATE employees SET name = ?, department = ?, salary = ?, status = ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pStat = conn.prepareStatement(SQL)) {

            Class.forName(DRIVER); // Loading the Driver class
            System.out.println("Connected");

            // Setting parameters for the PreparedStatement
            pStat.setString(1, employee.getName());
            pStat.setString(2, employee.getDepartment());
            pStat.setDouble(3, employee.getSalary());
            pStat.setString(4, employee.getStatus());
            pStat.setString(5, employee.getEmail()); // Update using email

            // Execute the update query
            pStat.executeUpdate();
            System.out.println("Employee updated");

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Error during update", ex);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "JDBC Driver not found", ex);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Unexpected Error", ex);
        }
        System.out.println("Connection closed");
    }

    // Delete Employee record
    public void delete(int empID) {
        String SQL = "DELETE FROM employees WHERE empID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pStat = conn.prepareStatement(SQL)) {

            Class.forName(DRIVER); // Loading the Driver class
            System.out.println("Connected");

            // Setting the empID parameter
            pStat.setInt(1, empID);

            // Execute the delete query
            pStat.executeUpdate();
            System.out.println("Employee deleted");

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Error during delete", ex);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "JDBC Driver not found", ex);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Unexpected Error", ex);
        }
        System.out.println("Connection closed"); // This will print after the try block
    }
}
