public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);

        Asistent[] asistents = new Asistent[10];
        
        for (int i = 0; i < 10; i++) {
            asistents[i] = new Asistent(esdeveniment, "Assistent-" + i);
            asistents[i].start();
        }

    }
}
