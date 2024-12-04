package ud1.ejercicios.ejExamen;

public class Hilo extends Thread {

    private int id;

    public Hilo(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        synchronized (Main.lock){
            if(Main.turno%2 == id || (Main.turno+1)%2 == id)
                System.out.print(id);
            else
                try {
                    Main.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
