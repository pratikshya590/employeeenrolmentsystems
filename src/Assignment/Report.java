package Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Report extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HRM Report"); // Set the window title
        
        Pane root = new Pane(); // Using Pane for positioning elements

        // Title Label
        Label title = new Label("HRM Report");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        title.setLayoutX(20);
        title.setLayoutY(20);

        // Message Label (for displaying button actions)
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        messageLabel.setLayoutX(20);
        messageLabel.setLayoutY(200);

        // Buttons for Report Generation
        Button salaryReportBtn = new Button("Generate Salary Report");
        Button tenureReportBtn = new Button("Generate Tenure Report");
        Button demographicsReportBtn = new Button("Generate Demographics Report");

        // Styling Report Buttons
        salaryReportBtn.setStyle("-fx-font-weight: bold; -fx-padding: 10; -fx-background-color: #D9D9D9;");
        tenureReportBtn.setStyle("-fx-padding: 10; -fx-background-color: #D9D9D9;");
        demographicsReportBtn.setStyle("-fx-padding: 10; -fx-background-color: #D9D9D9;");

        // HBox for Report Buttons
        HBox reportButtons = new HBox(20, salaryReportBtn, tenureReportBtn, demographicsReportBtn);
        reportButtons.setLayoutX(20);
        reportButtons.setLayoutY(60);

        // Action Buttons - Download and Print
        Button pdfBtn = new Button("Download as PDF");
        Button excelBtn = new Button("Download as Excel");
        Button printBtn = new Button("Print");
        Button closeBtn = new Button("Close");

        // Styling Action Buttons
        pdfBtn.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-padding: 10;");
        excelBtn.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-padding: 10;");
        printBtn.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-padding: 10;");
        closeBtn.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-padding: 10;");

        // HBox for Action Buttons
        HBox actionButtons = new HBox(20, pdfBtn, excelBtn, printBtn, closeBtn);
        actionButtons.setLayoutX(20);
        actionButtons.setLayoutY(120);

        //Button Click Events  
        pdfBtn.setOnAction(event -> messageLabel.setText("Downloaded as PDF"));
        excelBtn.setOnAction(event -> messageLabel.setText("Downloaded as Excel"));
        printBtn.setOnAction(event -> messageLabel.setText("Printed successfully"));
        closeBtn.setOnAction(event -> primaryStage.close()); // Closes the window

        // Add All Elements to Pane
        root.getChildren().addAll(title, reportButtons, actionButtons, messageLabel);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}