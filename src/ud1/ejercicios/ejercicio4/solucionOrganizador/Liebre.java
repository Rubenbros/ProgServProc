package ud1.ejercicios.ejercicio4.solucionOrganizador;

import java.util.Random;

public class Liebre extends Thread {

    private Carrera carrera;
    private Random random = new Random();

    public Liebre(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void run() {
        while (seguirJugando()){
            esperarTurno();
            if(!seguirJugando()) break;
            moverLiebre();
            terminarTurno();
        }
    }

    private void terminarTurno() {
        synchronized (carrera.lockLiebre) {
            carrera.turnoLiebre = false;
            carrera.lockLiebre.notifyAll();
        }
    }

    private void moverLiebre() {
        int movimiento = random.nextInt(100);
        if (movimiento < 20)
            calcularPosicion(0);
        else if (movimiento < 40)
            calcularPosicion(9);
        else if (movimiento < 50)
            calcularPosicion(-12);
        else if (movimiento < 80)
            calcularPosicion(1);
        else
            calcularPosicion(-2);
    }

    private void calcularPosicion(int movimiento) {
        synchronized (carrera.lockLiebre) {
            carrera.posicionLiebre += movimiento;
            if(carrera.posicionLiebre < 0)
                carrera.posicionLiebre = 0;
        }
    }

    private void esperarTurno() {
        synchronized (carrera.lockLiebre) {
            while (!carrera.turnoLiebre) {
                try {
                    carrera.lockLiebre.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean seguirJugando() {
        synchronized (carrera.terminado) {
            return !carrera.terminado;
        }
    }
}
