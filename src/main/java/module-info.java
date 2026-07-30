module com.summer26.sec01.group06.apbn {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.summer26.sec01.group06.apbn to javafx.fxml;

    opens com.summer26.sec01.group06.apbn.controller to javafx.fxml;

    opens com.summer26.sec01.group06.apbn.zaid.controllers to javafx.fxml;

    opens com.summer26.sec01.group06.apbn.model to javafx.base;

    exports com.summer26.sec01.group06.apbn;

    exports com.summer26.sec01.group06.apbn.controller;

    exports com.summer26.sec01.group06.apbn.model;

    exports com.summer26.sec01.group06.apbn.zaid.controllers;

    exports com.summer26.sec01.group06.apbn.zaid.models;

    exports com.summer26.sec01.group06.apbn.zaid.services;
}