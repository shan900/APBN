package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageFlightsController {

    @FXML
    private TextField txtFlightNo;

    @FXML
    private TextField txtDestination;

    @FXML
    private TextField txtGate;

    @FXML
    private void addFlight() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Flight");
        alert.setHeaderText(null);
        alert.setContentText("Flight Added Successfully.");
        alert.showAndWait();
    }

    @FXML
    private void updateFlight() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Flight");
        alert.setHeaderText(null);
        alert.setContentText("Flight Updated Successfully.");
        alert.showAndWait();
    }

    @FXML
    private void deleteFlight() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Flight");
        alert.setHeaderText(null);
        alert.setContentText("Flight Deleted Successfully.");
        alert.showAndWait();
    }

    @FXML
    private void clearData() {

        txtFlightNo.clear();
        txtDestination.clear();
        txtGate.clear();
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/jim/admin-dashboard.fxml"));

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

}