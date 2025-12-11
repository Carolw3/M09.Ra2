package src;
public class Fil<T> extends Thread {

    private T nombre;

    public Fil(T nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nombre + " " + i);
        }
        System.out.println("Acaba el fil " + nombre);
    }
}

