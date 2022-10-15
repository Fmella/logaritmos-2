import utils.Plot;
import utils.Utils;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Se instancian los algoritmos
        Algoritmo1 algoritmo1 = new Algoritmo1();

        
        // Se instancia la gráfica
        Plot plot = new Plot(
            "Tiempo promedio de los algoritmos según la cantidad de aristas que tienen los nodos", 
            "Cantidad de aristas en logaritmo base 2 [log_2(aristas)]", 
            "Tiempo en milisegundos [ms]"
        );
        
        // Se crea el eje x, corresponde a las potencias para las aristas
        int[] x = new int[9];
        for (int i = 16; i <= 24; i++) x[i-16] = i;

        // Se calcula la cantidad de nodos que se tendrá
        int n_nodes = (int) Math.pow(2, 14);

        // Se realizan los experimentos del algoritmo 1
        int[] alg1 = new int[9];
        for (int j = 0; j < alg1.length; j++) {
            alg1[j] = (int) Utils.promedio(50, n_nodes, (int) Math.pow(2, x[j]), algoritmo1);
        }
        plot.addSerie("Algoritmo 1", x, alg1);


        plot.finish();

        plot.setVisible(true);
    }
}