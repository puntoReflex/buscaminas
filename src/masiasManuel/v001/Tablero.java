package masiasManuel.v001;

public class Tablero {
    private static final int DIMENSION = 6;
    private static final int NUM_MINAS = 6;
    private static final char CELDA_CUBIERTA = '_';
    private static final char CELDA_MARCADA = 'M';
    private static final char CELDA_DESPEJADA = 'D';
    private static final char CELDA_MINA = 'X';
    private Console console;

    private char[][] celdas;
    private boolean[][] minas;
    private boolean[][] despejadas;
    private boolean[][] marcadas;

    public Tablero() {
        celdas = new char[DIMENSION][DIMENSION];
        minas = new boolean[DIMENSION][DIMENSION];
        despejadas = new boolean[DIMENSION][DIMENSION];
        marcadas = new boolean[DIMENSION][DIMENSION];
        console = new Console();

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                celdas[i][j] = CELDA_CUBIERTA;
                minas[i][j] = false;
                despejadas[i][j] = false;
                marcadas[i][j] = false;
            }
        }
        colocarMinas();
    }

    private void colocarMinas() {
        int minasColocadas = 0;

        while (minasColocadas < NUM_MINAS) {
            int fila = (int) (Math.random() * DIMENSION);
            int columna = (int) (Math.random() * DIMENSION);

            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }

    public void mostrar() {
        console.clearScreen();
        console.writeln("BUSCAMINAS");
        console.write("  ");
        for (int i = 1; i <= DIMENSION; i++) {
            console.write(i + " ");
        }
        console.writeln();

        for (int i = 0; i < DIMENSION; i++) {
            console.write((i + 1) + " ");
            for (int j = 0; j < DIMENSION; j++) {
                console.write(celdas[i][j] + " ");
            }
            console.writeln();
        }
        console.writeln();
    }

    public boolean despejar(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = coordenada.getColumna() - 1;

        if (despejadas[fila][columna] || marcadas[fila][columna]) {
            return true;
        }

        despejadas[fila][columna] = true;

        if (minas[fila][columna]) {
            celdas[fila][columna] = CELDA_MINA;
            return false;
        } else {
            celdas[fila][columna] = CELDA_DESPEJADA;
            return true;
        }
    }

    public void marcar(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = coordenada.getColumna() - 1;

        if (!despejadas[fila][columna]) {
            marcadas[fila][columna] = !marcadas[fila][columna];
            celdas[fila][columna] = marcadas[fila][columna] ? CELDA_MARCADA : CELDA_CUBIERTA;
        }
    }

    public boolean estaDespejada(Coordenada coordenada) {
        return despejadas[coordenada.getFila() - 1][coordenada.getColumna() - 1];
    }

    public boolean estaMarcada(Coordenada coordenada) {
        return marcadas[coordenada.getFila() - 1][coordenada.getColumna() - 1];
    }

    public boolean hayVictoria() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (!minas[i][j] && !despejadas[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void revelarMinas() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (minas[i][j]) {
                    celdas[i][j] = CELDA_MINA;
                }
            }
        }
    }
}
