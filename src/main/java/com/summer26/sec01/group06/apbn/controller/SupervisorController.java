package com.summer26.sec01.group06.apbn.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class SupervisorController {

    private void openWindow(ActionEvent event, String fxmlFile) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void viewPassengers(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/view-passengers.fxml");

    }

    public void viewFlightSchedule(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/supervisor-flight-schedule.fxml");

    }

    public void viewOfficers(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/view-officers.fxml");

    }

    public void generateReport(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/report.fxml");

    }

    public void logout(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/login.fxml");

    }
}