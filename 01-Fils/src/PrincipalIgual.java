package src;
public class PrincipalIgual {
    public static void main(String[] args) {

        Fil<String> f1 = new Fil<>("Pepe");
        Fil<String> f2 = new Fil<>("Juan");

        f1.start();
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
