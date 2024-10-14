package ud1.ejercicios.ejercicio1;

public class Main {

    public static void main(String[] args) {

        //Implentar objeto Counter que simplemente empieza a contar desde 0 y tiene un solo metodo que se llama increment
        //que aumenta el valor del contador en 1 y un metodo que devuelve su valor actual
        Counter counter = new Counter();

        //NumThreads es el numero de hilos concurrentes
        int numThreads = 6;

        //IncrementsPerThread es el numero de veces que el hilo incrementa el valor del contador
        int incrementsPerThread = 10000;

        //Implementar la clase IncrementThread que recibe el contador y le suma el valor de incrementsPerThread mediante
        //el metodo increment de Counter. El valor de incrementsPerThread es el numero de veces que el hilo incrementa el
        //valor del contador
        IncrementThread[] threads = new IncrementThread[numThreads];

        // Crea e inicia los hilos
            for (int i = 0; i < numThreads; i++) {
            threads[i] = new IncrementThread(counter, incrementsPerThread);
            threads[i].start();
        }

        // Espera que todos los hilos finalicen
            try {
            for (IncrementThread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprime el valor final del contador
            System.out.println("Final count: " + counter.getCount());
    }
}
