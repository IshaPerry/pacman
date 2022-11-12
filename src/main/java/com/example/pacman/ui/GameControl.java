package com.example.pacman.ui;
import javafx.application.Application;
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
    private static int delayTimer;
    private static int delayTime;
    private static int timeElapsed = 0;
    private static boolean blueReleased;
    private static boolean pinkReleased;
    private static boolean redReleased;


    public GameControl() {};

    /**
     * Initializes the game with the model's initial state. Called in configurationControls
     */
    public void start(Stage primaryStage) {
        blueReleased = false;
        pinkReleased = false;
        redReleased = false;
        delayTimer = 0;

        level = configurationControls.getLevel();
        maze m = new maze();
        this.gameModel = new GameModel();

        if (level.equals("Easy")) {
            GameModel.setMaxScore(84);
            delayTime = 40;
            gameModel.setMaze(m.getEasyArray());
        } else if (level.equals("Medium")) {
            GameModel.setMaxScore(91);
            delayTime = 30;
            gameModel.setMaze(m.getMedArray());
        } else {
            GameModel.setMaxScore(182);
            delayTime = 10;
            gameModel.setMaze(m.getHardArray());
        }

        String color = configurationControls.getPacman();
        gameModel.setPacmanColor(color);
        gameModel.setScore(0);
        gameModel.setLives(3);
        gameModel.setRound(1);
        gameModel.setCurrDirection(GameModel.Direction.NONE);
        this.gameView = new GameView();
        gameView.start(primaryStage);
        this.timer = new java.util.Timer();
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
                        gameModel.setGameStatus(GameModel.GameState.PLAYING);
                        gameModel.movePacman(GameModel.getCurrDirection());
                        delayTimer++;
                        if (GameModel.getSafeMode()) {
                            if (timeElapsed < 10) {
                                timeElapsed++;
                            } else {
                                GameModel.setSafeMode(false);
                                timeElapsed = 0;
                            }
                        }
                        System.out.println(delayTimer);
//                        if (delayTimer> 5 && (!pinkReleased)) {
//                            pinkReleased = true;
//                            gameModel.releaseGhost("Pink");
//                        }
                        if (delayTimer > 5 && !(blueReleased)) {
                            blueReleased = true;
                            gameModel.releaseGhost("Blue");
                        }
                        else if (delayTimer > delayTime && !(pinkReleased)) {
                            pinkReleased = true;
                            gameModel.releaseGhost("Pink");
                        } else if (delayTimer > delayTime * 2 && !(redReleased)) {
                            redReleased = true;
                            gameModel.releaseGhost("Red");
                        }
                        if (blueReleased) {
                            gameModel.moveBlueGhost(GameModel.getBlueCurrDir());
                        }
                        if (pinkReleased) {
                            gameModel.movePinkGhost(GameModel.getPinkCurrDir());
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

    public static void setDelayTimer(int x) {delayTimer = x; }

}
