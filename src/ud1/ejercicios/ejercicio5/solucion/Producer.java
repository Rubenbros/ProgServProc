package ud1.ejercicios.ejercicio5.solucion;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread {

    private int nMax;
    private List<Integer> numeros;
    private Lock lock;

    public Producer(int nMax, List<Integer> numeros, Lock lock) {
        this.nMax = nMax;
        this.numeros = numeros;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            int num = (int) (Math.random() * 100);
            synchronized (lock) {
                while(numeros.size() == nMax) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                numeros.add(num);
                System.out.println("Produced: " + num);
                lock.notifyAll();
            }
        }
    }
}
