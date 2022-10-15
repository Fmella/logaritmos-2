import java.util.ArrayList;

import utils.Function;
import utils.node.Node;
import utils.node.Pair;

/**
 * Algoritmo de Dijsktra con listas de adyacencia.
 */
public class Algoritmo1 implements Function {

    @Override
    public Object[] call(Node[] nodes) {
        
        // Cantidad de nodos |V|
        int len = nodes.length;

        // Arreglos de utilidad de tamaño |V|
        Node[] previos = new Node[len];
        long[] distancias = new long[len];
        ArrayList<Node> auxiliar = new ArrayList<Node>(len);

        // Para cada nodo su distancia es infinito (representado como LONG.MAX_VALUE)
        // y su nodo previo como indefinido (representado como null),
        // guardamos cada nodo en un arreglo auxiliar
        for (int i = 0; i < len; i++) {
            distancias[i] = Long.MAX_VALUE;
            auxiliar.add(nodes[i]);
        }
        // Nodo raíz es el nodo 0 (nodes[0]), su distancia es 0
        distancias[0] = 0;

        // Mientras haya vértices en el arreglo auxiliar repetimos:
        while(auxiliar.size() > 0) {

            // Obtenemos el índice del nodo de menor distancia en el arreglo de distancias
            long min_dist = Long.MAX_VALUE;
            // Tomamos el primero como null para evitar errores de declaración
            Node node_min = null;

            // Iteramos sobre cada nodo del arreglo auxiliar, si su distancia es menor reemplaza las variables previas
            for (Node node : auxiliar) {
                if (distancias[node.getIndex()] < min_dist) {
                    min_dist = distancias[node.getIndex()];
                    node_min = node;
                }
            }

            // El de menos distancia es eliminado del arreglo auxiliar
            auxiliar.remove(node_min);
            
            // Definimos como v al vértice eliminado
            Node v = node_min;
            

            // Si no encuentra más nodos con un camino menor significa que el árbol no es conexo
            // y los otros nodos quedaron en otro árbol
            if (v == null) {
                break;
            }

        
            // Para cada par que representa una arista del nodo v revisamos su distancia
            for (Pair pair : v.getEdges()) {
                // Para cada vecino u, si su distancia guardada es mayor a la distancia de v
                // más el peso de la arista, se modifica la distancia para u y se coloca v
                // como previo de u
                int u = pair.getNode();
                if(distancias[u] > (distancias[v.getIndex()] + pair.getWeight())) {
                    distancias[u] = distancias[v.getIndex()] + pair.getWeight();
                    previos[u] = v;
                }
            }
        }

        // Retornamos los arreglos de previos y distancias
        return new Object[]{previos, distancias};
    }
    
}
