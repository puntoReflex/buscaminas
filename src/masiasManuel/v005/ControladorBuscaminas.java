package masiasManuel.v005;

public class ControladorBuscaminas {
    private Tablero tablero;
    private VistaTablero vista;
    private boolean juegoTerminado;
    private boolean victoria;
    private boolean jugadorVivo;
    
    public ControladorBuscaminas(Tablero tablero, VistaTablero vista) {
        this.tablero = tablero;
        this.vista = vista;
        this.juegoTerminado = false;
        this.victoria = false;
        this.jugadorVivo = true;
    }
    
    public void iniciarJuego() {
        juegoTerminado = false;
        victoria = false;
        jugadorVivo = true;
        
        ejecutarBucleJuego();
    }
    
    private void ejecutarBucleJuego() {
        while (!juegoTerminado) {
            vista.mostrar(tablero);
            procesarTurno();
            verificarEstadoJuego();
        }
        
        terminarJuego();
    }
    
    private void procesarTurno() {
        AccionJugador accion = obtenerAccionJugador();
        Coordenada coordenada = obtenerCoordenadaJugador();
        
        ejecutarAccion(accion, coordenada);
    }
    
    private AccionJugador obtenerAccionJugador() {
        Console console = new Console();
        char accion;
        do {
            accion = console.readChar("[D]espejar, despejar [B]loque o [M]arcar mina?", true);
        } while (accion != 'D' && accion != 'M' && accion != 'B');
        console.writeln();
        
        if (accion == 'D') return AccionJugador.DESPEJAR;
        else if (accion == 'B') return AccionJugador.DESPEJAR_BLOQUE;
        else return AccionJugador.MARCAR;
    }
    
    private Coordenada obtenerCoordenadaJugador() {
        Coordenada coordenada = new Coordenada();
        coordenada.pedir();
        return coordenada;
    }
    
    private void ejecutarAccion(AccionJugador accion, Coordenada coordenada) {
        Console console = new Console();
        
        switch (accion) {
            case DESPEJAR:
                console.writeln("Coordenada despejada");
                jugadorVivo = tablero.despejar(coordenada);
                break;
            case DESPEJAR_BLOQUE:
                console.writeln("Bloque despejado");
                jugadorVivo = tablero.despejarBloque(coordenada);
                break;
            case MARCAR:
                tablero.marcar(coordenada);
                console.writeln("Coordenada marcada");
                break;
        }
    }
    
    private void verificarEstadoJuego() {
        victoria = tablero.hayVictoria();
        juegoTerminado = victoria || !jugadorVivo;
    }
    
    private void terminarJuego() {
        if (!victoria) {
            tablero.revelarMinas();
            vista.mostrarMensajeDerrota();
        } else {
            vista.mostrarMensajeVictoria();
        }
        vista.mostrar(tablero);
    }
    
    private enum AccionJugador {
        DESPEJAR,
        DESPEJAR_BLOQUE,
        MARCAR
    }
}