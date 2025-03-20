package Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LoginForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // GridPane for layout
        GridPane grid = new GridPane();
        grid.setVgap(10); // Vertical gap between rows
        grid.setHgap(10); // Horizontal gap between columns
        grid.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        // Title
        Label lblTitle = new Label("Login");
        lblTitle.setStyle("-fx-font-size: 65px; -fx-text-fill: #1E2A7D; -fx-font-weight: bolder;");
        grid.add(lblTitle, 1, 0);

        // Login Type Toggle
        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton btnEmployee = new ToggleButton("Employee");
        ToggleButton btnHR = new ToggleButton("HR");
        btnEmployee.setToggleGroup(toggleGroup);
        btnHR.setToggleGroup(toggleGroup);
        btnEmployee.setSelected(true);

        HBox toggleBox = new HBox(10, btnEmployee, btnHR);
        grid.add(new Label("Select login type"), 1, 1);
        grid.add(toggleBox, 1, 2);

        // Username and Password Fields
        TextField txtUser = new TextField();
        txtUser.setPromptText("User name/Email");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Password");

        grid.add(txtUser, 1, 3);
        grid.add(txtPassword, 1, 4);

        // Remember Me and Forgot Password
        CheckBox rememberMe = new CheckBox("Remember me");
        Label forgotPassword = new Label("Forgot password?");
        forgotPassword.setStyle("-fx-text-fill: blue; -fx-underline: true;");

        HBox optionsBox = new HBox(10, rememberMe, forgotPassword);
        grid.add(optionsBox, 1, 5);

        // Login Button
        Button btnLogin = new Button("Log in");
        btnLogin.setStyle("-fx-background-color: darkgreen; -fx-text-fill: white;");
        btnLogin.setMinWidth(200);

        // Success Message Label (Initially Hidden)
        Label successMessage = new Label();
        successMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        // Event Handler for Login Button
        btnLogin.setOnAction((ActionEvent event) -> {
            successMessage.setText("Login successfully!");
        });

        grid.add(btnLogin, 1, 6);
        grid.add(successMessage, 1, 7); // Message appears below login button

        // Sign Up Link
        Label signUp = new Label("Sign Up");
        signUp.setStyle("-fx-text-fill: blue; -fx-underline: true;");
        HBox signUpBox = new HBox(new Label("Don't have an account? "), signUp);
        grid.add(signUpBox, 1, 8);

        // Scene Setup
        Scene scene = new Scene(grid, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}