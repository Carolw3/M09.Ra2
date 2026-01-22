import java.util.Random;

public class Soci implements Runnable {
    
    private Compte compte;
    private float aportacio = 10f;
    private int esperaMax = 100;
    private Random random = new Random();
    private int maxAnys = 10;

    public Soci() {
        compte = new Compte().getInstancia();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {

        for (int mes = 0; mes < maxAnys * 12; mes++) {

            try {
                Thread.sleep(random.nextInt(esperaMax));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (compte) {
                if (mes % 2 == 0) {
                    ingressar();
                } else {
                    retirar();
                }
            }
        }
    }

    private void ingressar() {
        compte.setSaldo(compte.getSaldo() + aportacio);

    }

    private void retirar() {
        compte.setSaldo(compte.getSaldo() - aportacio);

    }
}
