package co.edu.uniquindio.ajedrez.piezas;

import co.edu.uniquindio.ajedrez.Casilla;
import co.edu.uniquindio.ajedrez.util.Coordinate;

import java.util.ArrayList;

public class Rey extends Pieza implements IMover{

    private TipoPieza tipo = TipoPieza.REY;

    public Rey(Color color) {
        super(color);
    }

    public ArrayList<Coordinate> movidas(Pieza pieza) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Coordinate coordinate = pieza.getCasilla().getCoordinate();
        if (coordinate != null) {
            // Usamos el mismo enfoque del caballo para las movidas basicas del rey.
            double radians = 0.0;
            for (int i = 0; i < 8; i++) {
                int rowPos = coordinate.getRow() + (int) Math.round(Math.sin(radians));
                int colPos = coordinate.getCol() + (int) Math.round(Math.cos(radians));
                radians += Math.toRadians(45.0);

                if (rowPos >= 0 && rowPos <= 7 && colPos >= 0 && colPos <= 7) {
                    coordinates.add(new Coordinate(rowPos, colPos));
                    // System.out.println("radians:" + radians + "row: " + rowPos + " col: " + colPos);
                }
            }

            // @todo Falta agregar modias de enroque.
        }
        return coordinates;
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

    @Override
    public void mover(Casilla coordinate) {

    }
}
