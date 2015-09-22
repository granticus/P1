package com.cs3114.simulation.p1;


public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		indexReaction = new int[reactionArray.length][reactionArray.length];
		setUpTable();
	}

	public Reaction[] updatePropensity(int curReactionIndex, int[] populations) {

		
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