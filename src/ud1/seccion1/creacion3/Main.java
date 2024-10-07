package ud1.seccion1.creacion3;

public class Main {

    public static void main(String[] args) {

        Thread hilo = new Thread(() -> System.out.println("My name is " + Thread.currentThread().getName()
                + " , state: " + Thread.currentThread().getState()));
        hilo.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
