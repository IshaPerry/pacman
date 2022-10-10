module com.example.pacman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pacman to javafx.fxml;
    exports com.example.pacman;
}