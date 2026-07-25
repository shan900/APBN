package com.summer26.sec01.group06.apbn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                MainApplication.class.getResource("/com/summer26/sec01/group06/apbn/fxml/login.fxml"));

        Scene scene = new Scene(loader.load());

        stage.setTitle("APBN Airport Security System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}