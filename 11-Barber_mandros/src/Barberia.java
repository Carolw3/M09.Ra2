
import java.util.LinkedList;

public class Barberia extends Thread {
    LinkedList<Client> cua;
    int maxCadires;
    Object condBarber = new Object();
    private static Barberia barberia;

    public Barberia(int c){
        maxCadires = c;
        cua = new LinkedList<Client>();
    }

    public synchronized Client seguentClient(){
        if(cua.size() == 0){
            return null;
        }
        Client c = cua.remove(0);
        System.out.println("Li toca al client " + c.getNom());
        return c;
    }

    public void entraClient(Client c){
        synchronized (condBarber) {
            if(cua.size() < maxCadires){
                cua.add(c);
                System.out.println("Client " + c.getNom() + " en espera");
                condBarber.notify();
            }else{
                System.out.println("No queden cadires, client " + c.getNom() + " se'n va");
            }
        }
    }

    @Override
    public void run(){
        try {
            // primeros 10 clientes
            for(int i = 1; i <= 10; i++){
                entraClient(new Client(i));
                Thread.sleep(500);
            }

            Thread.sleep(10000);

            // siguientes 10 clientes
            for(int i = 11; i <= 20; i++){
                entraClient(new Client(i));
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Barberia b = new Barberia(3);
        Barber barber = new Barber("Pepe", b);

        barber.start();
        b.start();
    }

}
