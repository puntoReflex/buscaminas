package masiasManuel.v001;

public class Coordenada {
    private int fila;
    private int columna;
    private Console console;
    
    public Coordenada(){
        console = new Console();
    }

    public void pedir() {
        console.writeln("Elija coordenada:");
        do {
            this.fila = console.readInt("> Fila: ");
            this.columna = console.readInt("> Columna: ");
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
