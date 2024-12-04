package ud1.ejercicios.ejercicio6.solucion;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class BaseDeDatos extends Thread {

    private final Lock lock;
    private final SharedNumber sharedNumber;
    private final int numeroSecreto;

    public BaseDeDatos(Lock lock, SharedNumber sharedNumber) {
        this.lock = lock;
        this.sharedNumber = sharedNumber;
        this.numeroSecreto = new Random().nextInt(100) + 1;
    }

    @Override
    public void run() {
        System.out.println("Número secreto generado por BaseDeDatos. ¡Intenta adivinarlo!");

        while (!sharedNumber.gameFinished) {
            synchronized (lock) {
                try {
                    // Espera hasta que el usuario haga un intento
                    lock.wait();
                } catch (InterruptedException e) {
                    // Maneja la interrupción y sale del bucle
                    Thread.currentThread().interrupt();
                    return;
                }

                // Verifica el intento del usuario
                if (sharedNumber.number == numeroSecreto) {
                    System.out.println("¡Felicidades! Has adivinado el número secreto: " + numeroSecreto);
                    sharedNumber.gameFinished = true; // Indica que el juego ha terminado
                } else if (sharedNumber.number < numeroSecreto) {
                    System.out.println("El número secreto es mayor. ¡Intenta de nuevo!");
                } else {
                    System.out.println("El número secreto es menor. ¡Intenta de nuevo!");
                }

                // Notifica a Akinator para que haga otro intento
                lock.notifyAll();
            }
        }
    }
}
