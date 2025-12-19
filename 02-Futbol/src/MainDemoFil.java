public class MainDemoFil{
    public static void main(String[] args) {
        Thread fil = Thread.currentThread();
        System.out.printf("MainDemoFil.main:\nPrioritat -> %d,\nNom -> %s\ntoString() -> %s", fil.getPriority(), fil.getName(), fil.toString());
    }
}