import co.edu.uniquindio.ajedrez.Casilla;
import co.edu.uniquindio.ajedrez.Tablero;
import co.edu.uniquindio.ajedrez.piezas.*;

public class Main {

    public static void main(String args[]) {

        Tablero tablero = new Tablero();
        System.out.println(tablero);

        /*// Validamos los posible movimientos de la pieza dummy negra
        Casilla casilla = tablero.getCasilla(1, 0);
        if (casilla != null) {
            System.out.println(casilla.getCoordinate());
            System.out.println(Dummy.movidas(casilla.getPieza()));
        }*/

        /*// Validamos los posibles movimientos de la pieza dummy blanca
        casilla = tablero.getCasilla(6, 0);
        if (casilla != null) {
            System.out.println(casilla.getCoordinate());
            System.out.println(Dummy.movidas(casilla.getPieza()));
        }*/

        Casilla casilla = tablero.getCasilla(0, 0);

        /*Pieza pieza = casilla.getPieza(); // Torre negra
        casilla.setPieza(null);
        casilla = tablero.getCasilla(4, 4);
        casilla.setPieza(pieza);
        pieza.setCasilla(casilla);*/

        casilla = tablero.getCasilla(0, 2); // Alfil negro
        Pieza pieza = casilla.getPieza();
        casilla.setPieza(null);
        casilla = tablero.getCasilla(2, 6);
        casilla.setPieza(pieza);
        pieza.setCasilla(casilla);

        /*casilla = tablero.getCasilla(0, 3); // Reina negra
        pieza = casilla.getPieza();
        casilla.setPieza(null);
        casilla = tablero.getCasilla(3, 2);
        casilla.setPieza(pieza);
        pieza.setCasilla(casilla);*/

        /*casilla = tablero.getCasilla(1, 2); // Peon negra
        pieza = casilla.getPieza();*/

        /*casilla = tablero.getCasilla(6, 4); // Peon blanco
        pieza = casilla.getPieza();*/

        /*casilla = tablero.getCasilla(0, 1); // Caballo negro
        pieza = casilla.getPieza();
        casilla.setPieza(null);
        casilla = tablero.getCasilla(4, 4);
        casilla.setPieza(pieza);
        pieza.setCasilla(casilla);*/

        /*casilla = tablero.getCasilla(0, 4); // Rey negro
        pieza = casilla.getPieza();
        casilla.setPieza(null);
        casilla = tablero.getCasilla(4, 5);
        casilla.setPieza(pieza);
        pieza.setCasilla(casilla);
*/
        if (casilla != null) {
            System.out.println(casilla.getCoordinate());
            if (pieza instanceof Pieza) {
                System.out.println(pieza.movidas(casilla.getPieza()));
            }
        }

        System.out.println(tablero);
    }
}
