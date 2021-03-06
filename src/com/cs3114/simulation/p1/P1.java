package com.cs3114.simulation.p1;

/**
 * Operating System: Windows 8.1
 * Compiler: Eclipse 
 * 
 * 
 * 
 * @author Grant Golden
 * @author Alex Hsu
 *
 */
// On my honor:
//
// - I have not used source code obtained from another student,
//   or any other unauthorized source, either modified or
//   unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
//   anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.

import java.util.ArrayList;
import java.io.*;

public class P1 {

	public static void main(String[] args) throws IOException {

		// INPUTTED DATA
		InputParser parse = new InputParser();

		int numSimulations = Integer.parseInt(args[0]);
		// This pretty much generates nS # of output files
		File oFile = new File(args[2]);
		oFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				oFile.getAbsoluteFile()));

		/*
		 * File iFile = new File(args[1]); InputStream read = new
		 * FileInputStream(iFile); String[] lines = read.toString().split("\n");
		 */

		FileReader freader = new FileReader(args[1]);
		BufferedReader bReader = new BufferedReader(freader);
		// String[] lines = bReader.toString().split("\n");
		String file = "";
		String line = "";
		while ((line = bReader.readLine()) != null) {
			file += line + "\n";
		}
		String[] lines = file.split("\n");

		// gets where the indexing starts, either 0 (S0), or 1 (S1)
		int offset = parse.getFirstIndex(lines[3]);

		// FIRST LINE
		int[] fline = parse.getInts(lines[0]);
		// total number of species
		int numSpecies = fline[0];
		// total number of reactions
		int totalReactions = fline[1];
		// total number of outputted
		int numOutputted = fline[2];
		// the final simulation time
		int finalSimTime = fline[3];

		// SECOND LINE
		// stores the current populations for each species
		int[] populations;

		// THIRD LINE
		// stores the array of indices to be tracked
		int[] trackedIndices = parse.getInts(lines[2]);
		// this loop updates
		for (int i = 0; i < numOutputted; i++) {
			trackedIndices[i] = trackedIndices[i] - offset;
		}
		int counter = 0;
		// REST OF LINES
		Reaction[] reactions = new Reaction[totalReactions];
		for (int reactionNum = 0; reactionNum < totalReactions; reactionNum++) {
			reactions[reactionNum] = new Reaction(
					parse.getKConstant(lines[reactionNum + 3]),
					parse.getReactants(lines[reactionNum + 3], numSpecies),
					parse.getEquation(lines[reactionNum + 3], numSpecies),
					counter++);
		}

		int[][] finalPops = new int[numSimulations][numSpecies];

		double currentTime;

		Heap reactionHeap;
		DependencyTable dependency = new DependencyTable(reactions);
		ArrayList<Reaction> dependents;
		
		for (int i = 0; i < numSimulations; i++) {

			currentTime = 0;
			populations = parse.getInts(lines[1]);

			/*
			 * Calculates and sets the tau to be initialized so that we can sort
			 * the Heap.
			 */
			for (int j = 0; j < totalReactions; j++) {
				//reactions[j].updateTau(populations);
				reactions[j].updateTau(populations);
			}

			reactionHeap = new Heap(reactions);
			
			while (currentTime < finalSimTime) {

				if (numSimulations == 1) {
					String newLine = currentTime + "\t";
					for (int j = 0; j < numOutputted; j++) {
						newLine += populations[trackedIndices[j]];
						if (j != numOutputted - 1) {
							newLine += "\t";
						} else {
							newLine += "\n";
						}
					}

					bw.write(newLine);
				}

				// choose lowest fire time
				// Gets the lowest firing time from the heap.
				Reaction minReaction = reactionHeap.minElement();

				double curTau = minReaction.getCurrentTau();
				
				// Gets the arraylist of dependents from the current reaction
				// fired. Then updates the current reaction with a new tau. The
				// heap sort function is called to bring the smallest element to
				// the front.
				dependents = dependency.getDependents(minReaction);
				//minReaction.setCurrentTau(nTau(minReaction.calculatePropensity(populations)));
				
				// update populations using the netChange of the chosen reaction
				int[] currNetChange = minReaction.getNetChanges();

				minReaction.incrementFired();

				for (int j = 0; j < numSpecies; j++) {
					populations[j] += currNetChange[j];
				}

				/*
				 * Once the population has been updated, we need to update the
				 * propensities that have been changed because of the reaction
				 * that was just fired. Also updates the propensity of the
				 * current reaction fired.
				 */
				
				
				for (int dIndex = 0; dIndex < dependents.size(); dIndex++) {
					Reaction temp = dependents.get(dIndex);
					//temp.updateTau(populations);
					temp.updateTau(populations);
					//temp.setCurrentTau(nTau(temp.calculatePropensity(populations)));
				}
				reactionHeap.minHeap();

				currentTime += curTau;
			}
			for (int j = 0; j < numSpecies; j++) {
				finalPops[i][j] = populations[j];
			}
		}

		if (numSimulations == 1) {
			for (int i = 0; i < totalReactions; i++) {
				bw.write(reactions[i].getNumFired() + "\n");
			}
		} else { // more than 1 sim
			double[] sum = new double[numSpecies];
			double[] mean = new double[numSpecies];

			for (int i = 0; i < numSimulations; i++) {
				for (int j = 0; j < numSpecies; j++) {
					sum[j] += finalPops[i][j];
				}
			}

			for (int i = 0; i < numSpecies; i++) {
				mean[i] = sum[i] / numSimulations;
			}

			double[] variances = new double[numSpecies];

			for (int i = 0; i < numSimulations; i++) {
				for (int j = 0; j < numSpecies; j++) {
					variances[j] += (finalPops[i][j] - mean[j])
							* (finalPops[i][j] - mean[j]);
				}
			}

			for (int i = 0; i < numSpecies; i++) {
				variances[i] /= (numSimulations - 1);
			}

			// STANDARD DEVIATION
			double[] stdPops = new double[numSpecies];
			for (int i = 0; i < numSpecies; i++) {
				stdPops[i] = Math.sqrt(variances[i]);
			}

			// OUTPUT THIS STUFF

			for (int i = 0; i < numSimulations; i++) {
				for (int j = 0; j < numOutputted; j++) {
					bw.write("" + finalPops[i][j]);
					if (j != numOutputted - 1) {
						bw.write("\t");
					} else {
						bw.write("\n");
					}
				}
			}

			String meanString = "";
			for (int i = 0; i < numOutputted; i++) {
				int index = trackedIndices[i];
				meanString += mean[index] + "\t";
			}
			meanString += "\n";
			System.out.print(meanString);
			bw.write(meanString);

			String varString = "";
			for (int i = 0; i < numOutputted; i++) {
				int index = trackedIndices[i];
				varString += variances[index] + "\t";
			}
			varString += "\n";
			System.out.print(varString);
			bw.write(varString);
		}

		bw.close();
		bReader.close();

	}
}