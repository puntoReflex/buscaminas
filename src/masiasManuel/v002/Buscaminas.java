package masiasManuel.v002;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar() {
        boolean jugando = true;

        do {
            tablero.mostrar();
            jugador.jugar(tablero);
            jugando = !tablero.hayVictoria() && jugador.estaVivo();
        } while (jugando);

        terminarJuego();
    }

    private void terminarJuego() {
        if (!tablero.hayVictoria()) {
            tablero.revelarMinas();
            jugador.lamentarDerrota();
        } else {
            jugador.celebrarVictoria();
        }
        tablero.mostrar();
    }
}