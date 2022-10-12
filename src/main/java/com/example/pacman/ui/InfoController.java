package com.example.pacman.ui;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;


public class InfoController {
    private String name;
    private static String level;
    private int lives;
    private int ghostSpeed;


    @FXML
    private TextField enterName;

    @FXML
    private ChoiceBox<String> levelSelector;

    public void initialize() {
        levelSelector.getItems().addAll("Easy", "Medium", "Hard");
      //  levelSelector.setOnAction(e -> setLevel(levelSelector.getValue()));

    }


    @FXML
    public void onSubmitButtonClick() throws IOException {
        name = enterName.getText();
        level = levelSelector.getSelectionModel().getSelectedItem();
        System.out.println(name);
        System.out.println(level);
        if (isSetUpValid()) {
            //start game scene
        }
    }

    private boolean isSetUpValid() { //code to set up errors
        /*
        if (name == null || name.trim().isEmpty() || level == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Input");
            if (playerName == null || playerName.trim().isEmpty()) {
                alert.setContentText("Please enter a valid name.");
            } else {
                alert.setContentText("Please select a difficulty.");
            }

            Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
            alertStage.getIcons().add(new Image(String.valueOf(getClass().getResource(
                    "/images/towerSpiky.png"))));

            alert.show();
            return false;
        }
        return true;*/
        return false;
    }







}
