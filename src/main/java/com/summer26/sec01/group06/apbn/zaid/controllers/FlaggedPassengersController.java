package com.summer26.sec01.group06.apbn.zaid.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class FlaggedPassengersController {


    @FXML
    private TextField passportNumberField;

    @FXML
    private TextField currentLocationField;


    @FXML
    private ComboBox<String> riskLevelComboBox;


    @FXML
    private TableView flaggedTable;


    @FXML
    private TableColumn passportColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn riskColumn;

    @FXML
    private TableColumn locationColumn;


    @FXML
    private Label statusLabel;



    @FXML
    public void initialize(){


        riskLevelComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High",
                "Critical"
        );


        riskLevelComboBox.setValue("Low");


        statusLabel.setText("Ready");

    }



    @FXML
    public void searchPassenger(ActionEvent event){


        String passport = passportNumberField.getText();


        if(passport.isEmpty()){

            statusLabel.setText("Enter passport number");

        }
        else{

            statusLabel.setText(
                    "Passenger record loaded"
            );

        }

    }





    @FXML
    public void notifySecurity(ActionEvent event){


        statusLabel.setText(
                "Security team notified"
        );


    }





    @FXML
    public void removeFlag(ActionEvent event){


        statusLabel.setText(
                "Passenger flag removed"
        );


    }





    @FXML
    public void clearFields(ActionEvent event){


        passportNumberField.clear();

        currentLocationField.clear();

        riskLevelComboBox.setValue("Low");


        statusLabel.setText(
                "Cleared"
        );


    }





    @FXML
    public void backButton(ActionEvent event) throws IOException{


        Parent root = FXMLLoader.load(
                getClass().getResource(
                        "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"
                )
        );


        Stage stage =
                (Stage)((Button)event.getSource())
                        .getScene()
                        .getWindow();


        stage.setScene(
                new Scene(root)
        );


        stage.show();


    }



}