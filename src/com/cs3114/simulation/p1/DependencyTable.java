package com.cs3114.simulation.p1;

import java.util.*;

public class DependencyTable {

	private Reaction[] table;
	private boolean[][] reactionIndex;	
	private int [][] specReactions;
	ArrayList<ArrayList<Reaction>>  rTable;

	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		specReactions = new int[reactionArray.length][reactionArray.length];
		reactionIndex = new boolean[reactionArray.length][reactionArray.length];
		rTable = new ArrayList<ArrayList<Reaction>>();
		setUpTable();
	}

	public int[] updatePropensity(Reaction curFired, int[] populations) {
		int[] net = curFired.getNetChanges();

		curFired.calculatePropensity(populations);
		
		int currIndex;
		for (currIndex = 0; currIndex < table.length; currIndex++) {
			if (curFired.equals(table[currIndex])) {
				break;
			}
		}
		
		for (int i = 0; i < rTable.get(currIndex).size(); i++) {
			rTable.get(currIndex).get(i).calculatePropensity(populations);
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
		
		for (int r = 0; r < rTable.size(); r++) {
			for (int c = 0; c < table.length; c++) {
				if (reactionIndex[r][c] == true) {
					rTable.get(r).add(table[c]);
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
	
	public Reaction[] getTable() {
		return table;
	}

}