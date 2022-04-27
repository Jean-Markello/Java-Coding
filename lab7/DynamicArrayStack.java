import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        if(capacity<DEFAULT_INC){
            elems= (E[])new Object[DEFAULT_INC];
        }else{ elems=(E[]) new Object[capacity];}
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {

        if(isEmpty()){
            throw new EmptyStackException();
        }

        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {

        if(isEmpty()){
            throw new EmptyStackException();
        }

        E top_c= elems[ --top ];
        while(getCapacity()-top >=DEFAULT_INC){
            E[] elem_more_capacity= (E[] )new Object[getCapacity()-DEFAULT_INC];
            for(int i=0; i<top;i++){
                elem_more_capacity[i]=elems[i];
            }
            this.elems=elem_more_capacity.clone();
        }

        return top_c;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) throws FullStackException{

        if (elems[elems.length-1]==null){
            throw new FullStackException();
        }

        if(top==getCapacity()){
            E[] elem_more_capacity= (E[])new Object[getCapacity()+DEFAULT_INC];
            for(int i=0; i<getCapacity();i++){
                elem_more_capacity[i]=elems[i];
            }
            this.elems=elem_more_capacity.clone();
        }
        elems[top++]= element;

    }

    @SuppressWarnings( "unchecked" )

    public void clear(){
        this.elems= (E[]) new Object[ DEFAULT_INC ];
        this.top= 0;
    }

}