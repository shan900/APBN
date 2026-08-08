package com.summer26.sec01.group06.apbn.zaid.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class CheckpointManagementController {


    @FXML
    private Button backButton;

    @FXML
    private ComboBox<String> checkpointComboBox;

    @FXML
    private ComboBox<String> checkpointStatusComboBox;

    @FXML
    private ComboBox<String> officerComboBox;


    @FXML
    private TableView<?> checkpointTable;


    @FXML
    private TableColumn<?,?> checkpointColumn;


    @FXML
    private TableColumn<?,?> officerColumn;


    @FXML
    private TableColumn<?,?> statusColumn;


    @FXML
    private Label statusLabel;



    @FXML
    public void initialize(){


        checkpointComboBox.getItems().addAll(
                "Gate A",
                "Gate B",
                "Gate C"
        );


        checkpointStatusComboBox.getItems().addAll(
                "Active",
                "Inactive",
                "Maintenance"
        );


        officerComboBox.getItems().addAll(
                "Officer 1",
                "Officer 2",
                "Officer 3"
        );


        statusLabel.setText("Ready");

    }



    @FXML
    public void viewCheckpoint(ActionEvent event){

        statusLabel.setText(
                "Checkpoint information loaded"
        );

    }



    @FXML
    public void assignOfficer(ActionEvent event){

        statusLabel.setText(
                "Officer Assigned Successfully"
        );

    }




    @FXML
    public void updateCheckpoint(ActionEvent event){

        statusLabel.setText(
                "Checkpoint Updated"
        );

    }




    @FXML
    public void verifyCheckpoint(ActionEvent event){

        statusLabel.setText(
                "Checkpoint Verified"
        );

    }




    @FXML
    public void saveCheckpoint(ActionEvent event){

        statusLabel.setText(
                "Checkpoint Data Saved"
        );

    }





    @FXML
    public void backButton(ActionEvent event) throws IOException{


        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource(
                                "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"
                        ));


        Parent root = loader.load();


        Stage stage =
                (Stage) backButton.getScene().getWindow();


        stage.setScene(
                new Scene(root)
        );


        stage.show();


    }


}