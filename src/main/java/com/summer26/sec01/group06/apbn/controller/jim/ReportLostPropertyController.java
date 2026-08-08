package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReportLostPropertyController {

    @FXML
    private TextField txtPassengerId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtDate;

    @FXML
    private TextArea txtDescription;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnBack;

    @FXML
    private void searchPassenger() {

        String id = txtPassengerId.getText().trim();

        if (id.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter Passenger ID.");
            alert.showAndWait();
            return;
        }

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 6 &&
                        data[0].trim().equalsIgnoreCase(id)) {

                    found = true;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Passenger Found.");
            alert.showAndWait();

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Passenger Not Found.");
            alert.showAndWait();
        }

    }

    @FXML
    private void clearFields() {

        txtPassengerId.clear();
        txtItemName.clear();
        txtLocation.clear();
        txtDate.clear();
        txtDescription.clear();

        txtPassengerId.requestFocus();
    }
    @FXML
    private void submitReport() {

        if (txtPassengerId.getText().trim().isEmpty()
                || txtItemName.getText().trim().isEmpty()
                || txtLocation.getText().trim().isEmpty()
                || txtDate.getText().trim().isEmpty()
                || txtDescription.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/lostProperties.txt", true))) {

            writer.write(
                    txtPassengerId.getText().trim() + "," +
                            txtItemName.getText().trim() + "," +
                            txtLocation.getText().trim() + "," +
                            txtDate.getText().trim() + "," +
                            txtDescription.getText().trim()
            );

            writer.newLine();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Lost Property Report Submitted Successfully.");
            alert.showAndWait();

            clearFields();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to save report.");
            alert.showAndWait();

            e.printStackTrace();
        }
    }

    @FXML
    private void back() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/fxml/jim/passenger-dashboard.fxml"));

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }

}