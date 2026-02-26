public class Taula {
    private Filosof[] filosofos;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {

        filosofos = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);  //Genera les forquilles
        }

        for (int i = 0; i < numFilosofs; i++) {
            filosofos[i] = new Filosof(i);  //Genera els filosofs

            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];

            filosofos[i].setForquilles(esquerra, dreta);
        }
    }

    public void cridarATaula() {
        for (Filosof f : filosofos) {
            f.start();
        }
    }


    /////////////////////////////////////////////////////////

    public void showTaula() {
        for (int i = 0; i < filosofos.length; i++) {
            System.out.println("Filòsof " + i +
                    " -> Forquilla esquerra: " + forquilles[i].getNumero() +
                    ", Forquilla dreta: " + forquilles[(i + 1) % filosofos.length].getNumero());
        }
    }
    
    public static void main(String[] args) {
        Taula taula = new Taula(5);
        taula.showTaula();
        taula.cridarATaula();
    }

}
