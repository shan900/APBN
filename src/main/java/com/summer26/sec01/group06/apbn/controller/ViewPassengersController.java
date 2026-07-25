package com.summer26.sec01.group06.apbn.controller;

import com.summer26.sec01.group06.apbn.model.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewPassengersController {

    @FXML
    private TableView<Passenger> tablePassengers;

    @FXML
    private TableColumn<Passenger, String> colPassengerId;

    @FXML
    private TableColumn<Passenger, String> colName;

    @FXML
    private TableColumn<Passenger, String> colPassport;

    @FXML
    private TableColumn<Passenger, String> colNationality;

    @FXML
    private TableColumn<Passenger, String> colFlight;

    @FXML
    private TableColumn<Passenger, String> colGate;

    @FXML
    public void initialize() {

        System.out.println("Initialize Called");

        colPassengerId.setCellValueFactory(new PropertyValueFactory<>("passengerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPassport.setCellValueFactory(new PropertyValueFactory<>("passportNo"));
        colNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        colFlight.setCellValueFactory(new PropertyValueFactory<>("flightNo"));
        colGate.setCellValueFactory(new PropertyValueFactory<>("gate"));

        loadPassengers();
    }

    private void loadPassengers() {

        System.out.println("Loading passengers...");

        ObservableList<Passenger> passengerList = FXCollections.observableArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader("passengers.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println("Line: " + line);

                String[] data = line.split(",");

                if (data.length == 6) {

                    Passenger passenger = new Passenger(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4],
                            data[5]
                    );

                    passengerList.add(passenger);

                    System.out.println("Added: " + passenger.getName());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total Passengers = " + passengerList.size());

        tablePassengers.setItems(passengerList);
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/summer26/sec01/group06/apbn/fxml/supervisor-dashboard.fxml"));

        Stage stage = (Stage) tablePassengers.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}