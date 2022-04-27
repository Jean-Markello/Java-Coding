import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderedList1 implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

        private Comparable value;
        private Node previous;
        private Node next;

        private Node ( Comparable value, Node previous, Node next ) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables

    private Node head;


    // Representation of the empty list.

    public OrderedList1() {
        head = new Node(null,null,null);
    }

    // Calculates the size of the list

    public int size() {
        int size = 0; Node p=head;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }


    public Object get( int pos ) {
        if (pos < 0 || pos >= size()) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }
        Node temp;
        temp = head;
        for (int i=0; i<pos && temp!=null; i++) {
            temp = temp.next;
        }
        return temp.value;

    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {

        if(head==null){
            head=new Node(o,null,null);
        }else{
            Node newNode=new Node(o,head,null);
            head.previous=newNode;
            head=newNode;
        }
        return head.value.equals(o);
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
        if (pos < 0 || pos >= size()) {
            System.out.println("stupid");
            throw new IndexOutOfBoundsException(Integer.toString(pos)+100);
        }

        Node r;
        if (pos == 0) {
            r = head;
            head = head.next;
        } else {
            Node p= head;
            for (int i=0; i<pos && p!=null; i++) {
                p = p.next;
            }

            if (head == p)
                head = p.next;

            if (p.next != null)
                p.next.previous = p.previous;

            if (p.previous != null)
                p.previous.next = p.next;

            p = null;
        }

    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
        Comparable[] compare=new Comparable[size()];
        Node r= other.head;
        head=new Node(other.head.value,other.head.next,head);
        for(int i=0; i<other.size()-1; i++) {
            head=other.head.next;
        }

        for(int a=0; a<size(); a++) {
            compare[a]=head.next.value;
        }

        Collections.reverse(List.of(compare));

        for(int h=0; h<size(); h++) {
            head.next=new Node(compare[h],head.next.previous,head.next.next);
        }


    }
}