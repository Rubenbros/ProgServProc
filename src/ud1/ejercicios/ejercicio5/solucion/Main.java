package ud1.ejercicios.ejercicio5.solucion;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Crea dos hilos: uno que produce números aleatorios y otro que consume esos números.
//Utiliza un ArrayList o una cola para almacenar los números producidos.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(); // ArrayList para almacenar los números
        final int nMax = 10;
        Lock lock = new ReentrantLock();

        Producer producer = new Producer(nMax, numeros, lock);
        Consumer consumer = new Consumer(numeros, lock);

        producer.start();
        consumer.start();

    }
}
