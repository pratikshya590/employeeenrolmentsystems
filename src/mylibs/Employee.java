package mylibs;

public class Employee {
    private int empID;
    private String name;
    private String department;
    private double salary;
    private String email;
    private String status;

    // Default constructor
    public Employee() {
        this.empID = 0;
        this.name = "";
        this.department = "";
        this.salary = 0.0;
        this.email = "";
        this.status = "";
    }

    // Parameterized constructor
    public Employee(int empID, String name, String department, double salary, String email, String status) {
        this.empID = empID;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.status = status;
    }

    // Copy constructor
    public Employee(Employee employee) {
        this.empID = employee.empID;
        this.name = employee.name;
        this.department = employee.department;
        this.salary = employee.salary;
        this.email = employee.email;
        this.status = employee.status;
    }

    // Getters and Setters
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public int getId() {
		return 0;
	}

	
	}
