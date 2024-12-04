package ud1.ejercicios.ejercicio7.solucion;

//Simula el funcionamiento de una carrera con un semáforo
//Los hilos de coches esperan el semáforo verde para avanzar y cuando han pasado esperan un tiempo aleatorio entre 1 y 5 segundos
//para volver a pasar
//El hilo del semáforo esta 3 segundos en verde donde los coches pueden pasar
//El hilo del semáforo esta 2 segundos en rojo donde los coches no pueden pasar
//El hilo del semáforo esta 1 segundo en naranja donde los coches tienen un 50% de posibilidades de pasar o quedarse esperando
public class Main {

    public static void main(String[] args) {
        final int NUM_COCHES = 10;
        Carretera carretera = new Carretera();
        Semaforo semaforo = new Semaforo(carretera);
        Coche[] coches = new Coche[NUM_COCHES];

        semaforo.start();
        for (int i = 0; i < coches.length; i++) {
            coches[i] = new Coche(carretera, i);
            coches[i].start();
        }

        try {
            semaforo.join();
            for (Coche coche : coches) coche.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
