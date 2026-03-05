public class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs){
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0 ; i < numFilosofs ; i++){
            forquilles[i] = new Forquilla(i);
        }
        for (int i = 0 ; i < numFilosofs ; i++){
            Forquilla esquerra =  forquilles[i];
            Forquilla dreta = forquilles[i];
            filosofs[i] = new Filosof("Fil" + i, dreta, esquerra);
        }
    }

    public void showTaula() {
        for (Filosof f : filosofs) {
            System.out.println(f.getName());
        }
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }

    public static void main(String[] args) {
        int numFilsofs = 5;
        Taula taula = new Taula(numFilsofs);

        System.out.println("Comensals i forquilles:");
        for (int i = 0; i < numFilsofs; i++) {
            System.out.println("Comensal:Fil" + i + " esq:" + i + " dret:" + ((i+1)%numFilsofs));
        }
        System.out.println("--------------------------");

        taula.cridarATaula();
    }
}
