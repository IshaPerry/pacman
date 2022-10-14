package com.example.pacman.ui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class welcome extends Application {
    public Stage stage;


   // private static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        //Scene scene = new Scene(root, 1000, 1000);
        //primaryStage.setTitle("Pacman");
        // Parent root = new GridPane();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }



    public static void main(String[] args){
        launch(args);
    }

}
