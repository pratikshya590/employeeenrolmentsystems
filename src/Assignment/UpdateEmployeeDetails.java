package Assignment; 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UpdateEmployeeDetails extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Update Employee Details");

        // GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Title
        Label title = new Label("Update Employee Details");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Name
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField("Prati");
        nameLabel.setStyle("-fx-font-weight: bold;");

        // Gender
        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField("Female");
        genderLabel.setStyle("-fx-font-weight: bold;");

        // Age
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField("28");
        ageLabel.setStyle("-fx-font-weight: bold;");

        // Phone Number
        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField("9800000000");
        phoneLabel.setStyle("-fx-font-weight: bold;");

        // Email
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField("prati@example.com");
        emailLabel.setStyle("-fx-font-weight: bold;");

        // Address
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField("Satungal, Kathmandu");
        addressLabel.setStyle("-fx-font-weight: bold;");

        // Message Label (for success message)
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        // Update Information Button
        Button updateBtn = new Button("Update Information");
        updateBtn.setStyle("-fx-background-color: lightgreen; -fx-font-weight: bold; -fx-padding: 10;");
        updateBtn.setOnAction(event -> messageLabel.setText("Updated Successfully!"));

        // Save Button
        Button saveBtn = new Button("Save");
        saveBtn.setStyle("-fx-background-color: lightblue; -fx-font-weight: bold; -fx-padding: 10;");
        saveBtn.setOnAction(event -> messageLabel.setText("Saved Information Successfully!"));

        // Back Button 
        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px;");
        
        // Event Handler for Back Button
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    new LoginForm().start(new Stage()); // Open Login page
                    primaryStage.close(); 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Adding components to the grid
        grid.add(title, 0, 0, 2, 1);
        grid.add(nameLabel, 0, 1); grid.add(nameField, 1, 1);
        grid.add(genderLabel, 0, 2); grid.add(genderField, 1, 2);
        grid.add(ageLabel, 0, 3); grid.add(ageField, 1, 3);
        grid.add(phoneLabel, 0, 4); grid.add(phoneField, 1, 4);
        grid.add(emailLabel, 0, 5); grid.add(emailField, 1, 5);
        grid.add(addressLabel, 0, 6); grid.add(addressField, 1, 6);
        grid.add(updateBtn, 1, 7);
        grid.add(backBtn, 2, 7);
        grid.add(saveBtn, 1, 8);
        grid.add(messageLabel, 1, 9);

        // Scene setup
        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}