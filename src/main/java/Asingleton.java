public class Asingleton {

    private static Asingleton instance = null;
    private static Object mutex = new Object();
    private Asingleton(){}

    public static Asingleton getInstance(){
        if(instance==null){
            synchronized (mutex){
                if(instance==null) instance = new Asingleton();
            }
        }
        return instance;
    }
}
