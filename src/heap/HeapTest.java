package heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

	Heap testHeap;
	@Before
	public void setUp() throws Exception {
		
		testHeap = new Heap(15);
	
	}

	@Test
	public void test() {
		System.out.println("The Min Heap is ");
		
        testHeap.insert(5);
        testHeap.insert(3);
        testHeap.insert(17);
        testHeap.insert(10);
        testHeap.insert(84);
        testHeap.insert(19);
        testHeap.insert(6);
        testHeap.insert(22);
        testHeap.insert(9);
        testHeap.minHeap();
 
        assertEquals("3, 5, 6, 9, 10, 17, 19, 22, 84",testHeap.print());
        System.out.println("The Min val is " + testHeap.remove());
        
        
        
	}

}
