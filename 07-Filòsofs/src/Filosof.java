import java.util.Random;

public class Filosof extends Thread {
    private String nom;
    private Forquilla esquerra;
    private Forquilla dreta;
    private int gana;
    private Random random = new Random();

    public Filosof(String nom) {
        this.nom = nom;
        this.gana = 0;
    }

    public void setForquilles(Forquilla esquerra, Forquilla dreta) {
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() {
        System.out.println("Filòsof: " + nom + " pensant");
        try {
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void menjar() {
        System.out.println("Filòsof: " + nom + " menja");
        try {
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Filòsof: " + nom + " ha acabat de menjar");
        esquerra.setEnUs(false);  //Despres de megar deixa anar les dos forquilles
        dreta.setEnUs(false);
    }


    @Override
    public void run() {

        while (true) {

            pensar();

            if (!esquerra.isEnUs()) {  //Si la esquerra esta lliure (no esta en us) la agafa

                esquerra.setEnUs(true);
                System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + esquerra.getNumero());

                if (!dreta.isEnUs()) {  //Si la dreta esta lliure la agafa

                    dreta.setEnUs(true);
                    System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + dreta.getNumero());

                    menjar(); //Si te les dos menja
                    gana = 0;

                } else {

                    esquerra.setEnUs(false);  //Si no pot tenir les dos deixa les que te i espera (augmenta la gana)
                    System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + esquerra.getNumero() + ") i espera (dreta ocupada)");
                    gana++;
                    System.out.println("Filòsof: " + nom + " gana=" + gana);
                    try {
                        Thread.sleep(500 + random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } else {  //Si no pot agafar la esquerra espera i la gana augmenta
                gana++;
                System.out.println("Filòsof: " + nom + " gana=" + gana);
                try {
                    Thread.sleep(1000 + random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
