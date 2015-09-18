
/**
 * The Class InputParser. This class has methods to take a String and return the necessary data from the string. It can return an array	of ints if the String needs each of those elements. It can also update the reactionary table.
 */
public class InputParser {
	
	/**
	 * Instantiates a new input parser. The class should not 
	 * store anything, so the main method is empty and does nothing.
	 */
	public InputParser() {};
	
	/**
	 * Gets the ints. Takes a String and returns all the ints from the line. This will only work if the line is split by whitespace and filled with only numbers of type integer.
	 *
	 * @param line The String that will be parsed for its ints. Cannot be null. Has to only contain numbers of type integer.
	 * @return the ints An array of the integers in the line.
	 */
	public int[] getInts(String line) {
		int[] num = new int[4];
		String[] strInts = line.split(" ");
		
		for (int k = 0; k < strInts.length; k++) {
			num[k] = Integer.parseInt(strInts[k]);
		}
		return null;
	}

	/*
  		ei. :
		  
		  	3 3 2 10
			1000 1000 0
			1 2
			
			S1 ->10 2S1
			S1 + S2 ->0.01 2S2
			S2 ->10 S3
			2S2
			
			S1	S2	S3 	k
			1	0	0	10
			-1	1	0	.01
			0	-1	1	10

		 */
	
	/**
	 * Reac and prod.
	 *
	 * @param line the line
	 * @param equationNumber the equation number
	 * @param rTable the r table
	 * @return the double[][]
	 */
	public double [][] reacAndProd(String line, int equationNumber, double[][] rTable) {
		String [] elements = line.split(" ");
		int side = 0;
		int kIndex = rTable.length;
		
		for (int i = 0; i < elements.length; i++) {
			
			int numSpecies = 1;
			int species = 0;
			int sIndex = elements[i].indexOf('S');
			
			if (elements[i].substring(0, 2).equals("->")) {
				side = 1;
				rTable[kIndex][equationNumber] = Integer.valueOf(elements[i].substring(3));
				break;
			}
			else if (elements[i].substring(0, 1).equals("+")) {
				break;
			}
			else if (elements[i].matches("\\d+S\\d+")) {
				numSpecies = Integer.valueOf(elements[i].substring(0, sIndex));
			}
			
			species = Integer.valueOf(elements[i].substring(sIndex+1)); //careful,sometimes the reaction starts at zero.
			
			if (side == 0) {
				rTable[species][equationNumber]-=numSpecies;
			}
			else if (side == 1) {
				rTable[species][equationNumber]+=numSpecies;
			}
		}
			
		return rTable;
	}
	
}
