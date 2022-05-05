import java.util.Iterator;

public class ReverseGLLIterator<T>  implements Iterator<T>{
	
	Node<T> linkList;
	
	// Class Methods
	// Constructor that sets the iterator at the end/tail of the linked list
	public ReverseGLLIterator(GenericList<T> theList){
		Node<T> temp = theList.getHead();
		while (temp.next != null) {
			temp = temp.next;
		}
		linkList = temp;
	}
	
	//  Returns true if the iteration has more elements when traversing the list in the reverse direction
	public boolean hasNext() {
		if(linkList.prev == null){
			return false;
		}
		else {
			return true;
		}
	}
	
	//  Returns the previous element in the iteration
	public T next() {
		T data = linkList.data;
		linkList = linkList.prev;
		return data;
	}
}
