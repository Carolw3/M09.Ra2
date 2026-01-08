public class DormAleatori extends Thread {

    private final long inici;

    public DormAleatori(String name) {
        super(name);
        this.inici = System.currentTimeMillis();
    }

    @Override
    public void run() {

        for(int i = 0 ; i < 10 ; i++){

            long actual = System.currentTimeMillis();

            long estona = actual - inici ;

            int random = (int) (Math.random()*1000);

            System.out.println(getName() + "\t(" + i + ") a dormir " + random + "ms total\t" + estona + "ms" );

            try {
                Thread.sleep(random);
            } catch (Exception e) {
                e.printStackTrace();
            }
            

        }
    }
    public static void main(String[] args) {
        
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        System.out.println("-- Fi de main ------------");

        joan.start();
        pep.start();

    }
}
