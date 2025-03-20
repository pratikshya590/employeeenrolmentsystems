package Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignUpForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sign Up");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setAlwaysOnTop(true);

        // GridPane Layout
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        // Labels
        Label lblTitle = new Label("Sign Up");
        lblTitle.setStyle("-fx-font-size: 45px; -fx-text-fill: #1E2A7D; -fx-font-weight: bold;");

        Label lblFirstName = new Label("First Name:");
        Label lblLastName = new Label("Last Name:");
        Label lblEmail = new Label("Email:");
        Label lblPassword = new Label("Password:");
        Label lblMessage = new Label(); // Message Label

        // Input Fields
        TextField txtFirstName = new TextField();
        TextField txtLastName = new TextField();
        TextField txtEmail = new TextField();
        PasswordField txtPassword = new PasswordField();

        // Styling for text fields
        String textFieldStyle = "-fx-background-color: #F1EAEA;";
        txtFirstName.setStyle(textFieldStyle);
        txtLastName.setStyle(textFieldStyle);
        txtEmail.setStyle(textFieldStyle);
        txtPassword.setStyle(textFieldStyle);

        // Sign Up Button
        Button btnSignUp = new Button("Sign Up");
        btnSignUp.setStyle("-fx-background-color: #278A16; -fx-text-fill: white;");

        // Event Handler for Sign-Up
        btnSignUp.setOnAction(event -> {
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                lblMessage.setText("All fields are required.");
                lblMessage.setStyle("-fx-text-fill: red;");
            } else {
                lblMessage.setText("Sign up successful!");
                lblMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            }
        });

        // Adding Components to GridPane
        pane.add(lblTitle, 1, 0);
        pane.add(lblFirstName, 0, 1);
        pane.add(txtFirstName, 1, 1);
        pane.add(lblLastName, 0, 2);
        pane.add(txtLastName, 1, 2);
        pane.add(lblEmail, 0, 3);
        pane.add(txtEmail, 1, 3);
        pane.add(lblPassword, 0, 4);
        pane.add(txtPassword, 1, 4);
        pane.add(btnSignUp, 1, 5);
        pane.add(lblMessage, 1, 6);

        // Scene Setup
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}