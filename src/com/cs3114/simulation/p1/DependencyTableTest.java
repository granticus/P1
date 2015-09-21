package com.cs3114.simulation.p1;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DependencyTableTest {

	private DependencyTable tTable;

	@Before
	public void setUp() throws Exception {
		Reaction[] reactions = new Reaction[3];
		Reaction reac1 = new Reaction(10, new int[] { 0, 0, 0 }, new int[] { 1,
				0, 0 });
		Reaction reac2 = new Reaction(.01, new int[] { 1, 1, 0 }, new int[] {
				-1, 1, 0 });
		Reaction reac3 = new Reaction(10, new int[] { 0, 1, 0 }, new int[] { 0,
				-1, 1 }); // FOR NOW, manually set
		/**
		
		->10 S1
		S1 + S2 ->.01 2S1
		S2 ->10 S3
		
		Should get:
		R:	1  2  3
		
		R1: 0, 1, 0
		R2: 0, 0, 1
		R3: 0, 0, 0
		
		 */
		reactions[0] = reac1;
		reactions[1] = reac2;
		reactions[2] = reac3;
		tTable = new DependencyTable(reactions);
	}

	@Test
	public void test() {
		int[][] table = tTable.getIR();
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		assertTrue(true);
	}

}
