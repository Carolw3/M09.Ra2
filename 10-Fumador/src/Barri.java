

public class Barri {
    static Estanc estanc;
    static Fumador[] fumadors;

    public Barri(){
        estanc = new Estanc();
        fumadors = new Fumador[3];
    }

    public static void main(String[] args) {

        Barri barri = new Barri();

        barri.estanc.start();

        for(int i = 0 ; i < fumadors.length ; i++){
            fumadors[i]= new Fumador(i, barri.estanc);
        }
        
        for (Fumador f : fumadors){
            f.start();
        }
        for (Fumador f : fumadors){
            try {
                f.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        estanc.tancarEstanc();

        try {
            barri.estanc.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
