package com.summer26.sec01.group06.apbn.controller.shan;

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

    // View All Passenger
    public void viewPassengers(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/shan/supervisor-view-passenger.fxml");

    }

    // View Flight Schedule
    public void viewFlightSchedule(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/shan/supervisor-flight-schedule.fxml");

    }

    // View Officers
    public void viewOfficers(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/shan/view-officers.fxml");

    }

    // Generate Report
    public void generateReport(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/shan/report.fxml");

    }

    // Logout
    public void logout(ActionEvent event) throws IOException {

        openWindow(event,
                "/com/summer26/sec01/group06/apbn/fxml/login.fxml");

    }
}