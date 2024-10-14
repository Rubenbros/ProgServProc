package ud1.ejercicios.ejercicio2;

//En este ejercicio, debes implementar un programa que use dos hilos. Uno de los hilos será responsable de contar los
//números impares y el otro de contar los números pares, de forma sincronizada, alternando entre un número impar y uno par.
public class Main {
    public static void main(String[] args) {
        Object lock = new Object(); // Objeto para sincronización

        // Crear hilos
        EvenThread evenThread = new EvenThread(lock);
        OddThread oddThread = new OddThread(lock);

        // Iniciar hilos
        evenThread.start();
        oddThread.start();

        // Esperar a que ambos hilos terminen
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ejecución finalizada.");
    }
}