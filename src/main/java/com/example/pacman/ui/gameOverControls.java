package com.example.pacman.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class gameOverControls {
    private static Stage stage;
    private static Label scoreLabel = new Label();
    private static Label livesLabel = new Label();
    private static Label ghostsLabel = new Label();
    private static Image win = new Image(Objects.requireNonNull(gameOverControls.class.getResourceAsStream("/winScreen.png")));
    private static Image lose = new Image(Objects.requireNonNull(gameOverControls.class.getResourceAsStream("/loseScreen.png")));


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
    public static void changeScene(Stage currentStage) throws NullPointerException, IOException {
        URL location = gameOverControls.class.getResource("/gameOver.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader(location);
        AnchorPane page = (AnchorPane) fxmlLoader.load();
        Scene newScene = new Scene(page);
        ImageView background = (ImageView) newScene.lookup("#background");
        if (GameModel.getGameStatus() == GameModel.GameState.LOSE) {
            background.setImage(lose);
        } else {
            background.setImage(win);
        }

        currentStage.setTitle("Game Over");
        page.getChildren().add(livesLabel);
        page.getChildren().add(scoreLabel);
        page.getChildren().add(ghostsLabel);

        livesLabel.setTranslateX(305);
        livesLabel.setTranslateY(211);
        livesLabel.setText(String.valueOf(GameModel.getLives()));
        livesLabel.setFont(Font.font("Ayuthaya", 20));
        livesLabel.setTextFill(Color.BLACK);
        scoreLabel.setTranslateX(305);
        scoreLabel.setTranslateY(178);
        scoreLabel.setText(String.valueOf(GameModel.getScore()));
        scoreLabel.setFont(Font.font("Ayuthaya", 20));
        scoreLabel.setTextFill(Color.BLACK);
        ghostsLabel.setTranslateX(305);
        ghostsLabel.setTranslateY(245);
        ghostsLabel.setText(String.valueOf(GameModel.getGhostsEaten()));
        ghostsLabel.setFont(Font.font("Ayuthaya", 20));
        ghostsLabel.setTextFill(Color.BLACK);
        currentStage.setScene(newScene);
        currentStage.setTitle("Game over");
    }
}
