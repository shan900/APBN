package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private void login() {

        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter Username and Password.");
            alert.showAndWait();
            return;
        }

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/users.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4
                        && data[1].trim().equalsIgnoreCase(username)
                        && data[2].trim().equals(password)) {

                    found = true;

                    String role = data[3].trim();

                    FXMLLoader loader = null;
                    String title = "";

                    switch (role) {

                        case "Admin":

                            loader = new FXMLLoader(
                                    getClass().getResource(
                                            "/com/summer26/sec01/group06/apbn/fxml/jim/admin-dashboard.fxml"));

                            title = "Admin Dashboard";
                            break;

                        case "Officer":

                            loader = new FXMLLoader(
                                    getClass().getResource(
                                            "/com/summer26/sec01/group06/apbn/fxml/shan/officer-dashboard.fxml"));

                            title = "Officer Dashboard";
                            break;

                        case "Supervisor":

                            loader = new FXMLLoader(
                                    getClass().getResource(
                                            "/com/summer26/sec01/group06/apbn/fxml/shan/supervisor-dashboard.fxml"));

                            title = "Supervisor Dashboard";
                            break;

                        case "Passenger":

                            loader = new FXMLLoader(
                                    getClass().getResource(
                                            "/com/summer26/sec01/group06/apbn/fxml/jim/passenger-dashboard.fxml"));

                            title = "Passenger Dashboard";
                            break;

                        case "Immigration Officer":

                            loader = new FXMLLoader(
                                    getClass().getResource(
                                            "/com/summer26/sec01/group06/apbn/fxml/shan/immigration-dashboard.fxml"));

                            title = "Immigration Dashboard";
                            break;

                        default:

                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Login Failed");
                            alert.setHeaderText(null);
                            alert.setContentText("Invalid User Role.");
                            alert.showAndWait();
                            return;
                    }

                    Stage stage = (Stage) txtUsername.getScene().getWindow();

                    stage.setScene(new Scene(loader.load()));
                    stage.setTitle(title);
                    stage.show();

                    break;
                }
            }

            if (!found) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Username or Password.");
                alert.showAndWait();
            }

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to read users.txt or open dashboard.");
            alert.showAndWait();

            e.printStackTrace();
        }
    }

}