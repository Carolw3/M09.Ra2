public class Dona extends Thread{
    String nom;
    BanyUnisex bany;

    public Dona(String n, BanyUnisex b){
        nom = n;
        bany = b;
    }

    public void run(){
        System.err.println(nom + " vol usar el bany");
        bany.entraDona();
        utilitzaLavabo();
        bany.surtDona();
        System.err.println(nom + " ha acabat d'usar el bany");
    }

    public void utilitzaLavabo(){
        
        try {
            int temps = 2000 + (int)(Math.random()*1000);
            Thread.sleep(temps);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
