import java.util.NoSuchElementException;

// Name:
// ID:
//=============================
public class LinkedDoublySkip<E> {

	//Node inner class
	public static class Node<T> {
		private T data;
		private Node<T> next, prevSkip;
		Node(T data, Node<T> next, Node<T> prevSkip) {
			this.data = data;
			this.next = next;
			this.prevSkip = prevSkip;
		}
		public T getData() { return data;}
		public Node<T> getNext(){ return next; }
		public Node<T> getPrevSkip(){ return prevSkip;}
	}

	private Node<E> head;
	private int size;
	private Node tail;

	public void add(E object) { // Q1.1 (8 marks)

		if (object==null)
			throw new IllegalStateException("Empty object can't be added!");


		//Add your code here
		Node<E> newNode = new Node<E>(object, null, null);

		if(head==null){
			head=new Node<E>(object, null, null);
			tail=head;
		}else{
			head=new Node<E>(object, head, null);
			head.next.prevSkip=head;
			size++;
		}

	}

	public LinkedDoublySkip() { // Q1.2 (2 marks)

		head=null;
		size=0;
		tail=null;

	}

	public LinkedDoublySkip(E[] array) { // Q1.3 (5 marks)
		if (array == null)
			throw new NullPointerException("array cannot be null");

		//Add your code here
		for(int i=0; i< array.length; i++){
			add(array[i]);
		}

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public E getElementAt(int index) { // Q1.4 (6 marks)
		if (index < 0 || index >=  size)
			throw new IllegalArgumentException("The index parameter is out of range");

		//Add your code here
		if(isEmpty())
			throw new IllegalStateException("Empty list!");

		Node<E> p = head;

		for (int i=0; i<index; i++) {
			p = p.next;
		}

		return p.data;

	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if(head==null) return buffer.toString();

		Node<E> p=head;
		while(p.next!=null) {
			buffer.append(p.data);
			p=p.next;
			buffer.append(", ");
		}
		buffer.append(p.data);

		return buffer.toString();
	}

	//LinkedDoublyIterator inner class
	private class LinkedDoublyIterator implements Iterator<E> { // Q1.5 (9 marks)

		private Node<E> current;
		// ADD other instance variables here (if needed!!)

		public LinkedDoublyIterator() {

			//Add your code here
			current=null;

		}

		public E next() {

			//Add your code here
			if(current == null) {
				current = head;
			} else {
				current = current.next;
			}
			if(current == null)
				throw new NoSuchElementException("Iterator at the end or list empty");
			return current.data;
		}

		public boolean hasNext(){
			if(current == null)
				return !isEmpty();
			else
				return (current.next != null);
		}

	}

	public Iterator<E> iterator() {
		return new LinkedDoublyIterator();
	}
}
