package com.example.pacman.ui;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
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
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.Objects;

public class GameView extends Application {
    static final int CELL = 30;
    private static GridPane pane = new GridPane();
    private ImageView[][] cellViews;
    private static Image yPacmanRight, yPacmanLeft, yPacmanUp;
    private static Image yPacmanDown;
    private static Image bPacmanRight, bPacmanLeft, bPacmanUp, bPacmanDown;
    private static Image pPacmanRight, pPacmanLeft, pPacmanUp, pPacmanDown;
    private static ImageView yGhostRight, yGhostLeft, yGhostUp, yGhostDown;
    private static ImageView rGhostRight, rGhostLeft, rGhostUp, rGhostDown;
    private static ImageView pGhostRight, pGhostLeft, pGhostUp, pGhostDown;
    private static ImageView bGhostRight, bGhostLeft, bGhostUp, bGhostDown;
    private static Text scoreDisplay = new Text();
    private static Text livesDisplay = new Text();
    private static Text roundDisplay = new Text();
    private static ImageView pacman;
    private static BorderPane bp;
    private Scene scene;


    public GameView() {
        this.yPacmanRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmright.gif")));
        this.yPacmanLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmleft.gif")));
        this.yPacmanUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmup.gif")));
        this.yPacmanDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmdown.gif")));

        this.bPacmanRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbr.gif")));
        this.bPacmanLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbl.gif")));
        this.bPacmanUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbu.gif")));
        this.bPacmanDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmbd.gif")));

        this.pPacmanRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpr.gif")));
        this.pPacmanLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpl.gif")));
        this.pPacmanUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpu.gif")));
        this.pPacmanDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pmpd.gif")));

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
        scoreDisplay.setText("Score: " + GameModel.getScore());
        livesDisplay.setText("Lives: " + GameModel.getLives());
        roundDisplay.setText("Round: " + GameModel.getRound());
        BorderPane.setAlignment(livesDisplay, Pos.BOTTOM_LEFT);
        HBox top = new HBox(scoreDisplay, roundDisplay);
        top.setSpacing(700);
        bp = new BorderPane();
        bp.setTop(top);
        bp.setBottom(livesDisplay);



        // Get maze array
        char[][] arr = GameModel.getMaze();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                Rectangle r = new Rectangle(CELL, CELL, CELL, CELL);
                if (arr[i][j] == 'W') {
                    r.setFill(Color.BLUE);
                } else {
                    r.setFill(Color.BLACK);
                }
                if (arr[i][j] == 'P') {
                    r.setFill(Color.BLACK);
                    pane.add(r, j, i);
                    Circle pellet = new Circle(CELL / 8, Color.YELLOW);
                    pane.add(pellet, j, i);
                    pane.setAlignment(Pos.CENTER);
                    GridPane.setHalignment(pellet, HPos.CENTER);
                    GridPane.setValignment(pellet, VPos.CENTER);


                } else if (arr[i][j] == 'B') {
                    r.setFill(Color.BLACK);
                    pane.add(r, j, i);
                    Circle pellet = new Circle(CELL/ 4, Color.YELLOW);
                    pane.add(pellet, j, i);
                    GridPane.setHalignment(pellet, HPos.CENTER);
                    GridPane.setValignment(pellet, VPos.CENTER);
                } else {
                    pane.add(r, j, i);
                }
            }
        }
        bp.setCenter(pane);
        pacman = new ImageView();
        String pacmanColor = GameModel.getPacmanColor();
        if (GameControl.getLevel().equals("Medium")) {
            if (pacmanColor.equals("Yellow")) {
                pacman.setImage(yPacmanUp);
            } else if (pacmanColor.equals("Blue")) {
                pacman.setImage(bPacmanUp);
            }else {
                pacman.setImage(pPacmanUp);
            }
        } else {
            if (pacmanColor.equals("Yellow")) {
                pacman.setImage(yPacmanRight);
            } else if (pacmanColor.equals("Blue")) {
                pacman.setImage(bPacmanRight);
            }else {
                pacman.setImage(pPacmanRight);
            }
        }

        pacman.setFitHeight(CELL);
        pacman.setFitWidth(CELL);
//        colPos = 1;   //column
//        rowPos = arr.length - 2; //row
        //  aniSprite pacMan = new aniSprite(pacman, s, s);
        pane.add(pacman, GameModel.getPacmanX(), GameModel.getPacmanY());  //column, row


        // Create a scene and place it in the stage
        scene = new Scene(bp);
        primaryStage.setTitle(GameControl.getLevel() + " maze"); // Set the stage title
        primaryStage.setScene(scene); // Place in scene in the stage
        scene.setOnKeyPressed(configurationControls.getGameControl());
        primaryStage.show(); // Display the stage;
    }

    public static void updateView() {
        Translate t = new Translate();
        t.setX(GameModel.getDx() * CELL);
        t.setY(GameModel.getDy() * CELL);
        orientPacman(pacman, GameModel.getPacmanColor(), GameModel.getCurrDirection());
        updateDisplay();
        pacman.getTransforms().addAll(t);



    }

    public static void updateDisplay(){
        scoreDisplay.setText("Score: " + GameModel.getScore());
        livesDisplay.setText("Lives: " + GameModel.getLives());
    }

    public static void removePellets() {
        ObservableList<Node> childrens = pane.getChildren();
        for (Node node : childrens) {
            if (node instanceof Circle && pane.getRowIndex(node) == GameModel.getPacmanY() && pane.getColumnIndex(node) == GameModel.getPacmanX()) {
                pane.getChildren().remove(node);
                break;
            }

         }
    }



    public static void orientPacman(ImageView p, String color, GameModel.Direction dir) {
        switch(color) {
            case "Blue":
                switch(dir){
                    case LEFT:
                        pacman.setImage(bPacmanLeft);
                        break;
                    case UP:
                        pacman.setImage(bPacmanUp);
                        break;
                    case DOWN:
                        pacman.setImage(bPacmanDown);
                        break;
                    case RIGHT:
                        pacman.setImage(bPacmanRight);
                        break;
                }
                break;
            case "Yellow":
                switch(dir){
                    case LEFT:
                        pacman.setImage(yPacmanLeft);
                        break;
                    case UP:
                        pacman.setImage(yPacmanUp);
                        break;
                    case DOWN:
                        pacman.setImage(yPacmanDown);
                        break;
                    case RIGHT:
                        pacman.setImage(yPacmanRight);
                        break;
                }
                break;
            case "Purple":
                switch(dir){
                    case LEFT:
                        pacman.setImage(pPacmanLeft);
                        break;
                    case UP:
                        pacman.setImage(pPacmanUp);
                        break;
                    case DOWN:
                        pacman.setImage(pPacmanDown);
                        break;
                    case RIGHT:
                        pacman.setImage(pPacmanRight);
                        break;
                }

        }
    }

    public static ImageView getPacman() {
        return pacman;
    }
}
