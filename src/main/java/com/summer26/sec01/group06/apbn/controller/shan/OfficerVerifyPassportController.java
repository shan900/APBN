package com.summer26.sec01.group06.apbn.controller.shan;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OfficerVerifyPassportController {

    @FXML
    private TextField txtPassport;

    @FXML
    private Label lblResult;

    @FXML
    private Button btnBack;

    @FXML
    private void verifyPassport() {

        String passport = txtPassport.getText().trim();

        if (passport.isEmpty()) {
            lblResult.setText("Please enter Passport Number.");
            return;
        }

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(
                new FileReader("data/passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 6 &&
                        data[2].trim().equalsIgnoreCase(passport.trim())) {

                    lblResult.setText(
                            "✅ Passport Verified\n\n" +
                                    "Passenger ID : " + data[0] +
                                    "\nName : " + data[1] +
                                    "\nPassport : " + data[2] +
                                    "\nNationality : " + data[3] +
                                    "\nFlight : " + data[4] +
                                    "\nGate : " + data[5]
                    );

                    found = true;
                    break;
                }
            }

            if (!found) {
                lblResult.setText("❌ Passport Not Found!");
            }

        } catch (IOException e) {
            lblResult.setText("Error reading data/passengers.txt");
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/officer-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Officer Dashboard");
        stage.show();
    }
}