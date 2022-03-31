package co.edu.uniquindio.ajedrez;

import co.edu.uniquindio.ajedrez.piezas.Pieza;

public class Casilla {

    private Pieza pieza;
    private String coordinates;

    public Casilla() {
    }

    public Casilla(Pieza pieza) {
        this.pieza = pieza;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String toString() {
        if (this.pieza != null) {
            return this.pieza.toString();
        }
        return " ";
    }
}
