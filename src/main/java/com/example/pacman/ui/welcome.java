package com.example.pacman.ui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class welcome extends Application {


   // private static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("/Users/ishaperry/Library/CloudStorage/OneDrive-GeorgiaInstituteofTechnology/pacman_2340/src/main/java/com/example/pacman/ui/welcome.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(welcome.class.getResource("welcome.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        //Scene scene = new Scene(root, 1000, 1000);
        //primaryStage.setTitle("Pacman");
        // Parent root = new GridPane();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }

   // public static Stage getPrimaryStage() {
   //     return primaryStage;
  //  }

    public static void main(String[] args){
        launch(args);
    }

}
