package com.example.pacman.ui;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
            changeScene(stage, "/configuration.fxml");
        });

        //exitButton
        exit.setOnAction(e -> {
            System.exit(0);
        });

        //imageView
       ImageView image = new ImageView("/Pac-Man-Ghosts.jpeg");

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
        } catch (IOException e) {
//            System.out.println("IO Error");
            System.out.println(e.toString());
        }
    }
}









