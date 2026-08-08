package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryExitApprovalController {

    @FXML
    private TextField passportNumberField;

    @FXML
    private TextField passengerNameField;

    @FXML
    private ComboBox<String> travelPermissionComboBox;

    @FXML
    private ComboBox<String> clearanceStatusComboBox;

    @FXML
    private ComboBox<String> travelStatusComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        travelPermissionComboBox.getItems().addAll(
                "Allowed",
                "Restricted",
                "Denied"
        );

        clearanceStatusComboBox.getItems().addAll(
                "Cleared",
                "Pending",
                "Not Cleared"
        );

        travelStatusComboBox.getItems().addAll(
                "Entry",
                "Exit"
        );

        statusLabel.setText("Ready");
    }

    // ==========================
    // Back Button
    // ==========================

    @FXML
    private void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    // ==========================
    // Approve Passenger
    // ==========================

    @FXML
    private void approvePassenger(ActionEvent event) {

        statusLabel.setText("Passenger Approved Successfully");

    }

    // ==========================
    // Reject Passenger
    // ==========================

    @FXML
    private void rejectPassenger(ActionEvent event) {

        statusLabel.setText("Passenger Rejected");

    }

    // ==========================
    // Save
    // ==========================

    @FXML
    private void saveApproval(ActionEvent event) {

        statusLabel.setText("Approval Saved Successfully");

    }

    // ==========================
    // Clear
    // ==========================

    @FXML
    private void clearFields(ActionEvent event) {

        passportNumberField.clear();
        passengerNameField.clear();

        travelPermissionComboBox.getSelectionModel().clearSelection();
        clearanceStatusComboBox.getSelectionModel().clearSelection();
        travelStatusComboBox.getSelectionModel().clearSelection();

        statusLabel.setText("Form Cleared");
    }
}