package ud1.ejercicios.ejercicio2.solucion;

class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= Main.MAX_NUMBER; i += 2) {
            synchronized (Main.lock) {
                while (!Main.isEvenTurn) {
                    try {
                        Main.lock.wait(); // Espera si no es el turno de pares
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even Number from EvenThread: " + i);
                Main.isEvenTurn = false; // Cambia el turno a impares
                Main.lock.notify(); // Notifica al hilo impar
            }
        }
    }
}