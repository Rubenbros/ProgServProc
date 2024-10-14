package ud1.ejercicios.ejercicio2;

public class EvenThread extends Thread {
    private final Object lock;
    private static final int MAX_NUMBER = 20;

    public EvenThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 2; i <= MAX_NUMBER; i += 2) {
            synchronized (lock) {
                // COMPLETAR: Lógica para esperar si no es el turno de pares
                // Tip: Usa wait()

                System.out.println("Par: " + i);

                // COMPLETAR: Notifica al hilo de impares que su turno ha llegado
                lock.notify();
            }
        }
    }
}