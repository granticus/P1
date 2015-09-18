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
		 * ei. :
		  
		  	3 3 2 10
			1000 1000 0
			1 2
			S1 ->10 2S1
			S1 + S2 ->0.01 2S2
			S2 ->10 S3
			2S2
			

		 */
		double [][] reacTable = new double[fline[0]][fline[1]]; // row vs column, the first is vertical the second is horizontal
		/*
		 * The [fline[0]] is the #of species, so s0, s1, s2, respectively
		 * The [fline[1]] is the # of chemical reactions, 
		 */
		int[] initProp;
		int[] pop = getInts(lines[1]); 
		int[] dPop = getInts(lines[2]); 
		
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
/*
  		 * ei. :
		  
		  	3 3 2 10
			1000 1000 0
			1 2
			
			
			
			S1 ->10 2S1
			S1 + S2 ->0.01 2S2
			S2 ->10 S3
			2S2
			
			k	S1	S2	S3
			10	1	0	0
			.01	-1	1	0
			10	0	-1	1

		 */
	
	private static double [][] reacAndProd(String line, int equationNumber, double[][] rTable) {
		
		/*
		 * The [fline[0]] is the #of species, so s0, s1, s2, respectively
		 * The [fline[1]] is the # of chemical reactions, 
		 */
		
		String [] sepEqua = line.split("->");
		
		//sepEqua[0] should have the reactants **assuming there exists reactants.
		//sepEqua[1] should have the products
		
		String [] reac = sepEqua[0].split(" + ");
		String [] prod = sepEqua[1].split(" + ");
		
		for (int j = 0; j < prod.length; j++) {
			int sIndex = prod[j].indexOf('S');
		}
		
		for (int i = 0; i < reac.length; i++) {
			int sIndex =reac[i].indexOf('S');
			
			if (reac[i].matches("\\d+S\\d+")) {
				//multiple reactants of the same species
				int reaction = Integer.valueOf(reac[i].substring(sIndex+1, sIndex+2));
				int numReac = Integer.valueOf(reac[i].substring(sIndex-2, sIndex));
				// This does not account for numbers greater than 9.
				rTable[reaction][equationNumber] = rTable[reaction][equationNumber] - numReac;
				// reaction gets what #species the matching is
			}
			else if (reac[i].matches("S\\d+")) {
				int reaction = Integer.valueOf(reac[i].substring(sIndex+1, sIndex+2));
				rTable[reaction][equationNumber]--;
			}
		}
		
		return null;
		
	}
	
	/*
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
	*/
}
