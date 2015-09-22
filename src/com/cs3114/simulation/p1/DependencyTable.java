package com.cs3114.simulation.p1;


public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		indexReaction = new int[reactionArray.length][reactionArray.length];
		setUpTable();
	}

	public int[] updatePropensity(Heap minHeap, int[] populations) {
		/*
		int curReactionIndex = 0;
		
		for (int indexTable = 0; indexTable < table.length; indexTable++) {
			//2 reactions are equal if their propensity, tau, and k values are the same.
			if (table[indexTable].equals(current)) {
				curReactionIndex = indexTable;
			}
		}
		
		for (int i= 0; i < table.length;i++) {
			//Update propensity for these reactions.
			if (indexReaction[curReactionIndex][i] != 0) {
				table[i].calculatePropensity(populations);
			}
		}
		*/
		Reaction curFired = minHeap.remove();
		int[] net = curFired.getNetChanges();
		for (int i = 0; i < net.length; i++) {
			if (net[i] != 0) {
				table[i].calculatePropensity(populations);
			}
		}
		
		for (int k = 0; k < net.length; k++) {
			populations[k] += net[k];
		}
		
		return populations;
	}

	private void setUpTable() {
		for (int i = 0; i < table.length; i++) {
			indexReaction[i] = table[i].getNetChanges();
		}
	}
	
	public int[][] getIR() {
		return indexReaction;
	}

}