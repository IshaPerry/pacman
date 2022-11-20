package com.example.pacman.ui;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

public class GameControl implements EventHandler<KeyEvent> {
    final private static double FRAMES_PER_SECOND = 5.0;
    private GameModel gameModel;
    private GameView gameView;
    private static Timer timer;
    private static String level;
    private static int gameTimer;
    private static int delayTime;
    private static int timeElapsed = 0;
    private static int ghostEatingTimer = 0;
    private static boolean blueReleased;
    private static boolean pinkReleased;
    private static boolean redReleased;
    private static boolean yellowReleased;

    private static int blueTimer;
    private static int pinkTimer;
    private static int redTimer;
    private static int yellowTimer;


    public GameControl() {};

    /**
     * Initializes the game with the model's initial state. Called in configurationControls
     */
    public void start(Stage primaryStage) {
        blueReleased = false;
        pinkReleased = false;
        redReleased = false;
        yellowReleased = false;

        gameTimer = 0;

        blueTimer = 0;
        pinkTimer = 0;
        redTimer = 0;
        yellowTimer = 0;


        level = configurationControls.getLevel();
        maze m = new maze();
        this.gameModel = new GameModel();

        if (level.equals("Easy")) {
            GameModel.setMaxPellets(74);
            delayTime = 40;
            GameModel.setMaze(m.getEasyArray());

        } else if (level.equals("Medium")) {
            GameModel.setMaxPellets(78);
            delayTime = 30;
            GameModel.setMaze(m.getMedArray());
        } else {
            GameModel.setMaxPellets(164);
            delayTime = 10;
            GameModel.setMaze(m.getHardArray());
        }
        GameModel.generateCherry(GameModel.getMaze().length, GameModel.getMaze()[0].length);
        GameModel.generateShield(GameModel.getMaze().length, GameModel.getMaze()[0].length);

        String color = configurationControls.getPacman();
        gameModel.setPacmanColor(color);
        gameModel.setScore(0);
        gameModel.setLives(3);
        gameModel.setPelletsEaten(0);
        gameModel.setGhostsEaten(0);

        GameModel.setCurrDirection(GameModel.Direction.NONE);
        this.gameView = new GameView();
        gameView.start(primaryStage);
        timer = new java.util.Timer();
        this.runTimer();
    }


    /**
     * On each animation frame, update the model with information and display UI
     */
    public void runTimer() {
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        GameModel.setGameStatus(GameModel.GameState.PLAYING);
                        gameModel.movePacman(GameModel.getCurrDirection());
                        gameTimer++;
                        blueTimer++;
                        pinkTimer++;
                        redTimer++;
                        yellowTimer++;
                        if (GameModel.getSafeMode()) {
                            if (timeElapsed < 20) {
                                timeElapsed++;
                            } else {
                                GameModel.setSafeMode(false);
                                timeElapsed = 0;
                            }
                        }
                        if (GameModel.getGhostEatingMode()) {
                            if (ghostEatingTimer < 25) {
                                ghostEatingTimer++;
                            } else {
                                GameModel.setGhostEatingMode(false);

                                ghostEatingTimer = 0;
                            }
                        }
                        if (level.equals("Easy")) {
                            if (blueTimer > 5 && !(blueReleased)  ) {
                                blueReleased = true;
                                gameModel.releaseGhost("Blue");
                            } else {
                                GameView.updateGhost(0, 0, "Blue");
                            }
                            if (pinkTimer > delayTime && !(pinkReleased)) {
                                pinkReleased = true;
                                gameModel.releaseGhost("Pink");
                            } else {
                                GameView.updateGhost(0, 0, "Pink");
                            }

                        } else if (level.equals("Medium")) {
                            if (blueTimer > 5 && !(blueReleased)) {
                                blueReleased = true;
                                gameModel.releaseGhost("Blue");
                            } else {
                                GameView.updateGhost(0, 0, "Blue");
                            }
                            if (pinkTimer > delayTime && !(pinkReleased)) {
                                pinkReleased = true;
                                gameModel.releaseGhost("Pink");
                            } else {
                                GameView.updateGhost(0, 0, "Pink");
                            }
                            if (redTimer > delayTime * 2 && !(redReleased)) {
                                redReleased = true;
                                gameModel.releaseGhost("Red");
                            } else {
                                GameView.updateGhost(0, 0, "Red");
                            }
                        } else {
                            if (blueTimer > 5 && !(blueReleased)) {
                                blueReleased = true;
                                gameModel.releaseGhost("Blue");
                            } else {
                                GameView.updateGhost(0, 0, "Blue");
                            }
                            if (pinkTimer > delayTime && !(pinkReleased)) {
                                pinkReleased = true;
                                gameModel.releaseGhost("Pink");
                            } else {
                                GameView.updateGhost(0, 0, "Pink");
                            }
                            if (redTimer > delayTime * 2 && !(redReleased)) {
                                redReleased = true;
                                gameModel.releaseGhost("Red");
                            } else {
                                GameView.updateGhost(0, 0, "Red");
                            }
                            if (yellowTimer > delayTime * 3 && !(yellowReleased)) {
                                yellowReleased = true;
                                gameModel.releaseGhost("Yellow");
                            } else {
                                GameView.updateGhost(0, 0, "Yellow");
                            }
                        }
//                        if (gameTimer > 5 && !(blueReleased)  ) {
//                            blueReleased = true;
//                            gameModel.releaseGhost("Blue");
//                        }
//                        else if (gameTimer > delayTime && !(pinkReleased)) {
//                            pinkReleased = true;
//                            gameModel.releaseGhost("Pink");
//                        } else if (gameTimer > delayTime * 2 && !(redReleased) && !level.equals("Easy")) {
//                            redReleased = true;
//                            gameModel.releaseGhost("Red");
//                        } else if (gameTimer > delayTime * 3 && !(yellowReleased) && level.equals("Hard")) {
//                            yellowReleased = true;
//                            gameModel.releaseGhost("Yellow");
//                                }
                        if (blueReleased) {
                            gameModel.moveBlueGhost(GameModel.getBlueCurrDir());
                        }
                        if (pinkReleased) {
                            gameModel.movePinkGhost(GameModel.getPinkCurrDir());
                        }
                        if (redReleased) {
                            gameModel.moveRedGhost(GameModel.getRedCurrDir());
                        }
                        if (yellowReleased) {

                            gameModel.moveYellowGhost(GameModel.getYellowCurrDir());
                        }

                        try {
                            gameModel.checkGameStatus();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                 });
                }
            };
        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    public static void resetGame() {
        try {
            timer.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




    @Override
    public void handle(KeyEvent e) {
        KeyCode code = e.getCode();
        gameModel.setOldDirection(gameModel.getCurrDirection());
        if (e.getCode() == KeyCode.SPACE) {
            timer.cancel();
        }
        if (e.getCode() == KeyCode.LEFT) {
            gameModel.setCurrDirection(GameModel.Direction.LEFT);
        } else if (e.getCode() == KeyCode.RIGHT) {
            gameModel.setCurrDirection(GameModel.Direction.RIGHT);
        } else if (e.getCode() == KeyCode.UP) {
            gameModel.setCurrDirection(GameModel.Direction.UP);
        } else if (e.getCode() == KeyCode.DOWN) {
            gameModel.setCurrDirection(GameModel.Direction.DOWN);
        }
    }

    public static String getLevel() {
        return level;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static boolean getBlueReleased() {
        return blueReleased;
    }

    public static void setBlueReleased(boolean x) {
        blueReleased = x;
    }

    public static void setPinkReleased(boolean x) {
        pinkReleased = x;
    }

    public static void setRedReleased(boolean x) {
        redReleased = x;
    }

    public static void setYellowReleased(boolean x) {
        yellowReleased = x;
    }

    public static void setGameTimer(int x) {
        gameTimer = x;
    }

    public static int getGhostEatingTimer() {
        return ghostEatingTimer;
    }

    public static void setBlueTimer(int x) {
        blueTimer = x;
    }

    public static void setPinkTimer(int x) {
        pinkTimer = x;
    }

    public static void setRedTimer(int x) {
        redTimer = x;
    }

    public static void setYellowTimer(int x) {
        yellowTimer = x;
    }

}
