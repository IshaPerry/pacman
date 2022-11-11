package com.example.pacman.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class gameOverControls {
    private static Stage stage;

    @FXML
    private static Label gameOverLabel = new Label();


    @FXML
    private void hitPlayAgain() {
        URL location = getClass().getResource("/welcome.fxml");

        try{
            this.stage = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            Pane page = (Pane) fxmlLoader.load();
            Scene newScene = new Scene(page);
            GameControl.setBlueReleased(false);
            GameControl.setPinkReleased(false);
            GameControl.setRedReleased(false);
            stage.setTitle("Welcome");
            this.stage.setScene(newScene);

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    @FXML
    private void hitExit() {
        System.exit(0);
    }



    public static void changeScene(Stage newStage, URL location, String text) {
        try {
            stage = newStage;
            stage.setTitle("Game Over");
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            // Scene newScene = new Scene(fxmlLoader.load(), 600,400);
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Scene newScene = new Scene(page);

            gameOverLabel.setText(text);
            page.getChildren().add(gameOverLabel);
            gameOverLabel.setFont(Font.font("Ayuthaya", 20));
            gameOverLabel.setTextFill(Color.WHITE);
            gameOverLabel.setTranslateX(230);
            gameOverLabel.setTranslateY(230);
            stage.setScene(newScene);
        } catch (IOException e) {
            System.out.println(e.toString());
        }


    }
}
