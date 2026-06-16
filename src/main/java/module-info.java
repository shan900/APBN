module com.summer26.sec01.group06.apbn {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.summer26.sec01.group06.apbn to javafx.fxml;
    exports com.summer26.sec01.group06.apbn;
}