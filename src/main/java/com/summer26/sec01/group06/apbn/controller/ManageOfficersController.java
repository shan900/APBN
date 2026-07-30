package com.summer26.sec01.group06.apbn.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageOfficersController {

    @FXML
    private TextField txtOfficerId;

    @FXML
    private TextField txtOfficerName;

    @FXML
    private TextField txtDepartment;

    @FXML
    private void addOfficer() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Officer");
        alert.setHeaderText(null);
        alert.setContentText("Officer Added Successfully.");
        alert.showAndWait();
    }

    @FXML
    private void updateOfficer() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Officer");
        alert.setHeaderText(null);
        alert.setContentText("Officer Updated Successfully.");
        alert.showAndWait();
    }

    @FXML
    private void deleteOfficer() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Officer");
        alert.setHeaderText(null);
        alert.setContentText("Officer Deleted Successfully.");
        alert.showAndWait();
    }

    @FXML
    private void clearData() {

        txtOfficerId.clear();
        txtOfficerName.clear();
        txtDepartment.clear();
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/admin-dashboard.fxml"));

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

}