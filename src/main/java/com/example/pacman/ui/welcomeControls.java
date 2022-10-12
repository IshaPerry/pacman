package com.example.pacman.ui;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
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

    public static Stage stage;
    @FXML
    private void hitStart(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/configuration.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), 600,400);
        stage = welcome.getStage();
        stage.setScene(newScene);
        System.out.println("Start has been hit!");
    }

    @FXML
    private void hitExit(ActionEvent event) {
        welcome.getStage().close();
    }
    @FXML
    public void initialize() throws IOException {
    }

}









