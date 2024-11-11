package ud1.ejercicios.ejercicio6.solucion;

import java.util.Scanner;

public class Akinator extends Thread {

    private Shared shared;
    private Scanner scanner = new Scanner(System.in);

    public Akinator(Shared shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        while (comprobarTurno() && !juegoTerminado()) {
            pedirNumero();
        }
    }

    private boolean comprobarTurno() {
        synchronized (shared.lock) {
            while (shared.turnoBD) {
                try {
                    shared.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private void pedirNumero() {
        System.out.println("Intenta adivinar el numero del 1 al 10: ");
        int numero = scanner.nextInt();
        synchronized (shared.lock) {
            shared.intento = numero;
            shared.turnoBD = true;
            shared.lock.notifyAll();
        }
    }

    private boolean juegoTerminado() {
        synchronized (shared.lock) {
            return shared.end;
        }
    }

}

