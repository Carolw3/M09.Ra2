import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex{
    public final String BANY_BUIT = "buit";
    public final String BANY_AMB_HOMES = "homes";
    public final String BANY_AMB_DONES = "dones";

    public final int CAPACITAT_MAXIMA = 3;

    public String estatActual = BANY_BUIT ;
    int ocupants = 0;

    Semaphore capacitat = new Semaphore(3);
    ReentrantLock lock = new ReentrantLock();

    public BanyUnisex(){

    }

    public void entraHome(){
        while (true) {
            lock.lock();
            try {
                if(estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES){
                    if(capacitat.tryAcquire()){
                        ocupants++;
                        estatActual = BANY_AMB_HOMES;
                        System.err.println("Home entra al bany. Ocupants: " + ocupants);
                        return;
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void surtHome(){
        lock.lock(); //El lock lo pondremos siempre antes de un try
        try {
            if(estatActual == BANY_AMB_HOMES && ocupants > 0 ){
            ocupants--;
            capacitat.release();
            System.out.println("Home surt del bany. Ocupants: " + ocupants);
            if (ocupants <= 0 ){
                estatActual = BANY_BUIT;
                System.out.println("El bany esta buit");
            }
        }
        } finally {
            lock.unlock(); //Para que sae lo que pase el finally siempre abra el candado
        }
        
    }

    public void entraDona(){
        while (true) {
            lock.lock();
            try {
                if (estatActual == BANY_AMB_DONES || estatActual == BANY_BUIT){
                    if (capacitat.tryAcquire()){
                        ocupants++;
                        estatActual = BANY_AMB_DONES;
                        System.out.println("Dona entra al bany. Ocupants: " + ocupants);
                        return;
                    }
                    
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void surtDona(){
        lock.lock();
        try {
            if (estatActual == BANY_AMB_DONES && ocupants > 0){
                ocupants--;
                capacitat.release();
                System.out.println("Dona surt del bany. Ocupants: " + ocupants);
                if (ocupants <= 0){
                    estatActual = BANY_BUIT;
                    System.out.println("El bany esta buit");
                }
            }
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BanyUnisex banyu = new BanyUnisex();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 5 ; i++){
            Home h = new Home("Home-" + i, banyu);
            threads.add(h);
            h.start();
            Dona d = new Dona("Dona-" + i, banyu);
            threads.add(d);
            d.start();
        }

        for(Thread t : threads){
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    }
}