public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;
        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public LinkedQueue(){
        front = rear = null;
    }

    public  boolean isEmpty(){
       return front == null ;       
    }

    public  void enqueue(E newElement){

        if(newElement == null) {
            throw new NullPointerException("no null object in my queue !");
        }
        
        Elem<E> newElem;
        newElem = new Elem<E>(newElement,null);
        if(isEmpty()) {
            front = newElem;
            rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }


    public E dequeue() {

        if(isEmpty()) {
            throw new IllegalStateException("Dequeue method called on an empty queue");
        }

        E returnedValue;
        returnedValue = front.value;

        if(front.next == null) {   
            front = rear = null;
        } else {
            front = front.next;
        }
        return returnedValue;
    }

}
