
public class GenericQueue<T> extends GenericList<T>{
	
	Node<T> tail;
	
	// Class Methods
	// Constructor that initializes the queue with a new node, containing the specified value
	GenericQueue(T value) {
		Node<T> newNode = new Node<T>(value);
		newNode.next = null;
		newNode.prev = null;
		this.setHead(newNode);
		this.tail = newNode;
		this.setLength(1);
	}
	
	// retrieves and removes the tail of the list. If tail is not the only node in queue, sets tail to previous node
	public T removeTail() {
		T tailData = tail.data;
		if (tail.prev != null ) {
			tail = tail.prev;
			tail.next = null;
		}
		return tailData;
	}
	
	// adds the value to the queue
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.next = null;
		newNode.prev = this.tail;
		this.tail.next = newNode;
		this.tail = newNode;
	}
	
	// calls the add method
	public void enqueue(T data) {
		this.add(data);
		this.setLength(getLength() + 1);
	}
	
	// calls the delete method
	public T dequeue() {
		T value = this.delete();
		return value;
	}
}
