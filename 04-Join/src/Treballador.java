import java.util.Random;

public class Treballador extends Thread {
    private int souAnualBrut;
    private int edatIniciTreball;
    private int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private Random rnd;


    public Treballador(String nom, int souAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);
        this.souAnualBrut = souAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 65;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public int getEdatActual() {
        return edatActual;
    }

    public void setEdatActual(int edatActual) {
        this.edatActual = edatActual;
    }

    public float getCobrat() {
        return cobrat;
    }

    public void setCobrat(float cobrat) {
        this.cobrat = cobrat;
    }


    private void  cobra(){
        this.cobrat += souAnualBrut / 12.0f;
    }

    private void pagaImpostos(){
        float mensualidad = souAnualBrut / 12.0f;
        cobrat -= mensualidad * 0.24f;
    }


    @Override
    public void run(){
        while(edatActual <= edatFiTreball){
            int mes = 1;

            while(mes <= 12){
                cobra();
                pagaImpostos();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    System.out.println("Error al fil");
                }

                mes++;
            }
            edatActual++;
        }
    }
}
