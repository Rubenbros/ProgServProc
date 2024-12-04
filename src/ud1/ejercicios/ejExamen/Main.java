package ud1.ejercicios.ejExamen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static int turno = 1;
    public static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo(1);
        Hilo hilo2 = new Hilo(2);
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
