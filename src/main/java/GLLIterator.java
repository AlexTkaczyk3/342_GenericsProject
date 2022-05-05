import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T>{

	Node<T> linkList;

	// Class Methods
	// Constructor that sets the iterator at the beginning/head of the linked list
	public GLLIterator(GenericList<T> theList){
		this.linkList = theList.getHead();
	}
	
	// Returns true if the iteration has more elements when traversing the list in the forward direction
	public boolean hasNext() {
		if(linkList.next == null){
			return false;
		}
		else {
			return true;
		}
	}
	
	// Returns the next element in the iteration
	public T next() {
		T data = linkList.data;
		linkList = linkList.next;
		return data;
	}
}