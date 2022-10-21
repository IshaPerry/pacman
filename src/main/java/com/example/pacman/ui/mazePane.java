package com.example.pacman.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private int l = configurationControls.getLives();
    private int r = 1;
    private Text score = new Text();
    private Text lives = new Text();
    private Text round = new Text();
    private ImageView[][] cellViews;
    private Image pacmanRight, pacmanLeft, pacmanUp, pacmanDown;
    private Image yGhostRight, yGhostLeft, yGhostUp, yGhostDown;
    private Image rGhostRight, rGhostLeft, rGhostUp, rGhostDown;
    private Image pGhostRight, pGhostLeft, pGhostUp, pGhostDown;
    private Image bGhostRight, bGhostLeft, bGhostUp, bGhostDown;
    //private Image cherry;

    public mazePane() {
        this.pacmanRight = new Image(".../.../resources/images/pmright.gif");
        this.pacmanLeft = new Image(".../.../resources/images/pmleft.gif");
        this.pacmanUp = new Image(".../.../resources/images/pmup.gif");
        this.pacmanDown = new Image(".../.../resources/images/pdown.gif");
        this.yGhostRight = new Image(".../.../resources/images/yright.gif");
        this.yGhostLeft = new Image(".../.../resources/images/yleft.gif");
        this.yGhostUp = new Image(".../.../resources/images/yup.gif");
        this.yGhostDown = new Image(".../.../resources/images/ydown.gif");
        this.rGhostRight = new Image(".../.../resources/images/rright.gif");
        this.rGhostLeft = new Image(".../.../resources/images/rleft.gif");
        this.rGhostUp = new Image(".../.../resources/images/rup.gif");
        this.rGhostDown = new Image(".../.../resources/images/rdown.gif");
        this.pGhostRight = new Image(".../.../resources/images/pright.gif");
        this.pGhostLeft = new Image(".../.../resources/images/pleft.gif");
        this.pGhostUp = new Image(".../.../resources/images/pup.gif");
        this.pGhostDown = new Image(".../.../resources/images/pdown.gif");
        this.bGhostRight = new Image(".../.../resources/images/bright.gif");
        this.bGhostLeft = new Image(".../.../resources/images/bleft.gif");
        this.bGhostUp = new Image(".../.../resources/images/bup.gif");
        this.bGhostDown = new Image(".../.../resources/images/bdown.gif");
    }

    private void

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
        char[][] arr;
        maze m = new maze();
        String lev = configurationControls.getLevel();
        if (lev.equals("Easy")) {
            arr = m.getEasyArray();
        } else if (lev.equals("Medium")) {
            arr = m.getMedArray();
        } else {
            arr = m.getHardArray();
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