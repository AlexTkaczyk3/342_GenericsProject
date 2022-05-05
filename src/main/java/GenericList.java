import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

abstract class GenericList<T> implements Iterable<T>{

	private Node<T> head;
	private int length;
	
	// Class Methods
	// prints the items of the list. If list is empty, prints "Empty List"
	public void print() {
		if (head == null) {
			System.out.println("Empty List");
		} else {
			Node<T> temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	
	// adds value to the list
	public abstract void add(T data);
	
	// returns the first value of the list and deletes the node. If list is empty, returns null
	public T delete() {
		T nodeVal;
		
		if (head == null) { // if empty
			nodeVal = null;
		} else {
			nodeVal = head.data;
			head = head.next;
			length--;
		}
		return nodeVal;
	}
	
	// stores and returns all values currently in the list into an ArrayList and returns it. List is empty afterwards
	public ArrayList<T> dumpList() {
		ArrayList<T> contentList = new ArrayList<T>();
		while (head != null) {
			contentList.add(head.data);
			head = head.next;
		}
		return contentList;
	}
	
	// returns the value at the specified index or null if the index is out of bounds
	public T get( int index) {
		T valGot;
		if (index < 0 || index >= length) {
			valGot = null;
		} else {
			Node<T> temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			valGot = temp.data;
		}
		return valGot;
	}
	
	// replace the element at specified index with the element and returns the element previously at the specified position. Returns null if index is out of bounds
	public T set(int index, T element) {
		T oldVal;
		if (index < 0 || index >= length) {
			oldVal = null;
		} else {
			Node<T> temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			oldVal = temp.data;
			temp.data = element;
		}
		return oldVal;
	}
	
	// getter for length variable
	public int getLength(){
		return length;
	}
	
	// setter for length variable
	public void setLength(int length){
		this.length = length;
	}
	
	// getter for head variable
	public Node<T> getHead(){
		return head;
	}
	
	// setter for head variable
	public void setHead(Node<T> head){
		this.head = head;
	}
	
	// implementing abstract method from the Iterable interface
	public Iterator<T> iterator() {
		return new GLLIterator<T>(this);
	}
		
	// returns a list-iterator of the elements of this list starting at the specified position
	public ListIterator<T> listIterator( int index) {
		return new GLListIterator<T>(this, index);
	}
	
	// returns an iterator over the elements of the list in reverse order (tail->head)
	public Iterator<T> descendingIterator( ) {
		return new ReverseGLLIterator<T>(this);
	}
}

class Node<T> {
	T data;
	Node<T> next;
	Node<T> prev;
	
	// Constructor that creates a new node, containing the specified value
	public Node(T val) {
		this.data = val;
	}
}