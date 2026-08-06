package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class ViewUsersController {

    @FXML
    private ListView<String> listUsers;

    @FXML
    public void initialize() {

        listUsers.setItems(FXCollections.observableArrayList(
                "Admin",
                "Officer",
                "Supervisor",
                "Passenger"
        ));
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/jim/admin-dashboard.fxml"));

        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}