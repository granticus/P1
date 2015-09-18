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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		int numSimulations = 1;
		
		//FIRST LINE
		int numSpecies = 3;
		int numReactions = 3;
		int numOutputted = 2;
		int finalSimTime = 10;
		
		int[] populations = new int[numSpecies];
		
		//SECOND LINE
		for(int i = 0; i < numSpecies; i++){
			//populations[i] = 	READ IN THE VALUES
		}
		populations[0] = 1000;
		populations[1] = 1000;
		populations[2] = 0; 	//FOR NOW, manually set them
		
		//THIRD LINE
		int[] trackedIndices = new int[numOutputted];
		
		for(int i = 0; i < numOutputted; i++){
			//trackedIndices[i] = READ IN VALUES
		}
		trackedIndices[0] = 1;
		trackedIndices[1] = 2;
		
		//REST OF LINES
		Reaction [] reactions = new Reaction[numReactions];
		for(int reactionNum = 0; reactionNum < numReactions; reactionNum++){
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
		for(int i = 0; i < numReactions; i++){
			reactions[i].calculatePropensity(populations);
		}
		
		int currentTime = 0;
		
		for(int i = 0; i < numSimulations; i++){
			while(currentTime < finalSimTime){
				
			}
		}
	}

	private static int[] getInts(String line) {
		int[] num = new int[4];
		String[] strInts = line.split(" ");
		
		for (int k = 0; k < strInts.length; k++) {
			num[k] = Integer.parseInt(strInts[k]);
		}
		return null;
	}
	
	private static void getReactions(String line) {
		String [] equation = line.split("->");
		//products will be equation.length - 1;
		if (equation.length < 2) {
			
		}
		String [] products = equation[equation.length-1].split(" ");
		if (products[0].split("+").length == 1) {
			//product contains 2 separate species.
		}
		int rateConstant = Integer.parseInt(products[0]);
		//Find index of "s" and try to get an int b4 and after
		//TODO Not finished.
	}
	
	private static double nTau(double propensity) {
		return Math.log(1/Math.random())/propensity;
	}
}
