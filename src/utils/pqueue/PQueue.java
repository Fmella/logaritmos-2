package utils.pqueue;

public class PQueue {
    private final int MAX_LENGTH;
    private int size;
    private final Tuple[] heap;

    public PQueue(int len){
        heap = new Tuple[len];
        this.size = 0;
        this.MAX_LENGTH = len;
    }
    public static int parent(int i) {
        return (i - 1) / 2;
    }
    public static int leftChild(int i) {
        return 2*i + 1;
    }
    public static int rightChild(int i) {
        return 2*i + 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Tuple element) {
        if (size == MAX_LENGTH) {
            System.out.println("The queue is full. Cannot insert");
            return;
        }

        heap[size] = element;
        size = size + 1;

        int i = size - 1;
        while (i > 0 && heap[PQueue.parent(i)].getDistance() > heap[i].getDistance()) {
            Tuple temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = PQueue.parent(i);
        }
    }

    public void minHeapify(int i){

        int left = PQueue.leftChild(i);
        int right = PQueue.rightChild(i);
        int actual = i;

        if (left <= size && heap[left].getDistance() < heap[actual].getDistance()) {
            actual = left;
        }

        if (right <= size && heap[right].getDistance() < heap[actual].getDistance()) {
            actual = right;
        }

        if (actual != i) {
            Tuple temp = heap[i];
            heap[i] = heap[actual];
            heap[actual] = temp;
            minHeapify(actual);
        }
    }

    public Tuple exctractMin() {
        Tuple minElement = heap[0];

        heap[0] = heap[size - 1];
        size = size - 1;

        minHeapify(0);
        return minElement;
    }
}
