import co.edu.uniquindio.ajedrez.Casilla;
import co.edu.uniquindio.ajedrez.Tablero;
import co.edu.uniquindio.ajedrez.piezas.Dummy;

public class Main {

    public static void main(String args[]) {

        Tablero tablero = new Tablero();
        System.out.println(tablero);

        // Validamos los posible movimientos de la pieza dummy negra
        Casilla casilla = tablero.getCasilla(1, 0);
        if (casilla != null) {
            System.out.println(casilla.getCoordinate());
            System.out.println(Dummy.movidas(casilla.getPieza()));
        }

        // Validamos los posibles movimientos de la pieza dummy blanca
        casilla = tablero.getCasilla(6, 0);
        if (casilla != null) {
            System.out.println(casilla.getCoordinate());
            System.out.println(Dummy.movidas(casilla.getPieza()));
        }
        
    }
}
