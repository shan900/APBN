package com.summer26.sec01.group06.apbn.zaid.controllers;

import com.summer26.sec01.group06.apbn.zaid.services.BaggageScannerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BaggageReportsController {

    private final BaggageScannerService baggageScannerService = new BaggageScannerService();

    @FXML
    private ComboBox<String> scannerComboBox;

    @FXML
    private ComboBox<String> machineStatusComboBox;

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        scannerComboBox.getItems().addAll(
                "Scanner 1",
                "Scanner 2",
                "Scanner 3"
        );

        scannerComboBox.setValue("Scanner 1");

        machineStatusComboBox.getItems().addAll(
                "Online",
                "Offline",
                "Maintenance"
        );

        machineStatusComboBox.setValue("Online");

        reportTypeComboBox.getItems().addAll(
                "Daily Report",
                "Weekly Report",
                "Monthly Report"
        );

        reportTypeComboBox.setValue("Daily Report");

        statusLabel.setText("Ready...");
    }

    @FXML
    public void monitorButton(ActionEvent event) {

        statusLabel.setText("Scanner is operating normally.");

    }

    @FXML
    public void generateButton(ActionEvent event) {

        statusLabel.setText("Inspection report generated.");

    }

    @FXML
    public void saveButton(ActionEvent event) {

        statusLabel.setText("Report saved successfully.");

    }
    @FXML
    private void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/summer26/sec01/group06/apbn/zaid/view/baggage-scanner.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}