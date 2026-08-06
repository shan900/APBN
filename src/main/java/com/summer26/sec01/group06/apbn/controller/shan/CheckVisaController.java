package com.summer26.sec01.group06.apbn.controller.shan;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckVisaController {

    @FXML
    private TextField txtPassport;

    @FXML
    private TextField txtVisaType;

    @FXML
    private TextField txtExpiryDate;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnBack;

    @FXML
    private void verifyVisa() {

        String passport = txtPassport.getText().trim();

        if (passport.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter Passport Number.");
            alert.showAndWait();
            return;
        }

        // Dummy Data
        txtVisaType.setText("Tourist Visa");
        txtExpiryDate.setText("31-Dec-2027");
        lblStatus.setText("Status : VALID");
    }

    @FXML
    private void clearData() {

        txtPassport.clear();
        txtVisaType.clear();
        txtExpiryDate.clear();
        lblStatus.setText("");
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/immigration-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Immigration Dashboard");
        stage.show();
    }
}