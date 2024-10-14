package ud1.ejercicios.ejercicio2;

public class OddThread extends Thread {
    private final Object lock;
    private static final int MAX_NUMBER = 19;

    public OddThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= MAX_NUMBER; i += 2) {
            synchronized (lock) {
                // COMPLETAR: Lógica para esperar si no es el turno de impares
                // Tip: Usa wait()

                System.out.println("Impar: " + i);

                // COMPLETAR: Notifica al hilo de pares que su turno ha llegado
                lock.notify();
            }
        }
    }
}