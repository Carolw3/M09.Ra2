public class Barber extends Thread{
    String nom ;
    Barberia barberia;

    public Barber(String n, Barberia b){
        nom = n;
        barberia = b;
    }

    @Override
public void run() {
    Client c;
    while (true) {
        synchronized (barberia.condBarber) {
            // Mientras no haya cliente, el barbero espera
            while ((c = barberia.seguentClient()) == null) {
                try {
                    System.out.println("Ningú en espra");
                    System.out.println("Barber " + nom + " dormint");
                    barberia.condBarber.wait();  // espera hasta que llegue un cliente
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // Si llega aquí, hay un cliente
        System.out.println("Tallant cabell a " + c.getNom());
        c.tallarseElCabell();
    }
}
}


                        