import co.edu.uniquindio.ajedrez.Casilla;
import co.edu.uniquindio.ajedrez.Tablero;
import co.edu.uniquindio.ajedrez.piezas.Dummy;

public class Main {

    public static void main(String args[]) {

        Tablero tablero = new Tablero();
        System.out.println(tablero);

        Casilla casilla = tablero.getCasilla(1, 0);
        if (casilla != null) {
            System.out.println(Dummy.movidas("a7"));
        }
    }
}
