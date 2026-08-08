package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class DocumentVerificationController {

    @FXML
    private Button backButton;

    @FXML
    private TextField passportNumberField;

    @FXML
    private TextField visaNumberField;

    @FXML
    private ComboBox<String> documentTypeComboBox;

    @FXML
    private ComboBox<String> expiryStatusComboBox;

    @FXML
    private ComboBox<String> authenticityComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        documentTypeComboBox.getItems().addAll(
                "Passport",
                "Visa",
                "Passport + Visa"
        );

        expiryStatusComboBox.getItems().addAll(
                "Valid",
                "Expired"
        );

        authenticityComboBox.getItems().addAll(
                "Original",
                "Fake",
                "Suspicious"
        );

        statusLabel.setText("Ready");
    }

    @FXML
    private void scanDocument(ActionEvent event) {

        statusLabel.setText("Document scanned successfully.");

    }

    @FXML
    private void verifyDocument(ActionEvent event) {

        statusLabel.setText("Document verified.");

    }

    @FXML
    private void clearFields(ActionEvent event) {

        passportNumberField.clear();
        visaNumberField.clear();

        documentTypeComboBox.getSelectionModel().clearSelection();
        expiryStatusComboBox.getSelectionModel().clearSelection();
        authenticityComboBox.getSelectionModel().clearSelection();

        statusLabel.setText("Fields cleared.");
    }

    @FXML
    private void saveVerification(ActionEvent event) {

        statusLabel.setText("Verification saved.");

    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}