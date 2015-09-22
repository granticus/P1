package com.cs3114.simulation.p1;

public class DependencyTable {

	private Reaction[] table;
	private boolean[][] reactionIndex;
	private int [][] specReactions;

	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		specReactions = new int[reactionArray.length][reactionArray.length];
		reactionIndex = new boolean[reactionArray.length][reactionArray.length];
		setUpTable();
	}

	public int[] updatePropensity(Reaction curFired, int[] populations) {
		int[] net = curFired.getNetChanges();

		int currIndex;
		for (currIndex = 0; currIndex < table.length; currIndex++) {
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
		return populations;
	}

	private void setUpTable() {

		for (int i = 0; i < table.length; i++) {
			specReactions[i] = table[i].getReactants();
		}
		
		for (int i = 0; i < table.length; i++) {
			int [] net = table[i].getNetChanges();
			for (int k = 0; k < net.length; k++) {
				if (net[k] != 0) {
					boolean[] dep = getDependencies(k);
					for (int j = 0; j < dep.length; j++) {
						if (dep[j] == true) {
							reactionIndex[i][j] = true;
						}
					}
				}
			}
		}	
	}
	
	private boolean[] getDependencies(int species) {
		boolean[] depen = new boolean[table.length];
		for (int r = 0; r < specReactions.length; r++) {
			if (specReactions[r][species] != 0) {
				depen[r] = true;
			}
		}
		
		return depen;
	}

	public boolean[][] getIR() {
		return reactionIndex;
	}

}