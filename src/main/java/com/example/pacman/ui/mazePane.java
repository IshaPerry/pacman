package com.example.pacman.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;
import java.awt.event.KeyAdapter;

import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public class mazePane extends Application {
    private int s = 0;
    private int l = configurationControls.getLives();
    private int r = 1;
    private Text score = new Text();
    private Text lives = new Text();
    private Text round = new Text();
    private ImageView[][] cellViews;
    private ImageView yPacmanRight, yPacmanLeft, yPacmanUp, yPacmanDown;
    private ImageView bPacmanRight, bPacmanLeft, bPacmanUp, bPacmanDown;
    private ImageView pPacmanRight, pPacmanLeft, pPacmanUp, pPacmanDown;
    private ImageView yGhostRight, yGhostLeft, yGhostUp, yGhostDown;
    private ImageView rGhostRight, rGhostLeft, rGhostUp, rGhostDown;
    private ImageView pGhostRight, pGhostLeft, pGhostUp, pGhostDown;
    private ImageView bGhostRight, bGhostLeft, bGhostUp, bGhostDown;
    private boolean inGame = true;
    private int key_dx, key_dy;
    private double x;
    private double y;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    private Direction dir;

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    ;
    //private Image cherry;

    public mazePane() {
        this.yPacmanRight = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmright.gif"))));
        this.yPacmanLeft = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmleft.gif"))));
        this.yPacmanUp = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmup.gif"))));
        this.yPacmanDown = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmdown.gif"))));

        this.bPacmanRight = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbr.gif"))));
        this.bPacmanLeft = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbl.gif"))));
        this.bPacmanUp = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbu.gif"))));
        this.bPacmanDown = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbd.gif"))));

        this.pPacmanRight = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpr.gif"))));
        this.pPacmanLeft = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpl.gif"))));
        this.pPacmanUp = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpu.gif"))));
        this.pPacmanDown = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpd.gif"))));

        this.yGhostRight = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/yright.gif"))));
        this.yGhostLeft = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/yleft.gif"))));
        this.yGhostUp = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/yup.gif"))));
        this.yGhostDown = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/ydown.gif"))));
        this.rGhostRight = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rright.gif"))));
        this.rGhostLeft = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rleft.gif"))));
        this.rGhostUp = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rup.gif"))));
        this.rGhostDown = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rdown.gif"))));
        this.pGhostRight = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pright.gif"))));
        this.pGhostLeft = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pleft.gif"))));
        this.pGhostUp = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pup.gif"))));
        this.pGhostDown = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pdown.gif"))));
        this.bGhostRight = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pright.gif"))));
        this.bGhostLeft = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bleft.gif"))));
        this.bGhostUp = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bup.gif"))));
        this.bGhostDown = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bdown.gif"))));
    }


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
        //pane.setPadding(new Insets(5,5,5,5));

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

        double s = 30; // height & width of each square
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
                    Circle pellet = new Circle(s / 8, Color.YELLOW);
                    pane.add(pellet, j, i);
                    pane.setAlignment(Pos.CENTER);
                    GridPane.setHalignment(pellet, HPos.CENTER);
                    GridPane.setValignment(pellet, VPos.CENTER);


                } else if (arr[i][j] == 'B') {
                    r.setFill(Color.BLACK);
                    pane.add(r, j, i);
                    Circle pellet = new Circle(s / 4, Color.YELLOW);
                    pane.add(pellet, j, i);
                    GridPane.setHalignment(pellet, HPos.CENTER);
                    GridPane.setValignment(pellet, VPos.CENTER);
                } else {
                    pane.add(r, j, i);
                }
            }
        }

        bp.setCenter(pane);
        ImageView pacman;
        if (configurationControls.getPacman().equals("Yellow")) {
            pacman = yPacmanRight;
        } else if (configurationControls.getPacman().equals("Blue")) {
            pacman = bPacmanRight;
        } else {
            pacman = pPacmanRight;
        }
        pacman.setFitHeight(s);
        pacman.setFitWidth(s);
        pane.add(pacman, 1, arr.length - 2);


        // Create a scene and place it in the stage
        Scene scene = new Scene(bp);
        primaryStage.setTitle(lev + " maze"); // Set the stage title
        primaryStage.setScene(scene); // Place in scene in the stage
        primaryStage.show(); // Display the stage;


        //method to control pacman movement
        //   private void movePacman() {}
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (inGame) {
                    System.out.println("in game");
                    if (e.getCode() == KeyCode.LEFT) {
                        key_dx = -1;
                        key_dy = 0;
                    } else if (e.getCode() == KeyCode.RIGHT) {
                        key_dx = 1;
                        key_dy = 0;
                        TranslateTransition t = new TranslateTransition();
                        t.setByX(40);
                        t.setNode(pacman);
                        t.play();
                        System.out.println("hi");
                    } else if (e.getCode() == KeyCode.DOWN) {
                        key_dx = 0;
                        key_dy = -1;
                    } else if (e.getCode() == KeyCode.UP) {
                        key_dx = 0;
                        key_dy = 1;
                    }
                }
            }

        });


    }
}
