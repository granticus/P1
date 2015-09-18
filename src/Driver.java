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
		double [][] reactions = new double[numReactions][numSpecies+1]; //+1 because of k
		for(int reactionNum = 0; reactionNum < numReactions; reactionNum++){
			for(int i = 0; i < numSpecies; i++){
				reactions[reactionNum][i] = 10; //READ IN SPECIES VALUES (+1, -2, 0, etc..)
			}
			reactions[reactionNum][numSpecies] = .1; //READ IN K
		}
		reactions[0][0] = 1;
		reactions[0][1] = 0;
		reactions[0][2] = 0;
		reactions[0][3] = 10;
		
		reactions[1][0] = -1;
		reactions[1][1] = 1;
		reactions[1][2] = 0;
		reactions[1][3] = .01;
		
		reactions[0][0] = 0;
		reactions[0][1] = -1;
		reactions[0][2] = 1;
		reactions[0][3] = 10; //FOR NOW, manually set
		
		//SETUP UP INITIAL PROPENSITIES
		double[] propensities = new double[numReactions];
		for(int i = 0; i < numReactions; i++){
			propensities[i] = 
		}
		
		int currentTime = 0;
		
		while(currentTime < finalSimTime){
			
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
