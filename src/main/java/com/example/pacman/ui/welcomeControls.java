package com.example.pacman.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import java.io.FileNotFoundException;




public class welcomeControls {
    @FXML
    private Button start;
    @FXML
    private Button exit;

    @FXML
    private ImageView image;

    @FXML
    public void initialize() throws FileNotFoundException {
        //startButton
        start.setOnAction(e -> {
            //Stage stage = (Stage) start.getScene().getWindow();
           // stage.close();
        });

        //exitButton
        exit.setOnAction(e -> {
           // System.exit(0);
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
}









