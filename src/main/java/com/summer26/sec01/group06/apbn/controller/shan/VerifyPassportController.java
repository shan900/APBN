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

public class VerifyPassportController {

    @FXML
    private TextField txtPassport;

    @FXML
    private Label lblResult;

    @FXML
    private Button btnBack;

    @FXML
    private void verifyPassport() {

        System.out.println("===== Verify Button Clicked =====");

        String passport = txtPassport.getText().trim();
        System.out.println("Entered Passport: " + passport);

        if (passport.isEmpty()) {
            lblResult.setText("Please enter Passport Number.");
            return;
        }

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println("Reading Line: " + line);

                String[] data = line.split(",");

                if (data.length >= 6) {

                    System.out.println("Passport in File: " + data[2]);

                    if (data[2].trim().equalsIgnoreCase(passport)) {

                        lblResult.setText(
                                "Passport Verified\n\n"
                                        + "Passenger ID : " + data[0]
                                        + "\nName : " + data[1]
                                        + "\nPassport : " + data[2]
                                        + "\nNationality : " + data[3]
                                        + "\nFlight No : " + data[4]
                                        + "\nGate : " + data[5]
                        );

                        found = true;

                        System.out.println("Passenger Found!");

                        break;
                    }
                }
            }

            if (!found) {
                lblResult.setText("Passport Not Found!");
                System.out.println("Passenger Not Found!");
            }

        } catch (IOException e) {

            lblResult.setText("Error reading passenger file.");

            System.out.println("Error Opening File!");
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/shan/immigration-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Immigration Dashboard");
        stage.show();
    }
}