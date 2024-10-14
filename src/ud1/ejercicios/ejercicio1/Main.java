package ud1.ejercicios.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numThreads = 6;
        int incrementsPerThread = 10000;
        IncrementThread[] threads = new IncrementThread[numThreads];

        // Crear e iniciar los hilos
        // COMPLETAR: Inicia los hilos con un bucle y llama a start()

        // Esperar a que todos los hilos terminen
        // COMPLETAR: Usa un bucle para esperar que cada hilo termine

        // Imprimir el conteo final
        System.out.println("Final count: " + counter.getCount());
    }
}