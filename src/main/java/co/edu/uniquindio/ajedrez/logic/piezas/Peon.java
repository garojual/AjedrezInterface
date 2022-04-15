package co.edu.uniquindio.ajedrez.logic.piezas;

import co.edu.uniquindio.ajedrez.logic.Casilla;
import co.edu.uniquindio.ajedrez.logic.util.Coordinate;

import java.util.ArrayList;

public class Peon extends Pieza implements IMover{

    private TipoPieza tipo = TipoPieza.PEON;

    public Peon(Color color) {
        super(color);
    }

    @Override
    public void mover(Casilla coordinate) {

    }

    public ArrayList<Coordinate> movidas(Pieza pieza) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Coordinate coordinate = pieza.getCasilla().getCoordinate();
        boolean isFirstMove = true;

        if (pieza.getColor().equals(Color.NEGRAS) && coordinate != null) {

            if ( coordinate.getRow() < 7 ) {
                Coordinate coord1 = new Coordinate(coordinate.getRow() + 1, coordinate.getCol());
                coordinates.add(coord1);
            }

            if(isFirstMove &&  coordinate.getRow() < 7){
                isFirstMove = false;
                Coordinate coord2 = new Coordinate(coordinate.getRow() + 2, coordinate.getCol());
                coordinates.add(coord2);
            }

            if(coordinate.getCol() < 7){
                Coordinate coord3 = new Coordinate(coordinate.getRow() + 1, coordinate.getCol() + 1);
                coordinates.add(coord3);
            }

            if(coordinate.getCol() > 0){
                Coordinate coord4 = new Coordinate(coordinate.getRow() + 1, coordinate.getCol() - 1);
                coordinates.add(coord4);
            }
        }

        else if (pieza.getColor().equals(Color.BLANCAS) && coordinate.getRow() > 0) {

            if ( coordinate.getRow() <= 7) {
                Coordinate coord1 = new Coordinate(coordinate.getRow() - 1, coordinate.getCol());
                coordinates.add(coord1);
            }

            if(isFirstMove &&  coordinate.getRow() < 7){
                isFirstMove = false;
                Coordinate coord2 = new Coordinate(coordinate.getRow() - 2, coordinate.getCol());
                coordinates.add(coord2);
            }

            if(coordinate.getCol() > 0){
                Coordinate coord3 = new Coordinate(coordinate.getRow() - 1, coordinate.getCol() - 1);
                coordinates.add(coord3);
            }

            if(coordinate.getCol() < 7){
                Coordinate coord4 = new Coordinate(coordinate.getRow() - 1, coordinate.getCol() + 1);
                coordinates.add(coord4);
            }
        }

        return coordinates;
    }

    public String toString() {
        // https://es.wikipedia.org/wiki/S%C3%ADmbolos_de_ajedrez_en_Unicode
        if (this.getColor().equals(Color.BLANCAS)) {
            return "\u2659";
        }
        else {
            return "\u265F";
        }
    }

}
