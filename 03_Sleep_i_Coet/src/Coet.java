import java.util.Scanner;

public class Coet {
    
    Motor mot1 = new Motor(1);
    Motor mot2 = new Motor(2);
    Motor mot3 = new Motor(3);
    Motor mot4 = new Motor(4);

    public Coet() {
        mot1.start();
        mot2.start();
        mot3.start();
        mot4.start();
    }


    public int  passaAPotencia(int p){
        if(p>10 || p<0){
            System.err.println("Potencia no valida");
            return 0;
        }

        mot1.setpObjectiu(p);
        mot2.setpObjectiu(p);
        mot3.setpObjectiu(p);
        mot4.setpObjectiu(p);

        return 1;

    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            if (sc.hasNextInt()) {
                int p = sc.nextInt();
                if (coet.passaAPotencia(p) == 1){
                    System.out.println("Passant a potència " + p);
                }
                
            } else {
                sc.next();
            }
        }
    }

}
