package Assignment;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mylibs.Employee;

public class EmployeeEnrolment extends Application {
    private TableView<Employee> table;
    private List<Employee> employeeList;  
    private TextField empIDInput, nameInput, departmentInput, salaryInput, emailInput, statusInput;  

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Enrollment");

        employeeList = new ArrayList<>();  

        table = new TableView<>();
        table.getColumns().addAll(getColumns());  

        GridPane formGrid = createForm();  

        // Buttons
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addEmployee());  
        
        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> updateEmployee());  

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteEmployee());  

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> searchEmployee());  

       

        // **Back Button to go to Login Page**
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px;");
        backButton.setOnAction(e -> {
            try {
                new LoginForm().start(new Stage());  // Open Login Page
                primaryStage.close();  // Close Employee Enrollment Page
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Layout
        FlowPane layout = new FlowPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setStyle("-fx-padding: 10;");
        layout.getChildren().addAll(table, formGrid, addButton, updateButton, deleteButton, searchButton, backButton);  

        Scene scene = new Scene(layout, 700, 600);  
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableColumn<Employee, ?>[] getColumns() {
        TableColumn<Employee, Integer> empIDColumn = new TableColumn<>("Employee ID");
        empIDColumn.setCellValueFactory(new PropertyValueFactory<>("empID"));

        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Employee, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Employee, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        return new TableColumn[]{empIDColumn, nameColumn, departmentColumn, salaryColumn, emailColumn, statusColumn};
    }

    private GridPane createForm() {
        GridPane grid = new GridPane();
        grid.setStyle("-fx-padding: 10;");
        grid.setHgap(10);
        grid.setVgap(8);

        empIDInput = createTextField("Employee ID", grid, 0);
        nameInput = createTextField("Name", grid, 1);
        departmentInput = createTextField("Department", grid, 2);
        salaryInput = createTextField("Salary", grid, 3);
        emailInput = createTextField("Email", grid, 4);
        statusInput = createTextField("Status", grid, 5);

        return grid;  
    }

    private TextField createTextField(String label, GridPane grid, int row) {
        Label lbl = new Label(label + ":");
        GridPane.setConstraints(lbl, 0, row);  
        TextField textField = new TextField();
        GridPane.setConstraints(textField, 1, row);  
        grid.getChildren().addAll(lbl, textField);  
        return textField;  
    }
    
    private void addEmployee() {
        Employee emp = new Employee(Integer.parseInt(empIDInput.getText()), nameInput.getText(), departmentInput.getText(), Double.parseDouble(salaryInput.getText()), emailInput.getText(), statusInput.getText());
        employeeList.add(emp);  
        table.getItems().add(emp);  
        resetForm();  
    }
    
    private void updateEmployee() {
        Employee selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                if (empIDInput.getText().isEmpty() || nameInput.getText().isEmpty() || departmentInput.getText().isEmpty() || salaryInput.getText().isEmpty() || emailInput.getText().isEmpty() || statusInput.getText().isEmpty()) {
                    System.out.println("All fields must be filled out!");
                    return;
                }

                selected.setEmpID(Integer.parseInt(empIDInput.getText()));  
                selected.setName(nameInput.getText());
                selected.setDepartment(departmentInput.getText());
                selected.setSalary(Double.parseDouble(salaryInput.getText()));  
                selected.setEmail(emailInput.getText());
                selected.setStatus(statusInput.getText());

                table.refresh();  
                resetForm();  

            } catch (NumberFormatException e) {
                System.out.println("Invalid input for Employee ID or Salary. Please enter valid numbers.");
            }
        }
    }
    
    private void deleteEmployee() {
        Employee selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            employeeList.remove(selected);  
            table.getItems().remove(selected);  
        }
    }
    
    private void searchEmployee() {
        int empID = Integer.parseInt(empIDInput.getText());
        Employee result = Employee.search(empID);  
        if (result.getEmpID() != 0) {  
            empIDInput.setText(String.valueOf(result.getEmpID()));
            nameInput.setText(result.getName());
            departmentInput.setText(result.getDepartment());
            salaryInput.setText(String.valueOf(result.getSalary()));
            emailInput.setText(result.getEmail());
            statusInput.setText(result.getStatus());
        } else {
            resetForm();  
            System.out.println("Employee not found");
        }
    }
    
    private void resetForm() {
        empIDInput.clear();
        nameInput.clear();
        departmentInput.clear();
        salaryInput.clear();
        emailInput.clear();
        statusInput.clear();
    }
    
    public static void main(String[] args) {
        launch(args);  
    }
}