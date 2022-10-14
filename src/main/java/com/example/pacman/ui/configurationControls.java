package com.example.pacman.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import javafx.scene.Parent;

public class configurationControls {

    private String name;
    private static String level;
    private int lives;
    private int ghostSpeed;
    private String error;

    @FXML
    private TextField enterName;

    @FXML
    private ChoiceBox<String> levelSelector;

    @FXML
    private Button submitButton;

    @FXML
    private Label userLabel2;

    @FXML
    private Button continueOn;

    private int events = 0;


    @FXML
    private void hitSubmit(ActionEvent event) throws IOException {  //we need to change this bc u can't have 2 fxml files to once controller
        name = enterName.getText();
        level = levelSelector.getSelectionModel().getSelectedItem();
        if (events == 0) {
            if (isSetUpValid()) {
                userLabel2.setText(name + " is ready to play level " + level + " with character: X!");
                // Label.setTitle("You're good to go!");
                setLevelParams(level);
                submitButton.setText("Continue");
                events += 1;
            } else {
                userLabel2.setText(error);
                //popUp.setTitle("Error");
                //continueOn.setOnAction(); ///code to open game screen)
            }
        }
        else {
            Stage stage = (Stage) submitButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mazeScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);
        }
        //popUp.show();
    }

    public void initialize() {
        levelSelector.getItems().addAll("Easy", "Medium", "Hard");


    }

    private boolean isSetUpValid() { //code to set up errors
        if (name == null || name.trim().isEmpty()) {
            error = "Enter a valid name: cannot be empty, null, or only whitespace";
            return false;
        } else if (level == null) {
            error = "Please select a level.";
            return false;
        } //code for a choosing a character
            return true;
        }

    private void setLevelParams(String level) {
        if (level.equals("Easy")) {
            lives = 5;
            ghostSpeed = 2;
        } else if (level.equals("Medium")) {
            lives = 4;
            ghostSpeed = 4;
        } else {
            lives = 3;
            ghostSpeed = 6;
        }
    }


}


