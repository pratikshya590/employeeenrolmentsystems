package Assignment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EmployeeTenure extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Tenure");

        // Creating a GridPane Layout
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);

        // Title Label
        Label title = new Label("Employee Tenure");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Labels and Text Fields
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField("Prati");
        nameLabel.setStyle("-fx-font-weight: bold;");

        Label startDateLabel = new Label("Start Date:");
        TextField startDateField = new TextField("1 January, 2021");
        startDateLabel.setStyle("-fx-font-weight: bold;");

        Label roleLabel = new Label("Current Role:");
        TextField roleField = new TextField("Senior Engineer");
        roleLabel.setStyle("-fx-font-weight: bold;");

        Label yearsWorkedLabel = new Label("Total Years Worked:");
        TextField yearsWorkedField = new TextField("2 years");
        yearsWorkedLabel.setStyle("-fx-font-weight: bold;");

        // View Button
        Button ViewedBtn = new Button("Viewed");
        ViewedBtn.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-padding: 10;");
        
     // Back Button 
        Button Back = new Button("Back");
        Back.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px;");

        // Message Label for Success
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        // Event Handler for the View Button
        ViewedBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageLabel.setText("Viewed");
                try {
                    new UpdateEmployeeDetails().start(new Stage());//load and display UpdateEmployeeDetails
                    primaryStage.close();//close current window
                    }
                    catch(Exception ex) {
                    	System.out.println("Error "+ex.getMessage());
                    }
            }
                });

        
     // Event Handler for Back Button
        Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    new LoginForm().start(new Stage()); // Open EmployeeEnrolment Page
                    primaryStage.close(); // Close SalaryDetails window
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        // Close Button
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-padding: 10;");
        closeButton.setOnAction(event -> primaryStage.close()); // Closes the window

        // Adding Components to GridPane
        grid.add(title, 0, 0, 2, 1);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(startDateLabel, 0, 2);
        grid.add(startDateField, 1, 2);
        grid.add(roleLabel, 0, 3);
        grid.add(roleField, 1, 3);
        grid.add(yearsWorkedLabel, 0, 4);
        grid.add(yearsWorkedField, 1, 4);
        grid.add(ViewedBtn, 1, 5); // Adding View button
        grid.add(Back, 2, 5); // Adding Back button
        grid.add(messageLabel, 1, 6); // Success message label
        grid.add(closeButton, 1, 7); // Close button at bottom

        // Creating the Scene
        Scene scene = new Scene(grid, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}