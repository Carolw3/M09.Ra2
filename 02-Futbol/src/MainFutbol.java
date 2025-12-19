public class MainFutbol {
    public static void main(String[] args) {
        String[] noms = {
            "Pique", "Vinicius", "Torres", "Ramos", "Ronaldo", "Leguan", "Belli", "Arnau", "Mesi", "Aspas", "Mbape"
        };

        Futbolista[] futbolistes = new Futbolista[Futbolista.NUM_JUGADORS];
        System.out.println("Inici de xuts --------------------");
        for (int i = 0 ; i < futbolistes.length ; i++){
            futbolistes[i]= new Futbolista(noms[i]);
        }
        for (Futbolista futbolista : futbolistes){
            futbolista.start();
        }
        for (Futbolista futbolista : futbolistes){
            try {
                futbolista.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Fi dels xuts ---------------------\n--- Estadisticas ---\n");

        for (Futbolista futbolista : futbolistes){
            System.out.printf("%s -> %d gols\n", futbolista.getName(), futbolista.getGolsEnTirades());
        }

    }
}
