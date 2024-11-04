package ud1.ejercicios.ejercicio6.solucion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Implementa un pequeño juego donde un hilo genera un número aleatorio y otro hilo pide al usuario que adivine ese número.
public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        // Crear una instancia de la clase para compartir el intento del usuario
        SharedNumber sharedNumber = new SharedNumber();

        // Crear instancias de BaseDeDatos y Akinator, compartiendo la variable de intento
        BaseDeDatos baseDeDatos = new BaseDeDatos(lock, sharedNumber);
        Akinator akinator = new Akinator(lock, sharedNumber);

        baseDeDatos.start();
        akinator.start();

        try {
            baseDeDatos.join();
            akinator.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
