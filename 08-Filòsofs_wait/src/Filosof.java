public class Filosof extends Thread{
    private int idFilosof;
    private Forquilla esquerra;
    private Forquilla dreta;
    private int gana;

    public Filosof(int idFilosof) {
        this.idFilosof = idFilosof;
        this.gana = 0;
    }

    public void setForquilles(Forquilla esquerra, Forquilla dreta) {
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    public void pensar() {
        try {
            System.out.println("Filòsof " + idFilosof + " està pensant");
            Thread.sleep((int)(Math.random() * 1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void menjar() {
        try {
            System.out.println("Filòsof " + idFilosof + " està menjant");
            Thread.sleep((int)(Math.random() * 1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void agafarForquilles() {
    int gana = 0;

    while (true) {
        if (esquerra.getPropietari() == Forquilla.LLIURE) {
            esquerra.setPropietari(idFilosof);
            System.out.println("Filòsof " + idFilosof + " agafa la forquilla esquerra " + esquerra.getNumero());
        } else {
            System.out.println("Filòsof " + idFilosof + " espera esquerra " );
        }

        if (dreta.getPropietari() == Forquilla.LLIURE) {
            dreta.setPropietari(idFilosof);
            System.out.println("Filòsof " + idFilosof + " agafa la forquilla dreta " + dreta.getNumero());
        }

        if (esquerra.getPropietari() == idFilosof && dreta.getPropietari() == idFilosof) {
            return;
        } else {

            if (esquerra.getPropietari() == idFilosof) {
                esquerra.setPropietari(Forquilla.LLIURE);
                System.out.println("Filòsof " + idFilosof + " deixa l'esquerra i espera (dreta ocupada)");
            }

            gana++;
            System.out.println("Filòsof " + idFilosof + " gana=" + gana);

            try {
                wait((int)(Math.random() * 500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

    public synchronized void deixarForquilles() {
    if (esquerra.getPropietari() == idFilosof) {
        esquerra.setPropietari(Forquilla.LLIURE);
    }
    if (dreta.getPropietari() == idFilosof) {
        dreta.setPropietari(Forquilla.LLIURE);
    }
    System.out.println("Filòsof " + idFilosof + " deixa forquilles");
    notifyAll();
}

    @Override
    public void run() {
        while (true) {
            pensar();
            agafarForquilles();
            menjar();
            deixarForquilles();
        }
    }
}
