import utils.Utils;

public class App {
    public static void main(String[] args) throws Exception {
        
        Algoritmo1 algoritmo1 = new Algoritmo1();

        double promedio1 = Utils.promedio(1, 10, 30, algoritmo1);

        System.out.println("Promedio: " + promedio1);
    }
}