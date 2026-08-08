package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ManageFlightsController {

    @FXML
    private TextField txtFlightNo;

    @FXML
    private TextField txtDestination;

    @FXML
    private TextField txtDepartureTime;

    @FXML
    private TextField txtGate;

    @FXML
    private ComboBox<String> cmbStatus;

    @FXML
    private Button btnBack;

    private final String FILE_NAME = "data/flights.txt";

    @FXML
    public void initialize() {

        cmbStatus.setItems(FXCollections.observableArrayList(
                "On Time",
                "Delayed",
                "Boarding",
                "Cancelled"
        ));
    }

    @FXML
    private void searchFlight() {

        String flightNo = txtFlightNo.getText().trim();

        if (flightNo.isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter Flight Number.").showAndWait();
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            boolean found = false;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5 &&
                        data[0].trim().equalsIgnoreCase(flightNo)) {

                    txtDestination.setText(data[1]);
                    txtDepartureTime.setText(data[2]);
                    txtGate.setText(data[3]);
                    cmbStatus.setValue(data[4]);

                    found = true;
                    break;
                }
            }

            if (!found) {

                new Alert(Alert.AlertType.INFORMATION,
                        "Flight Not Found.").showAndWait();
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read flights file.").showAndWait();
        }
    }

    @FXML
    private void addFlight() {

        if (txtFlightNo.getText().isEmpty()
                || txtDestination.getText().isEmpty()
                || txtDepartureTime.getText().isEmpty()
                || txtGate.getText().isEmpty()
                || cmbStatus.getValue() == null) {

            new Alert(Alert.AlertType.WARNING,
                    "Please fill all fields.").showAndWait();

            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(
                    txtFlightNo.getText() + "," +
                            txtDestination.getText() + "," +
                            txtDepartureTime.getText() + "," +
                            txtGate.getText() + "," +
                            cmbStatus.getValue());

            writer.newLine();

            new Alert(Alert.AlertType.INFORMATION,
                    "Flight Added Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to save flight.").showAndWait();
        }
    }
    @FXML
    private void updateFlight() {

        ArrayList<String> flights = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5 &&
                        data[0].trim().equalsIgnoreCase(txtFlightNo.getText().trim())) {

                    line = txtFlightNo.getText().trim() + ","
                            + txtDestination.getText().trim() + ","
                            + txtDepartureTime.getText().trim() + ","
                            + txtGate.getText().trim() + ","
                            + cmbStatus.getValue();

                    found = true;
                }

                flights.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read flights file.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Flight Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String flight : flights) {

                writer.write(flight);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Flight Updated Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update flight.").showAndWait();
        }
    }

    @FXML
    private void deleteFlight() {

        ArrayList<String> flights = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5 &&
                        data[0].trim().equalsIgnoreCase(txtFlightNo.getText().trim())) {

                    found = true;
                    continue;
                }

                flights.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read flights file.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Flight Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String flight : flights) {

                writer.write(flight);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Flight Deleted Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to delete flight.").showAndWait();
        }
    }

    @FXML
    private void clearData() {

        txtFlightNo.clear();
        txtDestination.clear();
        txtDepartureTime.clear();
        txtGate.clear();

        cmbStatus.getSelectionModel().clearSelection();

        txtFlightNo.requestFocus();
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/fxml/jim/admin-dashboard.fxml"));

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

}