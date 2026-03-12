
import java.util.Random;

public class Fumador extends Thread {
    int id;
    Estanc estanc;
    Tabac tabac;
    Llumi llumi;
    Paper paper;
    int fumades;

    Random ran = new Random();

    public Fumador (int id){
        this.id = id;
        estanc = new Estanc();
    }
    public void fuma(){
        if(tabac!=null && paper!=null && llumi!=null){
            fumades++;
            tabac = null;
            paper = null;
            llumi = null;
            try {
                Thread.sleep(500 + ran.nextInt(501));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void compraTabac(){
        tabac = estanc.venTabac();
    }

    public void compraPaper(){
        paper = estanc.venPaper();
    }

    public void compraLlumi(){
        llumi = estanc.venLlumi();
    }

    @Override
    public void run(){
        while(fumades <= 3){
            compraPaper();
            compraTabac();
            compraLlumi();

            fuma();
        }
    }
}
