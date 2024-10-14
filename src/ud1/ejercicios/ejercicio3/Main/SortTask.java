package ud1.ejercicios.ejercicio3.Main;

import java.util.Arrays;

public class SortTask extends Thread { // Extiende de Thread
    private int[] array;
    private int startIndex;
    private int endIndex;

    public SortTask(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        // COMPLETAR: Llamar a Arrays.sort para ordenar el segmento
        Arrays.sort(array, startIndex, endIndex + 1);
    }
}