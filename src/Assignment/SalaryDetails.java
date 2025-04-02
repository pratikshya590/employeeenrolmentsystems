package Assignment;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SalaryDetails extends Application {



	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Salary Details");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color: #F8F8F8; -fx-padding: 20px;");

        // Title Label (Styled as a Dark Header)
        Label title = new Label("Salary Details");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #4F4F4F; -fx-padding: 10px;");

        Label EmployeeIDLabel = new Label("EmployeeID:");
        EmployeeIDLabel.setStyle("-fx-font-weight: bold;");
        TextField EmployeeIDField = new TextField("1");
        
        // Input Fields with Labels
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold;");
        TextField nameField = new TextField("Prati");

        Label departmentLabel = new Label("Department:");
        departmentLabel.setStyle("-fx-font-weight: bold;");
        TextField departmentField = new TextField("IT");

        Label salaryLabel = new Label("Salary:");
        salaryLabel.setStyle("-fx-font-weight: bold;");
        TextField salaryField = new TextField("2021");

        Label EmailLabel = new Label("Email:");
        EmailLabel.setStyle("-fx-font-weight: bold;");
        TextField EmailField = new TextField("prati@example.com");

        Label StatusLabel = new Label("Status:");
        StatusLabel.setStyle("-fx-font-weight: bold;");
        TextField StatusField = new TextField("Full-Time");


        //  Viewed Button (Styled in Green)
        Button Viewed = new Button("Viewed");
        Viewed.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px;");
        
        // Back Button (Styled in Green)
        Button Back = new Button("Back");
        Back.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px;");

        // Message Label for Success
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        // Event Handler for Viewed Button
        Viewed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageLabel.setText("Viewed");
                try {
                    new EmployeeTenure().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
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

        // Adding Components to the GridPane
        grid.add(title, 0, 0, 2, 1);
        grid.add(EmployeeIDLabel, 0, 1);
        grid.add(EmployeeIDField, 1, 1);
        grid.add(nameLabel, 0, 2);
        grid.add(nameField, 1, 2);
        grid.add(departmentLabel, 0, 3);
        grid.add(departmentField, 1, 3);
        grid.add(salaryLabel, 0, 4);
        grid.add(salaryField, 1, 4);
        grid.add(EmailLabel, 0, 5);
        grid.add(EmailField, 1, 5);
        grid.add(Viewed, 1, 8);
        grid.add(Back, 2, 8);
        grid.add(messageLabel, 1, 9);

        // Setting Up the Scene
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}