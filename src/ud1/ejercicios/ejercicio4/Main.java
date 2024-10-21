package ud1.ejercicios.ejercicio4;

//Implemente una simulación de la fabula que cuenta la carrera entre la liebre y la tortuga.
//Para hacerlo más interesante la carrera será cuesta arriba por una pista resbaladiza, de modo
//que a veces podrán resbalar y retroceder algunas posiciones. Habrá un thread que
//implementará la tortuga y otro la liebre. Cada uno se suspenderá durante un segundo y
//luego evaluará lo que ha pasado según unas probabilidades:
//Animal    Suceso              Probabilidad    Movimiento
//Tortuga   Avance rápido       50%             3 casillas a la derecha
//          Resbaló             20%             6 casillas a la izquierda
//          Avance lento        30%             1 casilla a la derecha
//Liebre    Duerme              20%
//          Gran salto          20%             9 casillas a la derecha
//          Resbalón grande     10%             12 casillas a la izquierda
//          Pequeño salto       30%             1 casilla a la derecha
//          Resbalón pequeño    20%             2 casillas a la izquierda

//Gana el que antes avance 70 casillas
//Puede haber un empate
public class Main {

    public static void main(String[] args) {

        final int meta = 100;
        Thread liebre = new Thread(new Liebre());
        Thread tortuga = new Thread(new Tortuga());
    }
}
