package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

        try {

            // Officer Login
            if (username.equals("officer") && password.equals("123")) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "/com/summer26/sec01/group06/apbn/fxml/officer-dashboard.fxml"
                        )
                );

                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) txtUsername.getScene().getWindow();

                stage.setScene(scene);
                stage.setTitle("Officer Dashboard");
                stage.show();
            }

            // Supervisor Login
            else if (username.equals("supervisor") && password.equals("123")) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "/com/summer26/sec01/group06/apbn/fxml/supervisor-dashboard.fxml"
                        )
                );

                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) txtUsername.getScene().getWindow();

                stage.setScene(scene);
                stage.setTitle("Supervisor Dashboard");
                stage.show();
            }

            // Immigration Officer
            else if (username.equals("IO") && password.equals("1234")) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"
                        )
                );

                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) txtUsername.getScene().getWindow();

                stage.setScene(scene);
                stage.setTitle("Immigration Officer Dashboard");
                stage.show();
            }

            // Baggage Scanner Operator
            else if (username.equals("BSO") && password.equals("12345")) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "/com/summer26/sec01/group06/apbn/zaid/view/baggage-scanner.fxml"
                        )
                );

                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) txtUsername.getScene().getWindow();

                stage.setScene(scene);
                stage.setTitle("Baggage Scanner Operator Dashboard");
                stage.show();
            }

            // Invalid Login
            else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Username or Password");
                alert.showAndWait();
            }

        } catch (IOException e) {

            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Cannot open Dashboard.\n\n" + e.getMessage()
            );
            alert.showAndWait();
        }
    }
}