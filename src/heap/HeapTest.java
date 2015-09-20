package heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

	Heap testHeap;
	@Before
	public void setUp() throws Exception {
		int [] heapArray = new int[10];
		heapArray[0] = 15;
		heapArray[1] = 10;
		heapArray[2] = 8;
		
		testHeap = new Heap(heapArray, 3, 10);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
