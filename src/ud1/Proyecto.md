# Trabajo de Programación: Simulación del Juego de la Vida en Java

## Asignatura: Programación de Procesos y Servicios

### Descripción del Trabajo

El objetivo de este trabajo es implementar el **Juego de la Vida** de Conway utilizando programación concurrente en Java. Cada celda del tablero debe representarse como un hilo independiente que evalúe su estado (viva o muerta) en función de sus celdas vecinas. Un hilo controlador gestionará los ciclos de vida (generaciones) del tablero.

### Reglas del Juego de la Vida

1. **Supervivencia**: una celda viva con 2 o 3 celdas vecinas vivas permanece viva.
2. **Muerte por soledad**: una celda viva con menos de 2 celdas vecinas vivas muere.
3. **Muerte por sobrepoblación**: una celda viva con más de 3 celdas vecinas vivas muere.
4. **Nacimiento**: una celda muerta con exactamente 3 celdas vecinas vivas se convierte en una celda viva.

### Requisitos

1. **Implementación en Java**:
    - Cada celda debe ser un hilo que revise y actualice su estado en función de sus celdas vecinas.
    - Un hilo controlador debe gestionar el avance de generaciones sincronizando las celdas para actualizar el tablero de forma coordinada.

2. **Configuración del Tablero**:
    - El tablero debe poder inicializarse con un tamaño fijo especificado en el código y un estado inicial de celdas vivas o muertas generadas aleatoriamente o predeterminadas.

3. **Sincronización**:
    - Las celdas deben sincronizarse para evitar condiciones de carrera y asegurar que todas revisen su estado antes de avanzar a la siguiente generación.

4. **Salida en Consola**:
    - Mostrar el estado del tablero en cada generación.

### Formación de Grupos

El trabajo puede realizarse en grupos de 1, 2 o 3 personas.

### Fecha de Entrega

- **16/12/2024 23:59**
- Enviar repositorio o al correo con los fuentes ruben.jarne@cpilosenlaces.com

---

¡Buena suerte!
