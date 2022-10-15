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
     */
    public void call(Node[] nodes);
}

