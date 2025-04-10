# v004 - Controlador & vista separada & patrón creador

## Cambios realizados

1. Nueva clase: ControladorBuscaminas, responsable de coordinar todas las interacciones entre el modelo (Tablero) y la vista:
    - Centraliza el bucle principal del juego
    - Maneja las acciones del jugador
    - Controla el estado del juego
    - Coordina el flujo de información entre el modelo y la vista
    - Mayor cohesión: Cada método tiene una única responsabilidad bien definida.
1. Actualización de FabricaBuscaminas
    - Añadido método crearControlador() para instanciar el nuevo controlador.
    - Mantiene la cohesión asegurando que la fábrica sigue siendo responsable de la creación de todos los objetos.
1. Modificación de Juego
    - Ahora utiliza directamente el controlador en lugar de la clase Buscaminas.
    - El flujo es más claro y directo.

### A tener en cuenta

- Buscaminas - Toda la clase ha sido reemplazada por ControladorBuscaminas
- De la clase Jugador
  - jugar(Tablero tablero) - La lógica de juego ahora está en el controlador
  - pedirAccion() - Reemplazado por obtenerAccionJugador() en el controlador
  - celebrarVictoria() - Reemplazado por la gestión en el controlador y la vista
  - lamentarDerrota() - Reemplazado por la gestión en el controlador y la vista
  - estaVivo() - El estado del jugador ahora se gestiona en el controlador
  - O sea, toda la clase Jugador ya no es necesaria, ya que sus responsabilidades han sido asumidas por el controlador.
- Otros ajustes:
  - En FabricaBuscaminas, el método crearJugador() técnicamente ya no es necesario, aunque se mantiene para crear Buscaminas (que también es innecesario)
  - El método crearBuscaminas() de FabricaBuscaminas ya no se utiliza en la nueva implementación

<div align=center>

|||
|-|-|
|El patrón Controlador centraliza la lógica de coordinación que antes estaba dispersa entre varias clases, lo que resulta en un diseño más cohesivo y menos acoplado|La aplicación de los patrones vistos modifica la estructura -arquitectura- de un sistema para mejorar su organización.|

</div>

## Beneficios obtenidos

<div align=center>

|||
|-|-|
|Centralización de la lógica de control|Elimina la lógica de control dispersa entre Buscaminas y Jugador
||Facilita la comprensión del flujo del juego
|Responsabilidades bien definidas|El controlador coordina las interacciones
||El modelo (Tablero) maneja los datos y la lógica de dominio
||La vista (VistaTablero) se encarga de la presentación
|Flexibilidad para cambios|Podemos modificar aspectos específicos del juego sin afectar al resto
||Facilita la implementación de nuevas características
|Código más modular|Cada componente tiene una función clara y específica
||Las dependencias están explícitamente definidas y gestionadas

</div>

## Observaciones adicionales

### MVC a partir de los tres patrones de indirección principales

- Vista Separada: Separación entre el modelo (Tablero) y su visualización (VistaTablero)
- Creador: Centralización de la creación de objetos (FabricaBuscaminas)
- Controlador: Coordinación de las interacciones (ControladorBuscaminas)