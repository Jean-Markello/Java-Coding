public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
