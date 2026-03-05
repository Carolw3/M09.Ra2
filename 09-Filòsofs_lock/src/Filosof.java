import java.util.Random;

public class Filosof extends Thread{
    private long iniciGana;
    private long fiGana;
    private long gana;
    private Forquilla dreta;
    private Forquilla esquerra;
    private String nom;
    private Random rand;

    public Filosof( String nom, Forquilla dreta, Forquilla esquerra) {
        this.gana = gana;
        this.dreta = dreta;
        this.esquerra = esquerra;
        this.nom = nom;
        this.rand = new Random();
    }

    private void pensar(){
        try {
            iniciGana = System.currentTimeMillis();
            System.out.println(nom + "pensant...");
            Thread.sleep(1000 + rand.nextInt(1001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void agafarForquillaEsquerra() {
        esquerra.agafar();
    }

    public void agafarForquillaDreta() {
        dreta.agafar();
    }

    public boolean agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        System.out.printf("%s té forquilles esq(%d) dreta(%d)%n",
            nom, esquerra.getNum(), dreta.getNum());
        if (esquerra.getNum() > 0 && dreta.getNum() > 0){
            return true;
        }
        return false;
    }

    private void deixarForquilles(){
        dreta.deixar();
        esquerra.deixar();
    }

    private void calcularGana(){
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
    }

    private  void resetGana(){
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    private void mengar(){
        if(agafarForquilles()){
            calcularGana();
            System.out.println(nom + "té forquilles esquerres ( " + esquerra.getNum() + " ) dretes ( " + dreta.getNum() + " )");
            System.out.println(nom + " menja amb gana " + gana);
            try {
                Thread.sleep(1000 + rand.nextInt(1001));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(nom + " ha acabat de menjar");
            deixarForquilles();
            resetGana();
        }
    }

    @Override
    public  void run(){
        while (true) {
            pensar();
            mengar();
        }
    }

}