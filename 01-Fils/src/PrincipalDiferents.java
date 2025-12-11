package src;

public class PrincipalDiferents {
        public static void main(String[] args) {

        Fil<String> f1 = new Fil<>("Pepe");
        Fil<String> f2 = new Fil<>("Juan");

        f1.setPriority(Thread.MAX_PRIORITY);
        f2.setPriority(Thread.MIN_PRIORITY);

        f1.start();
        for (int e = 0; e < 1000; e++) {int o = e+89*2;}
        f2.start();

        System.out.println("Acaba thread main");

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
