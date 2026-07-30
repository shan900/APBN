package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportLostPropertyController {

    @FXML
    private TextField txtItemName;

    @FXML
    private TextArea txtDescription;

    @FXML
    private void submitReport() {

        if (txtItemName.getText().trim().isEmpty() ||
                txtDescription.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Lost property report submitted successfully.");
        alert.showAndWait();

        txtItemName.clear();
        txtDescription.clear();
    }

    @FXML
    private void back() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/passenger-dashboard.fxml"));

        Stage stage = (Stage) txtItemName.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }
}