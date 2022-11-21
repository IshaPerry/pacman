package com.example.pacman.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import java.util.EventObject;
import java.util.Objects;


public class gameOverControls {
    private static Stage stage;
    private static Label gameOverLabel = new Label();
    private static Label scoreLabel = new Label();
    private static Label livesLabel = new Label();


    @FXML
    private void hitPlayAgain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/configuration.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void hitExit() {
        System.exit(0);
    }

    @FXML
    public static void changeScene(Stage currentStage, String text, int lives, int score) throws NullPointerException, IOException {
        URL location = gameOverControls.class.getResource("/gameOver.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        AnchorPane page = (AnchorPane) fxmlLoader.load();
        Scene newScene = new Scene(page);
        currentStage.setTitle("Game Over");
        page.getChildren().add(gameOverLabel);
        page.getChildren().add(livesLabel);
        page.getChildren().add(scoreLabel);
        livesLabel.setMinHeight(29);
        livesLabel.setMinWidth(151);
        livesLabel.setTranslateX(317);
        livesLabel.setTranslateY(197);
        livesLabel.setText(String.valueOf(lives));
        scoreLabel.setMinHeight(29);
        scoreLabel.setMinWidth(151);
        scoreLabel.setTranslateX(317);
        scoreLabel.setTranslateY(226);
        scoreLabel.setText(String.valueOf(score));
        gameOverLabel.setMinHeight(40);
        gameOverLabel.setMinWidth(111);
        gameOverLabel.setTranslateX(262);
        gameOverLabel.setTranslateY(157);
        gameOverLabel.setTextFill(Color.WHITE);
        gameOverLabel.setText(text);
        gameOverLabel.setFont(Font.font("Ayuthaya", 20));
        livesLabel.setFont(Font.font("Ayuthaya", 20));
        livesLabel.setTextFill(Color.WHITE);
        scoreLabel.setFont(Font.font("Ayuthaya", 20));
        scoreLabel.setTextFill(Color.WHITE);
        currentStage.setScene(newScene);
        currentStage.setTitle("Game over");
    }

}
