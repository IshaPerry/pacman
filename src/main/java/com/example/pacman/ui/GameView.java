package com.example.pacman.ui;

import javafx.animation.PauseTransition;
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
import javafx.util.Duration;

import java.util.Objects;

public class GameView extends Application {
    static final int CELL = 30;
    private static GridPane pane = new GridPane();
    private ImageView[][] cellViews;
    private static Image yPacmanRight, yPacmanLeft, yPacmanUp;
    private static Image yPacmanDown;
    private static Image bPacmanRight, bPacmanLeft, bPacmanUp, bPacmanDown;
    private static Image pPacmanRight, pPacmanLeft, pPacmanUp, pPacmanDown;
    private static Image armorRight, armorLeft, armorUp, armorDown;

    private static Image rGhostRight, rGhostLeft, rGhostUp, rGhostDown;
    private static Image pGhostRight, pGhostLeft, pGhostUp, pGhostDown;
    private static Image bGhostRight, bGhostLeft, bGhostUp, bGhostDown;
    private static Image yGhostRight, yGhostLeft, yGhostUp, yGhostDown;

    private static Image bigPellet;
    private static Image shield;
    private static Image cherry;

    private static Text scoreDisplay = new Text();
    private static Text livesDisplay = new Text();
    private static Text roundDisplay = new Text();

    private static ImageView pacman;
    private static ImageView blue;
    private static ImageView pink;
    private static ImageView red;
    private static ImageView yellow;
    private static BorderPane bp;
    private Scene scene;
    private static Stage stage;


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


        this.rGhostRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rright.gif")));
        this.rGhostLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rleft.gif")));
        this.rGhostUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rup.gif")));
        this.rGhostDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/rdown.gif")));
        this.pGhostRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pright.gif")));
        this.pGhostLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pleft.gif")));
        this.pGhostUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pup.gif")));
        this.pGhostDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pdown.gif")));
        this.bGhostRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bright.gif")));
        this.bGhostLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bleft.gif")));
        this.bGhostUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bup.gif")));
        this.bGhostDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bdown.gif")));
        this.yGhostRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/yright.gif")));
        this.yGhostLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/yleft.gif")));
        this.yGhostUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/yup.gif")));
        this.yGhostDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/ydown.gif")));

        this.bigPellet = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bigPellet.gif")));
        this.cherry = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/cherry.gif")));
        this.shield = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/shield.png")));
    }

    public void start(Stage primaryStage) {
        stage = primaryStage;
        scoreDisplay.setText("Score: " + GameModel.getScore());
        livesDisplay.setText("Lives: " + GameModel.getLives());
        //roundDisplay.setText("Round: " + GameModel.getRound());
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
                    ImageView tempPellet = new ImageView();
                    tempPellet.setImage(bigPellet);
                    tempPellet.setFitHeight(CELL);
                    tempPellet.setFitWidth(CELL);
                    pane.add(tempPellet, j, i);
                } else if (arr[i][j] == 'C') {
                    r.setFill(Color.BLACK);
                    pane.add(r, j, i);
                    ImageView tempCherry = new ImageView();
                    tempCherry.setImage(cherry);
                    tempCherry.setFitHeight(CELL);
                    tempCherry.setFitWidth(CELL);
//                    Circle pellet = new Circle(CELL / 8, Color.RED);
                    pane.add(tempCherry, j, i);
//                    pane.setAlignment(Pos.CENTER);
//                    GridPane.setHalignment(pellet, HPos.CENTER);
//                    GridPane.setValignment(pellet, VPos.CENTER);
                } else {
                    pane.add(r, j, i);
                }
            }
        }
        bp.setCenter(pane);
        pacman = new ImageView();
        blue = new ImageView();
        red = new ImageView();
        pink = new ImageView();
        yellow = new ImageView();

        String pacmanColor = GameModel.getPacmanColor();
        if (pacmanColor.equals("Yellow")) {
            pacman.setImage(yPacmanRight);
        } else if (pacmanColor.equals("Blue")) {
            pacman.setImage(bPacmanRight);
        }else {
            pacman.setImage(pPacmanRight);
        }

        blue.setImage(bGhostUp);
        red.setImage(rGhostDown);
        pink.setImage(pGhostLeft);
        yellow.setImage(yGhostRight);

        pacman.setFitHeight(CELL);
        pacman.setFitWidth(CELL);
        blue.setFitHeight(CELL);
        blue.setFitWidth(CELL);
        red.setFitHeight(CELL);
        red.setFitWidth(CELL);
        pink.setFitHeight(CELL);
        pink.setFitWidth(CELL);
        yellow.setFitHeight(CELL);
        yellow.setFitWidth(CELL);

        pane.add(pacman, GameModel.getPacmanX(), GameModel.getPacmanY());  //column, row
        pane.add(blue, GameModel.getBlueX(), GameModel.getBlueY());
        pane.add(pink, GameModel.getPinkX(), GameModel.getPinkY());
        if (GameControl.getLevel().equals("Medium")) {
            pane.add(red, GameModel.getRedX(), GameModel.getRedY());
        } else if (GameControl.getLevel().equals("Hard")){
            pane.add(red, GameModel.getRedX(), GameModel.getRedY());
            pane.add(yellow, GameModel.getYellowX(), GameModel.getYellowY());
        }


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

    public static void resetPacmanView() {
        Translate t = new Translate();
        t.setX((1 - GameModel.getPacmanX()) * CELL);
        t.setY(((GameModel.getMaze().length - 2) - GameModel.getPacmanY()) * CELL);
        orientPacman(pacman, GameModel.getPacmanColor(), GameModel.Direction.RIGHT);
        pacman.getTransforms().addAll(t);
    }

    //test
    public static void resetGhostView(int originalX, int originalY, int currentPosX, int currentPosY, String ghost) {
        Translate t = new Translate();
        switch(ghost) {
            case "blue":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY- currentPosY) * CELL);
                blue.getTransforms().addAll(t);
                break;
            case "yellow":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY- currentPosY) * CELL);
                yellow.getTransforms().addAll(t);
                break;
            case "pink":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY - currentPosY) * CELL);
                pink.getTransforms().addAll(t);
                break;
            case "red":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY- currentPosY) * CELL);
                red.getTransforms().addAll(t);
                break;

        }

    }




    public static void updateGhost(int dx, int dy, String ghost) {
        Translate t = new Translate();
        t.setX(dx * CELL);
        t.setY(dy * CELL);

        if(ghost.equals("Blue")) {
            orientBlue(dx, dy);
            blue.getTransforms().addAll(t);
        } else if (ghost.equals("Pink")) {
            orientPink(dx, dy);
            pink.getTransforms().addAll(t);
        } else if (ghost.equals("Red")){
            orientRed(dx, dy);
            red.getTransforms().addAll(t);
        } else {
            orientYellow(dx, dy);
            yellow.getTransforms().addAll(t);
        }
    }


    public static void updateDisplay(){
        scoreDisplay.setText("Score: " + GameModel.getScore());
        livesDisplay.setText("Lives: " + GameModel.getLives());
    }

    public static void removePellets() {
        ObservableList<Node> children = pane.getChildren();
        for (Node node : children) {
            if (node instanceof Circle && pane.getRowIndex(node) == GameModel.getPacmanY() && pane.getColumnIndex(node) == GameModel.getPacmanX()) {
                pane.getChildren().remove(node);
                break;
            }
         }
    }

    public static void removeImageView() {
        ObservableList<Node> children = pane.getChildren();
        for (Node node : children) {
            if (node instanceof ImageView && pane.getRowIndex(node) == GameModel.getPacmanY() && pane.getColumnIndex(node) == GameModel.getPacmanX()) {
                pane.getChildren().remove(node);
                break;
            }
        }
    }

    /**
     * If the user hits play again, remove all remaining pellets from the screen (so they don't
     * stack on top of one another)
     */
    public static void removeRemainingPellets() {
        pane.getChildren().clear();
    }

    public static Stage getStage() {
        return stage;
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

    public static void orientBlue(int dx, int dy) {
        if (dx == 1) {
            blue.setImage(bGhostRight);
        } else if (dx == -1) {
            blue.setImage(bGhostLeft);
        } else if (dy == 1) {
            blue.setImage(bGhostDown);
        } else {
            blue.setImage(bGhostUp);
        }
    }
    public static void orientRed(int dx, int dy) {
        if (dx == 1) {
            red.setImage(rGhostRight);
        } else if (dx == -1) {
            red.setImage(rGhostLeft);
        } else if (dy == 1) {
            red.setImage(rGhostDown);
        } else {
            red.setImage(rGhostUp);
        }
    }

    public static void orientPink(int dx, int dy) {
        if (dx == 1) {
            pink.setImage(pGhostRight);
        } else if (dx == -1) {
            pink.setImage(pGhostLeft);
        } else if (dy == 1) {
            pink.setImage(pGhostDown);
        } else {
            pink.setImage(pGhostUp);
        }
    }

    public static void orientYellow(int dx, int dy) {
        if (dx == 1) {
            yellow.setImage(yGhostRight);
        } else if (dx == -1) {
            yellow.setImage(yGhostLeft);
        } else if (dy == 1) {
            yellow.setImage(yGhostDown);
        } else {
            yellow.setImage(yGhostUp);
        }
    }

    public static ImageView getPacman() {
        return pacman;
    }
}
