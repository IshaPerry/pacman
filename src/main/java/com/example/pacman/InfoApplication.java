package com.example.pacman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoApplication extends Application {

    @Override
    public void start(Stage infoStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InfoApplication.class.getResource("../../../../resources/InfoScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        infoStage.setTitle("Info Screen");
        infoStage.setScene(scene);
        infoStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
