package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EmergencyNotificationsController {

    @FXML
    private Label lblNotification;

    @FXML
    public void initialize() {

        lblNotification.setText(
                "• Flight Delay Notice\n\n" +
                        "• Security Alert\n\n" +
                        "• Boarding Gate Change\n\n" +
                        "• Emergency Exit Information"
        );
    }

    @FXML
    private void refreshNotifications() {

        lblNotification.setText(
                "• Flight Delay Notice\n\n" +
                        "• Security Alert\n\n" +
                        "• Boarding Gate Change\n\n" +
                        "• Emergency Exit Information"
        );
    }

    @FXML
    private void back() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/passenger-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) lblNotification.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }
}