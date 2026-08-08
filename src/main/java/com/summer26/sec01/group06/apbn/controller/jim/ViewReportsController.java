package com.summer26.sec01.group06.apbn.controller.jim;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewReportsController {

    @FXML
    private Button btnBack;

    private void openPage(String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/fxml/jim/" + fxml));

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void openSecurityRequests() throws IOException {

        openPage("security-requests.fxml");
    }

    @FXML
    private void openSpecialSupports() throws IOException {

        openPage("special-supports.fxml");
    }

    @FXML
    private void openLostProperties() throws IOException {

        openPage("lost-properties.fxml");
    }

    @FXML
    private void openRestrictedReports() throws IOException {

        openPage("restricted-reports.fxml");
    }

    @FXML
    private void openBlacklist() throws IOException {

        openPage("blacklist-management.fxml");
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