package Assignment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mylibs.Employee;



public class EmployeeDashboard extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Label lblTitle, lblEmpID, lblName, lblDepartment, lblSalary, lblEmail, lblMessage;
        TextField txtEmpID, txtName, txtDepartment, txtSalary, txtEmail;
        Button btnSearch, btnClose;
        
        lblTitle = new Label("Employee Dashboard");
        lblTitle.relocate(50, 0);
        Font font = new Font("Arial", 20);
        lblTitle.setFont(font);
        
        Font font1 = new Font("Arial", 15);
        lblEmpID = new Label("Employee ID");
        lblEmpID.relocate(50, 40);
        lblEmpID.setFont(font1);
        
        txtEmpID = new TextField();
        txtEmpID.relocate(50, 70);
        
        lblName = new Label("Name");
        lblName.relocate(50, 100);
        lblName.setFont(font1);
        
        txtName = new TextField();
        txtName.relocate(50, 130);
        txtName.setEditable(false); // Prevent manual editing
        
        lblDepartment = new Label("Department");
        lblDepartment.relocate(50, 160);
        lblDepartment.setFont(font1);
        
        txtDepartment = new TextField();
        txtDepartment.relocate(50, 190);
        txtDepartment.setEditable(false);
        
        lblSalary = new Label("Salary");
        lblSalary.relocate(50, 220);
        lblSalary.setFont(font1);
        
        txtSalary = new TextField();
        txtSalary.relocate(50, 250);
        txtSalary.setEditable(false);
        
        lblEmail = new Label("Email");
        lblEmail.relocate(50, 280);
        lblEmail.setFont(font1);
        
        txtEmail = new TextField();
        txtEmail.relocate(50, 310);
        txtEmail.setEditable(false);
        
        btnSearch = new Button("Search");
        btnSearch.relocate(50, 350);
        
        btnClose = new Button("Close");
        btnClose.relocate(150, 350);
        
        lblMessage = new Label("Enter Employee ID and press Search");
        lblMessage.relocate(50, 380);
        lblMessage.setFont(font1);
        
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                // Search and Display Employee Details
                try {
                    int empID = Integer.parseInt(txtEmpID.getText().trim()); // Convert input to integer
                    Employee employee = new Employee().search(empID); // Search Employee by ID
                    
                    if (employee.getEmpID() > 0) {
                        txtName.setText(employee.getName());
                        txtDepartment.setText(employee.getDepartment());
                        txtSalary.setText(String.valueOf(employee.getSalary()));
                        txtEmail.setText(employee.getEmail());
                        lblMessage.setText("Employee found!");
                    } else {
                        txtName.setText(""); // Clear fields if employee not found
                        txtDepartment.setText("");
                        txtSalary.setText("");
                        txtEmail.setText("");
                        lblMessage.setText("Employee not found!");
                    }
                } catch (NumberFormatException e) {
                    lblMessage.setText("Invalid Employee ID. Please enter a number.");
                }
            }
        });

        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(350);
        primaryStage.setHeight(450);

        pane.getChildren().add(lblTitle);
        pane.getChildren().add(lblEmpID);
        pane.getChildren().add(txtEmpID);
        pane.getChildren().addAll(lblName, txtName);
        pane.getChildren().addAll(lblDepartment, txtDepartment);
        pane.getChildren().addAll(lblSalary, txtSalary);
        pane.getChildren().addAll(lblEmail, txtEmail);
        pane.getChildren().addAll(btnSearch, btnClose, lblMessage);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
