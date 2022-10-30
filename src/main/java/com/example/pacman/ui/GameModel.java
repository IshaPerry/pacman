package com.example.pacman.ui;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

import javax.sound.midi.Soundbank;
import java.util.*;

public class GameModel {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT, NONE
    };
    // Attributes
    private static Direction currDirection;
    private static Direction oldDirection;
    private static Integer score;
    private static Integer lives;
    private static String pacmanColor;
    private char[][] maze;
    private static int pacmanX;
    private static int pacmanY;
    private static int dx;
    private static int dy;

    public GameModel() {}

    public void movePacman(Direction dir) {
        dx = 0;
        dy = 0;
        if (dir == Direction.LEFT) {
            dx = -1;
        } else if (dir == Direction.RIGHT) {
            dx = 1;
        } else if (dir == Direction.DOWN) {
            dy = 1;
        } else if (dir == Direction.UP) {
            dy = -1;
        }
        boolean collision = checkWallCollision(dx, dy);
        if (!collision) {
            pacmanX = pacmanX + dx;
            pacmanY = pacmanY + dy;
            System.out.println("No collision");
            GameView.updateView();
        }
        System.out.println("X=" + pacmanX + " Y=" + pacmanY);
    }

    private boolean checkWallCollision(int dx, int dy) {
        return maze[pacmanY + dy][pacmanX + dx] == 'W';
    }

    public static Direction getCurrDirection() {
        return currDirection;
    }

    public static void setCurrDirection(Direction dir) {
        oldDirection = currDirection;
        currDirection = dir;
    }
    public static void setOldDirection(Direction dir) {
        oldDirection = dir;
    }

    public char[][] getMaze() {
        return this.maze;
    }

    public char getMazeID(int i, int j) {
        return this.maze[i][j];
    }

    public void setMaze(char[][] maze) {
        this.maze = maze;
        pacmanX = 1;   //column
        pacmanY = maze.length - 2; //row
    }

    public static String getPacmanColor() {
        return pacmanColor;
    }

    public void setPacmanColor(String color) {
        pacmanColor = color;
    }

    public static Integer getScore() {
        return score;
    }

    public void setScore(Integer newScore) {
        score = newScore;
    }

    public static Integer getLives() {
        return lives;
    }

    public void setLives(Integer newLives) {
        lives = newLives;
    }

    public static int getPacmanX() {
        return pacmanX;
    }

    public static int getPacmanY() {
        return pacmanY;
    }

    public static int getDx() {
        return dx;
    }

    public static int getDy() {
        return dy;
    }
}
