module co.edu.uniquindio.ajedrez {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.ajedrez to javafx.fxml;
    opens co.edu.uniquindio.ajedrez.controller to javafx.fxml;
    exports co.edu.uniquindio.ajedrez;
}