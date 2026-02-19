public class Taula {
    private Filosof[] filosofos;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {

        filosofos = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            filosofos[i] = new Filosof("fil" + i);

            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];

            filosofos[i].setForquilles(esquerra, dreta);
        }
    }

    public static void main(String[] args) {

        Taula taula = new Taula(4);

        taula.showTaula();
        taula.cridarATaula();
    }


    public void showTaula() {
        for (int i = 0; i < filosofos.length; i++) {
            System.out.println(
                "Comensal:fil" + i +
                " esq:" + forquilles[i].getNumero() +
                " dret:" + forquilles[(i + 1) % forquilles.length].getNumero()
            );
        }
        System.out.println("--------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : filosofos) {
            f.start();
        }
    }
}
