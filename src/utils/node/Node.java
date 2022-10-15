package utils.node;

import java.util.ArrayList;

/**
 * Clase que representa un nodo de un grafo.
 * Contiene un arreglo con todas las aristas a sus vecinos.
 */
public class Node {
    ArrayList<Pair> neighbors;

    /**
     * Constructor de un nodo, inicializa el arreglo de vecinos.
     */
    public Node() {
        neighbors = new ArrayList<Pair>();
    }

    /**
     * Almacena un nodo vecino en su arreglo de vecinos.
     * @param node índice al nodo vecino
     * @param weight peso de la arista entre los nodos
     */
    public void addEdge(int node, int weight) {
        neighbors.add(new Pair(node, weight));
    }

    /**
     * Muestra el arreglo de vecinos a una forma legible
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < neighbors.size(); i++) {
            builder.append("[-("+neighbors.get(i).getWeight()+"->"+neighbors.get(i).getNode()+"]");
        }
        return builder.toString();
    }
}
