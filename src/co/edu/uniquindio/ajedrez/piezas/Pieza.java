package co.edu.uniquindio.ajedrez.piezas;

public class Pieza implements IPieza {

    private TipoPieza tipo;
    private Color color;

    public Pieza(Color color) {
        this.color = color;
    }

    @Override
    public TipoPieza getTipo() {
        return tipo;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
