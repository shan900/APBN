package com.summer26.sec01.group06.apbn.controller.shan;
import com.summer26.sec01.group06.apbn.model.Flight;
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

public class FlightScheduleController {

    @FXML
    private TableView<Flight> tableFlights;

    @FXML
    private TableColumn<Flight, String> colFlightNo;

    @FXML
    private TableColumn<Flight, String> colDestination;

    @FXML
    private TableColumn<Flight, String> colDeparture;

    @FXML
    private TableColumn<Flight, String> colGate;

    @FXML
    private TableColumn<Flight, String> colStatus;

    @FXML
    private Button btnBack;

    @FXML
    public void initialize() {

        colFlightNo.setCellValueFactory(new PropertyValueFactory<>("flightNo"));
        colDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colDeparture.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        colGate.setCellValueFactory(new PropertyValueFactory<>("gate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<Flight> list = FXCollections.observableArrayList(

                new Flight("BG201","London","10:30 AM","A1","On Time"),
                new Flight("EK582","Dubai","12:45 PM","B2","Delayed"),
                new Flight("SQ447","Singapore","02:15 PM","C3","On Time"),
                new Flight("QR641","Doha","05:00 PM","D1","Boarding"),
                new Flight("TK713","Istanbul","07:20 PM","E5","Cancelled")

        );

        tableFlights.setItems(list);

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