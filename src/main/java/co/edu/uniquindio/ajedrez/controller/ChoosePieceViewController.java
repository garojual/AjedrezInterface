package co.edu.uniquindio.ajedrez.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
* Pruebas para elegir una ficha desde una UI
* [Incompleta] Falta conectarse con la lógica y poder ser desplegada por el evento en cuestión
* */

public class ChoosePieceViewController {

    @FXML
    private GridPane gridPane;

    @FXML private Button B0;
    @FXML private Button B1;
    @FXML private Button B2;
    @FXML private Button B3;
    @FXML private int option;

    @FXML
    public void choosePiece(ActionEvent event){

        Button sourceButton = (Button) event.getSource();

        if(sourceButton.equals(B0)){
            System.out.println("0");
        }
        else if(sourceButton.equals(B1)){
            System.out.println("1");
        }
        else if(sourceButton.equals(B2)){
            System.out.println("2");
        }
        else if(sourceButton.equals(B3)){
            System.out.println("3");
        }

        Platform.exit();
    }

}

