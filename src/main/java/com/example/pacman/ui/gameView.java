package com.example.pacman.ui;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;

public class gameView extends Group {
    public final static double CELL_WIDTH = 10.0;

    public enum programState {
        START, INSTR, GAME, WIN, LOSE, PAUSE
    };

    programState state;
    private Timer timer;

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
     * put switch statement for state classes?
     */
    public void main() {
        while (true) {
            switch (state) {
                case START: start();
                    break;
                case INSTR: instr();
                    break;
                case PAUSE: pause();
                    break;
                case GAME: game();
                    break;
                case WIN: win();
                    break;
                case LOSE: lose();
                    break;
            }
        }
    }
//    private void update(gamelogic gl){}
    public void pause() {
        this.timer.cancel();
        state = programState.PAUSE;
    }

    public void start() {}

    public void game() {}
    public void instr() {}
    public void win(){}
    public void lose(){}
}