public class Motor extends Thread {
    
    int pObjectiu;
    int pActual;
    int id;

    public Motor(int id){
        this.pObjectiu = 0 ;
        this.pActual = 0 ;
        this.id=id;
    }

    public int getpObjectiu() {
        return pObjectiu;
    }
    public void setpObjectiu(int pObjectiu) {
        this.pObjectiu = pObjectiu;
    }
    public int getpActual() {
        return pActual;
    }
    public void setpActual(int pActual) {
        this.pActual = pActual;
    }

    @Override
    public void run() {
        while(true){
            if (pActual != pObjectiu) {
                
                if (getpActual() < getpObjectiu()){
                    sumaOresta(1, "Incre.");
                }else if (getpActual() > getpObjectiu()){
                    sumaOresta(-1, "Decre.");
                }else{
                    try {
                        Thread.sleep(500);
                        if (pActual == 0 && pObjectiu == 0){break;}
                    } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }else{
                sumaOresta(0, "FerRes.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
            
        }

    }


    public void sumaOresta(int op, String oper){
        int aleatori = (int) (Math.random()*2000);
        System.out.println(" Motor " + id + ": " + oper + " Objectiu: " + getpObjectiu() + " Actual: " + getpActual());
        try{
            Thread.sleep(aleatori);
            setpActual(pActual + op);
            if (pObjectiu == pActual){
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
