package utils;

import java.util.Random;

import utils.node.Node;


public final class Utils {


    /**
     * Crea una cantidad de aristas aleatorias para el arreglo de nodos entregado.
     * Suponemos que el grafo será un multigrafo, no conexo (con varios árboles),
     * dirigido y que sus nodos no tendrán una arista consigo mismo.
     * @param nodes arreglo de nodos
     * @param aristas cantidad de aristas aleatorias a crear
     */
    private static void random_edges(Node[] nodes, int aristas) {
        
        int maxRandom = nodes.length;
        Random random = new Random();

        // Se genera la cantidad de aristas pedidas
        for (int i = 0; i < aristas; i++) {

            // Se genera un índice que corresponda a algun nodo
            int nodeStart = random.nextInt(maxRandom);
            // Se genera otro índice que corresponderá a un vecino del nodo anterior
            int nodeEnd = random.nextInt(maxRandom);
            // Se genera un peso y se suma 1 para que sea estrictamente positivo
            int weight = random.nextInt(maxRandom) + 1;
            
            // Revisar que un nodo no tenga una arista consigo mismo
            while (nodeStart == nodeEnd){
                nodeEnd = random.nextInt(maxRandom);
            }

            // Se agrega la arista al arreglo de vecinos del nodo
            nodes[nodeStart].addEdge(nodeEnd, weight);
        }
    }

    /**
     * Función que calcula el tiempo que demora en ejecutar un algoritmo.
     * @param fun algoritmo a medir
     * @param nodes arreglo de nodos, argumento de la función
     * @return Tiempo de ejecución en milisegundos
     */
    private static long time_fun(Function fun, Node[] nodes) {
        long start = System.currentTimeMillis();
        fun.call(nodes);
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * Calcula el promedio de tiempo de ejecución de un algoritmo
     * con una determinada cantidad de iteraciones y aristas.
     * @param iteraciones número de iteraciones a ejecutar un algoritmo
     * @param n_nodes número de nodos que tendrá el grafo
     * @param aristas número de aristas que se tendrá en cada ejecución
     * @param fun algoritmo a medir
     * @return Tiempo promedio de ejecución en milisegundos
     */
    public static double promedio(int iteraciones, int n_nodes, int aristas, Function fun) {
        // Tiempo total
        double total = 0;
        Node[] nodes;
        for (int i = 0; i < iteraciones; i++) {
            // Arreglo de nodos
            nodes = new Node[n_nodes];
            // Generar aristas aleatorias
            random_edges(nodes, aristas);
            // Se suma al tiempo total lo que se demora en ejecutar el algoritmo en el arreglo de nodos
            total += time_fun(fun, nodes);
        }
        // Retorna calculo de promedio
        return total / iteraciones;
    }
    
}
