package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RejectPassengerController {

    @FXML
    private TextField passportNumberField;

    @FXML
    private TextField passengerNameField;

    @FXML
    private TextArea reasonArea;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        statusLabel.setText("Ready...");

    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private void rejectPassenger(ActionEvent event) {

        statusLabel.setText("Passenger Rejected.");

    }

    @FXML
    private void notifySecurity(ActionEvent event) {

        statusLabel.setText("Security Team Notified.");

    }

    @FXML
    private void blacklistPassenger(ActionEvent event) {

        statusLabel.setText("Passenger Added to Blacklist.");

    }

    @FXML
    private void generateReport(ActionEvent event) {

        statusLabel.setText("Rejection Report Generated.");

    }

}