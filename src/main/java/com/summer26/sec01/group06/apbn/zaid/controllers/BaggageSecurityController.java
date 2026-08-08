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

public class BaggageSecurityController {

    private final BaggageScannerService baggageScannerService = new BaggageScannerService();

    @FXML
    private TextField baggageIdField;

    @FXML
    private ComboBox<String> detectedItemComboBox;

    @FXML
    private ComboBox<String> securityStatusComboBox;

    @FXML
    private TextField trackingIdField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button detectButton;

    @FXML
    private Button rejectButton;

    @FXML
    private Button trackButton;
    @FXML
    private Button backButton;

    @FXML
    public void initialize() {

        detectedItemComboBox.getItems().addAll(
                "None",
                "Knife",
                "Gun",
                "Liquid",
                "Battery"
        );
        detectedItemComboBox.setValue("None");

        securityStatusComboBox.getItems().addAll(
                "Safe",
                "Suspicious",
                "Dangerous"
        );
        securityStatusComboBox.setValue("Safe");

        statusLabel.setText("Status: Ready...");
    }

    @FXML
    public void detectButton(ActionEvent event) {

        String baggageId = baggageIdField.getText().trim();

        if (baggageScannerService.detectDangerousItem(baggageId)) {

            detectedItemComboBox.setValue("None");
            securityStatusComboBox.setValue("Safe");

            statusLabel.setText("No prohibited items detected.");

        } else {

            statusLabel.setText("Please enter a Baggage ID.");

        }
    }

    @FXML
    public void rejectButton(ActionEvent event) {

        String baggageId = baggageIdField.getText().trim();

        if (baggageScannerService.rejectDangerousBaggage(baggageId)) {

            securityStatusComboBox.setValue("Dangerous");

            statusLabel.setText("Dangerous baggage rejected.");

        } else {

            statusLabel.setText("Please enter a Baggage ID.");

        }
    }

    @FXML
    public void trackButton(ActionEvent event) {

        String trackingId = trackingIdField.getText().trim();

        if (baggageScannerService.trackSuspiciousBaggage(trackingId)) {

            statusLabel.setText("Tracking baggage: " + trackingId);

        } else {

            statusLabel.setText("Please enter a Tracking ID.");

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