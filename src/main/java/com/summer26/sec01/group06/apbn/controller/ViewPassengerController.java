package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewPassengerController {

    @FXML
    private TextField txtPassengerId;

    @FXML
    private Label lblResult;

    @FXML
    private Button btnBack;

    @FXML
    private void searchPassenger() {

        String passengerId = txtPassengerId.getText().trim();

        if (passengerId.isEmpty()) {
            lblResult.setText("Please enter Passenger ID.");
            return;
        }

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 6 && data[0].equalsIgnoreCase(passengerId)) {

                    lblResult.setText(
                            "Passenger Information\n\n" +
                                    "Passenger ID : " + data[0] +
                                    "\nName : " + data[1] +
                                    "\nPassport : " + data[2] +
                                    "\nNationality : " + data[3] +
                                    "\nFlight : " + data[4] +
                                    "\nGate : " + data[5]);

                    found = true;
                    break;
                }
            }

            if (!found) {
                lblResult.setText("Passenger Not Found.");
            }

        } catch (IOException e) {

            lblResult.setText("Error reading passengers.txt");
            e.printStackTrace();
        }
    }

    @FXML
    private void clearData() {

        txtPassengerId.clear();
        lblResult.setText("");
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/immigration-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Immigration Dashboard");
        stage.show();
    }
}