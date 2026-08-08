package com.summer26.sec01.group06.apbn.zaid.controllers;

import com.summer26.sec01.group06.apbn.zaid.services.ImmigrationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PassengerVerificationController {

    private final ImmigrationService immigrationService = new ImmigrationService();

    @FXML
    private TextField passportNumberField;

    @FXML
    private TextField passengerNameField;

    @FXML
    private TextField nationalityField;

    @FXML
    private ComboBox<String> visaStatusComboBox;

    @FXML
    private ComboBox<String> blacklistStatusComboBox;

    @FXML
    private Button fetchButton;

    @FXML
    private Button verifyButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button backButton;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        visaStatusComboBox.getItems().addAll(
                "Valid",
                "Expired",
                "Pending"
        );

        blacklistStatusComboBox.getItems().addAll(
                "Clear",
                "Flagged"
        );

        visaStatusComboBox.setValue("Valid");
        blacklistStatusComboBox.setValue("Clear");

        statusLabel.setText("Ready...");
    }

    @FXML
    public void fetchPassenger(ActionEvent event) {

        String passport = passportNumberField.getText().trim();

        if (passport.isEmpty()) {
            statusLabel.setText("Enter Passport Number.");
            return;
        }

        if (immigrationService.fetchPassenger(passport)) {

            passengerNameField.setText("Zaid Khan");
            nationalityField.setText("Bangladesh");
            visaStatusComboBox.setValue("Valid");
            blacklistStatusComboBox.setValue("Clear");

            statusLabel.setText("Passenger information loaded.");

        } else {

            statusLabel.setText("Passenger not found.");

        }

    }

    @FXML
    public void verifyPassenger(ActionEvent event) {

        String passport = passportNumberField.getText().trim();

        if (immigrationService.verifyPassenger(passport)) {

            statusLabel.setText("Passenger Cleared.");

        } else {

            statusLabel.setText("Verification Failed.");

        }

    }

    @FXML
    public void saveVerification(ActionEvent event) {

        if (immigrationService.saveVerification()) {

            statusLabel.setText("Verification log saved.");

        } else {

            statusLabel.setText("Save failed.");

        }

    }

    @FXML
    public void clearFields(ActionEvent event) {

        passportNumberField.clear();
        passengerNameField.clear();
        nationalityField.clear();

        visaStatusComboBox.setValue("Valid");
        blacklistStatusComboBox.setValue("Clear");

        statusLabel.setText("Ready...");

    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) backButton.getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.show();

    }

}