package masiasManuel.v000;

import java.util.Scanner;

public class Jugador {

    private boolean estaVivo;

    public Jugador() {
        estaVivo = true;
    }

    public void jugar(Tablero tablero) {
        char accion = pedirAccion();
        Coordenada coordenada = new Coordenada();
        coordenada.pedir();

        if (accion == 'D') {
            System.out.println("Coordenada despejada");
            estaVivo = tablero.despejar(coordenada);
        } else {
            tablero.marcar(coordenada);
            System.out.println("Coordenada marcada");
        }
    }

    private char pedirAccion() {
        char accion;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("[D]espejar o [M]arcar mina? ");
            accion = scanner.next().toUpperCase().charAt(0);
        } while (accion != 'D' && accion != 'M');
        System.out.println();
        return accion;
    }

    public void celebrarVictoria() {
        System.out.println("¡Felicidades! Has ganado el juego.");
    }

    public void lamentarDerrota() {
        System.out.println("¡BOOM! Has pisado una mina. Fin del juego.");
    }

    public boolean estaVivo() {
        return estaVivo;
    }
}