import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GQTest {

	GenericQueue<Integer> queue;
	
	@BeforeEach
	void init() {
		queue = new GenericQueue<Integer>(60);
	}
	
	// Queue Tests
	
	@Test
	void nodeConstructorTest() {
		Node<Integer> newNode = new Node<Integer>(60);
		assertEquals(60, newNode.data, "node constructor fail");
	}
	
	@Test
	void queueConstructorTest() {
		int val = 60;
		assertEquals(val, queue.getHead().data, "queue constructor fail");
	}

	@Test
	void enqueueTest() {
		queue.enqueue(70);
		assertEquals(70, queue.tail.data,"enqueue fail");
	}
	
	@Test
	void dequeueTest() {
		assertEquals(60, queue.dequeue(),"dequeue fail");
	}
	
	@Test
	void removeTailTest() {
		queue.enqueue(70);
		queue.enqueue(13);
		assertEquals(13, queue.removeTail(),"tail removal failure");
	}
	
	//  Iterator Tests
	
	@Test
	void iteratorTest() {
		GLLIterator<Integer> forwardIterator = new GLLIterator<Integer>(queue);
		assertEquals(60, forwardIterator.linkList.data,"GLLIterator constructor failure");
	}
	
	@Test
	void descendingIteratorTest() {
		ReverseGLLIterator<Integer> reverseIterator = new ReverseGLLIterator<Integer>(queue);
		assertEquals(60, reverseIterator.linkList.data,"ReverseGLLIterator constructor failure");
	}
	
	@Test
	void listIteratorTest() {
		GLListIterator<Integer> listIterator = new GLListIterator<Integer>(queue, 0);
		assertEquals(60, listIterator.listNode.data,"GLListIterator constructor failure");
	}
	
	@Test
	void GLLIteratorHasNextTest() {
		GLLIterator<Integer> forwardIterator = new GLLIterator<Integer>(queue);
		assertEquals(false, forwardIterator.hasNext(), "forwardIterator hasNext fail");
	}
	
	@Test
	void GLLIteratorNextTest() {
		queue.enqueue(82);
		GLLIterator<Integer> forwardIterator = new GLLIterator<Integer>(queue);
		assertEquals(60, forwardIterator.next(),"forwardIterator next iteration fail");
	}
	
	@Test
	void ReverseGLLIteratorHasNextTest() {
		ReverseGLLIterator<Integer> reverseIterator = new ReverseGLLIterator<Integer>(queue);
		assertEquals(false, reverseIterator.hasNext(),"ReverseGLLIterator hasNext failure");
	}
	
	@Test
	void ReverseGLLIteratorNextTest() {
		queue.enqueue(17);
		ReverseGLLIterator<Integer> reverseIterator = new ReverseGLLIterator<Integer>(queue);
		assertEquals(17, reverseIterator.next(),"ReverseGLLIterator next iteration failure");
	}
	
	@Test
	void GLListIteratorHasNextTest() {
		queue.enqueue(89);
		GLListIterator<Integer> listIterator = new GLListIterator<Integer>(queue, 0);
		assertEquals(true, listIterator.hasNext(),"GLListIterator hasNext failure");
	}
	
	@Test
	void GLListIteratorNextTest() {
		queue.enqueue(24);
		GLListIterator<Integer> listIterator = new GLListIterator<Integer>(queue, 0);
		assertEquals(60, listIterator.next(),"GLListIterator next failure");
	}
	
	@Test
	void GLListIteratorHasPrevTest() {
		queue.enqueue(24);
		GLListIterator<Integer> listIterator = new GLListIterator<Integer>(queue, 1);
		assertEquals(true, listIterator.hasPrevious(),"GLListIterator hasPrevious failure");
	}
	
	@Test
	void GLListIteratorPrevTest() {
		queue.enqueue(68);
		GLListIterator<Integer> listIterator = new GLListIterator<Integer>(queue, 1);
		assertEquals(68, listIterator.previous(),"GLListIterator previous failure");
	}
	
	@Test
	void GLListIteratorNextIndexTest() {
		queue.enqueue(24);
		GLListIterator<Integer> listIterator = new GLListIterator<Integer>(queue, 0);
		assertEquals(1, listIterator.nextIndex(),"GLListIterator nextIndex failure");
	}
	
	@Test
	void GLListIteratorPrevIndexTest() {
		GLListIterator<Integer> listIterator = new GLListIterator<Integer>(queue, 0);
		assertEquals(-1, listIterator.previousIndex(),"GLListIterator prevIndex failure");
	}
	
	@Test
	void forEachLoopTest() {
		queue.enqueue(70);
		queue.enqueue(62);
		queue.enqueue(47);
		int queueContents = 0;
		for (Integer e : queue) {
			queueContents += e;
		}
		assertEquals(192, queueContents, "for each loop fail");
	}
}
