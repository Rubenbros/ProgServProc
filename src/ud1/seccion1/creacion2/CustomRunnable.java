package ud1.seccion1.creacion2;

public class CustomRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("My name is " + Thread.currentThread().getName()
                + " , state: " + Thread.currentThread().getState());    }
}
