package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SecurityClearanceStatusController {

    @FXML
    private Label lblStatus;

    @FXML
    public void initialize() {

        // Demo Status
        lblStatus.setText("Security Clearance: APPROVED");
    }

    @FXML
    private void refreshStatus() {

        lblStatus.setText("Security Clearance: APPROVED");
    }

    @FXML
    private void back() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/jim/passenger-dashboard.fxml"));

        Stage stage = (Stage) lblStatus.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }
}