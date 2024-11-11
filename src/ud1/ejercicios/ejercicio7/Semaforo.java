package ud1.ejercicios.ejercicio7;

import ud1.ejercicios.ejercicio7.Carretera.Estado;

public class Semaforo extends Thread {

    private Carretera carretera;

    public Semaforo(Carretera carretera) {
        this.carretera = carretera;
    }
    @Override
    public void run() {
        while (true) {
            try {
                switch (comprobarEstado()) {
                    case VERDE:
                        System.out.println("\uD83D\uDFE2");
                        sleep(3000);
                        cambiarEstado(Estado.NARANJA);
                    case NARANJA:
                        System.out.println("\uD83D\uDFE0");
                        sleep(1000);
                        cambiarEstado(Estado.ROJO);
                    case ROJO:
                        System.out.println("\uD83D\uDD34");
                        sleep(2000);
                        cambiarEstado(Estado.VERDE);
                        advertirCoches();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void advertirCoches() {
        synchronized (carretera.lock) {
            carretera.lock.notifyAll();
        }
    }

    private void cambiarEstado(Estado estado) {
        synchronized (carretera.lock) {
            carretera.estado = estado;
        }
    }

    private Estado comprobarEstado() {
        synchronized (carretera.lock) {
            return carretera.estado;
        }
    }
}
