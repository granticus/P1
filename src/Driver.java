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
import java.io.*;

public class Driver {

	public static void main(String[] args) throws IOException {

		InputParser parse = new InputParser();
		
		int numSimulations = Integer.parseInt(args[0]);
		//This pretty much generates nS # of output files
		File iFile = new File(args[1]);
		PrintWriter oFile = new PrintWriter (args[2]);
		InputStream read = new FileInputStream(iFile);
		String[] lines = read.toString().split("\n");
		
		//FIRST LINE
		int[] fline = parse.getInts(lines[0]);
		int numSpecies = fline[0];
		int totalReactions = fline[1];
		int numOutputted = fline[2];
		int finalSimTime = fline[3];
		
		//SECOND LINE
		int[] populations = parse.getInts(lines[1]);
			
		//THIRD LINE
		int[] trackedIndices = parse.getInts(lines[2]);
		
		//REST OF LINES
		Reaction [] reactions = new Reaction[totalReactions];
		for(int reactionNum = 0; reactionNum < totalReactions; reactionNum++){
			//double k = .1; //READ IN K, DELETE THIS LINE
			//reactions[reactionNum] = new Reaction(k, REACTANTS_ARRAY, NET_CHANGES);
		}
		
		Reaction reac1 = new Reaction(10, new int[]{1, 0, 0}, new int[]{1, 0, 0});
		Reaction reac2 = new Reaction(.01, new int[]{1, 1, 0}, new int[]{-1, 1, 0});
		Reaction reac3 = new Reaction(10, new int[]{0, 1, 0}, new int[]{0, -1, 1}); // FOR NOW, manually set
		reactions[0] = reac1;
		reactions[1] = reac2;
		reactions[2] = reac3;
		
		//SETUP UP INITIAL PROPENSITIES
		for(int i = 0; i < totalReactions; i++){
			reactions[i].calculatePropensity(populations);
		}
		
		int currentTime = 0;
		
		for(int i = 0; i < numSimulations; i++){
			while(currentTime < finalSimTime){
				
			}
		}
	}
	
	private static double nTau(double propensity) {
		return Math.log(1/Math.random())/propensity;
	}
}
