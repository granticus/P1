
/**
 * The Class InputParser. This class has methods to take a String and return the
 * necessary data from the string. It can return an array of ints if the String
 * needs each of those elements. It can also update the reactionary table.
 * 
 * @author Alex Hsu
 * @author Grant Golden
 * 
 */
public class InputParser {

	private int firstIndex = 0;
	
	
	/**
	 * Instantiates a new input parser. The class should not store anything, so
	 * the main method is empty and does nothing.
	 */
	public InputParser() {
		//Nothing needs to be initialized, so the body is empty.
	};

	/**
	 * Gets the ints. Takes a String and returns all the ints from the line.
	 * This will only work if the line is split by whitespace and filled with
	 * only numbers of type integer.
	 *
	 * @param line
	 *            The String that will be parsed for its ints. Cannot be null.
	 *            Has to only contain numbers of type integer.
	 * @return the ints An array of the integers in the line.
	 */
	public int[] getInts(String line) {
		String[] strInts = line.split(" ");
		int[] num = new int[strInts.length];

		for (int k = 0; k < strInts.length; k++) {
			num[k] = Integer.parseInt(strInts[k]);
		}
		return num;
	}

	/**
	 * Reactions and products. This will take a chemical equation and will
	 * update the equation table that the equation corresponds too. This will
	 * also get the k value of a reaction. This method should only be called
	 * once, and once the string has been parsed, should not be called again.
	 *
	 * @param line
	 *            The String that will be parsed. Cannot be null. Must follow
	 *            the specified format and rules.
	 * @param totalSpecies
	 *            This will determine how long to build the array.
	 * @return the double[] returns an updated equation table with the net loss
	 *         or gain from the equation with the k at the end.
	 */
	public int[] getEquation(String line, int totalSpecies) {
		String[] elements = line.split(" ");
		int side = 0;
		int[] netReaction = new int[totalSpecies];

		for (int i = 0; i < elements.length; i++) {

			int numSpecies = 1;
			int species = 0;
			int sIndex = elements[i].indexOf('S');

			if (elements[i].substring(0, 1).equals("+")) {
				continue;
			}

			else if (elements[i].substring(0, 2).equals("->")) {
				side = 1;
				continue;
			}
			if (elements[i].matches("\\d+S\\d+")) {
				numSpecies = Integer.valueOf(elements[i].substring(0, sIndex));
			}
			species = Integer.valueOf(elements[i].substring(sIndex + 1)) - 1;
			// careful,sometimes the reaction starts at zero.

			if (side == 0) {
				netReaction[species] -= numSpecies;
			} else if (side == 1) {
				netReaction[species] += numSpecies;
			}
		}

		return netReaction;
	}

	/**
	 * Gets the reactants and outputs them onto a table.
	 *
	 * @param line
	 *            The String that will have the chemical equation.
	 * @param equationNumber
	 *            The equation number that will dictate the row.
	 * @param totalSpecies
	 *            This will decide how long the array is.
	 * @return the reactants returns an array that has width of all the species
	 *         and whether those species are present in the reaction, but not
	 *         products.
	 */
	public int[] getReactants(String line, int totalSpecies) {
		String[] elements = line.split(" ");
		int[] reactants = new int[totalSpecies];

		for (int i = 0; i < elements.length; i++) {

			int numSpecies = 1;
			int species = 0;
			int sIndex = elements[i].indexOf('S');
			if (elements[i].substring(0, 1).equals("+")) {
				continue;
			}

			else if (elements[i].substring(0, 2).equals("->")) {
				break;
			}
			if (elements[i].matches("\\d+S\\d+")) {
				numSpecies = Integer.valueOf(elements[i].substring(0, sIndex));
			}
			species = Integer.valueOf(elements[i].substring(sIndex + 1)) - 1;
			// careful,sometimes the reaction starts at zero.

			reactants[species] += numSpecies;

		}
		return reactants;
	}

	/**
	 * Gets the k constant of a reaction by looking for the arrow and getting
	 * the number immediately after it..
	 *
	 * @param line
	 *            The equation the will have the k constant
	 * @return the k constant from the equation.
	 */
	public double getKConstant(String line) {
		int kIndex = line.indexOf("->") + 2;
		int endKIndex = line.substring(kIndex).indexOf(' ');
		if (kIndex != 1)
		{
			return Double.parseDouble(line
					.substring(kIndex, kIndex + endKIndex));
		}
		return 0;
	}
	
	public int getFirstIndex(String line4) {

		String[] elements = line4.split(" ");
		int sIndex = elements[0].indexOf("S");
		if ()
		
		
		return 0;
	}
}
