package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class SpecialSecuritySupportController {

    @FXML
    private ComboBox<String> cmbSupportType;

    @FXML
    private TextArea txtDetails;

    @FXML
    public void initialize() {

        cmbSupportType.getItems().addAll(
                "Wheelchair Assistance",
                "Medical Support",
                "Senior Citizen Assistance",
                "Pregnant Passenger Support",
                "Other"
        );
    }

    @FXML
    private void submitRequest() {

        if (cmbSupportType.getValue() == null || txtDetails.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please complete all fields.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Special security support request submitted successfully.");
        alert.showAndWait();

        cmbSupportType.getSelectionModel().clearSelection();
        txtDetails.clear();
    }

    @FXML
    private void back() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/jim/passenger-dashboard.fxml"));

        Stage stage = (Stage) cmbSupportType.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }
}