package co.edu.uniquindio.ajedrez.logic.piezas;

import co.edu.uniquindio.ajedrez.logic.Casilla;
import co.edu.uniquindio.ajedrez.logic.util.Coordinate;

import java.util.ArrayList;

public class Caballo extends Pieza implements IMover{

    private TipoPieza tipo = TipoPieza.CABALLO;

    public Caballo(Color color) {
        super(color);
    }

    @Override
    public void mover(Casilla coordinate) {

    }

    public ArrayList<Coordinate> movidas(Pieza pieza) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Coordinate coordinate = pieza.getCasilla().getCoordinate();
        if (coordinate != null) {
            // Las posibles posiciones del caballo pueden ser obtenidas teniendo en cuenta que las posiciones
            // toman la forma de un circulo espaciado cada 45 grados.
            double radians = Math.toRadians(45.0 / 2.0);
            for (int i = 0; i < 8; i++) {
                int rowPos = coordinate.getRow() + (int) Math.round(Math.sin(radians) * 2.0);
                int colPos = coordinate.getCol() + (int) Math.round(Math.cos(radians) * 2.0);
                radians += Math.toRadians(45.0);

                if (rowPos >= 0 && rowPos <= 7 && colPos >= 0 && colPos <= 7) {
                    coordinates.add(new Coordinate(rowPos, colPos));
                    // System.out.println("radians:" + radians + "row: " + rowPos + " col: " + colPos);
                }
            }
        }
        return coordinates;
    }

    public String toString() {
        // https://es.wikipedia.org/wiki/S%C3%ADmbolos_de_ajedrez_en_Unicode
        if (this.getColor().equals(Color.BLANCAS)) {
            return "\u2658";
        }
        else {
            return "\u265E";
        }
    }
}
