package com.example.pacman.ui;
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
    private int newX;
    private int newY;

    public GameModel() {}

    //make pacman move
    public void movePacman(Direction dir) {
        //make sure when pacman is moving along corridor, doesnt get interrupted by button press and wall, stop moving
        newLoc(dir);
//        System.out.println(currDirection);
//        System.out.println(oldDirection);
        if (currDirection == oldDirection) {
            if (maze[newX][newY] == 'W') { //pacman is moving along same direction
                oldDirection = Direction.NONE;
                currDirection = Direction.NONE;
                System.out.println("stuck");
            } else {
                pacmanX = newX;
                pacmanY = newY;
//                System.out.println("move");
            }
        } else { // not same direction like turning when in a corridor
            System.out.println(newX + " " + newY);
            System.out.println(maze[newX][newY]);
            if (!(maze[newX][newY] == 'W')) {
                System.out.println("ey");
                pacmanY = newY;
                pacmanX = newX;
            } else {
                newLoc(oldDirection);
                if (maze[newX][newY] == 'W') {
                    oldDirection = Direction.NONE;
                    currDirection = Direction.NONE;
                } else {
                    pacmanX = newX;
                    pacmanY = newY;
                }
            }
        }
    }

    private void newLoc(Direction dir) {
        newX = pacmanX;
        newY = pacmanY;
        if (dir == Direction.LEFT) {
            newX--;
        } else if (dir == Direction.RIGHT) {
            newX++;
        } else if (dir == Direction.DOWN) {
            newY++;
        } else if (dir == Direction.UP) {
            newY--;
        }
    }

    public Direction getCurrDirection() {
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
}
