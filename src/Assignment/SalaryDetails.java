package Assignment;

import javafx.application.Application;
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

        // Input Fields with Labels
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold;");
        TextField nameField = new TextField("Aastha Shrestha");

        Label monthLabel = new Label("Month:");
        monthLabel.setStyle("-fx-font-weight: bold;");
        TextField monthField = new TextField("January");

        Label yearLabel = new Label("Year:");
        yearLabel.setStyle("-fx-font-weight: bold;");
        TextField yearField = new TextField("2021");

        Label basicPayLabel = new Label("Basic Pay:");
        basicPayLabel.setStyle("-fx-font-weight: bold;");
        TextField basicPayField = new TextField("92000");

        Label allowancesLabel = new Label("Allowances:");
        allowancesLabel.setStyle("-fx-font-weight: bold;");
        TextField allowancesField = new TextField("10000");

        Label deductionLabel = new Label("Deduction:");
        deductionLabel.setStyle("-fx-font-weight: bold;");
        TextField deductionField = new TextField("2000");

        Label netSalaryLabel = new Label("Net Salary:");
        netSalaryLabel.setStyle("-fx-font-weight: bold;");
        TextField netSalaryField = new TextField("100000");
        netSalaryField.setEditable(false);

        // Download Payslip Button (Styled in Green)
        Button downloadPayslipBtn = new Button("Download Payslip");
        downloadPayslipBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px 10px;");

        // Message Label for Success
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        // Event Handler for the Button
        downloadPayslipBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageLabel.setText("Payslip downloaded successfully!");
            }
        });

        // Adding Components to the GridPane
        grid.add(title, 0, 0, 2, 1);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(monthLabel, 0, 2);
        grid.add(monthField, 1, 2);
        grid.add(yearLabel, 0, 3);
        grid.add(yearField, 1, 3);
        grid.add(basicPayLabel, 0, 4);
        grid.add(basicPayField, 1, 4);
        grid.add(allowancesLabel, 0, 5);
        grid.add(allowancesField, 1, 5);
        grid.add(deductionLabel, 0, 6);
        grid.add(deductionField, 1, 6);
        grid.add(netSalaryLabel, 0, 7);
        grid.add(netSalaryField, 1, 7);
        grid.add(downloadPayslipBtn, 1, 8);
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