public class Futbolista extends Thread {
    public static final int NUM_JUGADORS=11;
    public static final int NUM_TIRADES=20;
    public static final float PROBABILITAT=0.5f;

    private int golsEnTirades;

    public Futbolista(String nom){
        super (nom);
        this.golsEnTirades=0;
    }

    public int getGolsEnTirades() {
        return golsEnTirades;
    }

    @Override
    public void run(){
        for(int i = 0 ; i < NUM_TIRADES ; i++){
            if(Math.random() < PROBABILITAT){
                golsEnTirades++;
            }
        }

    }
}
