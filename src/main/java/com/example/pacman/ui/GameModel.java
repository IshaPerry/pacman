package com.example.pacman.ui;

public class GameModel {
    public enum Direction {
        UP, DOWN, LEFT, RIGHT, NONE
    };
    // Attributes
    private Direction currDirection;
    private static Integer score;
    private static Integer lives;
    private static String pacmanColor;
    private char[][] maze;

    public Direction getCurrDirection() {
        return currDirection;
    }

    public void setCurrDirection(Direction dir) {
        this.currDirection = dir;
    }

    public char[][] getMaze() {
        return this.maze;
    }

    public void setMaze(char[][] maze) {
        this.maze = maze;
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
}
