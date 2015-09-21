package com.cs3114.simulation.p1;


public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray) {
		// TODO later
		table = reactionArray;
		indexReaction = new int[reactionArray.length][reactionArray.length];
		setUpTable();
	}

	public Reaction[] updatePropensity(int curReactionIndex, int[] populations) {
		
		//table[curReactionIndex];
		
		for (int i= 0; i < table.length;i++) {
			//Update propensity for these reactions.
			if (indexReaction[curReactionIndex][i] != 0) {
				table[i].calculatePropensity(populations);
			}
		}
		
		return table;
	}

	private void setUpTable() {/*
		for (int i = 0; i < table.length; i++) {
			int index = 0;

			int[] reactants = table[i].getNetChanges();
			for (int spec = 0; spec < indexReaction.length; spec++) {
				if (reactants[i] != 0) {
					indexReaction[spec][index++] = i;
				}
			}
		}*/
		//int [][] netReactions= new int[table.length][table.length];
		
		for (int i = 0; i < table.length; i++) {
			//netReactions[i] = table[i].getNetChanges();
			indexReaction[i] = table[i].getNetChanges();
		}
	}
	
	public int[][] getIR() {
		return indexReaction;
	}

}