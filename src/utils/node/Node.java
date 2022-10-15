package utils.node;

import java.util.ArrayList;

/**
 * Clase que representa un nodo de un grafo.
 * Contiene un arreglo con todas las aristas a sus vecinos.
 */
public class Node {
    ArrayList<Pair> edges;

    /**
     * Constructor de un nodo, inicializa el arreglo de vecinos.
     */
    public Node() {
        edges = new ArrayList<Pair>();
    }

    /**
     * Almacena un nodo vecino en su arreglo de vecinos.
     * @param node índice al nodo vecino
     * @param weight peso de la arista entre los nodos
     */
    public void addEdge(int node, int weight) {
        edges.add(new Pair(node, weight));
    }

    /**
     * Muestra el arreglo de vecinos a una forma legible
     * Formato: [-(Weight)->ÍndiceVecino]...
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < edges.size(); i++) {
            builder.append("[("+edges.get(i).getWeight()+")->"+edges.get(i).getNode()+"]    ");
        }
        builder.append("\n");
        return builder.toString();
    }

    /**
     * Limpia el arreglo de vecinos del nodo
     */
    public void clear() {
        edges.clear();
    }
}
