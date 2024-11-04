package ud1.ejercicios.ejercicio5.solucion;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread {

    private ArrayList<Integer> list;
    private Lock lock;

    public Consumer(ArrayList<Integer> list, Lock lock) {
        this.list = list;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    while (list.isEmpty()) {
                        lock.wait(); // Espera a que haya elementos en la lista
                    }
                    int num = list.remove(0); // Consume el primer elemento
                    System.out.println("Consumido: " + num);

                    // Notifica al productor que ha consumido un elemento
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
