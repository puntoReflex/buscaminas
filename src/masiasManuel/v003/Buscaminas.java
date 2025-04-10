package masiasManuel.v003;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;
    private VistaTablero vista;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
        vista = new VistaTablero();
    }

    public void jugar() {
        boolean jugando = true;

        do {
            vista.mostrar(tablero);
            jugador.jugar(tablero);
            jugando = !tablero.hayVictoria() && jugador.estaVivo();
        } while (jugando);

        terminarJuego();
    }

    private void terminarJuego() {
        if (!tablero.hayVictoria()) {
            tablero.revelarMinas();
            vista.mostrarMensajeDerrota();
        } else {
            vista.mostrarMensajeVictoria();
        }
        vista.mostrar(tablero);
    }
}