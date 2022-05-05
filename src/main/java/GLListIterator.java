import java.util.ListIterator;

public class GLListIterator<T>  implements ListIterator<T>{

	Node<T> listNode;
	int index = 0;
	
	// Class Methods
	// Constructor that sets the iterator at the specified index of the linked list
	public GLListIterator(GenericList<T> theList, int index){
		this.listNode = theList.getHead();
		while (this.index != index) {
			listNode = listNode.next;
			this.index++;
		}
	}
	
	// Returns true if this list iterator has more elements when traversing the list in the forward direction
	public boolean hasNext() {
		if(listNode.next == null){
			return false;
		}
		else {
			return true;
		}
	}

	//  Returns the next element in the list and advances the cursor position
	public T next() {
		T data = listNode.data;
		listNode = listNode.next;
		index++;
		return data;
	}
	
	//  Returns true if this list iterator has more elements when traversing the list in the reverse direction
	public boolean hasPrevious() {
		if(listNode.prev == null){
			return false;
		}
		else {
			return true;
		}
	}
	
	//  Returns the previous element in the list and moves the cursor position backwards
	public T previous() {
		T data = listNode.data;
		listNode = listNode.prev;
		index--;
		return data;
	}

	//  Returns the index of the element that would be returned by a subsequent call to next()
	public int nextIndex() {
		if (listNode.next == null) {
			return -1;
		} else {
			return index + 1;
		}
	}

	//  Returns the index of the element that would be returned by a subsequent call to previous()
	public int previousIndex() {
		if (listNode.prev == null) {
			return -1;
		} else {
			return index - 1;
		}
	}

	// unimplemented
	public void remove() {
		return;
	}

	// unimplemented
	public void set(T e) {
		return;
	}

	// unimplemented
	public void add(T e) {
		return;	
	}
}
