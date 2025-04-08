# v001

Se introduce la clase de utilidad `Console.java`, que abstrae tanto las operaciones de entrada como las de salida por consola

## Vista pública

|Métodos de lectura|Métodos de escritura sin salto de línea|Métodos de escritura con salto de línea|Métodos para mensajes de error
|-|-|-|-|
|`public String readString(String title);`|`public void write(String string);`|`public void writeln();`|`public void writeError(String format);`
|`public String readString();`|`public void write(int value);`|`public void writeln(String string);`
|`public int readInt(String title);`|`public void write(double value);`|`public void writeln(int value);`
|`public double readDouble(String title);`|`public void write(char character);`|`public void writeln(double value);`
|`public char readChar(String title);`|`public void write(boolean value);`|`public void writeln(char value);`
|||`public void writeln(boolean value);`

La clase `Console` implementa:

- Métodos de lectura robustos con manejo de errores integrado
- Validación de formato con reintentos automáticos
- Mensajes de error personalizados y consistentes
- Métodos de escritura sobrecargados para distintos tipos de datos
- Versiones con y sin salto de línea para flexibilidad en la presentación

Esta implementación sigue los principios de responsabilidad única y encapsulamiento, aislando la complejidad de la interacción por consola del resto de la lógica. 

El diseño propuesto permite:

1. Cambiar el destino de la entrada/salida en el futuro modificando solo la implementación de `Console`
1. Aplicar formato consistente a través de toda la aplicación
1. Añadir funcionalidades adicionales (como registro o internacionalización) sin modificar el código cliente

A diferencia del uso directo de `Scanner` o `System.out`, esta clase ofrece mayor control, mejor manejo de errores y una interfaz coherente que mejora la mantenibilidad y reduce la duplicación de código, particularmente en aplicaciones con frecuente interacción por consola.
