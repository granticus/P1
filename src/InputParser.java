import java.io.*;


public class InputParser {

	public static void main(String[] args) throws IOException {
	
		int numSimulations = Integer.parseInt(args[0]);
		//This pretty much generates nS # of output files
		File iFile = new File(args[1]);
		PrintWriter oFile = new PrintWriter (args[2]);
		
		InputStream read = new FileInputStream(iFile);
		String [] lines = read.toString().split("\n");
		int[] fline = getInts(lines[0]);
		/*
		 * fline[0] is number of species
		 * fline[1] specifies the number of reactions
		 * fline[2] specifies # of chemical species that will be displayed in the output
		 * fline[3] final time when simulation time should end.
		 * 
		 */
		
		int[] initProp;
		int[] pop = getInts(lines[1]);
		//int[] output = new int[fline[2]]; 
		int[] dPop = getInts(lines[2]); //subtract the individual elements by 1 in order the index of array
		//We will need this later, but not currently important.
		/*
		for (int j = 0; j < output.length; j++) {
			output[j] = initNPop[dPop[j]-1];
		}*/
		//unless we keep dPop
		
		double time = 0;
		
		
		//while (time < numSimulations)
		// double tau = nTau(/*propensity*/0);
		// time += tau;
		
		for (int i = 4; i < 4 + fline[1]; i++) {
			//Parses line by line
			
			
			
		}
		
		
		
		read.close();
		oFile.close();
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
	
}
