package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BaggageScannerController {

    @FXML
    private StackPane informationCard;

    @FXML
    private StackPane securityCard;

    @FXML
    private StackPane reportsCard;

    @FXML
    private StackPane machineStatusCard;


    @FXML
    public void initialize() {
        System.out.println("Baggage Scanner Dashboard Loaded");
    }


    // =========================================================
    // CARD 1 - Baggage Information
    // =========================================================

    @FXML
    private void openInformation(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/baggage-information.fxml"
        ));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Baggage Information");
        stage.show();
    }


    // =========================================================
    // CARD 2 - Baggage Security
    // =========================================================

    @FXML
    private void openSecurity(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/baggage-security.fxml"
        ));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Baggage Security");
        stage.show();
    }


    // =========================================================
    // CARD 3 - Baggage Reports
    // =========================================================

    @FXML
    private void openReports(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/baggage-reports.fxml"
        ));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Baggage Inspection Reports");
        stage.show();
    }


    // =========================================================
    // CARD 4 - GOAL 6
    // Monitor Scanning Machine Status
    // =========================================================

    @FXML
    private void openMachineStatus(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/scanner-machine-status.fxml"
        ));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Scanner Machine Status");
        stage.show();
    }


    // =========================================================
    // LOGOUT
    // =========================================================

    @FXML
    private void logout(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/fxml/login.fxml"
                )
        );

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("APBN Login");
        stage.show();
    }
}