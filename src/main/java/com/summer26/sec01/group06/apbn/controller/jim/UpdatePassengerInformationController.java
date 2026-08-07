package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UpdatePassengerInformationController {

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
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnBack;

    @FXML
    private void searchPassenger() {

        String passengerId = txtPassengerId.getText().trim();

        if (passengerId.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
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
                        data[0].trim().equalsIgnoreCase(passengerId)) {

                    txtName.setText(data[1]);
                    txtPassport.setText(data[2]);
                    txtNationality.setText(data[3]);
                    txtFlightNo.setText(data[4]);
                    txtGate.setText(data[5]);

                    found = true;
                    break;
                }
            }

            if (!found) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not Found");
                alert.setHeaderText(null);
                alert.setContentText("Passenger Not Found.");
                alert.showAndWait();
            }

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to read passengers.txt");
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
    }
    @FXML
    private void updateInformation() {

        if (txtPassengerId.getText().isEmpty()
                || txtName.getText().isEmpty()
                || txtPassport.getText().isEmpty()
                || txtNationality.getText().isEmpty()
                || txtFlightNo.getText().isEmpty()
                || txtGate.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }

        java.util.ArrayList<String> records = new java.util.ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].trim().equalsIgnoreCase(txtPassengerId.getText().trim())) {

                    line = txtPassengerId.getText().trim() + ","
                            + txtName.getText().trim() + ","
                            + txtPassport.getText().trim() + ","
                            + txtNationality.getText().trim() + ","
                            + txtFlightNo.getText().trim() + ","
                            + txtGate.getText().trim();
                }

                records.add(line);
            }

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to read passenger file.");
            alert.showAndWait();
            return;
        }

        try (java.io.BufferedWriter writer =
                     new java.io.BufferedWriter(
                             new java.io.FileWriter("data/passengers.txt"))) {

            for (String record : records) {

                writer.write(record);
                writer.newLine();

            }

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to update passenger.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Passenger information updated successfully.");
        alert.showAndWait();
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