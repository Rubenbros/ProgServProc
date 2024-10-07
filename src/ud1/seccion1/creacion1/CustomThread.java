package ud1.seccion1.creacion1;

public class CustomThread extends Thread{
    @Override
    public void run() {
        System.out.println("My name is " + this.getName() + " , state: " + this.getState());
    }
}
