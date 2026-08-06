package com.summer26.sec01.group06.apbn.controller.shan;

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

public class SearchPassengerController {

    @FXML
    private TextField txtPassengerId;

    @FXML
    private Label lblResult;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPassport;

    @FXML
    private Label lblNationality;

    @FXML
    private Label lblFlight;

    @FXML
    private Label lblGate;

    @FXML
    private Button btnBack;

    @FXML
    private void searchPassenger() {

        String passengerId = txtPassengerId.getText().trim();

        if (passengerId.isEmpty()) {
            lblResult.setText("Please enter Passenger ID.");
            clearLabels();
            return;
        }

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 6 && data[0].equalsIgnoreCase(passengerId)) {

                    lblResult.setText("Passenger Found");

                    lblName.setText(data[1]);
                    lblPassport.setText(data[2]);
                    lblNationality.setText(data[3]);
                    lblFlight.setText(data[4]);
                    lblGate.setText(data[5]);

                    found = true;
                    break;
                }
            }

            if (!found) {

                lblResult.setText("Passenger Not Found");
                clearLabels();

            }

        } catch (IOException e) {

            lblResult.setText("Error reading passenger file.");
            e.printStackTrace();
        }
    }

    private void clearLabels() {

        lblName.setText("-");
        lblPassport.setText("-");
        lblNationality.setText("-");
        lblFlight.setText("-");
        lblGate.setText("-");
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/officer-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Officer Dashboard");
        stage.show();
    }
}