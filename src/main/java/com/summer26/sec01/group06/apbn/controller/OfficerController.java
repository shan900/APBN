package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OfficerController {

    @FXML
    private Button btnScanPassenger;

    @FXML
    private Button btnVerifyPassport;

    @FXML
    private Button btnSearchPassenger;

    @FXML
    private Button btnFlightSchedule;

    @FXML
    private Button btnLogout;

    // ===========================
    // Scan Passenger
    // ===========================
    @FXML
    private void openPassengerScan() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/passenger-scan.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnScanPassenger.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Passenger Scan");
        stage.show();
    }

    // ===========================
    // Verify Passport
    // ===========================
    @FXML
    private void verifyPassport() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/verify-passport.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnVerifyPassport.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Verify Passport");
        stage.show();
    }

    // ===========================
    // Search Passenger
    // ===========================
    @FXML
    private void searchPassenger() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/search-passenger.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnSearchPassenger.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Search Passenger");
        stage.show();
    }

    // ===========================
    // View Flight Schedule
    // ===========================
    @FXML
    private void viewFlights() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/flight-schedule.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnFlightSchedule.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Flight Schedule");
        stage.show();
    }

    // ===========================
    // Logout
    // ===========================
    @FXML
    private void logout() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/login.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
}