
import java.util.Random;

public class Client extends Thread {
    String nom;

    Random ran = new Random();

    public Client(int id){
        nom = "Client-" + id;
    }
    public String getNom(){
        return nom;
    }

    public void tallarseElCabell(){
        try {
            Thread.sleep(900 + ran.nextInt(100));
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }
}
