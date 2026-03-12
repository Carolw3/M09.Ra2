
import java.util.Random;

public class Fumador extends Thread {
    int id;
    Estanc estanc;
    Tabac tabac;
    Llumi llumi;
    Paper paper;
    int fumades;

    Random ran = new Random();

    public Fumador (int id, Estanc estanc){
        this.id = id;
        this.estanc = estanc;
    }
    public void fuma(){
        if(tabac!=null && paper!=null && llumi!=null){
            fumades++;
            tabac = null;
            paper = null;
            llumi = null;
            try {
                System.err.println("Fumador " + id + " fumant");
                Thread.sleep(500 + ran.nextInt(501));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.err.println("El fumador " + id + " ha fumat " + fumades + " vegades");
        }
    }

    public void compraTabac(){
        if (this.tabac != null){
            return;
        }
        this.tabac = estanc.venTabac();
        System.err.println("Fumador " + id + " comprant tabac");
        
    }

    public void compraPaper(){
        if (this.paper == null){
            this.paper = estanc.venPaper();
            System.err.println("Fumador " + id + " comprant paper");
        }
    }

    public void compraLlumi(){
        if (this.llumi == null){
            this.llumi = estanc.venLlumi();
            System.err.println("Fumador " + id + " comprant llumi");
        }
    }

    @Override
    public void run(){
        while(fumades < 3){
            compraPaper();
            compraTabac();
            compraLlumi();

            fuma();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
