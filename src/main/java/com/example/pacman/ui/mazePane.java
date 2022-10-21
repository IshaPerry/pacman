package com.example.pacman.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mazePane extends Application {
    private int s = 0;
    private int l = 2;
    private int r = 1;
    private Text score = new Text();
    private Text lives = new Text();
    private Text round = new Text();

    @Override // Override the start method in the application class
    public void start(Stage primaryStage) {
        score.setText("Score: " + s);
        lives.setText("Lives: " + l);
        round.setText("Round " + r + "!");
        BorderPane.setAlignment(lives, Pos.BOTTOM_LEFT);
        HBox top = new HBox(score, round);
        top.setSpacing(500);
        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setBottom(lives);

        // Create a GridPane
        GridPane pane = new GridPane();

        // Get maze array

        maze m = new maze();
        String lev = levelSelector.getSelectionModel().getSelectedItem();
        if (level().equals("Easy")) {
            char[][] arr = m.getEasyArray();
        } else if (level.equals("Medium")) {
            char[][] arr = m.getMedArray();
        } else {
            char[][] arr = m.getHardArray();
        }

        double s = 25; // height & width of each square
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                Rectangle r = new Rectangle(s, s, s, s);
                if (arr[i][j] == 'W') {
                    r.setFill(Color.BLUE);
                } else {
                    r.setFill(Color.BLACK);
                }
                if (arr[i][j] == 'P') {
                    r.setFill(Color.BLACK);
                    pane.add(r, j, i);
                    Circle pellet = new Circle(s/4, Color.YELLOW);
                    pane.add(pellet, j, i);
                } else if (arr[i][j] == 'B') {
                    r.setFill(Color.BLACK);
                    pane.add(r, j, i);
                    Circle pellet = new Circle(s/2, Color.YELLOW);
                    pane.add(pellet, j, i);
                } else {
                    pane.add(r, j, i);
                }
            }
        }
        pane.setStyle("~fx-grid-lines-visible: false");

        bp.setCenter(pane);

        // Create a scene and place it in the stage
        Scene scene = new Scene (bp);
        primaryStage.setTitle("Easy maze"); // Set the stage title
        primaryStage.setScene(scene); // Place in scene in the stage
        primaryStage.show(); // Display the stage;
    }
}