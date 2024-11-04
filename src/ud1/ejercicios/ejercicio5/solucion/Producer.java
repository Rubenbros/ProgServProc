package ud1.ejercicios.ejercicio5.solucion;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread {

    private ArrayList<Integer> list;
    private int nMax;
    private Lock lock;

    public Producer(ArrayList<Integer> list, int nMax, Lock lock) {
        this.list = list;
        this.nMax = nMax;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            int num = generarNumero();
            synchronized (lock) {
                try {
                    while (list.size() == nMax) {
                        lock.wait(); // Espera si la lista está llena
                    }
                    list.add(num); // Añade el número a la lista
                    System.out.println("Producido: " + num);

                    // Notifica al consumidor que hay un nuevo elemento
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private int generarNumero() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
