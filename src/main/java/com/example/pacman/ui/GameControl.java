package com.example.pacman.ui;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class GameControl implements EventHandler<KeyEvent> {
    final private static double FRAMES_PER_SECOND = 5.0;
    private GameModel gameModel;
    private GameView gameView;
    private Timer timer;
    private static String level;

    public GameControl() {};

    /**
     * Initializes the game with the model's initial state. Called in configurationControls
     */
    public void start(Stage primaryStage) {
        level = configurationControls.getLevel();
        maze m = new maze();
        this.gameModel = new GameModel();

        if (level.equals("Easy")) {
            gameModel.setMaze(m.getEasyArray());
        } else if (level.equals("Medium")) {
            gameModel.setMaze(m.getMedArray());
        } else {
            gameModel.setMaze(m.getHardArray());
        }
        String color = configurationControls.getPacman();
        gameModel.setPacmanColor(color);
        gameModel.setScore(0);
        gameModel.setLives(3);
        gameModel.setRound(1);
        gameModel.setCurrDirection(GameModel.Direction.NONE);
        gameModel.setOldDirection(GameModel.Direction.NONE);
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
                        gameModel.movePacman(GameModel.getCurrDirection());
                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }


    @Override
    public void handle(KeyEvent e) {
        System.out.println("press");
        KeyCode code = e.getCode();
        if (e.getCode() == KeyCode.LEFT) {
            gameModel.setCurrDirection(GameModel.Direction.LEFT);
        } else if (e.getCode() == KeyCode.RIGHT) {
            gameModel.setCurrDirection(GameModel.Direction.RIGHT);
        } else if (e.getCode() == KeyCode.UP) {
            gameModel.setCurrDirection(GameModel.Direction.UP);
        } else if (e.getCode() == KeyCode.DOWN) {
            gameModel.setCurrDirection(GameModel.Direction.DOWN);
        }
        System.out.println(gameModel.getCurrDirection());
    }

    public static String getLevel() {
        return level;
    }

}
