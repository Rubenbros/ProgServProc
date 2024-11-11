package ud1.ejercicios.ejercicio6.solucion;

import java.util.Random;

public class BD extends Thread{

    private Shared shared;
    private final Integer numero = generarNumero();

    public BD(Shared shared) {
        this.shared = shared;
    }

    private Integer generarNumero() {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Override
    public void run(){
        while (!juegoTerminado()){
            esperarNumero();
            comprobarIntento();
        }
        System.out.println("Enhorabuena");
    }

    private void comprobarIntento() {
        synchronized (shared.lock) {
            if (shared.intento.equals(numero)) {
                shared.end = true;
            }
            shared.turnoBD = false;
            shared.lock.notifyAll();
        }
    }

    private void esperarNumero() {
        synchronized (shared.lock) {
            while (!shared.turnoBD) {
                try {
                    shared.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean juegoTerminado() {
        synchronized (shared.lock) {
            return shared.end;
        }
    }
}


