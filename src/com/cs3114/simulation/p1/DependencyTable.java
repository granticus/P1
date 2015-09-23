package com.cs3114.simulation.p1;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class DependencyTable.
 */
public class DependencyTable {

	
	/** The reaction index. */
	private boolean[][] reactionIndex;	
	
	/** The spec reactions. */
	private int [][] specReactions;
	
	/** The r table. */
	ArrayList<ArrayList<Reaction>>  rTable;

	/**
	 * Instantiates a new dependency table.
	 *
	 * @param reactionArray the reaction array
	 */
	public DependencyTable(Reaction[] reactionArray) {
		table = reactionArray;
		specReactions = new int[reactionArray.length][reactionArray.length];
		reactionIndex = new boolean[reactionArray.length][reactionArray.length];
		rTable = new ArrayList<ArrayList<Reaction>>();
		setUpTable();
	}
	
	/**
	 * Gets the dependents.
	 *
	 * @param curFired the cur fired
	 * @return the dependents
	 */
	public ArrayList<Reaction> getDependents(Reaction curFired) {
		return rTable.get(curFired.getIndex());
	}
	
	/**
	 * Sets the up table.
	 */
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
	
	/**
	 * Gets the dependencies.
	 *
	 * @param species the species
	 * @return the dependencies
	 */
	private boolean[] getDependencies(int species) {
		boolean[] depen = new boolean[table.length];
		for (int r = 0; r < specReactions.length; r++) {
			if (specReactions[r][species] != 0) {
				depen[r] = true;
			}
		}
		
		return depen;
	}

	/**
	 * Gets the ir.
	 *
	 * @return the ir
	 */
	public boolean[][] getIR() {
		return reactionIndex;
	}
	
	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public Reaction[] getTable() {
		return table;
	}

}