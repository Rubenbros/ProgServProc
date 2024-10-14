package ud1.ejercicios.ejercicio2.solucion;

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= Main.MAX_NUMBER; i += 2) {
            synchronized (Main.lock) {
                while (Main.isEvenTurn) {
                    try {
                        Main.lock.wait(); // Espera si no es el turno de impares
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Number from OddThread: " + i);
                Main.isEvenTurn = true; // Cambia el turno a pares
                Main.lock.notify(); // Notifica al hilo par
            }
        }
    }
}