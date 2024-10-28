package ud1.ejercicios.ejercicio3.solucion;

import java.util.Arrays;

public class SortTask implements Runnable {
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
        Arrays.sort(array, startIndex, endIndex + 1);
    }

}
