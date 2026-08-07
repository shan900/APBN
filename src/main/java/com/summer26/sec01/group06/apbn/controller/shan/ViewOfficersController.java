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

import java.io.BufferedReader;
import java.io.FileReader;
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

        ObservableList<SecurityOfficer> officerList = FXCollections.observableArrayList();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("data/officers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4) {

                    officerList.add(new SecurityOfficer(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim()
                    ));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        tableOfficers.setItems(officerList);
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