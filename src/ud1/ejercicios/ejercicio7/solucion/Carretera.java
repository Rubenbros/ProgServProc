package ud1.ejercicios.ejercicio7.solucion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Carretera {

    public enum Estado {
        VERDE, ROJO, NARANJA
    }
    public Estado estado = Estado.VERDE;
    public final Lock lock = new ReentrantLock();
}
