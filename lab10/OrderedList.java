import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

        private Comparable value;

        private Node previous;
        private Node next;

        private Node( Comparable value, Node previous, Node next ) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables

    private Node head;
    private Node tail;

    // Representation of the empty list.

    public OrderedList() {
        head = null;
        tail = null;
    }

    // Calculates the size of the list

    public int size() {
        int size=0; Node p = head;
        while ( p!=null ) {
            p = p.next;
            size++;
        }
        return size;
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {

        if (o==null){
            throw new IllegalArgumentException("null");
        }
        if (head==null){
            head= new Node(o,null,null );
            tail=head;
        }else if(head.value.compareTo(o)>=0) {
            head= new Node(o,null,head);
            head.next.previous = head;

        }else {
            Node p = head;
            while ( p.next != null && p.next.value.compareTo(o) < 0 ) {
                p = p.next;
            }
            if ( p.next == null ) {
                tail.next = new Node( o, tail, null );
                tail = tail.next;
            } else {
                Node r = p.next;
                p.next = new Node( o, p, r );
                r.previous = p.next;
            }
        } return true;
    }

    public Object get( int pos ) {
        if (pos < 0 || pos >= size()) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }
        Node p = head;
        for (int i=0; i<pos; i++) {
            if (p==null) {
                throw new IndexOutOfBoundsException(Integer.toString(pos));
            } else {
                p = p.next;
            }
        } return p.value;
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
        if (pos < 0 || pos >= size()) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }
        Node p = head;
        if(pos==0) {
            if ( head == null ) {
                throw new IndexOutOfBoundsException( Integer.toString( pos ) );
            }
            head = head.next;
            if (head==null) {
                tail=null;
            }else{
                head.previous = null;
            }
            p.value = null;
            p.next = null;

        } else {
            for ( int i=0; i<pos; i++ )
                if ( p == null ) {
                    throw new IndexOutOfBoundsException(Integer.toString(pos));
                } else {
                    p = p.next;
                }

            Node r = p;
            p = p.previous;
            Node q = r.next;
            p.next = q;
            if ( r == tail ) {
                tail = p;
            } else {
                q.previous = p;
            }
            r.value = null; r.next = null; r.previous = null;
        }
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
        Node p = head;
        Node r = other.head;

        while(r!=null ) {
            if(p==null){
                head = tail = new Node( r.value, null, null );
                p = head;
                r = r.next;
            }else if(r.value.compareTo(p.value)<0) {
                if(p==head) {
                    head = new Node(r.value,null, head);
                    p.previous=head;
                }else{
                    p.previous.next=new Node(r.value,p.previous,p);
                    p.previous=p.previous.next;
                }
                r=r.next;
            }else if(p.next==null) {
                p.next = new Node(r.value, p,null );
                tail = p.next;
                p=p.next;
                r=r.next;
            }else {
                p=p.next;
            }
        }
    }
}