package com.cs3114.simulation.p1;

import java.util.*;


public class DependencyTable {

	private Reaction[] table;
	private boolean[][] reactionIndex;

	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		reactionIndex = new boolean[reactionArray.length][reactionArray.length];
		setUpTable();
	}

	public int[] updatePropensity(Heap minHeap, int[] populations) {
	
		Reaction curFired = minHeap.remove();
		int[] net = curFired.getNetChanges();
		
		int currIndex;
		for (currIndex =0; currIndex < table.length; currIndex++) {
			if (curFired.equals(table[currIndex])) {
				break;
			}
		}
		
		for (int c = 0; c < reactionIndex[0].length; c++) {
			if (reactionIndex[currIndex][c] == true) {
				table[c].calculatePropensity(populations);
			}
		}
		
		for (int k = 0; k < net.length; k++) {
			populations[k] += net[k];
		}
		
		curFired.incrementFired();
		minHeap.insert(curFired);
		return populations;
	}

	private void setUpTable() {
		
		for (int r = 0; r < reactionIndex.length; r++) {
			int [] netChange = table[r].getNetChanges();
			if (netChange[r] != 0) {

				int [] reactants = table[r].getReactants();
				for (int iReactants = 0; iReactants < reactants.length; iReactants++) {
					if (reactants[iReactants] != 0) {
						reactionIndex[r][iReactants] = true;
					}
				}
			}
		}
	}

}