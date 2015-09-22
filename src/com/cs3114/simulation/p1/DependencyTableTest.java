package com.cs3114.simulation.p1;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DependencyTableTest {

	private DependencyTable tTable;

	@Before
	public void setUp() throws Exception {
		Reaction[] reactions = new Reaction[4];
		Reaction reac1 = new Reaction(10, new int[]{0, 0, 0}, new int[] {1, 0, 0});
		Reaction reac2 = new Reaction(.01, new int[]{1, 1, 0}, new int[] {-1, 1, 0});
		Reaction reac3 = new Reaction(10, new int[]{0, 1, 0}, new int[] {0, -1, 1});
		Reaction reac4 = new Reaction(25, new int[]{0, 0, 1}, new int[]{0, 2, -1});
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
		boolean[][] table = tTable.getIR();
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		assertTrue(true);
	}
	
	@Test
	public void testGetSpeciesChange() {
		
	}

}
