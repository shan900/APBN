package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RequestSecurityAssistanceController {

    @FXML
    private TextField txtPassengerId;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private ComboBox<String> cmbPriority;

    @FXML
    private TextArea txtDescription;

    @FXML
    private Button btnBack;

    @FXML
    public void initialize() {

        cmbType.setItems(FXCollections.observableArrayList(
                "Medical Emergency",
                "Suspicious Activity",
                "Lost Child",
                "Lost Property",
                "Security Escort",
                "Other"
        ));

        cmbPriority.setItems(FXCollections.observableArrayList(
                "High",
                "Medium",
                "Low"
        ));
    }

    @FXML
    private void searchPassenger() {

        String id = txtPassengerId.getText().trim();

        if (id.isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter Passenger ID.").showAndWait();
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

            new Alert(Alert.AlertType.INFORMATION,
                    "Passenger Found.").showAndWait();

        } else {

            new Alert(Alert.AlertType.ERROR,
                    "Passenger Not Found.").showAndWait();
        }
    }

    @FXML
    private void clearFields() {

        txtPassengerId.clear();
        cmbType.getSelectionModel().clearSelection();
        cmbPriority.getSelectionModel().clearSelection();
        txtDescription.clear();

        txtPassengerId.requestFocus();
    }
    @FXML
    private void submitRequest() {

        if (txtPassengerId.getText().trim().isEmpty()
                || cmbType.getValue() == null
                || cmbPriority.getValue() == null
                || txtDescription.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }

        try (java.io.BufferedWriter writer =
                     new java.io.BufferedWriter(
                             new java.io.FileWriter("data/securityRequests.txt", true))) {

            writer.write(
                    txtPassengerId.getText().trim() + "," +
                            cmbType.getValue() + "," +
                            cmbPriority.getValue() + "," +
                            txtDescription.getText().trim()
            );

            writer.newLine();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Security Assistance Request Submitted Successfully.");
            alert.showAndWait();

            clearFields();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to save request.");
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