package com.example.pacman.ui;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
    private static Image yPacmanRight, yPacmanLeft, yPacmanUp, yPacmanDown, yLives;
    private static Image bPacmanRight, bPacmanLeft, bPacmanUp, bPacmanDown, bLives;
    private static Image pPacmanRight, pPacmanLeft, pPacmanUp, pPacmanDown, pLives;
    private static Image armorRight, armorLeft, armorUp, armorDown;

    private static Image rGhostRight, rGhostLeft, rGhostUp, rGhostDown;
    private static Image pGhostRight, pGhostLeft, pGhostUp, pGhostDown;
    private static Image bGhostRight, bGhostLeft, bGhostUp, bGhostDown;
    private static Image yGhostRight, yGhostLeft, yGhostUp, yGhostDown;
    private static Image scaredGhost, flash;

    private static Image bigPellet;
    private static Image shield;
    private static Image cherry;

    private static Text scoreDisplay = new Text();
    private static HBox lifeBox = new HBox();

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
        this.armorRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sright.gif")));
        this.armorUp = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sup.gif")));
        this.armorDown = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sdown.gif")));
        this.armorLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sleft.gif")));

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
        this.scaredGhost = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/scared.gif")));
        this.flash = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/flash.gif")));

        this.bigPellet = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bigPellet.gif")));
        this.cherry = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/cherry.gif")));
        this.shield = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/shield.png")));
        this.yLives = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/ylives.png")));
        this.pLives = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/plives.png")));
        this.bLives = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blives.png")));
    }

    public void start(Stage primaryStage) {
        stage = primaryStage;
        bp = new BorderPane();
        bp.setStyle("-fx-background-color: black;");
        HBox top = new HBox();
        top.setPrefHeight(CELL);
        bp.setTop(top);

        VBox left = new VBox();
        left.setPrefWidth(CELL);
        bp.setLeft(left);

        VBox right = new VBox();
        right.setPrefWidth(CELL);
        bp.setRight(right);

        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        String pacmanColor = GameModel.getPacmanColor();
        for (int i = 0; i < 3; i++) {
            ImageView lifeImage = new ImageView();
            lifeImage.setFitHeight(CELL);
            lifeImage.setFitWidth(CELL);
            if (pacmanColor.equals("Yellow")) {
                lifeImage.setImage(yLives);
            } else if (pacmanColor.equals("Blue")) {
                lifeImage.setImage(bLives);
            } else {
                lifeImage.setImage(pLives);
            }
            lifeBox.getChildren().add(lifeImage);
        }
        scoreDisplay.setText("SCORE: " + GameModel.getScore());
        scoreDisplay.setFill(Color.WHITE);
        scoreDisplay.setStyle("-fx-font-size: 14;");
        HBox bottom = new HBox(lifeBox, region, scoreDisplay);
        bottom.setPadding(new Insets(0, CELL, 0, CELL));
        bottom.setPrefHeight(CELL);
        bp.setBottom(bottom);

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
                    pane.add(tempCherry, j, i);
                } else if (arr[i][j] == 'A') {
                    r.setFill(Color.BLACK);
                    pane.add(r, j, i);
                    ImageView tempShield = new ImageView();
                    tempShield.setImage(shield);
                    tempShield.setFitHeight(CELL);
                    tempShield.setFitWidth(CELL);
                    pane.add(tempShield, j, i);
                }else {
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
        scene.getStylesheets().add(this.getClass().getResource("/style.css").toExternalForm());
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
            case "Blue":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY- currentPosY) * CELL);
                blue.getTransforms().addAll(t);
                break;
            case "Yellow":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY- currentPosY) * CELL);
                yellow.getTransforms().addAll(t);
                break;
            case "Pink":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY - currentPosY) * CELL);
                pink.getTransforms().addAll(t);
                break;
            case "Red":
                t.setX((originalX - currentPosX) * CELL);
                t.setY((originalY- currentPosY) * CELL);
                red.getTransforms().addAll(t);
                break;

        }

    }







    public static void updateGhost(int dx, int dy, String ghost) {
        int timeElapsed = GameControl.getGhostEatingTimer();
        Translate t = new Translate();
        t.setX(dx * CELL);
        t.setY(dy * CELL);
        if(ghost.equals("Blue")) {
            if(!(GameModel.getGhostEatingMode())) {
                orientBlue(dx, dy);
            } else if (timeElapsed > 15){
                blue.setImage(flash);
            } else {
                blue.setImage(scaredGhost);
            }
            blue.getTransforms().addAll(t);
        } else if (ghost.equals("Pink")) {
            if (!(GameModel.getGhostEatingMode())) {
                orientPink(dx, dy);
            } else if (timeElapsed > 15){
                pink.setImage(flash);
            } else {
                pink.setImage(scaredGhost);
            }
            pink.getTransforms().addAll(t);
        } else if (ghost.equals("Red")){
            if (!(GameModel.getGhostEatingMode())) {
                orientRed(dx, dy);
            } else if (timeElapsed > 15){
                red.setImage(flash);
            } else {
                red.setImage(scaredGhost);
            }
            red.getTransforms().addAll(t);
        } else {
            if (!(GameModel.getGhostEatingMode())) {
                orientYellow(dx, dy);
            } else if (timeElapsed > 15){
                yellow.setImage(flash);
            } else {
                yellow.setImage(scaredGhost);
            }
            yellow.getTransforms().addAll(t);
        }
    }


    public static void updateDisplay(){
        scoreDisplay.setText("SCORE: " + GameModel.getScore());
        lifeBox.getChildren().clear();
        String pacmanColor = GameModel.getPacmanColor();
        for (int i = 0; i < GameModel.getLives(); i++) {
            ImageView lifeImage = new ImageView();
            lifeImage.setFitHeight(CELL);
            lifeImage.setFitWidth(CELL);
            if (pacmanColor.equals("Yellow")) {
                lifeImage.setImage(yLives);
            } else if (pacmanColor.equals("Blue")) {
                lifeImage.setImage(bLives);
            } else {
                lifeImage.setImage(pLives);
            }
            lifeBox.getChildren().add(lifeImage);
        }
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
        if (!GameModel.getSafeMode()) {
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
        } else {
            switch(dir) {
                case LEFT:
                    pacman.setImage(armorLeft);
                    break;
                case UP:
                    pacman.setImage(armorUp);
                    break;
                case DOWN:
                    pacman.setImage(armorDown);
                    break;
                case RIGHT:
                    pacman.setImage(armorRight);
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
