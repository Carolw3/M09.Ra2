public class Asociacio {
    

    private int numSocis = 1000;
    private Thread[] socis;

    public Asociacio() {
        socis = new Thread[numSocis];
    }

    public void iniciaCompteTempsSocis() {

        for (int i = 0; i < numSocis; i++) {
            Soci soci = new Soci();
            socis[i] = new Thread(soci, "Soci-" + i);
            socis[i].start();
        }
    }

    public void esperaFinalSocis() {

        for (int i = 0; i < numSocis; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalanceCompte() {
        Compte compte = new Compte().getInstancia();
        System.out.println("\nSaldo final del compte: " + compte.getSaldo());
    }

    public static void main(String[] args) {

        Asociacio associacio = new Asociacio();

        associacio.iniciaCompteTempsSocis();
        associacio.esperaFinalSocis();
        associacio.mostraBalanceCompte();
    }
}
