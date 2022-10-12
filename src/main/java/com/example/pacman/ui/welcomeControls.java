package com.example.pacman.ui;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;


public class welcomeControls {
    @FXML
    private Button start;
    @FXML
    private Button exit;

    @FXML
    private ImageView image;

    public Stage stage;

    @FXML
    public void initialize() throws FileNotFoundException {
        //startButton
        start.setOnAction(e -> {
            Stage stage = (Stage) start.getScene().getWindow();
            this.stage = stage;
            changeScene(stage, "/InfoScreen.fxml");
        });

        //exitButton
        exit.setOnAction(e -> {
            stage.close();
        });

        //imageView
       ImageView image = new ImageView("/Pac-Man-Ghosts.jpeg");
        /*
        InputStream stream = new FileInputStream("/Users/ishaperry/Library/CloudStorage/OneDrive-GeorgiaInstituteofTechnology/pacman_2340/Pac-Man-Ghosts.jpeg");
        Image image = new Image(stream);
        farmImageView.setImage(image);
        farmImageView.setX(10);
        farmImageView.setY(10);
        farmImageView.setFitWidth(575);
        farmImageView.setPreserveRatio(true);
         */


    }

    public void changeScene(Stage stage, String filePath) {
        try {
            this.stage = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filePath));
            // Scene newScene = new Scene(fxmlLoader.load(), 600,400);
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            FadeTransition ft = new FadeTransition(Duration.millis(3000), page);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            Scene newScene = new Scene(page);
            this.stage.setScene(newScene);
            throw new IOException();
        } catch (IOException e) {
            System.out.println("");
        }
    }
}









