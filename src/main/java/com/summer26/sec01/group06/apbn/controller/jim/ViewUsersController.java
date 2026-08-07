package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ViewUsersController {

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private Button btnBack;

    private final String FILE_NAME = "data/users.txt";

    @FXML
    public void initialize() {

        cmbRole.setItems(FXCollections.observableArrayList(
                "Admin",
                "Officer",
                "Supervisor",
                "Passenger"
        ));
    }

    @FXML
    private void searchUser() {

        String userId = txtUserId.getText().trim();

        if (userId.isEmpty()) {

            new Alert(Alert.AlertType.WARNING,
                    "Please enter User ID.").showAndWait();
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4 &&
                        data[0].trim().equalsIgnoreCase(userId)) {

                    txtUsername.setText(data[1]);
                    txtPassword.setText(data[2]);
                    cmbRole.setValue(data[3]);

                    found = true;
                    break;
                }
            }

            if (!found) {

                new Alert(Alert.AlertType.INFORMATION,
                        "User Not Found.").showAndWait();
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read users file.").showAndWait();
        }
    }

    @FXML
    private void addUser() {

        if (txtUserId.getText().isEmpty()
                || txtUsername.getText().isEmpty()
                || txtPassword.getText().isEmpty()
                || cmbRole.getValue() == null) {

            new Alert(Alert.AlertType.WARNING,
                    "Please fill all fields.").showAndWait();

            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(
                    txtUserId.getText() + ","
                            + txtUsername.getText() + ","
                            + txtPassword.getText() + ","
                            + cmbRole.getValue());

            writer.newLine();

            new Alert(Alert.AlertType.INFORMATION,
                    "User Added Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to save user.").showAndWait();
        }
    }
    @FXML
    private void updatePassword() {

        ArrayList<String> users = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4 &&
                        data[0].trim().equalsIgnoreCase(txtUserId.getText().trim())) {

                    line = txtUserId.getText().trim() + ","
                            + txtUsername.getText().trim() + ","
                            + txtPassword.getText().trim() + ","
                            + cmbRole.getValue();

                    found = true;
                }

                users.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read users file.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "User Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String user : users) {

                writer.write(user);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "Password Updated Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to update password.").showAndWait();
        }
    }

    @FXML
    private void deleteUser() {

        ArrayList<String> users = new ArrayList<>();

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4 &&
                        data[0].trim().equalsIgnoreCase(txtUserId.getText().trim())) {

                    found = true;
                    continue;
                }

                users.add(line);
            }

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to read users file.").showAndWait();
            return;
        }

        if (!found) {

            new Alert(Alert.AlertType.INFORMATION,
                    "User Not Found.").showAndWait();
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String user : users) {

                writer.write(user);
                writer.newLine();
            }

            new Alert(Alert.AlertType.INFORMATION,
                    "User Deleted Successfully.").showAndWait();

            clearData();

        } catch (IOException e) {

            new Alert(Alert.AlertType.ERROR,
                    "Unable to delete user.").showAndWait();
        }
    }

    @FXML
    private void clearData() {

        txtUserId.clear();
        txtUsername.clear();
        txtPassword.clear();

        cmbRole.getSelectionModel().clearSelection();

        txtUserId.requestFocus();
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