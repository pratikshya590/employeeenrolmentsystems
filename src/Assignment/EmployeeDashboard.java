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

        // Declare 
        Label lblTitle, lblEmpID, lblName, lblDepartment, lblSalary, lblEmail, lblMessage;
        TextField txtEmpID, txtName, txtDepartment, txtSalary, txtEmail;
        Button btnSearch, btnClose;

        // Set up the title label
        lblTitle = new Label("Employee Dashboard");
        lblTitle.relocate(50, 0);
        Font font = new Font("Arial", 20);
        lblTitle.setFont(font);

        // Set up font for other labels
        Font font1 = new Font("Arial", 15);

        // Employee ID label and text field
        lblEmpID = new Label("Employee ID");
        lblEmpID.relocate(50, 40);
        lblEmpID.setFont(font1);
        
        txtEmpID = new TextField();
        txtEmpID.relocate(50, 70);

        // Name label and text field - set to non-editable
        lblName = new Label("Name");
        lblName.relocate(50, 100);
        lblName.setFont(font1);

        txtName = new TextField();
        txtName.relocate(50, 130);
        txtName.setEditable(false); // Prevent editing

        // Department label and text field - set to non-editable
        lblDepartment = new Label("Department");
        lblDepartment.relocate(50, 160);
        lblDepartment.setFont(font1);

        txtDepartment = new TextField();
        txtDepartment.relocate(50, 190);
        txtDepartment.setEditable(false);

        // Salary label and text field - set to non-editable
        lblSalary = new Label("Salary");
        lblSalary.relocate(50, 220);
        lblSalary.setFont(font1);

        txtSalary = new TextField();
        txtSalary.relocate(50, 250);
        txtSalary.setEditable(false);

        // Email label and text field - set to non-editable
        lblEmail = new Label("Email");
        lblEmail.relocate(50, 280);
        lblEmail.setFont(font1);

        txtEmail = new TextField();
        txtEmail.relocate(50, 310);
        txtEmail.setEditable(false);

        // Search and Close buttons
        btnSearch = new Button("Search");
        btnSearch.relocate(50, 350);

        btnClose = new Button("Close");
        btnClose.relocate(150, 350);

        // Message label
        lblMessage = new Label("Enter Employee ID and press Search");
        lblMessage.relocate(50, 380);
        lblMessage.setFont(font1);

        // Action for the Search button
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
            	
                //  parse the employee ID and search for the employee
                try {
                    int empID = Integer.parseInt(txtEmpID.getText().trim()); // Convert input to integer
                    Employee employee = Employee.search(empID); // Search for the employee by ID
                    if (employee.getEmpID() > 0) {
                    	
                        // If the employee is found, populate the fields
                        txtName.setText(employee.getName());
                        txtDepartment.setText(employee.getDepartment());
                        txtSalary.setText(String.valueOf(employee.getSalary()));
                        txtEmail.setText(employee.getEmail());
                        lblMessage.setText("Employee found!"); // Display success message
                    } else {
                    	
                        // Clear fields if employee is not found
                        txtName.setText(""); 
                        txtDepartment.setText("");
                        txtSalary.setText("");
                        txtEmail.setText("");
                        lblMessage.setText("Employee not found!"); // Display error message
                    }
                } catch (NumberFormatException e) {
                	
                    // If the input is not a valid integer, show an error message
                    lblMessage.setText("Invalid Employee ID. Please enter a number.");
                }
            }
        });

        // Action for the Close button 
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close(); // Close the window
                
            }
                });
           
        

        // Set up the scene and add all components to the pane
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(350);
        primaryStage.setHeight(450);

        // Add all components to the pane
        pane.getChildren().add(lblTitle);
        pane.getChildren().add(lblEmpID);
        pane.getChildren().add(txtEmpID);
        pane.getChildren().addAll(lblName, txtName);
        pane.getChildren().addAll(lblDepartment, txtDepartment);
        pane.getChildren().addAll(lblSalary, txtSalary);
        pane.getChildren().addAll(lblEmail, txtEmail);
        pane.getChildren().addAll(btnSearch, btnClose, lblMessage);

        primaryStage.show(); // Show the primary stage
    }

    public static void main(String[] args) {
        launch(args); 
    }
}