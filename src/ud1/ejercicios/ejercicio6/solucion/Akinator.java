package ud1.ejercicios.ejercicio6.solucion;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;

public class Akinator extends Thread {

    private final Lock lock;
    private final SharedNumber sharedNumber;

    public Akinator(Lock lock, SharedNumber sharedNumber) {
        this.lock = lock;
        this.sharedNumber = sharedNumber;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (!sharedNumber.gameFinished) {
            System.out.print("Introduce tu intento: ");
            int intento = scanner.nextInt();

            synchronized (lock) {
                sharedNumber.number = intento; // Actualiza el intento del usuario

                // Notifica a BaseDeDatos que se ha hecho un nuevo intento
                lock.notifyAll();

                try {
                    // Espera a que BaseDeDatos verifique el intento
                    lock.wait();
                } catch (InterruptedException e) {
                    // Maneja la interrupción y sale del bucle
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        // Cierra el escáner solo cuando el juego ha terminado
        scanner.close();
    }
}
