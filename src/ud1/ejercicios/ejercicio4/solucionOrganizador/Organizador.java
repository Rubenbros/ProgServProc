package ud1.ejercicios.ejercicio4.solucionOrganizador;

public class Organizador extends Thread {

    private Carrera carrera;

    public Organizador(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void run() {
        System.out.println("Empieza la carrera!");
        printCarrera();
        while(seguirJugando()) {
            darTurnos();
            esperarMovimientos();
            if (carreraContinua())
                printCarrera();
            else{
                notificarFin();
            }
        }
        mostrarGanador();
    }

    private void mostrarGanador() {
        System.out.println("La carrera ha terminado!");
        if(carrera.posicionTortuga >= Carrera.META && carrera.posicionLiebre >= Carrera.META)
            System.out.println("\uD83D\uDC07 \uD83D\uDC95 \uD83D\uDC22");
        else if (carrera.posicionTortuga >= Carrera.META)
            System.out.println("\uD83D\uDC22 \uD83E\uDD47");
        else
            System.out.println("\uD83D\uDC07 \uD83E\uDD47");
    }

    private void notificarFin() {
        synchronized (carrera.terminado) {
            carrera.terminado = true;
        }
        synchronized (carrera.lockTortuga) {
            carrera.turnoTortuga = true;
            carrera.lockTortuga.notifyAll();
        }
        synchronized (carrera.lockLiebre) {
            carrera.turnoLiebre = true;
            carrera.lockLiebre.notifyAll();
        }
    }

    private boolean carreraContinua() {
        synchronized (carrera.lockTortuga) {
            synchronized (carrera.lockLiebre) {
                if(carrera.posicionTortuga >= Carrera.META || carrera.posicionLiebre >= Carrera.META)
                    return false;
            }
        }
        return true;
    }

    private void esperarMovimientos() {
        synchronized (carrera.lockLiebre) {
            while (carrera.turnoLiebre) {
                try {
                    carrera.lockLiebre.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized (carrera.lockTortuga) {
            while (carrera.turnoTortuga) {
                try {
                    carrera.lockTortuga.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void darTurnos() {
        synchronized (carrera.lockLiebre) {
            synchronized (carrera.lockTortuga) {
                carrera.turnoTortuga = true;
                carrera.lockTortuga.notifyAll();
                carrera.turnoLiebre = true;
                carrera.lockLiebre.notifyAll();
            }
        }
    }

    private boolean seguirJugando() {
        synchronized (carrera.terminado) {
            return !carrera.terminado;
        }
    }

    private void printCarrera() {
        for(int i = 0; i < Carrera.META; i++) {
            if(i == carrera.posicionLiebre)
                System.out.print("\uD83D\uDC07");
            else
                System.out.print("=");
        }
        System.out.println();
        for(int i = 0; i < Carrera.META; i++) {
            if(i == carrera.posicionTortuga)
                System.out.print("\uD83D\uDC22");
            else
                System.out.print("=");
        }
        System.out.println();
        System.out.println();
    }
}
