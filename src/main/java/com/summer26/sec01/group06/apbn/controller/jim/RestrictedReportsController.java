package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class RestrictedReportsController {

    @FXML
    private ListView<String> listReports;

    @FXML
    private TextField txtPassengerId;

    @FXML
    private TextField txtItem;

    @FXML
    private TextArea txtReason;

    private final String FILE_NAME = "data/reports.txt";

    @FXML
    public void initialize() {

        loadReports();
    }

    @FXML
    private void loadReports() {

        listReports.getItems().clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                listReports.getItems().add(line);
            }

        } catch (IOException e) {

            // File না থাকলেও Program চলবে
        }
    }

    @FXML
    private void searchReport() {

        if (txtPassengerId.getText().trim().isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter Passenger ID.")
                    .showAndWait();
            return;
        }

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4 &&
                        data[0].trim().equalsIgnoreCase(
                                txtPassengerId.getText().trim())) {

                    txtItem.setText(data[1]);
                    txtReason.setText(data[2]);

                    found = true;
                    break;
                }
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read reports.")
                    .showAndWait();

            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Report Not Found.")
                    .showAndWait();
        }
    }

    @FXML
    private void investigateReport() {

        ArrayList<String> reports = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4 &&
                        data[0].trim().equalsIgnoreCase(
                                txtPassengerId.getText().trim())) {

                    line = data[0] + ","
                            + data[1] + ","
                            + data[2] + ",Investigating";

                    txtItem.setText(data[1]);
                    txtReason.setText(data[2]);

                    found = true;
                }

                reports.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read reports.")
                    .showAndWait();

            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Report Not Found.")
                    .showAndWait();

            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String report : reports) {

                writer.write(report);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Investigation Started Successfully.")
                    .showAndWait();

            loadReports();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update report.")
                    .showAndWait();
        }
    }
    @FXML
    private void deleteReport() {

        ArrayList<String> reports = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4 &&
                        data[0].trim().equalsIgnoreCase(
                                txtPassengerId.getText().trim())) {

                    found = true;
                    continue;
                }

                reports.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read reports.")
                    .showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Report Not Found.")
                    .showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String report : reports) {

                writer.write(report);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Report Deleted Successfully.")
                    .showAndWait();

            loadReports();
            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to delete report.")
                    .showAndWait();
        }
    }

    @FXML
    private void clearData() {

        txtPassengerId.clear();
        txtItem.clear();
        txtReason.clear();

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