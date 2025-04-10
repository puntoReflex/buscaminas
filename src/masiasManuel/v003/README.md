# v003 - Patrón vista separada

## Cambios realizados

- Eliminado el método mostrar() de la clase Tablero
  - Se quitó toda la responsabilidad de visualización
  - Se añadieron métodos getter (getCelda() y getDimension()) para que la vista pueda acceder a los datos
- Creada la nueva clase VistaTablero
  - Encapsula toda la lógica de visualización
  - Incluye métodos para mostrar mensajes de victoria y derrota
- Modificada la clase Buscaminas
  - Ahora incluye una instancia de VistaTablero
  - Delega la visualización a esta clase
  - La lógica del juego permanece igual
- Modificada la clase Jugador
  - Se eliminaron los métodos celebrarVictoria() y lamentarDerrota() ya que ahora eso es responsabilidad de VistaTablero

## Beneficios de esta implementación

<div align=center>

|||
|-|-|
|Mejor separación de responsabilidades|Tablero gestiona solamente el estado del juego
||VistaTablero se encarga de la visualización
||Buscaminas coordina el flujo del juego
|Mayor flexibilidad|Podemos cambiar la visualización (por ejemplo, crear una interfaz gráfica) sin modificar la lógica del juego
||Podemos probar la lógica del juego sin depender de la interfaz de usuario
|Código más mantenible|Los cambios en la visualización no afectan a la lógica y viceversa
||Cada clase tiene una única responsabilidad, lo que hace más fácil entender y modificar el código
|Consistencia con los patrones de indirección|Implementa el patrón Vista Separada de forma clara
||Ejemplifica los principios mencionados en el documento teórico

</div>
