package co.edu.uniquindio.ajedrez.logic.piezas;

import co.edu.uniquindio.ajedrez.logic.Casilla;
import co.edu.uniquindio.ajedrez.logic.Tablero;
import co.edu.uniquindio.ajedrez.logic.util.Coordinate;

import java.util.ArrayList;

public class Peon extends Pieza implements IMover{

    private TipoPieza tipo = TipoPieza.PEON;

    public Peon(Color color) {
        super(color);
    }

    //Con esta solución, no es necesario llamar a movidas, pues la función es llamada dentro de esta
    @Override
    public void mover(Casilla coordinate) {
        Tablero tablero = this.getCasilla().getTablero(); //Base del código para obtener el tablero

        Coordinate coord0 = coordinate.getCoordinate(); //Suponemos que esta es la casilla donde está el peon

        ArrayList<Coordinate> movidasValidas = new ArrayList<>();
        ArrayList<Coordinate> movidasTotales = movidas(this);

        for(int i = 0; i < movidasTotales.size(); i ++){
            //Solo hace comprobaciones
            Casilla casillaAux = tablero.getCasilla(movidasTotales.get(i).getRow(), movidasTotales.get(i).getCol());

            /*
            * Termina siendo redundante a partir del segundo turno, ya que comprueba dos veces la misma casilla, pero
            * es la única forma de que funcione para el doble movimiento del inicio de turno.
            */
            if(casillaAux.getCoordinate().getCol() == coord0.getCol()){ //Movimiento avanzar
                if(this.getColor() == Color.NEGRAS){ //Negras bajan
                    if(casillaAux.getCoordinate().getRow() == coord0.getRow() + 1){
                        if(casillaAux.getPieza() == null){
                            movidasValidas.add(movidasTotales.get(i));
                        }
                    }
                    else{ //Doble casilla
                        if(casillaAux.getPieza() == null &&
                                tablero.getCasilla(coord0.getRow()+ 1, coord0.getCol()).getPieza() == null){
                            movidasValidas.add(movidasTotales.get(i));
                        }
                    }
                }
                else{ //Blancas suben
                    if(casillaAux.getCoordinate().getRow() == coord0.getRow() - 1){
                        if(casillaAux.getPieza() == null){
                            movidasValidas.add(movidasTotales.get(i));
                        }
                    }
                    else{ //Doble casilla
                        if(casillaAux.getPieza() == null &&
                                tablero.getCasilla(coord0.getRow()- 1, coord0.getCol()).getPieza() == null){
                            movidasValidas.add(movidasTotales.get(i));
                        }
                    }
                }
            }
            else if(casillaAux.getCoordinate().getCol() != coord0.getCol() && casillaAux.getPieza() != null){
                movidasValidas.add(movidasTotales.get(i));
            }
        }
        //Por ahora automáticamente imprime las movidas totales y luego las movidas válidas
        System.out.println("Todas las movidas: " + movidasTotales + "\n" +
                "Movidas Validas : " + movidasValidas);
    }

    public Pieza reclamar(Color color, int option){
        Pieza piezaReclamada = null;
        ArrayList<Pieza> piezas = new ArrayList<>();

        piezas.add(new Alfil(color));  // 0
        piezas.add(new Caballo(color));// 1
        piezas.add(new Reina(color));  // 2
        piezas.add(new Torre(color));  // 3

        return piezas.get(option);
    }

    public void ValidarReclamar(Casilla casilla){
        Tablero tablero = this.getCasilla().getTablero();

        if(this.getColor() == Color.NEGRAS){
            if(casilla.getCoordinate().getRow() == 7){
                //Desplegar una ventana para elegir el numero
                //reclamar(Color.NEGRAS);
            }
        }
        else{
            if(casilla.getCoordinate().getRow() == 0){
                //reclamar(Color.BLANCAS);
            }
        }
    }

    //Todas las movidas
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
