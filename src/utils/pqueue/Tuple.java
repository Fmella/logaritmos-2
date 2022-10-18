package utils.pqueue;

import utils.node.Node;

public class Tuple {
    private final long distance;
    private final Node node;

    public Tuple(long distance, Node nodo) {
        this.distance = distance;
        this.node = nodo;
    }

    public long getDistance(){
        return this.distance;
    }

    public Node getNode(){
        return this.node;
    }
}
