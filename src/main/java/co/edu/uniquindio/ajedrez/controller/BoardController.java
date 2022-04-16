package co.edu.uniquindio.ajedrez.controller;

import co.edu.uniquindio.ajedrez.logic.Tablero;
import co.edu.uniquindio.ajedrez.logic.piezas.Pieza;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class BoardController {

    @FXML
    private GridPane gridPane;

    private Button[][] buttons = new Button[8][8];

    private Tablero tablero;

    @FXML
    public void initialize() {
        tablero = new Tablero();
        for (Node node: gridPane.getChildren()) {
//          if (node.getClass().equals(Button.class)) {
            if (node instanceof Button) {
                Button button = ((Button) node);
                button.setText(" ");
                Integer row = GridPane.getRowIndex(button);
                Integer column = GridPane.getColumnIndex(button);

                if (row == null) {
                    row = 0;
                }

                /*button.prefHeight(40.0);
                button.prefWidth(40.0);
                button.minWidth(40.0);
                button.minHeight(40.0);*/

                button.setStyle("-fx-min-width: 80px;");
                button.setTextFill(Color.BLACK);
                button.setFont(new Font(16));

                buttons[row][column - 1] = button;
            }
        }
        pintarBotones();
        render();
    }

    private void pintarBotones() {
        for (int i = 0; i < buttons.length ; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                Button button = buttons[i][j];
                if ((i + j) % 2 == 0) {
                    button.setStyle("-fx-background-color: #ffffff;");
                }
                else {
                    button.setStyle("-fx-background-color: #888888;");
                }
            }
        }
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