package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeclareRestrictedItemController {

    @FXML
    private TextField txtItemName;

    @FXML
    private TextArea txtReason;

    @FXML
    private void submitDeclaration() {

        if (txtItemName.getText().trim().isEmpty()
                || txtReason.getText().trim().isEmpty()) {

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
        alert.setContentText("Restricted item declared successfully.");
        alert.showAndWait();

        txtItemName.clear();
        txtReason.clear();
    }

    @FXML
    private void back() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/jim/passenger-dashboard.fxml"));

        Stage stage = (Stage) txtItemName.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Passenger Dashboard");
        stage.show();
    }
}