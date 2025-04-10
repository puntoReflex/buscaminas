package masiasManuel.v005;

public class Juego {
    public static void main(String[] args) {

        FabricaBuscaminas fabrica = new FabricaBuscaminas();
        ControladorBuscaminas controlador = fabrica.crearControlador();
        
        controlador.iniciarJuego();
    }
}