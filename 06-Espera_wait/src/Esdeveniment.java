import java.util.ArrayList;
import java.util.List;

public class Esdeveniment{

    public List<Asistent> asistents;
    public int placesMax;
    public int placesDisponibles;


    public Esdeveniment(int placesMax) {
        this.placesMax = placesMax;
        this.asistents = new ArrayList<>();
        this.placesDisponibles = placesMax;
    }

    public synchronized void ferReserva(Asistent a){
    
        try {
            while(placesDisponibles == 0){
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        asistents.add(a);
        placesDisponibles--;
        System.out.println(a.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);

    }

    public synchronized void cancelaReserva(Asistent a){
        if(asistents.contains(a)){
            asistents.remove(a);
            placesDisponibles++;
            System.out.println(a.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.println(a.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: "+ placesDisponibles);
        }
        

    }

    

    
}