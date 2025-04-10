package masiasManuel.v004;

public class FabricaBuscaminas {
    
    public Tablero crearTablero() {
        return new Tablero();
    }
    
    public Jugador crearJugador() {
        return new Jugador();
    }
    
    public VistaTablero crearVistaTablero() {
        return new VistaTablero();
    }
    
    public Buscaminas crearBuscaminas() {
        Tablero tablero = crearTablero();
        Jugador jugador = crearJugador();
        VistaTablero vista = crearVistaTablero();
        
        return new Buscaminas(tablero, jugador, vista);
    }
}