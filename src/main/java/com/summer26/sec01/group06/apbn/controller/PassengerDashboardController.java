package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class PassengerDashboardController {

    @FXML
    private Button btnScan, btnRequest, btnLostProperty, btnStatus,
            btnUpdate, btnDeclare, btnSupport, btnNotification, btnLogout;

    private void openPage(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/" + fxml));

        Stage stage = (Stage) btnScan.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void passengerScan() throws IOException {
        openPage("passenger-scan.fxml");
    }

    @FXML
    private void requestSecurityAssistance() throws IOException {
        openPage("request-security-assistance.fxml");
    }

    @FXML
    private void reportLostProperty() throws IOException {
        openPage("report-lost-property.fxml");
    }

    @FXML
    private void securityClearanceStatus() throws IOException {
        openPage("security-clearance-status.fxml");
    }

    @FXML
    private void updatePassengerInformation() throws IOException {
        openPage("update-passenger-information.fxml");
    }

    @FXML
    private void declareRestrictedItem() throws IOException {
        openPage("declare-restricted-item.fxml");
    }

    @FXML
    private void specialSecuritySupport() throws IOException {
        openPage("special-security-support.fxml");
    }

    @FXML
    private void emergencyNotifications() throws IOException {
        openPage("emergency-notifications.fxml");
    }

    @FXML
    private void logout() throws IOException {
        openPage("login.fxml");
    }
}