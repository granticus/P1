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
//   during the discussion. I have violated neither the spiritnor
//   letter of this restriction.
import java.io.*;

public class P1 {

	public static void main(String[] args) throws IOException {
/*
		//SAMPLE HARDCODED DATA
		int numSimulations = 1;
		
		int numSpecies = 3;
		int totalReactions = 3;
		int numOutputted = 2;
		int finalSimTime = 10;
		
		int[] populations = new int[3];
		populations[0] = 1000;
		populations[1] = 1000;
		populations[2] = 0;
		
		int[] trackedIndices = new int[2];
		trackedIndices[0] = 0;
		trackedIndices[1] = 1;
		
		Reaction [] reactions = new Reaction[totalReactions];
		Reaction reac1 = new Reaction(10, new int[]{1, 0, 0}, new int[]{1, 0, 0});
		Reaction reac2 = new Reaction(.01, new int[]{1, 1, 0}, new int[]{-1, 1, 0});
		Reaction reac3 = new Reaction(10, new int[]{0, 1, 0}, new int[]{0, -1, 1}); // FOR NOW, manually set
		reactions[0] = reac1;
		reactions[1] = reac2;
		reactions[2] = reac3;
		
		File oFile = new File("output.output");
		oFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(oFile.getAbsoluteFile()));
		System.out.println(oFile.getAbsolutePath());
		
		*/
		
	
		
		//INPUTTED DATA
		InputParser parse = new InputParser();
		
		int numSimulations = Integer.parseInt(args[0]);
		//This pretty much generates nS # of output files
		File oFile = new File(args[2]);
		oFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(oFile.getAbsoluteFile()));
		
		/*
		File iFile = new File(args[1]);
		InputStream read = new FileInputStream(iFile);
		String[] lines = read.toString().split("\n");

	*/
		
		FileReader freader = new FileReader(args[1]);
		BufferedReader bReader = new BufferedReader(freader);
		//String[] lines = bReader.toString().split("\n");
		String file = "";
		String line = "";
		while((line=bReader.readLine()) != null) {
			file += line + "\n";
		}
		String [] lines = file.split("\n");
		
		int offset = parse.getFirstIndex(lines[3]);
		
		//FIRST LINE
		int[] fline = parse.getInts(lines[0]);
		int numSpecies = fline[0];
		int totalReactions = fline[1];
		int numOutputted = fline[2];
		int finalSimTime = fline[3];
		
		//SECOND LINE
		int[] populations;

		//THIRD LINE
		int[] trackedIndices = parse.getInts(lines[2]); // SUBTRACT 1 MAYBE LATER
		for(int i = 0; i < numOutputted; i++){
			trackedIndices[i] = trackedIndices[i] - offset;
		}
		int counter = 0;
		//REST OF LINES
		Reaction [] reactions = new Reaction[totalReactions];
		for(int reactionNum = 0; reactionNum < totalReactions; reactionNum++){
			reactions[reactionNum] = new Reaction(parse.getKConstant(lines[reactionNum+3]), parse.getReactants(lines[reactionNum+3], numSpecies),
					parse.getEquation(lines[reactionNum+3], numSpecies), counter++);
		}
		
		int [][] finalPops = new int[numSimulations][numSpecies];
		
		double currentTime;
		
		for(int i = 0; i < numSimulations; i++){
			
			currentTime = 0;
			populations = parse.getInts(lines[1]);
			
			while(currentTime < finalSimTime){
				
				if(numSimulations == 1){
					String newLine = currentTime + "\t";
					for(int j = 0; j < numOutputted; j++){
						newLine += populations[trackedIndices[j]];
						if(j != numOutputted - 1){ newLine += "\t"; }
						else { newLine += "\n"; }
					}
					
					bw.write(newLine);
				}
				
				//calculate fire times
				for(int j = 0; j < totalReactions; j++){
					reactions[j].setCurrentTau(nTau(reactions[j].calculatePropensity(populations)));
				}
				
				//choose lowest fire time
				int lowestFireTimeIndex = 0;
				for(int j = 1; j < totalReactions; j++){
					if(reactions[j].getCurrentTau() < reactions[lowestFireTimeIndex].getCurrentTau()){
						lowestFireTimeIndex = j;		
					}
				}
				
				//update populations using the netChange of the chosen reaction
				int[] currNetChange = reactions[lowestFireTimeIndex].getNetChanges();
				reactions[lowestFireTimeIndex].incrementFired();
				
				for(int j = 0; j < numSpecies; j++){
					populations[j] += currNetChange[j];
				}
				
				//add chosen time to currentTime
				currentTime += reactions[lowestFireTimeIndex].getCurrentTau();
			}
			for(int j = 0; j < numSpecies; j++){
				finalPops[i][j] = populations[j];
			}
		}

		if (numSimulations == 1){
			for(int i = 0; i < totalReactions; i++){
				bw.write(reactions[i].getNumFired() + "\n");
			}
		}else { // more than 1 sim
			double[] sum = new double[numSpecies];
			double[] mean = new double[numSpecies];
			
			for(int i = 0; i < numSimulations; i++){
				for(int j = 0; j < numSpecies; j++){
					sum[j] += finalPops[i][j];
				}
			}
			
			for(int i = 0; i < numSpecies; i++){
				mean[i] = sum[i]/numSimulations;
			}
			
			double[] variances = new double[numSpecies];
			
			for(int i = 0; i < numSimulations; i++){
				for(int j = 0; j < numSpecies; j++){
					variances[j] += (finalPops[i][j] - mean[j])*(finalPops[i][j] - mean[j]);
				}
			}
			
			for(int i = 0; i < numSpecies; i++){
				variances[i] /= (numSimulations - 1);
			}
			
			//STANDARD DEVIATION
			double []stdPops = new double[numSpecies];
			for(int i = 0; i < numSpecies; i++){
				stdPops[i] = Math.sqrt(variances[i]);
			}
			
			//OUTPUT THIS STUFF
			
			for(int i = 0; i < numSimulations; i++){
				for(int j = 0; j < numOutputted; j++){
					bw.write("" + finalPops[i][j]);
					if(j != numOutputted - 1){
						bw.write("\t");
					}else{
						bw.write("\n");
					}
				}
			}
			
			String meanString = "";
			for(int i = 0; i < numOutputted; i++){
				int index = trackedIndices[i];
				meanString += mean[index] + "\t";
			}
			meanString += "\n";
			System.out.print(meanString);
			bw.write(meanString);
			
			String varString = "";
			for(int i = 0; i < numOutputted; i++){
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
	
	private static double nTau(double propensity) {
		return Math.log(1/Math.random())/propensity;
	}
}
