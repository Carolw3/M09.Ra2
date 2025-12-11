package src;

public class PrincipalEstricte {
    public static void main(String[] args) {

        Fil f1 = new Fil("Pepe");
        Fil f2 = new Fil("Juan");

        f1.setPriority(Thread.MIN_PRIORITY);
        f2.setPriority(Thread.MAX_PRIORITY);

        f1.start();
        f2.start();

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Acaba thread main");
    }
}
