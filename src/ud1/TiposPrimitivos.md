## Por qué no se Pueden Pasar Tipos Primitivos entre Hilos sin ser Finales

Los tipos primitivos en Java, como `int`, `boolean`, etc., son **inmutables**. Cuando se pasa un tipo primitivo entre hilos, lo que se pasa es una copia del valor, no una referencia al objeto. Esto significa que si un hilo modifica el valor, no afectará a la copia que tiene otro hilo.

