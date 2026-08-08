package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ImmigrationController {
    @javafx.fxml.FXML
    private Label dashboardLabel;
    @javafx.fxml.FXML
    private Button checkpointButton;
    @javafx.fxml.FXML
    private Button passengerVerificationButton;
    @javafx.fxml.FXML
    private Button travelHistoryButton;
    @javafx.fxml.FXML
    private Button flaggedPassengersButton;
    @javafx.fxml.FXML
    private Button rejectPassengerButton;
    @javafx.fxml.FXML
    private Button documentVerificationButton;
    @javafx.fxml.FXML
    private Button reportsButton;
    @javafx.fxml.FXML
    private Button approvalButton;

    // ==========================
    // Reusable Page Loader
    // ==========================

    private void loadPage(ActionEvent event, String fxmlFile) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/" + fxmlFile));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    // ==========================
    // Back Button
    // ==========================

    public void backButton(ActionEvent event) throws IOException {

        // Change this later when connected to your main dashboard
        loadPage(event, "login.fxml");

    }

    // ==========================
    // Goal 1
    // Passenger Verification
    // ==========================

    @javafx.fxml.FXML
    public void openPassengerVerification(ActionEvent event) throws IOException {

        loadPage(event, "passenger-verification.fxml");

    }

    // ==========================
    // Goal 2
    // Document Verification
    // ==========================

    public void openDocumentVerification(ActionEvent event) throws IOException {

        loadPage(event, "document-verification.fxml");

    }

    // ==========================
    // Goal 3
    // Approve Entry / Exit
    // ==========================

    @javafx.fxml.FXML
    public void openApproval(ActionEvent event) throws IOException {

        loadPage(event, "entry-exit-approval.fxml");

    }

    // ==========================
    // Goal 4
    // Reject Passenger
    // ==========================

    public void openRejectPassenger(ActionEvent event) throws IOException {

        loadPage(event, "reject-passenger.fxml");

    }

    // ==========================
    // Goal 5
    // Travel History
    // ==========================

    @javafx.fxml.FXML
    public void openTravelHistory(ActionEvent event) throws IOException {

        loadPage(event, "travel-history.fxml");

    }

    // ==========================
    // Goal 6
    // Immigration Reports
    // ==========================

    @javafx.fxml.FXML
    public void openReports(ActionEvent event) throws IOException {

        loadPage(event, "immigration-reports.fxml");

    }

    // ==========================
    // Goal 7
    // Flagged Passengers
    // ==========================

    @javafx.fxml.FXML
    public void openFlaggedPassengers(ActionEvent event) throws IOException {

        loadPage(event, "flagged-passengers.fxml");

    }

    // ==========================
    // Goal 8
    // Checkpoint Management
    // ==========================

    @javafx.fxml.FXML
    public void openCheckpointManagement(ActionEvent event) throws IOException {

        loadPage(event, "checkpoint-management.fxml");

    }
    // ==========================
    // Logout
    // ==========================

    @FXML
    public void logout(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/fxml/login.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("APBN Airport Security System");
        stage.show();
    }



}