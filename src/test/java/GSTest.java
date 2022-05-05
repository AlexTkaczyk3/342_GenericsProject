import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GSTest {

	GenericStack<String> stack;
	
	@BeforeEach
	void init() {
		stack = new GenericStack<String>("ring");
	}
	
	//  Stack Tests
	
	@Test
	void stackConstructorTest() {
		assertEquals("ring", stack.getHead().data, "stack sontructor fail");
	}

	@Test
	void pushTest() {
		stack.push("index");
		assertEquals("index", stack.getHead().data, "push fail");
	}
	
	@Test
	void popTest() {
		stack.push("thumb");
		stack.push("index");
		assertEquals("index", stack.pop(), "pop fail");
	}
	
	@Test
	void removeTailTest() {
		stack.push("pinky");
		assertEquals("ring", stack.removeTail(),"failure msg");
	}
	
}
