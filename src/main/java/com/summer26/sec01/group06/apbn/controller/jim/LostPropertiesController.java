package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LostPropertiesController {

    @FXML
    private ListView<String> listLostProperties;

    @FXML
    private TextField txtPassengerId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextArea txtDescription;

    private final String FILE_NAME = "data/lostProperties.txt";

    @FXML
    public void initialize() {

        loadLostProperties();
    }

    @FXML
    private void loadLostProperties() {

        listLostProperties.getItems().clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                listLostProperties.getItems().add(line);
            }

        } catch (IOException e) {

            // যদি file না থাকে তাহলে List খালি থাকবে
        }
    }

    @FXML
    private void markAsFound() {

        if (txtPassengerId.getText().trim().isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter Passenger ID.")
                    .showAndWait();
            return;
        }

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
                            + data[2] + ",Found";

                    txtItemName.setText(data[1]);
                    txtDescription.setText(data[2]);

                    found = true;
                }

                reports.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read lost property file.")
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
                    "Property marked as Found.")
                    .showAndWait();

            loadLostProperties();

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
                    "Unable to read lost property file.")
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

            loadLostProperties();
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
        txtItemName.clear();
        txtDescription.clear();

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