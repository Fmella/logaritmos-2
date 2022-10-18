import utils.Function;
import utils.node.Node;
import utils.node.Pair;
import utils.pqueue.PQueue;
import utils.pqueue.Tuple;

/**
 * Algoritmo de Dijsktra con cola de prioridad con extractMin.
 */
public class Algoritmo2 implements Function {

    @Override
    public Object[] call(Node[] nodes) {

        // Cantidad de nodos |V|
        int len = nodes.length;

        // Arreglos de utilidad de tamaño |V|
        Node[] previos = new Node[len];
        long[] distancias = new long[len];
        PQueue pqueue = new PQueue(33554432);

        // Para cada nodo su distancia es infinito (representado como LONG.MAX_VALUE)
        // y su nodo previo como indefinido (representado como null),
        // guardamos cada nodo en un arreglo auxiliar
        for (int i = 0; i < len; i++) {
            distancias[i] = Long.MAX_VALUE;
        }
        // Nodo raíz es el nodo 0 (nodes[0]), su distancia es 0
        distancias[0] = 0;

        Tuple element = new Tuple(0, nodes[0]);
        pqueue.add(element);

        // Mientras haya vértices en el arreglo auxiliar repetimos:
        while(!pqueue.isEmpty()) {
            // Definimos como v al vértice eliminado
            Tuple t = pqueue.exctractMin();

            // Para cada par que representa una arista del nodo v revisamos su distancia
            for (Pair pair : t.getNode().getEdges()) {
                // Para cada vecino u, si su distancia guardada es mayor a la distancia de v
                // más el peso de la arista, se modifica la distancia para u y se coloca v
                // como previo de u
                int u = pair.getNode();
                if(distancias[u] > (distancias[t.getNode().getIndex()] + pair.getWeight())) {
                    distancias[u] = distancias[t.getNode().getIndex()] + pair.getWeight();
                    previos[u] = t.getNode();
                    pqueue.add(new Tuple(distancias[u], nodes[u]));
                }
            }
        }

        // Retornamos los arreglos de previos y distancias
        return new Object[]{previos, distancias};
    }

}
