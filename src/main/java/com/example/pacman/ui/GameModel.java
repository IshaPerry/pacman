package com.example.pacman.ui;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GameModel {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT, NONE
    }

    public enum GameState {
        WIN, LOSE, PLAYING,
    }

    // Attributes
    private static GameState gameStatus;
    private static Direction currDirection;
    private static Direction oldDirection;
    private static int pacmanOldX;
    private static int pacmanOldY;
    private static boolean safeMode = false;
    private static boolean ghostEatingMode = false;

    private static int maxPellets;
    private static int pelletsEaten;

    private static Direction blueCurrDir;
    private static Direction blueOldDir;

    private static Direction pinkCurrDir;
    private static Direction pinkOldDir;

    private static Direction redCurrDir;
    private static Direction redOldDir;

    private static Direction yellowCurrDir;
    private static Direction yellowOldDir;

    private static Integer score;
    private static Integer lives;
    private static int ghostsEaten = 0;

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
    private static int yellowX;
    private static int yellowY;
    private static int yellowDx;
    private static int yellowDy;

    private final Map<Direction, int[]> map;
    private static final Random randomDir = new Random();

    public GameModel() {
        map = new HashMap<>();
        map.put(Direction.LEFT, new int[]{-1, 0});
        map.put(Direction.RIGHT, new int[]{1, 0});
        map.put(Direction.UP, new int[]{0, -1});
        map.put(Direction.DOWN, new int[]{0, 1});
    }

    public static void generateCherry(int x, int y) {
        int cherryX = randomDir.nextInt(x);
        int cherryY = randomDir.nextInt(y);
        while (maze[cherryX][cherryY] != 'P' || (cherryX == pacmanX && cherryY == pacmanY)) {
            cherryX = randomDir.nextInt(x);
            cherryY = randomDir.nextInt(y);
        }
        maze[cherryX][cherryY] = 'C';
    }

    public static void generateShield(int x, int y) {
        int shieldX = randomDir.nextInt(x);
        int shieldY = randomDir.nextInt(y);
        while (maze[shieldX][shieldY] != 'P' || (shieldX == pacmanX && shieldY == pacmanY)) {
            shieldX = randomDir.nextInt(x);
            shieldY = randomDir.nextInt(y);
        }
        maze[shieldX][shieldY] = 'A';
    }

    public void movePacman(Direction dir) {
        pacmanOldX = pacmanX;
        pacmanOldY = pacmanY;
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
            checkPellet();
            pacmanY = pacmanY + dy;
            pacmanX = pacmanX + dx;
            GameView.updateView();
        } else {
            if (oldDirection != currDirection) {
                //keepgoing in old direction
                currDirection = oldDirection;
            }
        }
    }

    private boolean checkMaze(int dx, int dy) {
        char newPos = maze[pacmanY + dy][pacmanX + dx];
        if (newPos == 'W') {
            return true;
        }
        return false;
    }

    private void checkPellet() {
        char currPos = maze[pacmanY][pacmanX];
        if (currPos == 'P') {
            score += 1;
            pelletsEaten += 1;
            maze[pacmanY][pacmanX] = 'S';
            GameView.removePellets();
        } else if (currPos == 'B') {
            score += 1;
            ghostEatingMode = true;
            pelletsEaten += 1;
            maze[pacmanY][pacmanX] = 'S';
            GameView.removeImageView();
        } else if (currPos == 'C') {
            lives++;
            maze[pacmanY][pacmanX] = 'S';
            GameView.removeImageView();
        } else if (currPos == 'A') {
            safeMode = true;
            maze[pacmanY][pacmanX] = 'S';
            GameView.removeImageView();
        }
    }

    public void releaseGhost(String color) {
        String level = GameControl.getLevel();
        if (level.equals("Easy")) {
            if (color.equals("Blue")) {
                blueX += 2;
                blueY += 2;
                GameView.updateGhost(2, 2, "Blue");
                blueDx = -1;
                blueDy = 0;
                blueCurrDir = Direction.LEFT;
                blueOldDir = Direction.NONE;
            } else if (color.equals("Pink")) {
                pinkX += 2;
                pinkY += 2;
                GameView.updateGhost(2, 2, "Pink");
                pinkDx = -1;
                pinkDy = 0;
                pinkCurrDir = Direction.LEFT;
                pinkOldDir = Direction.NONE;
            }
        } else if (level.equals("Medium")) {
            if (color.equals("Blue")) {
                blueX += 2;
                blueY += 2;
                GameView.updateGhost(2, 2, "Blue");
                blueDx = -1;
                blueDy = 0;
                blueCurrDir = Direction.LEFT;
                blueOldDir = Direction.NONE;
            } else if (color.equals("Pink")) {
                pinkX += 2;
                pinkY += 2;
                GameView.updateGhost(2, 2, "Pink");
                pinkDx = -1;
                pinkDy = 0;
                pinkCurrDir = Direction.LEFT;
                pinkOldDir = Direction.NONE;
            } else if (color.equals("Red")){
                redY += 2;
                GameView.updateGhost(0, 2, "Red");
                redDx = -1;
                redDy = 0;
                redCurrDir = Direction.LEFT;
                redOldDir = Direction.NONE;
            }
        } else {
            if (color.equals("Blue")) {
                blueY += -1;
                GameView.updateGhost(0, -1, "Blue");
                blueDx = -1;
                blueDy = 0;
                blueCurrDir = Direction.LEFT;
                blueOldDir = Direction.NONE;
            } else if (color.equals("Pink")) {
                pinkY += -2;
                GameView.updateGhost(0, -2, "Pink");
                pinkDx = 1;
                pinkDy = 0;
                pinkCurrDir = Direction.RIGHT;
                pinkOldDir = Direction.NONE;
            } else if (color.equals("Red")) {
                redY += -1;
                GameView.updateGhost(0, -1, "Red");
                redDx = -1;
                redDy = 0;
                redCurrDir = Direction.LEFT;
                redOldDir = Direction.NONE;
            } else if (color.equals("Yellow")) {
                yellowY += -2;
                GameView.updateGhost(0, -2, "Yellow");
                yellowDx = 1;
                yellowDy = 0;
                yellowCurrDir = Direction.RIGHT;
                yellowOldDir = Direction.NONE;
            }
        }
    }

    /**
     * Algorithm #1
     * If the blue ghost collides with a wall, it's next direction is chosen at random
     * @param dir the ghost's current direction
     */
    public void moveBlueGhost(Direction dir) {
        blueOldDir = blueCurrDir;
        blueCurrDir = dir;

        char newPos = maze[blueY + blueDy][blueX + blueDx];
        char currPos = maze[blueY][blueX];
        if ((blueX == pacmanX && blueY == pacmanY) || (blueX == pacmanOldX && blueY == pacmanOldY)) {
            if (ghostEatingMode) {
                score += 10;
                ghostsEaten += 1;
                resetGhostPos("Blue");
                System.out.println("eat");
                score += 10;
                ghostsEaten += 1;
            } else if (!safeMode) {
                sendGhostsHome();
            }
        }

        if (newPos != 'W' && newPos != 'G') {
            blueX += blueDx;
            blueY += blueDy;
            GameView.updateGhost(blueDx, blueDy, "Blue");
        }
        if (newPos == 'W' || newPos == 'G') {
            newPos = currPos;
            blueOldDir = blueCurrDir;
            Direction tempDir = randomDirection(randomDir.nextInt(4), "Blue");
            if (blueOldDir != tempDir) {
                blueCurrDir = tempDir;
            } else {
                blueCurrDir = randomDirection(randomDir.nextInt(4), "Blue");
            }
        }
//        System.out.printf("BLUE X=%d, Y=%d \n", blueX, blueY);
//        System.out.println("Blue Direction: " + GameModel.getBlueCurrDir());
//        System.out.println("PACMAN X=" + pacmanX + " Y=" + pacmanY);
    }

    /**
     * Algorithm #2
     * If the pink ghost collides with a wall, it's next direction is chosen at random.
     * If the pink ghost is in the same row/column as pacman, it will change
     * its direction to start following pacman
     * @param dir the ghost's current direction
     */
    public void movePinkGhost(Direction dir) {
        pinkOldDir = pinkCurrDir;
        pinkCurrDir = dir;

        // Pink ghost & pacman are in the same row
        if (pinkY == pacmanY) {
            // If pacman is to the left of ghost, move left
            if (pacmanX < pinkX) {
                if (!ghostEatingMode) {
                    pinkCurrDir = Direction.LEFT;
                    pinkDx = -1;
                    pinkDy = 0;
                } else {
                    pinkCurrDir = Direction.RIGHT;
                    pinkDx = 1;
                    pinkDy = 0;
                }
            // If pacman is to the right of ghost, move right
            } else {
                if (!ghostEatingMode) {
                    pinkCurrDir = Direction.RIGHT;
                    pinkDx = 1;
                    pinkDy = 0;
                } else {
                    pinkCurrDir = Direction.LEFT;
                    pinkDx = -1;
                    pinkDy = 0;
                }
            }
        }
        // Pink ghost & pacman are in the same column
        else if (pinkX == pacmanX) {
            // If pacman is above the ghost, move up
            if (pacmanY < pinkY) {
                if (!ghostEatingMode) {
                    pinkCurrDir =  Direction.UP;
                    pinkDy = -1;
                    pinkDx = 0;
                } else {
                    pinkCurrDir =  Direction.DOWN;
                    pinkDy = 1;
                    pinkDx = 0;
                }
            // If pacman is below the ghost, move down
            } else {
                if (!ghostEatingMode) {
                    pinkCurrDir = Direction.DOWN;
                    pinkDy = 1;
                    pinkDx = 0;
                } else {
                    pinkCurrDir = Direction.UP;
                    pinkDy = -1;
                    pinkDx = 0;
                }
            }
        }

        char currPos = maze[pinkY][pinkX];
        char newPos = maze[pinkY + pinkDy][pinkX + pinkDx];

        if ((pinkX == pacmanX && pinkY == pacmanY) || (pinkX == pacmanOldX && pinkY == pacmanOldY)) {
            if (ghostEatingMode) {
                score += 10;
                ghostsEaten += 1;
                resetGhostPos("Pink");
                System.out.println("eat");
                score += 10;
                ghostsEaten += 1;
            } else if (!safeMode) {
                sendGhostsHome();
            }
        }

        if (newPos != 'W' && newPos != 'G') {
            pinkX += pinkDx;
            pinkY += pinkDy;
            GameView.updateGhost(pinkDx, pinkDy, "Pink");
        }
        if (newPos == 'W' || newPos == 'G') {
            newPos = currPos;
//            System.out.println("Hit a wall");
            pinkOldDir = pinkCurrDir;
            Direction tempDir = randomDirection(randomDir.nextInt(4), "Pink");
            if (pinkOldDir != tempDir) {
                pinkCurrDir = tempDir;
            } else {
                pinkCurrDir = randomDirection(randomDir.nextInt(4), "Pink");
            }
        }
    }

    /**
     * Algorithm #3
     * If the red ghost collides with a wall, it's next direction is chosen depending on
     * a probability threshold called epsilon.
     * If epsilon is greater than a randomly generated number between [0,1]
     * the ghost moves in the direction that has the smallest distance to pacman
     * using a heuristic of manhattan distance.
     * Otherwise, the ghost moves randomly.
     * @param dir the ghost's current direction
     */
    public void moveRedGhost(Direction dir) {
        redDx = map.get(redCurrDir)[0];
        redDy = map.get(redCurrDir)[1];
        redOldDir = redCurrDir;
        redCurrDir = dir;

        char newPos = maze[redY + redDy][redX + redDx];
        if ((redX == pacmanX && redY == pacmanY) || (redX == pacmanOldX && redY == pacmanOldY)) {
            if (ghostEatingMode) {
                score += 10;
                ghostsEaten += 1;
                resetGhostPos("Red");
                System.out.println("eat");
                score += 10;
                ghostsEaten += 1;
            } else if (!safeMode) {
                sendGhostsHome();
            }
        }

        if (newPos != 'W' && newPos != 'G') {
            redX += redDx;
            redY += redDy;
            GameView.updateGhost(redDx, redDy, "Red");
        }
        if (newPos == 'W' || newPos == 'G') {
            double epsilon = 0.40;
            Random rd = new Random();
            // The red ghost moves towards pacman {epsilon}% of the time
            if (epsilon > rd.nextDouble()) {
                Direction tempDir = redOldDir;
                int minDistance = Integer.MAX_VALUE;
                redOldDir = redCurrDir;
                for (Map.Entry<Direction, int[]> entry : map.entrySet()) {
                    Direction potentialDirection = entry.getKey();
                    int[] displacement = entry.getValue();
                    int potentialX = redX + displacement[0];
                    int potentialY = redY + displacement[1];
                    // Use manhattan distance as a heuristic
                    int heuristic = Math.abs(potentialX-pacmanX) + Math.abs(potentialY-pacmanY);
                    if (heuristic < minDistance && potentialDirection != redOldDir && maze[potentialY][potentialX] != 'W') {
                        tempDir = potentialDirection;
                    }
                }
                redCurrDir = tempDir;
            // The red ghost moves randomly {1 - epsilon}% of the time
            } else {
                redOldDir = redCurrDir;
                Direction tempDir = randomDirection(randomDir.nextInt(4), "Red");
                if (redOldDir != tempDir) {
                    redCurrDir = tempDir;
                } else {
                    redCurrDir = randomDirection(randomDir.nextInt(4), "Red");
                }
            }
        }
    }

    public void moveYellowGhost(Direction dir) {
        yellowOldDir = yellowCurrDir;
        yellowCurrDir = dir;

        if (yellowY == pacmanY) {
            if (pacmanX < yellowX) {
                yellowCurrDir = Direction.LEFT;
                yellowDx = -1;
                yellowDy = 0;
            } else {
                yellowCurrDir = Direction.RIGHT;
                yellowDx = 1;
                yellowDy = 0;
            }
        } else if (yellowX == pacmanX) {
            if (pacmanY < yellowY) {
                yellowCurrDir =  Direction.UP;
                yellowDy = -1;
                yellowDx = 0;
            } else {
                yellowCurrDir = Direction.DOWN;
                yellowDy = 1;
                yellowDx = 0;
            }
        }

        char currPos = maze[yellowY][yellowX];
        char newPos = maze[yellowY + yellowDy][yellowX + yellowDx];

        if ((yellowX == pacmanX && yellowY == pacmanY) || (yellowX == pacmanOldX && yellowY == pacmanOldY)) {
            if (ghostEatingMode) {
                score += 10;
                ghostsEaten += 1;
                resetGhostPos("Yellow");
                System.out.println("eat");
                score += 10;
                ghostsEaten += 1;
            } else if (!safeMode) {
                sendGhostsHome();
            }
        }

        if (newPos != 'W') {
            yellowX += yellowDx;
            yellowY += yellowDy;
            GameView.updateGhost(yellowDx, yellowDy, "Yellow");
        }
        if (newPos == 'W') {
            newPos = currPos;
            System.out.println("Hit a wall");
            yellowOldDir = yellowCurrDir;
            Direction tempDir = randomDirection(randomDir.nextInt(4), "Yellow");
            if (yellowOldDir != tempDir) {
                yellowCurrDir = tempDir;
            } else {
                yellowCurrDir = randomDirection(randomDir.nextInt(4), "Yellow");
            }
        }
    }

    public Direction randomDirection(int x, String color) {
        if (x == 0) {
            if (color.equals("Blue")) {
                blueDx = -1;
                blueDy = 0;
                return Direction.LEFT;
            } else if (color.equals("Pink")) {
                pinkDx = -1;
                pinkDy = 0;
                return Direction.LEFT;
            } else if (color.equals("Red")){
                redDx = -1;
                redDy = 0;
                return Direction.LEFT;
            } else {
                yellowDx = -1;
                yellowDy = 0;
                return Direction.LEFT;
            }
        } else if (x == 1) {
            if (color.equals("Blue")) {
                blueDx = 1;
                blueDy = 0;
                return Direction.RIGHT;
            } else if (color.equals("Pink")) {
                pinkDx = 1;
                pinkDy = 0;
                return Direction.RIGHT;
            } else if (color.equals("Red")){
                redDx = 1;
                redDy = 0;
                return Direction.RIGHT;
            } else {
                yellowDx = 1;
                yellowDy = 0;
                return Direction.RIGHT;
            }
        } else if (x == 2) {
            if (color.equals("Blue")) {
                blueDy = -1;
                blueDx = 0;
                return Direction.UP;
            } else if (color.equals("Pink")) {
                pinkDy = -1;
                pinkDx = 0;
                return Direction.UP;
            } else if (color.equals("Red")){
                redDy = -1;
                redDx = 0;
                return Direction.UP;
            } else {
                yellowDy = -1;
                yellowDx = 0;
                return Direction.UP;
            }
        } else {
            if (color.equals("Blue")) {
                blueDy = 1;
                blueDx = 0;
                return Direction.DOWN;
            } else if (color.equals("Pink")) {
                pinkDy = 1;
                pinkDx = 0;
                return Direction.DOWN;
            } else if (color.equals("Red")){
                redDy = 1;
                redDx = 0;
                return Direction.DOWN;
            } else {
                yellowDy = 1;
                yellowDx = 0;
                return Direction.DOWN;
            }
        }
    }

    public void checkGameStatus() throws IOException {
        URL location = getClass().getResource("/gameOver.fxml");
        if (pelletsEaten == maxPellets) {
            setGameStatus(GameState.WIN);
        } else if (lives == 0) {
            setGameStatus(GameState.LOSE);
        }
        if (gameStatus == GameState.WIN) {
            GameView.removeRemainingPellets();
            GameControl.getTimer().cancel();
            gameOverControls.changeScene(GameView.getStage());
        } else if (gameStatus == GameState.LOSE) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameOverControls.fxml"));

            GameControl.getTimer().cancel();
            gameOverControls.changeScene(GameView.getStage());
            GameView.removeRemainingPellets();
        }
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

    public static void setMaze(char[][] newMaze) {
        maze = newMaze;
        pacmanX = 1;
        pacmanY = maze.length - 2;
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
            yellowX = 10;
            yellowY = 10;
        }
    }

    public static void sendGhostsHome() {
        GameControl.setGameTimer(0);
        resetGhostPos("Blue");
        resetGhostPos("Pink");
        if (!GameControl.getLevel().equals("Easy")) {
            resetGhostPos("Red");
        }
        if (GameControl.getLevel().equals("Hard")) {
            resetGhostPos("Yellow");
        }
        lives -= 1;
        GameView.updateDisplay();
        if (!ghostEatingMode) {
            GameView.resetPacmanView();
            pacmanX = 1;
            pacmanY = maze.length - 2;
        }
    }

    public static void resetGhostPos(String ghost) {
        int originalX = 0;
        int originalY = 0;
        int currX =  0;
        int currY = 0;
        if (GameControl.getLevel().equals("Easy")) {
            switch(ghost) {
                case "Blue":
                    originalX = 9;
                    originalY = 1;
                    currX = blueX;
                    currY = blueY;
                    blueX = 9;
                    blueY = 1;
                    blueDx = 0;
                    blueDy = 0;
                    blueCurrDir = Direction.NONE;
                    GameControl.setBlueReleased(false);
                    GameControl.setBlueTimer(0);
                    break;
                case "Pink":
                    originalX = 12;
                    originalY = 1;
                    currX = pinkX;
                    currY = pinkY;
                    pinkX = 12;
                    pinkY = 1;
                    pinkDx = 0;
                    pinkDy = 0;
                    pinkCurrDir = Direction.NONE;
                    GameControl.setPinkReleased(false);
                    GameControl.setPinkTimer(0);
                    break;
                case "Red":
                    originalX = 15;
                    originalY = 1;
                    currX = redX;
                    currY = redY;
                    redX = 15;
                    redY = 1;
                    redDx = 0;
                    redDy = 0;
                    GameControl.setRedReleased(false);
                    GameControl.setRedTimer(0);
                    break;
            }

        } else if (GameControl.getLevel().equals("Medium")) {
            switch(ghost) {
                case "Blue":
                    originalX = 8;
                    originalY = 5;
                    currX = blueX;
                    currY = blueY;
                    blueX = 8;
                    blueY = 5;
                    blueX = 8;
                    blueY = 5;
                    blueDx = 0;
                    blueDy = 0;
                    blueCurrDir = Direction.NONE;
                    GameControl.setBlueReleased(false);
                    GameControl.setBlueTimer(0);
                    break;
                case "Pink":
                    originalX = 9;
                    originalY = 5;
                    currX = pinkX;
                    currY = pinkY;
                    pinkX = 9;
                    pinkY = 5;
                    pinkDx = 0;
                    pinkDy = 0;
                    pinkCurrDir = Direction.NONE;
                    GameControl.setPinkReleased(false);
                    GameControl.setPinkTimer(0);
                    break;
                case "Red":
                    originalX = 11;
                    originalY = 5;
                    currX = redX;
                    currY = redY;
                    redX = 11;
                    redY = 5;
                    redDx = 0;
                    redDy = 0;
                    GameControl.setRedReleased(false);
                    GameControl.setRedTimer(0);
                    break;
            }
        } else {
            switch(ghost) {
                case "Blue":
                    originalX = 8;
                    originalY = 9;
                    currX = blueX;
                    currY = blueY;
                    blueX = 8;
                    blueY = 9;
                    blueDx = 0;
                    blueDy = 0;
                    blueCurrDir = Direction.NONE;
                    GameControl.setBlueReleased(false);
                    GameControl.setBlueTimer(0);
                    break;
                case "Pink":
                    originalX = 9;
                    originalY = 10;
                    currX = pinkX;
                    currY = pinkY;
                    pinkX = 9;
                    pinkY = 10;
                    pinkDx = 0;
                    pinkDy = 0;
                    pinkCurrDir = Direction.NONE;
                    GameControl.setPinkReleased(false);
                    GameControl.setPinkTimer(0);
                    break;
                case "Red":
                    originalX = 10;
                    originalY = 9;
                    currX = redX;
                    currY = redY;
                    redX = 10;
                    redY = 9;
                    redDx = 0;
                    redDy = 0;
                    GameControl.setRedReleased(false);
                    GameControl.setRedTimer(0);
                    break;
                case "Yellow":
                    originalX = 10;
                    originalY = 10;
                    currX = yellowX;
                    currY = yellowY;
                    yellowX = 10;
                    yellowY = 10;
                    yellowDx = 0;
                    yellowDy = 0;
                    GameControl.setYellowReleased(false);
                    GameControl.setYellowTimer(0);
                    break;
            }

        }
        GameView.resetGhostView(originalX, originalY, currX, currY, ghost);

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

    public static int getYellowX() {
        return yellowX;
    }

    public static int getYellowY() {
        return yellowY;
    }

    public static void setGameStatus(GameState state) {
        gameStatus = state;
    }

    public static GameState getGameStatus() {
        return gameStatus;
    }

    public static void setMaxPellets(int numPellets) {
        maxPellets = numPellets;
    }

    public static Direction getBlueCurrDir() {
        return blueCurrDir;
    }

    public static Direction getPinkCurrDir() {
        return pinkCurrDir;
    }

    public static Direction getRedCurrDir() {
        return redCurrDir;
    }

    public static Direction getYellowCurrDir() {
        return yellowCurrDir;
    }

    public static boolean getSafeMode() {
        return safeMode;
    }

    public static void setSafeMode(boolean x) {
        safeMode = x;
    }

    public static boolean getGhostEatingMode() {
        return ghostEatingMode;
    }

    public static void setGhostEatingMode(boolean x) {
        ghostEatingMode = x;
    }

    public static void setPelletsEaten(int x) {
        pelletsEaten = 0;
    }

    public static void setGhostsEaten(int x) {
        ghostsEaten = 0;
    }

    public static int getGhostsEaten() {
        return ghostsEaten;
    }
}
