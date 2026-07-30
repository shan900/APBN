package com.summer26.sec01.group06.apbn.controller;

import com.summer26.sec01.group06.apbn.model.Passenger;
import com.summer26.sec01.group06.apbn.util.PassengerFileHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PassengerScanController {

    @FXML
    private TextField txtPassengerId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPassport;
    @FXML
    private TextField txtNationality;
    @FXML
    private TextField txtFlightNo;
    @FXML
    private TextField txtGate;
    @FXML
    private ComboBox<String> cmbGender;
    @FXML
    private Button btnBack;

    @FXML
    public void initialize() {

        System.out.println("PassengerScanController Loaded");

        cmbGender.getItems().addAll(
                "Male",
                "Female",
                "Other"
        );
    }

    @FXML
    private void scanPassenger() {

        if (txtPassengerId.getText().isEmpty()
                || txtName.getText().isEmpty()
                || txtPassport.getText().isEmpty()
                || txtNationality.getText().isEmpty()
                || txtFlightNo.getText().isEmpty()
                || txtGate.getText().isEmpty()
                || cmbGender.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }

        Passenger passenger = new Passenger(
                txtPassengerId.getText(),
                txtName.getText(),
                txtPassport.getText(),
                txtNationality.getText(),
                txtFlightNo.getText(),
                txtGate.getText()
        );

        PassengerFileHandler.savePassenger(passenger);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Passenger scanned successfully.");
        alert.showAndWait();

        txtPassengerId.clear();
        txtName.clear();
        txtPassport.clear();
        txtNationality.clear();
        txtFlightNo.clear();
        txtGate.clear();
        cmbGender.getSelectionModel().clearSelection();
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/passenger-dashboard.fxml"));

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }
}