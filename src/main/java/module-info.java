module com.example.pacman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.pacman.ui to javafx.fxml, javafx.graphics;


    opens com.example.pacman to javafx.fxml, javafx.graphics;
    exports com.example.pacman;
    exports com.example.pacman.ui;
}