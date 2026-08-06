package com.summer26.sec01.group06.apbn.controller.shan;

import com.summer26.sec01.group06.apbn.model.SecurityOfficer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewOfficersController {

    @FXML
    private TableView<SecurityOfficer> tableOfficers;

    @FXML
    private TableColumn<SecurityOfficer, String> colOfficerId;

    @FXML
    private TableColumn<SecurityOfficer, String> colName;

    @FXML
    private TableColumn<SecurityOfficer, String> colShift;

    @FXML
    private TableColumn<SecurityOfficer, String> colStatus;

    @FXML
    private Button btnBack;

    @FXML
    public void initialize() {

        colOfficerId.setCellValueFactory(new PropertyValueFactory<>("officerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colShift.setCellValueFactory(new PropertyValueFactory<>("shift"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<SecurityOfficer> list = FXCollections.observableArrayList(

                new SecurityOfficer("OF001", "Rahim Ahmed", "Morning", "Active"),
                new SecurityOfficer("OF002", "Karim Hasan", "Evening", "Active"),
                new SecurityOfficer("OF003", "John Smith", "Night", "On Duty"),
                new SecurityOfficer("OF004", "Sarah Khan", "Morning", "Active")

        );

        tableOfficers.setItems(list);
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/supervisor-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Supervisor Dashboard");
        stage.show();
    }
}