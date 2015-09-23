package com.cs3114.simulation.p1;

import java.util.*;

public class DependencyTable {

	private Reaction[] table;
	private boolean[][] reactionIndex;
	ArrayList<ArrayList<Reaction>>  rTable;

	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		reactionIndex = new boolean[reactionArray.length][reactionArray.length];
		rTable = new ArrayList<ArrayList<Reaction>>();
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
		curFired.calculatePropensity(populations);
		
		for (int c = 0; c < reactionIndex[0].length; c++) {
			if (reactionIndex[currIndex][c] == true) {
				table[c].calculatePropensity(populations);
			}
		}

		for (int k = 0; k < net.length; k++) {
			populations[k] += net[k];
		}
		return populations;
	}

	private void setUpTable() {

		for(int i = 0; i < table.length; i++) {
			rTable.add(new ArrayList<Reaction>());
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
		
		for (int r = 0; r < rTable.size(); r++) {
			for (int c = 0; c < table.length; c++) {
				if (reactionIndex[r][c] == true) {
					rTable.get(r).add(table[c]);
				}
			}
		}
	}

	public boolean[][] getIR() {
		return reactionIndex;
	}
	
	public Reaction[] getTable() {
		return table;
	}

}