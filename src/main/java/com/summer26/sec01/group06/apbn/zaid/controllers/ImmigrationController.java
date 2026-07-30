package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.summer26.sec01.group06.apbn.zaid.models.Passenger;
import com.summer26.sec01.group06.apbn.zaid.services.ImmigrationService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class ImmigrationController {

    @FXML
    private TextField passengerNameField;

    @FXML
    private TextField passportField;

    @FXML
    private TextField searchPassportField;

    @FXML
    private ComboBox<String> visaStatusCombo;

    @FXML
    private Label statusLabel;

    private final ImmigrationService immigrationService = new ImmigrationService();
    @FXML
    private Button clearButton;
    @FXML
    private Button verifyButton;
    @FXML
    private Button approveButton;
    @FXML
    private Button rejectButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button saveButton;

    @FXML
    public void initialize() {

        visaStatusCombo.getItems().addAll(
                "Valid",
                "Expired",
                "Pending"
        );

        visaStatusCombo.setValue("Valid");

        statusLabel.setText("Ready...");
    }


    @FXML
    public void clearButton(ActionEvent actionEvent) {
        passengerNameField.clear();
        passportField.clear();
        visaStatusCombo.setValue("Valid");

        statusLabel.setText("Ready...");
    }

    @FXML
    public void verifyButton(ActionEvent actionEvent) {
        String name = passengerNameField.getText().trim();
        String passport = passportField.getText().trim();
        String visaStatus = visaStatusCombo.getValue();

        if (name.isEmpty() || passport.isEmpty()) {
            statusLabel.setText("Please enter passenger name and passport number.");
            return;
        }

        if ("Valid".equals(visaStatus)) {
            statusLabel.setText("Passenger Verified Successfully.");
        } else {
            statusLabel.setText("Verification Failed: Visa is " + visaStatus);
        }
    }

    @FXML
    public void rejectButton(ActionEvent actionEvent) {
        String name = passengerNameField.getText().trim();

        if (name.isEmpty()) {
            statusLabel.setText("No passenger selected.");
            return;
        }

        statusLabel.setText("Passenger Rejected.");

    }

    @FXML
    public void approveButton(ActionEvent actionEvent) {
        String name = passengerNameField.getText().trim();
        String passport = passportField.getText().trim();
        String visaStatus = visaStatusCombo.getValue();

        if (name.isEmpty() || passport.isEmpty()) {
            statusLabel.setText("Please verify passenger details first.");
            return;
        }

        if ("Valid".equals(visaStatus)) {
            statusLabel.setText("Passenger Approved for Departure.");
        } else {
            statusLabel.setText("Cannot approve. Passenger verification failed.");
        }
    }

    @FXML
    public void searchButton(ActionEvent actionEvent) {

        String passport = searchPassportField.getText().trim();

        if (passport.isEmpty()) {
            statusLabel.setText("Enter passport number.");
            return;
        }

        if (passport.equalsIgnoreCase("P12345")) {

            passengerNameField.setText("Zaid Khan");
            passportField.setText("P12345");
            visaStatusCombo.setValue("Valid");

            statusLabel.setText("Passenger Found.");

        } else {

            statusLabel.setText("Passenger Not Found.");

        }

    }

    @FXML
    public void saveButton(ActionEvent actionEvent) {

        Passenger passenger = new Passenger(
                passengerNameField.getText(),
                passportField.getText(),
                visaStatusCombo.getValue()
        );

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("data/passengers.bin")
                    );

            out.writeObject(passenger);

            out.close();

            statusLabel.setText("Passenger saved successfully.");

        } catch (IOException e) {

            statusLabel.setText("Error saving passenger.");

        }

    }
}