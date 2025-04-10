package masiasManuel.v005;

public class VistaTablero {
    private Console console;
    
    public VistaTablero() {
        console = new Console();
    }
    
    public void mostrar(Tablero tablero) {
        console.clearScreen();
        console.writeln("BUSCAMINAS");
        console.write("  ");
        
        for (int i = 1; i <= tablero.getDimension(); i++) {
            console.write(i + " ");
        }
        console.writeln();

        for (int i = 0; i < tablero.getDimension(); i++) {
            console.write((i + 1) + " ");
            for (int j = 0; j < tablero.getDimension(); j++) {
                console.write(tablero.getCelda(i, j) + " ");
            }
            console.writeln();
        }
        console.writeln();
    }
    
    public void mostrarMensajeVictoria() {
        console.writeln("¡Felicidades! Has ganado el juego.");
    }
    
    public void mostrarMensajeDerrota() {
        console.writeln("¡BOOM! Has pisado una mina. Fin del juego.");
    }
}