package co.edu.uniquindio.ajedrez;

import co.edu.uniquindio.ajedrez.piezas.Pieza;
import co.edu.uniquindio.ajedrez.util.Coordinate;

public class Casilla {

    private Pieza pieza;
    private Coordinate coordinate;

    public Casilla(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Casilla(Coordinate coordinate, Pieza pieza) {
        this.coordinate = coordinate;
        this.pieza = pieza;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String toString() {
        if (this.pieza != null) {
            return this.pieza.toString();
        }
        else if (coordinate != null) {
            if ((coordinate.getRow() + coordinate.getCol()) % 2 == 0) {
                return "\u2593";
            }
        }
        return "\u2591";
    }
}
