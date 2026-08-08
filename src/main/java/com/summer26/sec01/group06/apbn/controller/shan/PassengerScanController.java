package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
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
    private Label lblResult;

    @FXML
    private Button btnBack;

    @FXML
    private void scanPassenger() {

        if (txtPassengerId.getText().trim().isEmpty()
                || txtName.getText().trim().isEmpty()
                || txtPassport.getText().trim().isEmpty()
                || txtNationality.getText().trim().isEmpty()
                || txtFlightNo.getText().trim().isEmpty()
                || txtGate.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 6
                        && data[0].trim().equalsIgnoreCase(txtPassengerId.getText().trim())
                        && data[1].trim().equalsIgnoreCase(txtName.getText().trim())
                        && data[2].trim().equalsIgnoreCase(txtPassport.getText().trim())
                        && data[3].trim().equalsIgnoreCase(txtNationality.getText().trim())
                        && data[4].trim().equalsIgnoreCase(txtFlightNo.getText().trim())
                        && data[5].trim().equalsIgnoreCase(txtGate.getText().trim())) {

                    found = true;
                    break;
                }
            }

            if (found) {

                lblResult.setStyle("-fx-text-fill: green; -fx-font-size:18px; -fx-font-weight:bold;");
                lblResult.setText("✅ Passenger Scan Successful");

            } else {

                lblResult.setStyle("-fx-text-fill: red; -fx-font-size:18px; -fx-font-weight:bold;");
                lblResult.setText("❌ Passenger Not Scanned");
            }

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to read passenger data.");
            alert.showAndWait();
        }
    }
    @FXML
    private void clearFields() {

        txtPassengerId.clear();
        txtName.clear();
        txtPassport.clear();
        txtNationality.clear();
        txtFlightNo.clear();
        txtGate.clear();

        lblResult.setText("");

        txtPassengerId.requestFocus();
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/fxml/jim/passenger-dashboard.fxml"));

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }

}