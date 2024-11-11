package ud1.ejercicios.ejercicio5.solucion;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread {

    private List<Integer> numeros;
    private Lock lock;

    public Consumer(List<Integer> numeros, Lock lock) {
        this.numeros = numeros;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (numeros.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer: " + numeros.remove(0));
                lock.notifyAll();
            }
        }
    }
}
