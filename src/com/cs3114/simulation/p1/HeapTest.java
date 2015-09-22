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
		reac1.setCurrentTau(.5);
		Reaction reac2 = new Reaction(.01, new int[]{1, 1, 0}, new int[]{-1, 1, 0});
		reac2.setCurrentTau(.3);
		Reaction reac3 = new Reaction(10, new int[]{0, 1, 0}, new int[]{0, -1, 1});
		reac3.setCurrentTau(.9);
		Reaction reac4 = new Reaction(25, new int[]{0, 0, 1}, new int[]{0, 1, -1});
		reac4.setCurrentTau(.6);
		
		reactions[0] = reac1;
		reactions[1] = reac2;
		reactions[2] = reac3;
		reactions[3] = reac4;
		
		testHeap = new Heap(reactions);
		
	
	}

	@Test
	public void testHeap() {

        testHeap.minHeap();
        Reaction testReaction = testHeap.remove();
        assertTrue(.3 == testReaction.getCurrentTau());
        testReaction.setCurrentTau(1.2);
        testHeap.insert(testReaction);
        System.out.println(testHeap.print());
        
        testReaction = testHeap.remove();
        assertTrue(.5 == testReaction.getCurrentTau());
        testReaction.setCurrentTau(1.5);
        testHeap.insert(testReaction);

        testReaction = testHeap.remove();
        assertTrue(.6 == testReaction.getCurrentTau());
        testReaction.setCurrentTau(1.8);
        testHeap.insert(testReaction);

        testReaction = testHeap.remove();
        assertTrue(.9 == testReaction.getCurrentTau());
        testReaction.setCurrentTau(2.0);
        testHeap.insert(testReaction);

        
	}

}
