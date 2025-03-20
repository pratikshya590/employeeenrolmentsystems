package Assignment;

import javafx.application.Application;
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
        TextField nameField = new TextField("Aastha Shrestha");
        nameLabel.setStyle("-fx-font-weight: bold;");

        Label startDateLabel = new Label("Start Date:");
        TextField startDateField = new TextField("1 January, 2021");
        startDateLabel.setStyle("-fx-font-weight: bold;");

        Label roleLabel = new Label("Current Role:");
        TextField roleField = new TextField("Senior Engineer");
        roleLabel.setStyle("-fx-font-weight: bold;");

        Label yearsWorkedLabel = new Label("Total Years Worked:");
        TextField yearsWorkedField = new TextField("4 years");
        yearsWorkedLabel.setStyle("-fx-font-weight: bold;");

        // Close Button
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-padding: 10;");
        closeButton.setOnAction(event -> primaryStage.close()); // Closes the window

        // Adding Components to GridPane
        grid.add(title, 0, 0, 2, 1);
        grid.add(nameLabel, 0, 1); grid.add(nameField, 1, 1);
        grid.add(startDateLabel, 0, 2); grid.add(startDateField, 1, 2);
        grid.add(roleLabel, 0, 3); grid.add(roleField, 1, 3);
        grid.add(yearsWorkedLabel, 0, 4); grid.add(yearsWorkedField, 1, 4);
        grid.add(closeButton, 1, 5); // Close button at bottom right

        // Creating the Scene
        Scene scene = new Scene(grid, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
