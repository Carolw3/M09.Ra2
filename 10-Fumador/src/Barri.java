

public class Barri {
    Estanc estanc;
    Fumador[] fumadors;

    public Barri(){
        estanc = new Estanc();
        fumadors = new Fumador[3];
    }

    public static void main(String[] args) {

        for(int i = 0 ; i < fumadors.length ; i++){
            fumadors[i]= new Fumador(i);
        }
    }
}
