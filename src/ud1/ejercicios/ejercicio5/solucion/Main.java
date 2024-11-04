package ud1.ejercicios.ejercicio5.solucion;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Crea dos hilos: uno que produce números aleatorios y otro que consume esos números.
//Utiliza un ArrayList o una cola para almacenar los números producidos.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        final int nMax = 10;
        Lock lock = new ReentrantLock();

        Producer producer = new Producer(list, nMax,lock);
        Consumer consumer = new Consumer(list,lock);

        producer.start();
        consumer.start();

        try {
            Thread.sleep(5000);
            System.out.println("hora de acabar");
            producer.interrupt();
            consumer.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
