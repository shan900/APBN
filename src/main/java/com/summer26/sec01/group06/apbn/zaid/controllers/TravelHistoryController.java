package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class TravelHistoryController {

    @FXML
    private TextField passportNumberField;

    @FXML
    private ComboBox<String> countryComboBox;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private TableView<?> travelHistoryTable;

    @FXML
    private TableColumn<?, ?> passportColumn;

    @FXML
    private TableColumn<?, ?> countryColumn;

    @FXML
    private TableColumn<?, ?> entryDateColumn;

    @FXML
    private TableColumn<?, ?> exitDateColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        countryComboBox.setItems(FXCollections.observableArrayList(
                "Bangladesh",
                "India",
                "China",
                "Japan",
                "Malaysia",
                "Singapore",
                "Thailand",
                "USA",
                "UK",
                "Canada"
        ));

        statusLabel.setText("Ready...");
    }

    // ==========================
    // Back Button
    // ==========================

    @FXML
    private void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(
                "/com/summer26/sec01/group06/apbn/zaid/view/immigration.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    // ==========================
    // Search
    // ==========================

    @FXML
    private void searchHistory(ActionEvent event) {

        if (passportNumberField.getText().isEmpty()) {

            statusLabel.setText("Please enter Passport Number.");

        } else {

            statusLabel.setText("Travel history loaded successfully.");

            // Database code will be added later

        }

    }

    // ==========================
    // Filter
    // ==========================

    @FXML
    private void filterHistory(ActionEvent event) {

        statusLabel.setText("Travel history filtered.");

    }

    // ==========================
    // Export
    // ==========================

    @FXML
    private void exportHistory(ActionEvent event) {

        statusLabel.setText("Travel history exported successfully.");

    }

    // ==========================
    // Clear
    // ==========================

    @FXML
    private void clearFields(ActionEvent event) {

        passportNumberField.clear();

        countryComboBox.getSelectionModel().clearSelection();

        fromDatePicker.setValue(null);

        toDatePicker.setValue(null);

        travelHistoryTable.getItems().clear();

        statusLabel.setText("Form Cleared.");

    }

}