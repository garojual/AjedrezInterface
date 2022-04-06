package co.edu.uniquindio.ajedrez.piezas;

import co.edu.uniquindio.ajedrez.Casilla;
import co.edu.uniquindio.ajedrez.Tablero;
import co.edu.uniquindio.ajedrez.util.Coordinate;

import java.util.ArrayList;

public class Alfil extends Pieza implements IMover{

    private TipoPieza tipo = TipoPieza.ALFIL;

    public Alfil(Color color) {
        super(color);
    }

    @Override
    public void mover(Casilla coordinate) {
        // Tomamos de la ficha actual la casilla y el tablero de la casilla, esto nos permitira validar si la ficha
        // puede moverse, comer, reclamar o hacer enroque.
        Tablero tablero = this.getCasilla().getTablero();
    }

    public ArrayList<Coordinate> movidas(Pieza pieza) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Coordinate coordinate = pieza.getCasilla().getCoordinate();
        if (coordinate != null) {
            for (int i = -8; i < 8; i++) {
                int row = i + coordinate.getRow();
                int col = i + coordinate.getCol();
                if (row >= 0 && row <= 7 && col >= 0 && col <= 7 && row != coordinate.getRow() && col != coordinate.getCol()) {
                    Coordinate coordenada = new Coordinate(row, col);
                    coordinates.add(coordenada);
                }

                int col1 = coordinate.getCol() - i;
                if (row >= 0 && row <= 7 && col1 >= 0 && col1 <= 7 && row != coordinate.getRow() && col1 != coordinate.getCol()) {
                    Coordinate coordenada = new Coordinate(row, col1);
                    coordinates.add(coordenada);
                }
            }
        }
        return coordinates;
    }

    public String toString() {
        // https://es.wikipedia.org/wiki/S%C3%ADmbolos_de_ajedrez_en_Unicode
        if (this.getColor().equals(Color.BLANCAS)) {
            return "\u2657";
        }
        else {
            return "\u265D";
        }
    }
}
