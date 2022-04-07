package co.edu.uniquindio.ajedrez.controller;

import co.edu.uniquindio.ajedrez.logic.Tablero;
import co.edu.uniquindio.ajedrez.logic.piezas.Pieza;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private GridPane gridPane;

    private Button[][] buttons = new Button[8][8];

    private Tablero tablero;

    @FXML
    public void initialize() {
        tablero = new Tablero();
        for (Node node: gridPane.getChildren()) {
            if (node.getClass().equals(Button.class)) {
                Button button = ((Button) node);
                button.setText(" ");
                Integer row = GridPane.getRowIndex(button);
                Integer column = GridPane.getColumnIndex(button);

                if (row == null) {
                    row = 0;
                }

                buttons[row][column - 1] = button;
            }
        }
        render();
    }

    private void render() {
        for (int i = 0; i < buttons.length ; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                Button button = buttons[i][j];
                if (button != null && tablero.getCasilla(i, j).getPieza() instanceof Pieza) {
                    button.setText(tablero.getCasilla(i, j).getPieza().toString());
                }
                else {
                    button.setText("");
                }
            }
        }
    }
}