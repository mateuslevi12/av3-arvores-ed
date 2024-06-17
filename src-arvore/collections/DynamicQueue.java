package collections;

public class DynamicQueue<E> implements Queue<E> {

    LinkedList<E> queue;

    public DynamicQueue(){
        queue = new LinkedList<>();
    }

    @Override
    public E dequeue() {
        
        return queue.removeFirst();
    }

    @Override
    public void enqueue(E value) {
        queue.add(value);
        
    }

    @Override
    public E first() {
        
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        
        return queue.isEmpty();
    }

    @Override
    public int size() {
        
        return queue.size();
    }
    @Override
    public String toString() {
        
        return " first\n  \\/ \n"+queue.toString();
    }
}
