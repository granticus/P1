
/**
 * The Class InputParser. This class has methods to take a String and return the necessary data from the string. It can return an array	of ints if the String needs each of those elements. It can also update the reactionary table.
 * 
 * @author Alex Hsu
 * @author Grant Golden
 * 
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
	
	/**
	 * Reactions and products. This will take a chemical equation and will update the equation table that the equation corresponds too. This will also get the k value of a reaction. This method should only be called once, and once the string has been parsed, should not be called again.
	 *
	 * @param line The String that will be parsed. Cannot be null. Must follow the specified format and rules.
	 * @param equationNumber What number reaction (and row) the equation will go under in the equation table.
	 * @param rTable The equation table that will be updated everytime a reaction fires.
	 * @return the double[][] returns an updated equation table with the net loss or gain from the equation.
	 */
	public double [][] parseReaction(String line, int equationNumber, double[][] rTable) {
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
	
	/**
	 * Gets the reactants and outputs them onto a table.
	 *
	 * @param line The String that will have the chemical equation.
	 * @param equationNumber The equation number that will dictate the row.
	 * @param rTable the r table
	 * @return the reactants
	 */
	public int [][] getReactants(String line, int equationNumber, double[][] rTable) {
		String [] elements = line.split(" ");
		int[][] reactants = new int[rTable.length-1][rTable[0].length];
		
		for (int i = 0; i < elements.length; i++) {
			
			int numSpecies = 1;
			int species = 0;
			int sIndex = elements[i].indexOf('S');
			
			if (elements[i].substring(0, 2).equals("->")) {
				return reactants;
			}
			else if (elements[i].substring(0, 1).equals("+")) {
				break;
			}
			else if (elements[i].matches("\\d+S\\d+")) {
				numSpecies = Integer.valueOf(elements[i].substring(0, sIndex));
			}
			species = Integer.valueOf(elements[i].substring(sIndex+1)); //careful,sometimes the reaction starts at zero.
			
			reactants[species][equationNumber]+=numSpecies;
		}
			
		return reactants;
	}
	
}
