package com.cs3114.simulation.p1;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DependencyTableTest {

	private DependencyTable tTable;

	@Before
	public void setUp() throws Exception {
		Reaction[] reactions = new Reaction[4];
		int counter = 0;
		Reaction reac1 = new Reaction(10, new int[]{0, 0, 0}, new int[] {1, 0, 0}, counter++);
		Reaction reac2 = new Reaction(.01, new int[]{1, 1, 0}, new int[] {-1, 1, 0},counter++);
		Reaction reac3 = new Reaction(10, new int[]{0, 1, 0}, new int[] {0, -1, 1},counter++);
		Reaction reac4 = new Reaction(25, new int[]{0, 0, 1}, new int[]{0, 2, -1},counter++);
		/**
		
		->10 S1
		S1 + S2 ->.01 2S1
		S2 ->10 S3
		S3 ->25 2S2
		
		 */
		reactions[0] = reac1;
		reactions[1] = reac2;
		reactions[2] = reac3;
		reactions[3] = reac4;
		tTable = new DependencyTable(reactions);
	}

	@Test
	public void test() {
		int []pops = {1000, 100, 500};
		Reaction curFired = new Reaction(10, new int[]{0, 0, 0}, new int[] {1, 0, 0}, 0);
		pops = tTable.updatePropensity(curFired, pops);
		assertEquals(1001, pops[0]);
		
		assertTrue(true);
	}
}
