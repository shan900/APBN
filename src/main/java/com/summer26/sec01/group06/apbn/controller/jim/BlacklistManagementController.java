package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class BlacklistManagementController {

    @FXML
    private TextField txtPassengerId;

    @FXML
    private TextField txtPassengerName;

    @FXML
    private TextField txtReason;

    @FXML
    private ListView<String> listBlacklist;

    private final String PASSENGER_FILE = "data/passengers.txt";
    private final String BLACKLIST_FILE = "data/blacklist.txt";

    @FXML
    public void initialize() {

        loadBlacklist();
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
                     new BufferedReader(new FileReader(PASSENGER_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 2 &&
                        data[0].trim().equalsIgnoreCase(id)) {

                    txtPassengerName.setText(data[1]);
                    found = true;
                    break;
                }
            }

            if (!found) {

                new Alert(Alert.AlertType.INFORMATION,
                        "Passenger Not Found.").showAndWait();
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read passengers file.").showAndWait();
        }
    }

    @FXML
    private void addBlacklist() {

        if (txtPassengerId.getText().isEmpty()
                || txtPassengerName.getText().isEmpty()
                || txtReason.getText().isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please fill all fields.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(BLACKLIST_FILE, true))) {

            writer.write(
                    txtPassengerId.getText() + ","
                            + txtPassengerName.getText() + ","
                            + txtReason.getText());

            writer.newLine();

            new Alert(Alert.AlertType.INFORMATION,
                    "Passenger added to Blacklist.").showAndWait();

            loadBlacklist();
            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to save blacklist data.").showAndWait();
        }
    }
    @FXML
    private void removeBlacklist() {

        ArrayList<String> records = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(BLACKLIST_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 3 &&
                        data[0].trim().equalsIgnoreCase(txtPassengerId.getText().trim())) {

                    found = true;
                    continue;
                }

                records.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read blacklist file.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Passenger not found in blacklist.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(BLACKLIST_FILE))) {

            for (String record : records) {

                writer.write(record);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Passenger removed from blacklist successfully.").showAndWait();

            loadBlacklist();
            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update blacklist file.").showAndWait();
        }
    }

    @FXML
    private void loadBlacklist() {

        listBlacklist.getItems().clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(BLACKLIST_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                listBlacklist.getItems().add(line);
            }

        } catch (IOException e) {

            // File না থাকলেও app চলবে
        }
    }

    @FXML
    private void clearData() {

        txtPassengerId.clear();
        txtPassengerName.clear();
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