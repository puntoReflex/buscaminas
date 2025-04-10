# v004 - Vista separada & patrón creador

## Cambios realizados

1. Nueva clase: FabricaBuscaminas, responsable de la creación de todos los componentes del juego
    - crearTablero(): Crea una instancia de Tablero
    - crearJugador(): Crea una instancia de Jugador
    - crearVistaTablero(): Crea una instancia de VistaTablero
    - crearBuscaminas(): Crea una instancia completa del juego con todos sus componentes
1. Modificación de Buscaminas
    - Eliminado el constructor por defecto que creaba directamente las dependencias
    - Añadido un constructor que recibe las dependencias ya instanciadas (inyección de dependencias)
1. Modificación de Juego
    - Utiliza FabricaBuscaminas para crear el juego

## Beneficios obtenidos

- Reducción del acoplamiento: Buscaminas ya no depende directamente de implementaciones concretas.
- Flexibilidad para cambios futuros: Podemos cambiar fácilmente las implementaciones.
  ```java
  public class FabricaBuscaminasGrafico extends FabricaBuscaminas {
      @Override
      public VistaTablero crearVistaTablero() {
          return new VistaTableroGrafico();
      }
  }
  ```
- Centralización de la lógica de creación: Todos los objetos se crean de manera consistente en un solo lugar.
- Preparación para patrones adicionales: Esta estructura facilita la implementación de patrones como Abstract Factory, Factory Method o Builder en el futuro.
