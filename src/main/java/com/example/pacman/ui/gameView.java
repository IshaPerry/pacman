package com.example.pacman.ui;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class gameView extends Group {
    public final static double CELL_WIDTH = 10.0;

    @FXML
    private int rows;
    @FXML
    private int columns;
    private ImageView[][] cellViews;
    private Image pacmanRight;
    private Image pacmanLeft;
    private Image pacmanUp;
    private Image pacmanDown;
    private Image yGhostRight;
    private Image yGhostLeft;
    private Image yGhostUp;
    private Image yGhostDown;
    private Image rGhostRight;
    private Image rGhostLeft;
    private Image rGhostUp;
    private Image rGhostDown;
    private Image pGhostRight;
    private Image pGhostLeft;
    private Image pGhostUp;
    private Image pGhostDown;
    private Image bGhostRight;
    private Image bGhostLeft;
    private Image bGhostUp;
    private Image bGhostDown;
    private Image bigPellet;
    private Image smallPellet;
    private Image cherry;

    /**
     * Initializes the values of the image instance variables
     */
    public gameView() {
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
        //this.bigPellet = new Image();
        //this.smallPellet = new Image();
        //this.cherry = new Image();
    }

    /**
     * Constructs the maze
     */
    private void initializeMaze() {
        if (this.rows > 0 && this.columns > 0) {
            this.cellViews = new ImageView[this.rows][this.columns];
            for (int row = 0; row < this.rows; row++) {
                for (int column = 0; column < this.columns; column++) {
                    ImageView imageView = new ImageView();
                    imageView.setX((double) column * CELL_WIDTH);
                    imageView.setY((double) row * CELL_WIDTH);
                    imageView.setFitWidth(CELL_WIDTH);
                    imageView.setFitHeight(CELL_WIDTH);
                    this.cellViews[row][column] = imageView;
                    this.getChildren().add(imageView);
                }
            }
        }
    }
}
