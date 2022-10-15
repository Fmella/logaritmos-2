package utils;

import utils.node.Node;

/**
 * Interfaz para los algoritmos representados como funciones,
 * utiliza el método call para ejecutar el algoritmo.
 */
public interface Function {
    /**
     * Método call que implementa el algoritmo.
     * @param nodes arreglo de nodos que conocen sus vecinos
     * @return Un arreglo con los nodos previos de cada nodo y un arreglo con las distancias de los nodos a la raiz.
     */
    public Object[] call(Node[] nodes);
}

