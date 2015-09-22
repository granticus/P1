package com.cs3114.simulation.p1;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

	Heap testHeap;
	@Before
	public void setUp() throws Exception {
		
		//testHeap = new Heap(15);
		Reaction [] reactions = new Reaction[4];
		Reaction reac1 = new Reaction(10, new int[]{1, 0, 0}, new int[]{1, 0, 0});
		Reaction reac2 = new Reaction(.01, new int[]{1, 1, 0}, new int[]{-1, 1, 0});
		Reaction reac3 = new Reaction(10, new int[]{0, 1, 0}, new int[]{0, -1, 1});
		Reaction reac4 = new Reaction(25, new int[]{0, 0, 1}, new int[]{0, 1, -1});
		reactions[0] = reac1;
		reactions[1] = reac2;
		reactions[2] = reac3;
		reactions[3] = reac4;
		
	
	}

	@Test
	public void test() {
		
        /*testHeap.insert(5);
        testHeap.insert(3);
        testHeap.insert(17);
        testHeap.insert(10);
        testHeap.insert(84);
        testHeap.insert(19);
        testHeap.insert(6);
        testHeap.insert(22);
        testHeap.insert(9);*/
        testHeap.minHeap();
 
        System.out.print(testHeap.print());
        
        //System.out.println("The Min val is " + testHeap.remove());
        
        assertTrue(true);
        
        
        
	}

}
