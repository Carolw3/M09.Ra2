
public class Administracio {
    private static int numPoblacioActiva = 50;
    private static Treballador[] poblacioActiva;


    public Administracio() {
        poblacioActiva = new Treballador[numPoblacioActiva];

        for (int i = 0 ; i < numPoblacioActiva ; i++){
            poblacioActiva[i]= new Treballador("Ciutadà", 25000, 20, 65 );
        }
    }


    public static void main(String[] args) {
        Administracio administracio = new Administracio();

        for (int i = 0; i < numPoblacioActiva; i++) {
            administracio.poblacioActiva[i].start();
        }

        try {
            for (Treballador treb : poblacioActiva){
                treb.join();
            }
        } catch (Exception e) {
            System.out.println("Error al fil");
        }


        for (int i = 0 ; i < numPoblacioActiva ; i++){
            Treballador treb = administracio.poblacioActiva[i];

            System.out.printf("%s-%d -> edat: %d / total: %.2f%n",
                                treb.getName(), i, treb.getEdatActual(), treb.getCobrat());
        }
    }

}
