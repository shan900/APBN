package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ScannerMachineStatusController {

    @FXML
    private ComboBox<String> machineComboBox;

    @FXML
    private Label healthStatusLabel;

    @FXML
    private Label scannerStatusLabel;

    @FXML
    private Label maintenanceDateLabel;

    @FXML
    private TextArea problemArea;

    @FXML
    private Label statusLabel;


    // =========================================================
    // INITIALIZE
    // =========================================================

    @FXML
    public void initialize() {

        machineComboBox.getItems().addAll(
                "Scanner Machine 01",
                "Scanner Machine 02",
                "Scanner Machine 03"
        );

        machineComboBox.setValue("Scanner Machine 01");

        healthStatusLabel.setText("Unknown");
        scannerStatusLabel.setText("Not Checked");
        maintenanceDateLabel.setText("Not Available");
        problemArea.setText("");

        statusLabel.setText("Ready");
    }


    // =========================================================
    // GOAL 6 - EVENT 2
    // Fetch Scanner Machine Data
    // =========================================================

    @FXML
    private void fetchMachineData(ActionEvent event) {

        String machine = machineComboBox.getValue();

        if (machine == null || machine.isEmpty()) {

            statusLabel.setText("Please select a scanner machine.");
            return;
        }

        // Sample machine data for project demonstration

        healthStatusLabel.setText("Healthy");
        scannerStatusLabel.setText("Operational");
        maintenanceDateLabel.setText("Recently Checked");

        healthStatusLabel.setStyle(
                "-fx-background-color:#E8F5E9;" +
                        "-fx-background-radius:8;" +
                        "-fx-padding:10;" +
                        "-fx-font-weight:bold;" +
                        "-fx-text-fill:#2E7D32;"
        );

        problemArea.setText(
                "No technical problem detected."
        );

        statusLabel.setText(
                machine + " data loaded successfully."
        );
    }


    // =========================================================
    // GOAL 6 - EVENT 4
    // Detect Technical Problems
    // =========================================================

    @FXML
    private void detectProblem(ActionEvent event) {

        String machine = machineComboBox.getValue();

        if (machine == null || machine.isEmpty()) {

            statusLabel.setText("Please select a scanner machine.");
            return;
        }

        /*
         * For project demonstration, the system checks
         * the scanner status and displays the result.
         */

        if (scannerStatusLabel.getText().equals("Operational")) {

            problemArea.setText(
                    "No technical problem detected.\n" +
                            "Scanner machine is operating normally."
            );

            statusLabel.setText(
                    "Technical problem check completed."
            );

        } else {

            problemArea.setText(
                    "Technical problem detected.\n" +
                            "Scanner requires technical inspection."
            );

            statusLabel.setText(
                    "Technical problem detected."
            );
        }
    }


    // =========================================================
    // GOAL 6 - EVENT 5
    // Generate Maintenance Alert
    // =========================================================

    @FXML
    private void generateAlert(ActionEvent event) {

        String machine = machineComboBox.getValue();

        if (machine == null || machine.isEmpty()) {

            statusLabel.setText("Please select a scanner machine.");
            return;
        }

        problemArea.setText(
                "MAINTENANCE ALERT\n\n" +
                        "Scanner Machine: " + machine + "\n" +
                        "Status: Maintenance check requested."
        );

        statusLabel.setText(
                "Maintenance alert generated."
        );
    }


    // =========================================================
    // GOAL 6 - EVENT 6
    // Notify Technical Department
    // =========================================================

    @FXML
    private void notifyTechnicalDepartment(ActionEvent event) {

        String machine = machineComboBox.getValue();

        if (machine == null || machine.isEmpty()) {

            statusLabel.setText("Please select a scanner machine.");
            return;
        }

        statusLabel.setText(
                "Technical department notified for " + machine + "."
        );
    }


    // =========================================================
    // GOAL 6 - EVENT 7
    // Save Maintenance Log
    // =========================================================

    @FXML
    private void saveMaintenanceLog(ActionEvent event) {

        String machine = machineComboBox.getValue();

        if (machine == null || machine.isEmpty()) {

            statusLabel.setText("Please select a scanner machine.");
            return;
        }

        statusLabel.setText(
                "Maintenance log saved successfully."
        );
    }


    // =========================================================
    // BACK TO BAGGAGE DASHBOARD
    // =========================================================

    @FXML
    private void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/baggage-scanner.fxml"
        ));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Baggage Scanner Operator Dashboard");
        stage.show();
    }
}