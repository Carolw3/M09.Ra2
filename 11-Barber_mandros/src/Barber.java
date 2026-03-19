public class Barber extends Thread{
    String nom ;
    Barberia barberia;

    public Barber(String n, Barberia b){
        nom = n;
        barberia = b;
    }

    @Override
    public void run(){
        Client c;
        while (true) {
            c = barberia.seguentClient();
            if(c != null){
                System.out.println("Tallant cabell a client-" + c.getNom());
                c.tallarseElCabell();
            }else{
                synchronized (barberia.condBarber) {
                    try {
                        System.out.println("Ningú en espra");
                        System.out.println("Barber " + nom + " dormint");
                        barberia.condBarber.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            }
        }
        
        
    }
}