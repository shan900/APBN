package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ManageOfficersController {

    @FXML
    private TextField txtOfficerId;

    @FXML
    private TextField txtOfficerName;

    @FXML
    private TextField txtDepartment;

    @FXML
    private ComboBox<String> cmbShift;

    @FXML
    private ComboBox<String> cmbStatus;

    @FXML
    private Button btnBack;

    private final String FILE_NAME = "data/officers.txt";

    @FXML
    public void initialize() {

        cmbShift.setItems(FXCollections.observableArrayList(
                "Morning",
                "Evening",
                "Night"
        ));

        cmbStatus.setItems(FXCollections.observableArrayList(
                "Active",
                "Inactive",
                "On Leave"
        ));
    }

    @FXML
    private void searchOfficer() {

        String officerId = txtOfficerId.getText().trim();

        if (officerId.isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter Officer ID.").showAndWait();
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            boolean found = false;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5 &&
                        data[0].trim().equalsIgnoreCase(officerId)) {

                    txtOfficerName.setText(data[1]);
                    txtDepartment.setText(data[2]);
                    cmbShift.setValue(data[3]);
                    cmbStatus.setValue(data[4]);

                    found = true;
                    break;
                }
            }

            if (!found) {

                new Alert(Alert.AlertType.INFORMATION,
                        "Officer Not Found.").showAndWait();
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read officers file.").showAndWait();
        }
    }

    @FXML
    private void addOfficer() {

        if (txtOfficerId.getText().isEmpty()
                || txtOfficerName.getText().isEmpty()
                || txtDepartment.getText().isEmpty()
                || cmbShift.getValue() == null
                || cmbStatus.getValue() == null) {

            new Alert(Alert.AlertType.WARNING,
                    "Please fill all fields.").showAndWait();

            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(
                    txtOfficerId.getText() + "," +
                            txtOfficerName.getText() + "," +
                            txtDepartment.getText() + "," +
                            cmbShift.getValue() + "," +
                            cmbStatus.getValue());

            writer.newLine();

            new Alert(Alert.AlertType.INFORMATION,
                    "Officer Added Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to save officer.").showAndWait();
        }
    }
    @FXML
    private void updateOfficer() {

        ArrayList<String> officers = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5 &&
                        data[0].trim().equalsIgnoreCase(txtOfficerId.getText().trim())) {

                    line = txtOfficerId.getText().trim() + ","
                            + txtOfficerName.getText().trim() + ","
                            + txtDepartment.getText().trim() + ","
                            + cmbShift.getValue() + ","
                            + cmbStatus.getValue();

                    found = true;
                }

                officers.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read officers file.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Officer Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String officer : officers) {

                writer.write(officer);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Officer Updated Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update officer.").showAndWait();
        }
    }

    @FXML
    private void deleteOfficer() {

        ArrayList<String> officers = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5 &&
                        data[0].trim().equalsIgnoreCase(txtOfficerId.getText().trim())) {

                    found = true;
                    continue;
                }

                officers.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read officers file.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Officer Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String officer : officers) {

                writer.write(officer);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Officer Deleted Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to delete officer.").showAndWait();
        }
    }

    @FXML
    private void clearData() {

        txtOfficerId.clear();
        txtOfficerName.clear();
        txtDepartment.clear();

        cmbShift.getSelectionModel().clearSelection();
        cmbStatus.getSelectionModel().clearSelection();

        txtOfficerId.requestFocus();
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