package ud1.ejercicios.ejercicio5.solucion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shared {

    public final Lock lock = new ReentrantLock();
    public Integer intento = -1;
    public Boolean end = false;
    public Boolean turnoBD = false;
}
