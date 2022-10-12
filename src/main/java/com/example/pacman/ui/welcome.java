package com.example.pacman.ui;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;

import java.io.IOException;

public class welcome extends Application {
    public static Stage stage;

   // private static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
        Scene welcomeScreen = new Scene(fxmlLoader.load(), 600, 400);
        //Scene scene = new Scene(root, 1000, 1000);
        //primaryStage.setTitle("Pacman");
        // Parent root = new GridPane();
        primaryStage.setScene(welcomeScreen);
        primaryStage.setTitle("Pacman");
        primaryStage.show();
    }

    public static Stage getStage() {
        System.out.println("Getter");
        return stage;
    }
    public static void main(String[] args){
        launch(args);
    }

}
