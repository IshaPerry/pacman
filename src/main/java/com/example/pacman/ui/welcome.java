package com.example.pacman.ui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

/**
 * Class that creates the Welcome Screen
 * @authors Isha Perry and Suemin Lee
 */

public class welcome extends Application {
    public Stage stage;


    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }



    public static void main(String[] args){
        launch(args);
    }

}
