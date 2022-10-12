package com.example.pacman.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class configurationControls {

    @FXML
    private Button submitButton;
    @FXML
    private void hitSubmit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/goBack.fxml"));
        Scene startGame = new Scene(fxmlLoader.load(), 200, 300);
        Stage popUp = new Stage();
        popUp.setScene(startGame);
        popUp.setTitle("You're good to go!");
        popUp.show();
    }

    public void initialize() {
    }

}
