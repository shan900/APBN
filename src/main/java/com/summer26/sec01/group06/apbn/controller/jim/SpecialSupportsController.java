package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class SpecialSupportsController {

    @FXML
    private ListView<String> listSupports;

    @FXML
    private TextField txtPassengerId;

    @FXML
    private ComboBox<String> cmbSupportType;

    private final String FILE_NAME = "data/specialSupports.txt";

    @FXML
    public void initialize() {

        cmbSupportType.setItems(FXCollections.observableArrayList(
                "Medical",
                "Wheelchair",
                "Escort",
                "VIP Escort"
        ));

        loadSupports();
    }

    @FXML
    private void loadSupports() {

        listSupports.getItems().clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                listSupports.getItems().add(line);
            }

        } catch (IOException e) {

            // File না থাকলেও App চলবে
        }
    }

    @FXML
    private void sendMedicalTeam() {

        updateSupportStatus("Medical Team Assigned");
    }

    @FXML
    private void sendWheelchair() {

        updateSupportStatus("Wheelchair Team Assigned");
    }

    @FXML
    private void sendEscortTeam() {

        updateSupportStatus("Escort Team Assigned");
    }

    private void updateSupportStatus(String status) {

        if (txtPassengerId.getText().trim().isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter Passenger ID.")
                    .showAndWait();
            return;
        }

        ArrayList<String> supports = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 3 &&
                        data[0].trim().equalsIgnoreCase(txtPassengerId.getText().trim())) {

                    line = data[0] + "," + data[1] + "," + status;

                    cmbSupportType.setValue(data[1]);

                    found = true;
                }

                supports.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read support requests.")
                    .showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Support Request Not Found.")
                    .showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String support : supports) {

                writer.write(support);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    status)
                    .showAndWait();

            loadSupports();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update support request.")
                    .showAndWait();
        }
    }
    @FXML
    private void completeSupport() {

        updateSupportStatus("Completed");

        clearData();
    }

    @FXML
    private void deleteSupport() {

        ArrayList<String> supports = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 3 &&
                        data[0].trim().equalsIgnoreCase(txtPassengerId.getText().trim())) {

                    found = true;
                    continue;
                }

                supports.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read support requests.")
                    .showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Support Request Not Found.")
                    .showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String support : supports) {

                writer.write(support);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Support Request Deleted Successfully.")
                    .showAndWait();

            loadSupports();
            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to delete support request.")
                    .showAndWait();
        }
    }

    @FXML
    private void clearData() {

        txtPassengerId.clear();
        cmbSupportType.getSelectionModel().clearSelection();
        txtPassengerId.requestFocus();
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/fxml/jim/view-reports.fxml"));

        Stage stage = (Stage) txtPassengerId.getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("System Reports");
        stage.show();
    }

}