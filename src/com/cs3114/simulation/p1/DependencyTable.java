package com.cs3114.simulation.p1;

import java.util.*;

/**
 * The Class Dependency Table. The primary purpose of this class is to return an
 * arraylist of all the Reactions that will be updated when a specific reaction
 * fires.
 */
public class DependencyTable {

	/** The total number of reactions. */
	private int totReactions;

	/** The reaction index. */
	private boolean[][] reactionIndex;

	/** The species of all the reactions. */
	private int[][] specReactions;

	/** The r table. */
	ArrayList<ArrayList<Reaction>> rTable;

	/**
	 * Instantiates a new dependency table.
	 *
	 * @param reactionArray
	 *            the reaction array
	 */
	public DependencyTable(Reaction[] reactionArray) {
		totReactions = reactionArray.length;
		specReactions = new int[totReactions][totReactions];
		reactionIndex = new boolean[totReactions][totReactions];
		rTable = new ArrayList<ArrayList<Reaction>>();
		setUpTable(reactionArray);
	}

	/**
	 * Gets the dependents.
	 *
	 * @param curFired
	 *            the current reaction that will be fired. Called from the main;
	 * @return an arraylist that will return all the reactions that depends on
	 *         the population that will change when the current reaction fires.
	 */
	public ArrayList<Reaction> getDependents(Reaction curFired) {
		return rTable.get(curFired.getIndex());
	}

	/**
	 * Sets the 2d arraylist of all the reactions that depend on each other and
	 * stores that in a 2d table.
	 *
	 * @param reactionArray
	 *            The reaction array that needs to be set up. However, since we
	 *            only care about it to set up the arraylist, we do not need to
	 *            store it in for later.
	 */
	private void setUpTable(Reaction[] reactionArray) {

		/* Allocates the array to account for every reaction. */
		for (int i = 0; i < reactionArray.length; i++) {
			rTable.add(new ArrayList<Reaction>());
		}

		/* Stores the reactants into a 2d array of [Reactions][reactants] */
		for (int i = 0; i < reactionArray.length; i++) {
			specReactions[i] = reactionArray[i].getReactants();
		}

		/*
		 * SetUps the reaction Index. This is to make it easier to store indo
		 * the arraylist
		 */
		for (int i = 0; i < reactionArray.length; i++) {
			int[] net = reactionArray[i].getNetChanges();
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

		/*
		 * Always add current reaction fired index so the program will know to
		 * update its own propensity
		 */
		for (int r = 0; r < reactionIndex.length; r++) {
			for (int c = 0; c < reactionIndex[0].length; c++) {
				if (r == c) {
					reactionIndex[r][c] = true;
				}
			}
		}

		/*
		 * Once the reactionIndex is set, we go through every row. If there is
		 * an element that is true, the we store that Reaction in the array.
		 */
		for (int r = 0; r < rTable.size(); r++) {
			for (int c = 0; c < reactionArray.length; c++) {
				if (reactionIndex[r][c] == true) {
					rTable.get(r).add(reactionArray[c]);
				}
			}
		}
	}

	public void print() {

		for (int r = 0; r < reactionIndex.length; r++) {
			for (int c = 0; c < reactionIndex[0].length; c++) {
				System.out.print(reactionIndex[r][c] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Gets the dependencies and outputs them into an array of boolean. Takes a
	 * species, and goes through every reactant that this species is a part of.
	 * True if the reaction depends on this species, false if not.
	 *
	 * @param species
	 *            the species that will be checked to be part of the reactants.
	 * @return the dependencies
	 */
	private boolean[] getDependencies(int species) {
		boolean[] depen = new boolean[totReactions];
		for (int r = 0; r < specReactions.length; r++) {
			if (specReactions[r][species] != 0) {
				depen[r] = true;
			}
		}

		return depen;
	}

}