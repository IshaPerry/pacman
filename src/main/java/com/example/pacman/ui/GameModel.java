package com.example.pacman.ui;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class GameModel {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT, NONE
    }

    public enum GameState {
        WIN, LOSE, PLAYING
    }

    // Attributes
    private static GameState gameStatus;
    private static Direction currDirection;
    private static Direction oldDirection;
    private static int pacmanOldX;
    private static int pacmanOldY;
    private static boolean safeMode = false;

    private static int maxScore;


    private static Direction blueCurrDir;
    private static Direction blueOldDir;

    private static Direction pinkCurrDir;
    private static Direction pinkOldDir;

    private static Direction redCurrDir;
    private static Direction redOldDir;

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

    private static int rowCount;
    private static int columnCount;


    Random randomDir = new Random();

    public GameModel() {
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
            // Now check for wraparound
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
            maze[pacmanY][pacmanX] = 'S';
            GameView.removePellets();
        } else if (currPos == 'B') {
            score += 5;
            maze[pacmanY][pacmanX] = 'S';
            GameView.removePellets();
        }
    }

    public void releaseGhost(String color) {
        if (color.equals("Blue") && !(GameControl.getLevel().equals("Hard"))) {
            blueDx = 2;
            blueDy = 2;
            blueX += blueDx;
            blueY += blueDy;
            GameView.updateGhost(blueDx, blueDy, "Blue");
            blueDx = -1;
            blueDy = 0;
            blueCurrDir = Direction.LEFT;
            blueOldDir = Direction.NONE;
        } else if (color.equals("Blue") && (GameControl.getLevel().equals("Hard"))) {
            blueDy = -1;
            blueDx = 0;
            blueX += blueDx;
            blueY += blueDy;
            GameView.updateGhost(blueDx, blueDy, "Blue");
        } else if (color.equals("Pink") && !(GameControl.getLevel().equals("Hard"))) {
            pinkDx = 2;
            pinkDy = 2;
            pinkX += pinkDx;
            pinkY += pinkDy;
            GameView.updateGhost(pinkDx, pinkDy, "Pink");
            pinkDx = -1;
            pinkDy = 0;
            pinkCurrDir = Direction.LEFT;
            pinkOldDir = Direction.NONE;
        } else if (color.equals("Pink") && (GameControl.getLevel().equals("Hard"))) {
            pinkDy -= 2;
            pinkDx = 0;
            pinkX += pinkDx;
            pinkY += pinkDy;
            GameView.updateGhost(pinkDx, pinkDy, "Pink");
        } else if (color.equals("Red") && !(GameControl.getLevel().equals("Hard"))) {
            redDy = 2;
            redDx = 0;
            redY += 2;
            GameView.updateGhost(redDx, redDy, "Red");
            redDx = -1;
            redDy = 0;
            redCurrDir = Direction.LEFT;
            redOldDir = Direction.NONE;
        } else if (color.equals("Red") && (GameControl.getLevel().equals("Hard"))) {
            redDy -= 1;
            redDx = 0;
            redX += redDx;
            redY += redDy;
            GameView.updateGhost(redDx, redDy, "Red");
            redCurrDir = Direction.LEFT;
            redOldDir = Direction.NONE;
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
            if (!safeMode) {
                safeMode = true;
                System.out.println("Collided");
                lives -= 1;
                GameView.updateDisplay();
                GameView.resetPacmanView();
                pacmanX = 1;
                pacmanY = maze.length - 2;
            }
        }

        if (newPos != 'W') {
            blueX += blueDx;
            blueY += blueDy;
            GameView.updateGhost(blueDx, blueDy, "Blue");
        }
        if (newPos == 'W') {
            newPos = currPos;
            blueOldDir = blueCurrDir;
            Direction tempDir = randomDirection(randomDir.nextInt(4), "Blue");
            if (blueOldDir != tempDir) {
                blueCurrDir = tempDir;
            } else {
                blueCurrDir = randomDirection(randomDir.nextInt(4), "Blue");
            }
        }
        System.out.printf("BLUE X=%d, Y=%d \n", blueX, blueY);
        System.out.println("Blue Direction: " + GameModel.getBlueCurrDir());
        System.out.println("PACMAN X=" + pacmanX + " Y=" + pacmanY);
    }

    /**
     * Algorithm #2
     * If the pink ghost collides with a wall, it's next direction is chosen at random.
     * If the pink ghost is in the same row/column as pacman, it will change
     * its direction to start following pacman
     * @param dir the ghost's current direction
     */
    public void movePinkGhost(Direction dir) {
        System.out.println("\n");
        pinkOldDir = pinkCurrDir;
        pinkCurrDir = dir;

        // Pink ghost & pacman are in the same row
        if (pinkY == pacmanY) {
            // If pacman is to the left of ghost, move left
            if (pacmanX < pinkX) {
                pinkCurrDir = Direction.LEFT;
                pinkDx = -1;
                pinkDy = 0;
            // If pacman is to the right of ghost, move right
            } else {
                pinkCurrDir = Direction.RIGHT;
                pinkDx = 1;
                pinkDy = 0;
            }
            System.out.println("Same row!");
            System.out.println("Pink dir: " + pinkCurrDir + ", Pacman dir: " + currDirection);
        }
        // Pink ghost & pacman are in the same column
        else if (pinkX == pacmanX) {
            // If pacman is above the ghost, move up
            if (pacmanY < pinkY) {
                pinkCurrDir =  Direction.UP;
                pinkDy = -1;
                pinkDx = 0;
            // If pacman is below the ghost, move down
            } else {
                pinkCurrDir = Direction.DOWN;
                pinkDy = 1;
                pinkDx = 0;
            }
            System.out.println("Same column!");
            System.out.println("Pink dir: " + pinkCurrDir + ", Pacman dir: " + currDirection);
        }

        char currPos = maze[pinkY][pinkX];
        char newPos = maze[pinkY + pinkDy][pinkX + pinkDx];

        if ((pinkX == pacmanX && pinkY == pacmanY) || (pinkX == pacmanOldX && pinkY == pacmanOldY)) {
            if (!safeMode) {
                safeMode = true;
                System.out.println("Collided");
                lives -= 1;
                GameView.updateDisplay();
                GameView.resetPacmanView();
                pacmanX = 1;
                pacmanY = maze.length - 2;
            }
        }

        if (newPos != 'W') {
            pinkX += pinkDx;
            pinkY += pinkDy;
            GameView.updateGhost(pinkDx, pinkDy, "Pink");
        }
        if (newPos == 'W') {
            newPos = currPos;
            System.out.println("Hit a wall");
            pinkOldDir = pinkCurrDir;
            Direction tempDir = randomDirection(randomDir.nextInt(4), "Pink");
            if (pinkOldDir != tempDir) {
                pinkCurrDir = tempDir;
            } else {
                pinkCurrDir = randomDirection(randomDir.nextInt(4), "Pink");
            }
        }
        System.out.println("PACMAN X=" + pacmanX + " Y=" + pacmanY);
    }

    /**
     * Algorithm #3
     * If the red ghost collides with a wall, it's next direction is chosen depending on
     * a probability threshold called epsilon.
     * We generate a random double between [0-1]
     * If epsilon is greater than this probability, the ghost moves in the direction that has the
     * smallest distance to pacman using a heuristic of manhattan distance.
     * Otherwise, the ghost moves randomly.
     * @param dir the ghost's current direction
     */
    public void moveRedGhost(Direction dir) {
        Map<Direction, int[]> map = new HashMap<>();
        map.put(Direction.LEFT, new int[]{-1, 0});
        map.put(Direction.RIGHT, new int[]{1, 0});
        map.put(Direction.UP, new int[]{0, -1});
        map.put(Direction.DOWN, new int[]{0, 1});
        redDx = map.get(redCurrDir)[0];
        redDy = map.get(redCurrDir)[1];
        redOldDir = redCurrDir;
        redCurrDir = dir;

        char newPos = maze[redY + redDy][redX + redDx];
        if ((redX == pacmanX && redY == pacmanY) || (redX == pacmanOldX && redY == pacmanOldY)) {
            if (!safeMode) {
                safeMode = true;
                System.out.println("Collided");
                lives -= 1;
                GameView.updateDisplay();
                GameView.resetPacmanView();
                pacmanX = 1;
                pacmanY = maze.length - 2;
            }
        }

        if (newPos != 'W') {
            redX += redDx;
            redY += redDy;
            GameView.updateGhost(redDx, redDy, "Red");
        }
        if (newPos == 'W') {
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
        System.out.printf("Red X=%d, Y=%d \n", redX, redY);
        System.out.println("Red Direction: " + GameModel.getRedCurrDir());
        System.out.println("Red dx: " + redDx + ", Red dy: " + redDy);
        System.out.println("PACMAN X=" + pacmanX + " Y=" + pacmanY + "\n");
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
            } else {
                redDx = -1;
                redDy = 0;
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
            } else {
                redDx = 1;
                redDy = 0;
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
            } else {
                redDy = -1;
                redDx = 0;
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
            } else {
                redDy = 1;
                redDx = 0;
                return Direction.DOWN;
            }
        }
    }

    public void checkGameStatus() throws MalformedURLException {
        URL location = getClass().getResource("/gameOver.fxml");
        if (score == maxScore) {
            setGameStatus(GameState.WIN);
        } else if (lives == 0) {
            setGameStatus(GameState.LOSE);
        }
        if (gameStatus == GameState.WIN) {
            GameView.removeRemainingPellets();
            GameControl.getTimer().cancel();
            gameOverControls.changeScene(GameView.getStage(), location, "Congrats, you won!");
        } else if (gameStatus == GameState.LOSE) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameOverControls.fxml"));

            GameControl.getTimer().cancel();
            gameOverControls.changeScene(GameView.getStage(), location, "Sorry, you lost!");
            GameView.removeRemainingPellets();
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

    public static void setGameStatus(GameState state) {
        gameStatus = state;
    }

    public GameState getGameStatus() {
        return gameStatus;
    }

    public static void setMaxScore(int max) {
        maxScore = max;
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

    public static boolean getSafeMode() {
        return safeMode;
    }

    public static void setSafeMode(boolean x) {
        safeMode = x;
    }

    public static void setRowCount(int x) {
        rowCount = x;
    }

    public static void setColumnCount(int x) {
        columnCount = x;
    }
}
