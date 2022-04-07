package co.edu.uniquindio.ajedrez.logic.piezas;

import co.edu.uniquindio.ajedrez.logic.Casilla;
import co.edu.uniquindio.ajedrez.logic.util.Coordinate;

import java.util.ArrayList;

public class Torre extends Pieza implements IMover{

    private TipoPieza tipo = TipoPieza.TORRE;

    public Torre(Color color) {
        super(color);
    }

    @Override
    public void mover(Casilla coordinate) {

    }

    public ArrayList<Coordinate> movidas(Pieza pieza) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Coordinate coordinate = pieza.getCasilla().getCoordinate();
        if (coordinate != null) {
            for (int i = 0; i < 8; i++) {
                Coordinate coordenada = new Coordinate (coordinate.getRow(), i);
                if (i != coordinate.getRow()) {
                    coordinates.add(coordenada);
                }
                coordenada = new Coordinate (i, coordinate.getCol());
                if (i != coordinate.getCol()) {
                    coordinates.add(coordenada);
                }
            }
        }
        return coordinates;
    }

    public String toString() {
        // https://es.wikipedia.org/wiki/S%C3%ADmbolos_de_ajedrez_en_Unicode
        if (this.getColor().equals(Color.BLANCAS)) {
            return "\u2656";
        }
        else {
            return "\u265C";
        }
    }
}
