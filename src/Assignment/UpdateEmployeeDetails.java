package Assignment; 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UpdateEmployeeDetails extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Update Employee Details"); // Set window title

        GridPane grid = new GridPane(); // Using GridPane for structured form layout
        grid.setHgap(10);
        grid.setVgap(10);

        // Title Label
        Label title = new Label("Update Employee Details");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Name Input Field
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField("Aastha Shrestha");
        nameLabel.setStyle("-fx-font-weight: bold;");

        // Gender Input Field
        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField("Female");
        genderLabel.setStyle("-fx-font-weight: bold;");

        // Age Input Field
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField("28");
        ageLabel.setStyle("-fx-font-weight: bold;");

        // Phone Number Input Field
        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField("9800000000");
        phoneLabel.setStyle("-fx-font-weight: bold;");

        // Email Input Field
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField("aasthashrestha12@gmail.com");
        emailLabel.setStyle("-fx-font-weight: bold;");

        // Address Input Field
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField("Satungal, Kathmandu");
        addressLabel.setStyle("-fx-font-weight: bold;");

        // Message Label (To display success message)
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        // Update Information Button
        Button updateBtn = new Button("Update Information");
        updateBtn.setStyle("-fx-background-color: lightgreen; -fx-font-weight: bold; -fx-padding: 10;");
        
        // Button Click Action - Displays Success Message
        updateBtn.setOnAction(event -> messageLabel.setText("Updated Successfully!"));

        // Adding Components to GridPane
        grid.add(title, 0, 0, 2, 1);
        grid.add(nameLabel, 0, 1); grid.add(nameField, 1, 1);
        grid.add(genderLabel, 0, 2); grid.add(genderField, 1, 2);
        grid.add(ageLabel, 0, 3); grid.add(ageField, 1, 3);
        grid.add(phoneLabel, 0, 4); grid.add(phoneField, 1, 4);
        grid.add(emailLabel, 0, 5); grid.add(emailField, 1, 5);
        grid.add(addressLabel, 0, 6); grid.add(addressField, 1, 6);
        grid.add(updateBtn, 1, 7);
        grid.add(messageLabel, 1, 8); // Message label appears below the button

        // Setting Up the Scene
        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args); 
    }
}