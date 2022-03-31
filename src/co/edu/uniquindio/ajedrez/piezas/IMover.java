package co.edu.uniquindio.ajedrez.piezas;

import co.edu.uniquindio.ajedrez.util.Coordinate;

import java.util.ArrayList;

public interface IMover {

    public void mover();
    public static ArrayList<Coordinate> movidas(String current) {
        return new ArrayList<>();
    }
}
