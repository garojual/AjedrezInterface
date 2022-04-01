package co.edu.uniquindio.ajedrez.piezas;

import co.edu.uniquindio.ajedrez.util.Coordinate;

import java.util.ArrayList;

public class Rey extends Pieza implements IMover{

    private TipoPieza tipo = TipoPieza.REY;

    public Rey(Color color) {
        super(color);
    }

    @Override
    public void mover() {

    }

    public static ArrayList<Coordinate> movidas(String current) {
        return new ArrayList<>();
    }

    public String toString() {
        // https://es.wikipedia.org/wiki/S%C3%ADmbolos_de_ajedrez_en_Unicode
        if (this.getColor().equals(Color.BLANCAS)) {
            return "\u2654";
        }
        else {
            return "\u265A";
        }
    }
}
