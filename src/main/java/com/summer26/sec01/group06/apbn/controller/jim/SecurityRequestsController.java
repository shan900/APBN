package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class SecurityRequestsController {

    @FXML
    private ListView<String> listRequests;

    @FXML
    private TextField txtPassengerId;

    @FXML
    private TextArea txtProblem;

    private final String FILE_NAME = "data/securityRequests.txt";

    @FXML
    public void initialize() {

        loadRequests();
    }

    @FXML
    private void loadRequests() {

        listRequests.getItems().clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                listRequests.getItems().add(line);
            }

        } catch (IOException e) {

            // File না থাকলে List খালি থাকবে
        }
    }

    @FXML
    private void assignTeam() {

        if (txtPassengerId.getText().isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter Passenger ID.").showAndWait();
            return;
        }

        ArrayList<String> requests = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 3 &&
                        data[0].trim().equalsIgnoreCase(txtPassengerId.getText().trim())) {

                    line = data[0] + "," + data[1] + ",Assigned";
                    txtProblem.setText(data[1]);

                    found = true;
                }

                requests.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read security requests.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Request Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String request : requests) {

                writer.write(request);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Security Team Assigned Successfully.")
                    .showAndWait();

            loadRequests();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update request.")
                    .showAndWait();
        }
    }
    @FXML
    private void completeRequest() {

        ArrayList<String> requests = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 3 &&
                        data[0].trim().equalsIgnoreCase(txtPassengerId.getText().trim())) {

                    line = data[0] + "," + data[1] + ",Completed";
                    found = true;
                }

                requests.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read security requests.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Request Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String request : requests) {

                writer.write(request);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Request marked as Completed.")
                    .showAndWait();

            loadRequests();
            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update request.")
                    .showAndWait();
        }
    }

    @FXML
    private void deleteRequest() {

        ArrayList<String> requests = new ArrayList<>();

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

                requests.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read security requests.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "Request Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String request : requests) {

                writer.write(request);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Request Deleted Successfully.")
                    .showAndWait();

            loadRequests();
            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to delete request.")
                    .showAndWait();
        }
    }

    @FXML
    private void clearData() {

        txtPassengerId.clear();
        txtProblem.clear();
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