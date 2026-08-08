package com.summer26.sec01.group06.apbn.zaid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ImmigrationReportsController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private TextArea reportPreviewArea;

    @FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll(
                "Daily Report",
                "Weekly Report",
                "Monthly Report",
                "Passenger Clearance Report",
                "Flagged Passenger Report",
                "Checkpoint Activity Report"
        );

        reportTypeComboBox.setValue("Daily Report");

        reportPreviewArea.setEditable(false);
        reportPreviewArea.setText("No report generated.");
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
    // Generate Report
    // ==========================

    @FXML
    private void generateReport(ActionEvent event) {

        String report =
                "========== IMMIGRATION REPORT ==========\n\n" +
                        "Report Type : " + reportTypeComboBox.getValue() + "\n" +
                        "From Date   : " + fromDatePicker.getValue() + "\n" +
                        "To Date     : " + toDatePicker.getValue() + "\n\n" +
                        "Passenger Statistics\n" +
                        "-------------------------\n" +
                        "Passengers Cleared : 120\n" +
                        "Passengers Rejected: 8\n" +
                        "Flagged Cases      : 4\n\n" +
                        "Report generated successfully.";

        reportPreviewArea.setText(report);
    }

    // ==========================
    // Save Report
    // ==========================

    @FXML
    private void saveReport(ActionEvent event) {

        reportPreviewArea.appendText("\n\n✔ Report saved successfully.");
    }

    // ==========================
    // Export PDF
    // ==========================

    @FXML
    private void exportPDF(ActionEvent event) {

        reportPreviewArea.appendText("\n✔ PDF exported successfully.");
    }


}