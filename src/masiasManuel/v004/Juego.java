package masiasManuel.v004;

public class Juego {
    public static void main(String[] args) {

        FabricaBuscaminas fabrica = new FabricaBuscaminas();
        Buscaminas buscaminas = fabrica.crearBuscaminas();
        
        buscaminas.jugar();
    }
}