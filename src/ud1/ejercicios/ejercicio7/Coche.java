package ud1.ejercicios.ejercicio7;

import ud1.ejercicios.ejercicio7.Carretera.Estado;

import java.util.Random;

public class Coche extends Thread {

    private Carretera carretera;
    private int id;
    private Random random = new Random();

    public Coche(Carretera carretera, int id) {
        this.carretera = carretera;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            darVuelta();
            switch (mirarSemaforo()) {
                case VERDE:
                    System.out.println("Coche " + id + " pasa en verde");
                    break;
                case ROJO:
                    System.out.println("Coche " + id + " espera en rojo");
                    esperarVerde();
                    break;
                case NARANJA:
                    if(paraEnNaranja()) {
                        System.out.println("Coche " + id + " espera en amarillo");
                        esperarVerde();
                    }
                    else
                        System.out.println("Coche " + id + " pasa en amarillo");
            }
        }
    }

    private boolean paraEnNaranja() {
        return random.nextBoolean();
    }

    private void esperarVerde() {
        synchronized (carretera.lock) {
            while (carretera.estado != Estado.VERDE) {
                try {
                    carretera.lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void darVuelta() {
        try {
            sleep(random.nextInt(1000,5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Estado mirarSemaforo() {
        synchronized (carretera.lock) {
            return carretera.estado;
        }
    }
}
