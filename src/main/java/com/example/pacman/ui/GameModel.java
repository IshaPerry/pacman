package com.example.pacman.ui;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

import javax.sound.midi.Soundbank;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class GameModel {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT, NONE
    };

    public enum GameState {
        WIN, LOSE, PLAYING
    };
    // Attributes
    private static GameState gameStatus;
    private static Direction currDirection;
    private static Direction oldDirection;
    private static Integer score;
    private static Integer lives;
    private static Integer round;
    private static String pacmanColor;
    private static char[][] maze;
    private static int pacmanX;
    private static int pacmanY;
    private static int dx;
    private static int dy;
    private static int blueX;
    private static int blueY;
    private static int pinkX;
    private static int pinkY;
    private static int redX;
    private static int redY;
    private static int blueDx;
    private static int blueDy;
    private static int redDx;
    private static int redDy;
    private static int pinkDx;
    private static int pinkDy;

    public GameModel() {}

    public void movePacman(Direction dir) {
        oldDirection = currDirection;
        currDirection = dir;
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
        boolean collision = checkMaze(dx, dy);
        if (!collision) {
            // Now check for wraparound
            pacmanY = pacmanY + dy;
            pacmanX = pacmanX + dx;
            GameView.updateView();
        } else {
            if (oldDirection != currDirection) {
                //keepgoing in old direction
                currDirection = oldDirection;
            }
        }
        System.out.println("X=" + pacmanX + " Y=" + pacmanY);
    }

    private boolean checkMaze(int dx, int dy) {
        char newPos = maze[pacmanY + dy][pacmanX + dx];
        char currPos = maze[pacmanY][pacmanX];
        if (newPos == 'W') {
            return true;
        } else if (currPos == 'P') {
            score += 1;
            maze[pacmanY][pacmanX] = 'S';
            GameView.removePellets();
        } else if (currPos == 'B') {
            score += 5;
            maze[pacmanY][pacmanX] = 'S';
            GameView.removePellets();
        }
        return false;
    }

    public void checkGameStatus() throws MalformedURLException {
        URL location = getClass().getResource("/gameOver.fxml");
        if (gameStatus == GameState.WIN) {
            gameOverControls.changeScene(GameView.getStage(), location, "Congrats, you won!");
            GameControl.getTimer().cancel();
        } else if (gameStatus == GameState.LOSE) {
            gameOverControls.changeScene(GameView.getStage(), location, "Sorry, you lost!");
            GameControl.getTimer().cancel();
        } else {
            return;
        }
    }

    public void testGameOver() {
        gameStatus = GameState.WIN;
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

    public static char[][] getMaze() {
        return maze;
    }

    public char getMazeID(int i, int j) {
        return this.maze[i][j];
    }

    public void setMaze(char[][] newMaze) {
        maze = newMaze;
        pacmanX = 1;   //column
        pacmanY = maze.length - 2; //row
        String level = GameControl.getLevel();
        if (level.equals("Easy")) {
            blueX = 9;
            blueY = 1;
            pinkX = 12;
            pinkY = 1;
            redX = 15;
            redY = 1;
        } else if (level.equals("Medium")) {
            blueX = 8;
            blueY = 5;
            pinkX = 9;
            pinkY = 5;
            redX = 11;
            redY = 5;
        } else {
            blueX = 8;
            blueY = 9;
            pinkX = 9;
            pinkY = 10;
            redX = 10;
            redY = 9;
        }
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

    public static Integer getRound() {
        return round;
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

    public void setRound(Integer newRound) {
        round = newRound;
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

    public static int getBlueX() {
        return blueX;
    }

    public static int getBlueY() {
        return blueY;
    }

    public static int getPinkX() {
        return pinkX;
    }

    public static int getPinkY() {
        return pinkY;
    }

    public static int getRedX() {
        return redX;
    }

    public static int getRedY() {
        return redY;
    }

    public static int getBlueDX() {
        return blueDx;
    }

    public static int getBlueDY() {
        return blueDy;
    }

    public static int getPinkDX() {
        return pinkDx;
    }

    public static int getPinkDY() {
        return pinkDy;
    }

    public static int getRedDX() {
        return redDx;
    }

    public static int getRedDY() {
        return redDy;
    }

    public static void setGameStatus(GameState state) {
        gameStatus = state;
    }

    public GameState getGameStatus() {
        return gameStatus;
    }
}
