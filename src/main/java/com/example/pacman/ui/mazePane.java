package com.example.pacman.ui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

public class mazePane extends Application {
    @Override // Override the start method in the application class
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane pane = new GridPane();

        // Get maze array
        easyMaze maze = new easyMaze();
        char[][] arr = maze.getMazeArray();

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

        // Create a scene and place it in the stage
        Scene scene = new Scene (pane);
        primaryStage.setTitle("Easy maze"); // Set the stage title
        primaryStage.setScene(scene); // Place in scene in the stage
        primaryStage.show(); // Display the stage;
    }
}