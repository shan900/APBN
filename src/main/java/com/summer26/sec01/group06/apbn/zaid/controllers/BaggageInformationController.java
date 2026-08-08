package com.summer26.sec01.group06.apbn.zaid.controllers;

import com.summer26.sec01.group06.apbn.zaid.services.BaggageScannerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BaggageInformationController {

    private final BaggageScannerService baggageScannerService = new BaggageScannerService();

    @FXML
    private TextField passengerNameField;

    @FXML
    private TextField baggageIdField;

    @FXML
    private ComboBox<String> scannerComboBox;

    @FXML
    private ComboBox<String> baggageStatusComboBox;

    @FXML
    private TextField searchBaggageField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button scanButton;

    @FXML
    private Button approveButton;

    @FXML
    private Button rejectButton;

    @FXML
    private Button searchButton;

    @FXML
    public void initialize() {

        scannerComboBox.getItems().addAll(
                "Scanner 1",
                "Scanner 2",
                "Scanner 3"
        );
        scannerComboBox.setValue("Scanner 1");

        baggageStatusComboBox.getItems().addAll(
                "Safe",
                "Suspicious",
                "Dangerous"
        );
        baggageStatusComboBox.setValue("Safe");

        statusLabel.setText("Ready...");
    }

    @FXML
    public void scanButton(ActionEvent event) {

        String passengerName = passengerNameField.getText().trim();
        String baggageId = baggageIdField.getText().trim();

        if (baggageScannerService.scanBaggage(passengerName, baggageId)) {

            statusLabel.setText("Baggage scanned successfully.");

        } else {

            statusLabel.setText("Please enter Passenger Name and Baggage ID.");

        }

    }

    @FXML
    public void approveButton(ActionEvent event) {

        if (baggageScannerService.approveBaggage(baggageIdField.getText().trim())) {

            statusLabel.setText("Baggage approved.");

        } else {

            statusLabel.setText("Enter a Baggage ID first.");

        }

    }

    @FXML
    public void rejectButton(ActionEvent event) {

        if (baggageScannerService.rejectBaggage(baggageIdField.getText().trim())) {

            statusLabel.setText("Baggage rejected.");

        } else {

            statusLabel.setText("Enter a Baggage ID first.");

        }

    }

    @FXML
    public void searchButton(ActionEvent event) {

        String baggageId = searchBaggageField.getText().trim();

        if (baggageScannerService.searchBaggage(baggageId)) {

            passengerNameField.setText("Zaid Khan");
            baggageIdField.setText("B1001");
            scannerComboBox.setValue("Scanner 1");
            baggageStatusComboBox.setValue("Safe");

            statusLabel.setText("Baggage Found.");

        } else {

            statusLabel.setText("Baggage Not Found.");

        }

    }
    @FXML
    private void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/summer26/sec01/group06/apbn/zaid/view/baggage-scanner.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}