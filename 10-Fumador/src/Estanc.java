import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread{
    
    List<Tabac> tabacs;
    List<Paper> papers;
    List<Llumi> llumins;

    Random rand = new Random();
    Boolean obert = true;

    public Estanc (){
        tabacs = new ArrayList<>();
        papers = new ArrayList<>();
        llumins = new ArrayList<>();

    }

    public void nouSubinistrament (){
        int r = rand.nextInt(3);

        switch(r){
            case 0 :
                Tabac tabac = new Tabac();
                addTabac(tabac);
                break;
            case 1:
                Llumi llumi = new Llumi();
                addLlumi(llumi);
                break;
            case 2:
                Paper paper = new Paper();
                addPaper(paper);
                break;
        }
    }

    public void addTabac(Tabac t){
        System.err.println("Afegint tabac");
        tabacs.add(t);
    }

    public void addLlumi(Llumi l){
        System.err.println("Afegint llumi");
        llumins.add(l);
    }

    public void addPaper(Paper p){
        System.err.println("Afegint paper");
        papers.add(p);
    }

    public Tabac venTabac(){
        if(!tabacs.isEmpty()){
            Tabac t = tabacs.get(0);
            tabacs.remove(0);
            return t;
        }
        return null;
    }

    public Llumi venLlumi(){
        if(!llumins.isEmpty()){
            Llumi l = llumins.get(0);
            llumins.remove(0);
            return l;
        }
        return null;
    }

    public Paper venPaper(){
        if(!tabacs.isEmpty()){
            Paper p = papers.get(0);
            papers.remove(0);
            return p;
        }
        return null;
    }

    public void tancarEstanc(){
        obert = false;
    }

    @Override
    public void run(){
        System.err.println("Estanc obert");
        while (obert){
            try {
                nouSubinistrament();
                Thread.sleep(500 + rand.nextInt(1001));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }


}
