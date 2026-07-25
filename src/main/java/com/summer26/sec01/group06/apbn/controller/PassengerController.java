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

public class PassengerController {

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
    private Button btnScan;

    @FXML
    private Button btnBack;

    @FXML
    public void initialize() {

        cmbGender.getItems().addAll(
                "Male",
                "Female",
                "Other"
        );
    }

    @FXML
    private void scanPassenger() {

        System.out.println("Scan Button Clicked");

        if (txtPassengerId.getText().trim().isEmpty()
                || txtName.getText().trim().isEmpty()
                || txtPassport.getText().trim().isEmpty()
                || txtNationality.getText().trim().isEmpty()
                || txtFlightNo.getText().trim().isEmpty()
                || txtGate.getText().trim().isEmpty()
                || cmbGender.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all passenger information.");
            alert.showAndWait();
            return;
        }

        try {

            Passenger passenger = new Passenger(

                    txtPassengerId.getText().trim(),
                    txtName.getText().trim(),
                    txtPassport.getText().trim(),
                    txtNationality.getText().trim(),
                    txtFlightNo.getText().trim(),
                    txtGate.getText().trim()

            );

            PassengerFileHandler.savePassenger(passenger);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Passenger scanned and saved successfully.");

            alert.showAndWait();

            clearFields();

        } catch (Exception e) {

            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    private void clearFields() {

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
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/fxml/officer-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Officer Dashboard");
        stage.show();
    }
}