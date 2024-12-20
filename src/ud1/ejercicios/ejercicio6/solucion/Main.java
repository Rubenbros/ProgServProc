package ud1.ejercicios.ejercicio6.solucion;

//Implementa un pequeño juego donde un hilo genera un número aleatorio y otro hilo pide al usuario que adivine ese número.
public class Main {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Akinator akinator = new Akinator(shared);
        BD bd = new BD(shared);

        akinator.start();
        bd.start();

        try {
            akinator.join();
            bd.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
