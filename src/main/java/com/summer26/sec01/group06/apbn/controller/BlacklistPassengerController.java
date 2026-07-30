package com.summer26.sec01.group06.apbn.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class BlacklistPassengerController {

    @FXML
    private TextField txtPassengerId;

    @FXML
    private TextField txtReason;

    @FXML
    private Label lblMessage;

    @FXML
    private Button btnBack;

    @FXML
    private void blacklistPassenger() {

        String id = txtPassengerId.getText().trim();
        String reason = txtReason.getText().trim();

        if(id.isEmpty() || reason.isEmpty()){

            lblMessage.setText("Please complete all fields.");
            return;
        }

        try{

            FileWriter writer = new FileWriter("blacklist.txt",true);

            writer.write(id + "," + reason + "\n");

            writer.close();

            lblMessage.setText("Passenger Blacklisted Successfully.");

        }

        catch(IOException e){

            lblMessage.setText("Error Saving Data.");

        }

    }

    @FXML
    private void clearData(){

        txtPassengerId.clear();
        txtReason.clear();
        lblMessage.setText("");

    }

    @FXML
    private void goBack() throws IOException{

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/immigration-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("Immigration Dashboard");

        stage.show();

    }

}