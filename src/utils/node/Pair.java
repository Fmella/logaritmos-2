package utils.node;

/**
 * Clase auxiliar para Node.
 * Almacena el par (node, weight) que contiene el índice 
 * de un nodo vecino y el peso de la arista.
 */
public final class Pair {
    private int node;
    private int weight;

    /**
     * Constructor de un par.
     * @param node índice al nodo vecino
     * @param weight peso de la arista entre los nodos
     */
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    
    /**
     * @return Índice del nodo vecino
     */
    public int getNode() {
        return node;
    }

    /**
     * @return Peso de la arista con el vecino
     */
    public int getWeight() {
        return weight;
    }
}