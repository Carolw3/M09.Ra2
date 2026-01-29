
import java.util.Random;

public class Asistent extends Thread {
    Esdeveniment esdeveniment;
    public String nom;
    Random random;

    public Asistent(Esdeveniment esdeveniment, String nom) {
        this.esdeveniment = esdeveniment;
        this.nom = nom;
        this.random = new Random();
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run(){

        while (true) {

            try {
                int probable = random.nextInt(100);

                if (probable < 50) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }

                Thread.sleep(random.nextInt(1001));

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    
}
