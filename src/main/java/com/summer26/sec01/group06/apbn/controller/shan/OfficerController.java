package com.summer26.sec01.group06.apbn.controller.shan;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    private void openPassengerScan() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/passenger.fxml"));

            Stage stage = (Stage) btnScanPassenger.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Passenger Scan");
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    // ===========================
    // Verify Passport
    // ===========================
    @FXML
    private void verifyPassport() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/officer-verify-passport.fxml"));

            Stage stage = (Stage) btnVerifyPassport.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Verify Passport");
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("FXML Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    // ===========================
    // Search Passenger
    // ===========================
    @FXML
    private void searchPassenger() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/search-passenger.fxml"));

            Stage stage = (Stage) btnSearchPassenger.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Search Passenger");
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ===========================
    // Flight Schedule
    // ===========================
    @FXML
    private void viewFlights() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/flight-schedule.fxml"));

            Stage stage = (Stage) btnFlightSchedule.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Flight Schedule");
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ===========================
    // Logout
    // ===========================
    @FXML
    private void logout() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/login.fxml"));

            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Login");
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}