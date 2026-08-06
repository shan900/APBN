package com.summer26.sec01.group06.apbn.controller.shan;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReportController {

    @FXML
    private Label lblPassengers;

    @FXML
    private Label lblFlights;

    @FXML
    private Label lblOfficers;

    @FXML
    public void initialize() {

        lblPassengers.setText(String.valueOf(countPassengers()));

        // Dummy values
        lblFlights.setText("5");
        lblOfficers.setText("2");
    }

    private int countPassengers() {

        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("passengers.txt"))) {

            while (reader.readLine() != null) {
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/supervisor-dashboard.fxml"));

        Stage stage = (Stage) lblPassengers.getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}