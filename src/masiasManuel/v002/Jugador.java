package masiasManuel.v002;

public class Jugador {

    private boolean estaVivo;
    private Console console;

    public Jugador() {
        estaVivo = true;
        console = new Console();
    }

    public void jugar(Tablero tablero) {
        char accion = pedirAccion();
        Coordenada coordenada = new Coordenada();
        coordenada.pedir();

        if (accion == 'D') {
            console.writeln("Coordenada despejada");
            estaVivo = tablero.despejar(coordenada);
        } else if(accion == 'B') {
            console.writeln("Bloque despejado");
            estaVivo = tablero.despejarBloque(coordenada);
        } else {
            tablero.marcar(coordenada);
            console.writeln("Coordenada marcada");
        }
    }

    private char pedirAccion() {
        char accion;
        do {
            accion = console.readChar("[D]espejar, despejar [B]loque o [M]arcar mina?", true);
        } while (accion != 'D' && accion != 'M' && accion != 'B');
        console.writeln();
        return accion;
    }

    public void celebrarVictoria() {
        console.writeln("¡Felicidades! Has ganado el juego.");
    }

    public void lamentarDerrota() {
        console.writeln("¡BOOM! Has pisado una mina. Fin del juego.");
    }

    public boolean estaVivo() {
        return estaVivo;
    }
}