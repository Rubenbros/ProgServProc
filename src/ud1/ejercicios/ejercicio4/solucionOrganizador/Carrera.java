package ud1.ejercicios.ejercicio4.solucionOrganizador;

public class Carrera {
    public static final Integer META = 70;
    public Integer posicionTortuga = 0;
    public Integer posicionLiebre = 0;
    public Boolean turnoTortuga = false;
    public Boolean turnoLiebre = false;
    public final Object lockTortuga = new Object();
    public final Object lockLiebre = new Object();
    public Boolean terminado = false;
}
