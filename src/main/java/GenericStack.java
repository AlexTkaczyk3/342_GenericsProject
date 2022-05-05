
public class GenericStack<T> extends GenericList<T> {
	
	Node<T> tail;
	
	// Class Methods
	// Constructor that initializes the stack with a new node, containing the specified value
	GenericStack(T value) {
		Node<T> newNode = new Node<T>(value);
		newNode.next = null;
		newNode.prev = null;
		this.setHead(newNode);
		this.tail = newNode;
		this.setLength(1);
	}
	
	// retrieves and removes the tail of the list
	public T removeTail() {
		T tailData = tail.data;
		if (tail.prev != null ) {
			tail = tail.prev;
			tail.next = null;
		}
		return tailData;
	}
	
	// adds the value to the stack
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.next = this.getHead();
		this.getHead().prev = newNode;
		this.setHead(newNode);
	}
	
	// calls the add method
	public void push(T data) {
		this.add(data);
		this.setLength(getLength() + 1);
	}
	
	// calls the delete method
	public T pop() {
		T value = this.delete();
		return value;
	}
}
