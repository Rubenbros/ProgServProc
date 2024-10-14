package ud1.ejercicios.ejercicio2.solucion;

public class Main {
    public static final int MAX_NUMBER = 20;
    public static Object lock = new Object(); // Objeto para sincronizar los hilos
    public static boolean isEvenTurn = false; // Comenzamos con el turno de impares

    public static void main(String[] args) {
        // Crear hilos sin usar lambdas
        Thread evenThread = new EvenThread(); // Hilo para los números pares
        Thread oddThread = new OddThread();   // Hilo para los números impares

        // Iniciar ambos hilos
        evenThread.start();
        oddThread.start();
    }
}