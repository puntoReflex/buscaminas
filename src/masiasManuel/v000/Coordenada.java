package masiasManuel.v000;

import java.util.Scanner;

public class Coordenada {
    private int fila;
    private int columna;

    public void pedir() {
        System.out.println("Elija coordenada:");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("> Fila: ");
            this.fila = scanner.nextInt();
            System.out.print("> Columna: ");
            this.columna = scanner.nextInt();
        } while (!this.esValida());
    }

    public boolean esValida() {
        return (fila >= 1 && fila <= 6 && columna >= 1 && columna <= 6);
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}

