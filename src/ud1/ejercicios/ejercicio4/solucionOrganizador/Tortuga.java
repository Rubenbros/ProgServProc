package ud1.ejercicios.ejercicio4.solucionOrganizador;

import java.util.Random;

public class Tortuga extends Thread {

    private Carrera carrera;
    private Random random = new Random();

    public Tortuga(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void run() {
        while (seguirJugando()){
            esperarTurno();
            if(!seguirJugando()) break;
            moverTortuga();
            terminarTurno();
        }
    }

    private void terminarTurno() {
        synchronized (carrera.lockTortuga) {
            carrera.turnoTortuga = false;
            carrera.lockTortuga.notifyAll();
        }
    }

    private void moverTortuga() {
        int movimiento = random.nextInt(100);
        if(movimiento < 50)
            calcularPosicion(3);
        else if(movimiento < 70)
            calcularPosicion(-6);
        else
            calcularPosicion(1);
    }

    private void calcularPosicion(int movimiento) {
        synchronized (carrera.lockTortuga) {
            carrera.posicionTortuga += movimiento;
            if(carrera.posicionTortuga < 0)
                carrera.posicionTortuga = 0;
        }
    }

    private void esperarTurno() {
        synchronized (carrera.lockTortuga) {
            while (!carrera.turnoTortuga) {
                try {
                    carrera.lockTortuga.wait();
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
