package co.edu.uniquindio.ajedrez.piezas;

import co.edu.uniquindio.ajedrez.Casilla;
import co.edu.uniquindio.ajedrez.util.Coordinate;

import java.util.ArrayList;

public class Pieza implements IPieza {

    private TipoPieza tipo;
    private Color color;
    private Casilla casilla;

    public Pieza(Color color) {
        this.color = color;
    }

    @Override
    public TipoPieza getTipo() {
        return tipo;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    static ArrayList<Coordinate> movidas(Pieza pieza) {
        return new ArrayList<>();
    }
}
