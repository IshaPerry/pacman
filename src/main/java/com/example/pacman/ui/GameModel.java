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
        }
        System.out.println("dx=" + dx + " dy=" + dy);
        System.out.println("X=" + pacmanX + " Y=" + pacmanY);
    }

    private boolean checkWallCollision(int dx, int dy) {
        return maze[pacmanY + dy][pacmanX + dx] == 'W';
    }

//    private boolean checkWallCollision(int x, int y, char[][] arr) {
//        if (arr[rowPos + y][colPos + x] == 'W') {
//            System.out.printf("Hit a wall, xPos: %d, YPos: %d \n", colPos + x, rowPos);
//            return true;  //there is a wall collision
//        } else if (arr[rowPos + y][colPos + x] == 'P') { //separate B later
//            s += 1;
//            arr[rowPos + y][colPos + x] = 'E';
//            ObservableList<Node> childrens = pane.getChildren();
//            for (Node node : childrens) {
//                if (node instanceof Circle && pane.getRowIndex(node) == rowPos && pane.getColumnIndex(node) == colPos) {
//                    pane.getChildren().remove(node);
//                    break;
//                }
//            }
//
//            System.out.printf("No wall, xPos: %d, YPos: %d \n", colPos, rowPos);
//            return false;
//
//        } else if (arr[rowPos + y - 1][colPos + x - 1] == 'B') {
//            s += 3;
//            arr[rowPos + y][colPos + x] = 'E';
//        }
//        return false;
//    }
    //make pacman move
//    public void movePacman(Direction dir) {
//        //make sure when pacman is moving along corridor, doesn't get interrupted by button press and wall, stop moving
//
//        newLoc(dir);
//        if (currDirection == oldDirection) {
//            if (maze[newX][newY] == 'W') { //pacman is moving along same direction
//                oldDirection = Direction.NONE;
//                currDirection = Direction.NONE;
//                System.out.println("stuck");
//            } else {
//                pacmanX = newX;
//                pacmanY = newY;
//                System.out.println("newX=" + newX + " newY=" + newY);
//                System.out.println("X=" + pacmanX + " Y=" + pacmanY);
//            }
//        } else { // not same direction like turning when in a corridor
//            System.out.println(maze[newX][newY]);
//            if (!(maze[newX][newY] == 'W')) {
//                pacmanY = newY;
//                pacmanX = newX;
//            } else {
//                newLoc(oldDirection);
//                if (maze[newX][newY] == 'W') {
//                    oldDirection = Direction.NONE;
//                    currDirection = Direction.NONE;
//                } else {
//                    pacmanX = newX;
//                    pacmanY = newY;
//                }
//            }
//        }
////        System.out.println("newX=" + newX + " newY=" + newY);
////        System.out.println("X=" + pacmanX + " Y=" + pacmanY);
//    }

//    private void newLoc(Direction dir) {
//        newX = pacmanX;
//        newY = pacmanY;
//        if (dir == Direction.LEFT) {
//            newX--;
//        } else if (dir == Direction.RIGHT) {
//            newX++;
//        } else if (dir == Direction.DOWN) {
//            newY++;
//        } else if (dir == Direction.UP) {
//            newY--;
//        }
//        System.out.println("newX=" + newX + " newY=" + newY);
//        System.out.println("X=" + pacmanX + " Y=" + pacmanY);
//    }

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

    public static int getDx() {
        return dx;
    }

    public static int getDy() {
        return dy;
    }
}
