package com.example.pacman.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Pos;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Iterator;
import java.util.Objects;

import javafx.animation.*;
import javafx.util.Duration;

public class mazePane extends Application {
    private int s = 0;
    private int l = configurationControls.getLives();
    private int r = 1;
    private static GridPane pane = new GridPane();
    private Text score = new Text();
    private Text lives = new Text();
    private Text round = new Text();
    private ImageView[][] cellViews;
    private Image yPacmanRight, yPacmanLeft, yPacmanUp;
    private Image yPacmanDown;
    private Image bPacmanRight, bPacmanLeft, bPacmanUp, bPacmanDown;
    private Image pPacmanRight, pPacmanLeft, pPacmanUp, pPacmanDown;
    private ImageView yGhostRight, yGhostLeft, yGhostUp, yGhostDown;
    private ImageView rGhostRight, rGhostLeft, rGhostUp, rGhostDown;
    private ImageView pGhostRight, pGhostLeft, pGhostUp, pGhostDown;
    private ImageView bGhostRight, bGhostLeft, bGhostUp, bGhostDown;
    private boolean inGame = true;
    private int key_dx, key_dy;
    private int colPos;
    private int rowPos;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    private Direction dir;
    private char pacmanType;

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    ;
    //private Image cherry;

    public mazePane() {

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
        score.setText("Score: " + s);
        lives.setText("Lives: " + l);
        round.setText("Round " + r + "!");
        BorderPane.setAlignment(lives, Pos.BOTTOM_LEFT);
        HBox top = new HBox(score, round);
        top.setSpacing(500);
        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setBottom(lives);


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
//        int numRows = arr.length;
//        int numCols = arr[0].length;
//        System.out.println(arr[numRows - 1][numCols - 1]);
        bp.setCenter(pane);
        ImageView pacman = new ImageView();
        if (configurationControls.getPacman().equals("Yellow")) {
            pacman.setImage(yPacmanRight);
            pacmanType = 'y';
        } else if (configurationControls.getPacman().equals("Blue")) {
            pacman.setImage(bPacmanRight);
            pacmanType = 'b';
        } else {
            pacman.setImage(pPacmanRight);
            pacmanType = 'p';
        }
        pacman.setFitHeight(s);
        pacman.setFitWidth(s);
        colPos = 1;   //column
        rowPos = arr.length - 2; //row
      //  aniSprite pacMan = new aniSprite(pacman, s, s);
        System.out.println(colPos);
        System.out.println(rowPos);
        pane.add(pacman, colPos, rowPos);  //column, row
        System.out.println("col: " + pacman.getX() + "row: "+ pacman.getY());



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
                   TranslateTransition t = new TranslateTransition();

                    boolean collision = false;
                    if (e.getCode() == KeyCode.LEFT) {
                        key_dx = -1;
                        key_dy = 0;
                        collision = checkWallCollision(key_dx, key_dy, arr);
                        if (!collision) {
                            pacman.setImage(orientPacman(pacman, pacmanType, Direction.LEFT));
                            t.setByX(-s);
                            t.setNode(pacman);
                            t.play();
                        }

                    } else if (e.getCode() == KeyCode.RIGHT) {
                        key_dx = 1;
                        key_dy = 0;
                        if (! checkWallCollision(key_dx, key_dy, arr)) {
                            pacman.setImage(orientPacman(pacman, pacmanType, Direction.RIGHT));
                            t.setByX(s);
                            t.setNode(pacman);
                            t.play();
                        }
                    } else if (e.getCode() == KeyCode.DOWN) {
                        key_dx = 0;
                        key_dy = 1;
                        if (! checkWallCollision(key_dx, key_dy, arr)) {
                            pacman.setImage(orientPacman(pacman, pacmanType, Direction.DOWN));
                            t.setByY(s);
                            t.setNode(pacman);
                            t.play();
                        }
                    } else if (e.getCode() == KeyCode.UP) {
                        key_dx = 0;
                        key_dy = -1;
                        if (! checkWallCollision(key_dx, key_dy, arr)) {
                            pacman.setImage(orientPacman(pacman, pacmanType, Direction.UP));
                            t.setByY(-s);
                            t.setNode(pacman);
                            t.play();
                        }
                    }
                    if (!collision) {
                        colPos += key_dx; //update x position
                        rowPos += key_dy; //update y position
                    }
                }
            }

        });




    }

    private boolean checkWallCollision(int x, int y, char[][] arr) {
        if (arr[rowPos + y][colPos + x] == 'W') {
            return true;  //there is a wall collision
        } else if (arr[rowPos + y][colPos + x] == 'P') { //separate B later
            s += 1;
            arr[rowPos + y][colPos + x] = 'E';
            ObservableList<Node> childrens = pane.getChildren();
            for (Node node : childrens) {
                if (node instanceof Circle && pane.getRowIndex(node) == rowPos && pane.getColumnIndex(node) == colPos) {
                    pane.getChildren().remove(node);
                    break;
                }
            }

            System.out.printf("No wall, xPos: %d, YPos: %d \n", colPos, rowPos);
            return false;

        } else if (arr[rowPos + y - 1][colPos + x - 1] == 'B') {
            s += 3;
            arr[rowPos + y][colPos + x] = 'E';
        }
        return false;
    }




     private Image orientPacman(ImageView p, char type, Direction dir) {
          switch(type) {
              case 'b':
                  switch(dir){
                      case LEFT:
                          return bPacmanLeft;
                      case UP:
                          return  bPacmanUp;
                      case DOWN:
                          return bPacmanDown;
                      case RIGHT:
                          return bPacmanRight;
                  }
              case 'y':
                  switch(dir){
                      case LEFT:
                          return yPacmanLeft;
                      case UP:
                          return  yPacmanUp;
                      case DOWN:
                          return yPacmanDown;
                      case RIGHT:
                          return yPacmanRight;
                  }
              case 'p':
                  switch(dir){
                      case LEFT:
                          return pPacmanLeft;
                      case UP:
                          return  pPacmanUp;
                      case DOWN:
                          return pPacmanDown;
                      case RIGHT:
                          return pPacmanRight;
                  }

          }
          return pPacmanLeft;
    }

}





