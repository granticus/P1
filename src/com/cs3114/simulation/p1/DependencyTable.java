package com.cs3114.simulation.p1;


public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		indexReaction = new int[reactionArray.length][reactionArray.length];
		setUpTable();
	}

	public Reaction[] updatePropensity(Reaction current, int[] populations) {
		
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
		
		return table;
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