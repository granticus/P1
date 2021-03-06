package com.cs3114.simulation.p1;

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

	private int firstIndex;

	/**
	 * Instantiates a new input parser. The class should not store anything, so
	 * the main method is empty and does nothing.
	 */
	public InputParser() {
		firstIndex = 0;
	}

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

		int[] netReaction = new int[totalSpecies];

		String[] equation = new String[2];
		int splitIndex = line.indexOf("->");
		if (splitIndex == 0) {
			equation[0] = "";
			equation[1] = line.substring(2);
		} else {
			equation = line.split("->");
		}

		for (int i = 0; i < equation.length; i++) {
			if (equation[i].equals(""))
				continue;

			String[] elements = equation[i].split(" ");

			for (int j = 0; j < elements.length; j++) {

				int numSpecies = 1;
				int species = 0;
				int sIndex = elements[j].indexOf('S');
				if (sIndex == -1)
					continue;

				if (elements[j].substring(0, 1).equals("+")
						|| elements[j].substring(0, 2).equals("->")) {
					continue;
				}
				if (elements[j].matches("\\d+S\\d+")) {
					numSpecies = Integer.valueOf(elements[i].substring(0,
							sIndex));
				}
				species = Integer.valueOf(elements[j].substring(sIndex + 1))
						- firstIndex;

				if (i == 0) {
					netReaction[species] -= numSpecies;
				} else if (i == 1) {
					netReaction[species] += numSpecies;
				}
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

		int[] reactants = new int[totalSpecies];
		if (line.substring(0, 2).equals("->")) {
			return reactants;
		}
		/*
		 * Separates the equation into reactants and products. We only care
		 * about the reactants
		 */
		String[] reac = line.split("->");
		String[] elements = reac[0].split(" ");

		for (int i = 0; i < elements.length; i++) {
			int numSpecies = 1;
			int species = 0;
			int sIndex = elements[i].indexOf('S');

			if (elements[i].substring(0, 1).equals("+")) {
				continue;
			}

			if (elements[i].matches("\\d+S\\d+")) {
				numSpecies = Integer.valueOf(elements[i].substring(0, sIndex));
			}
			species = Integer.valueOf(elements[i].substring(sIndex + 1))
					- firstIndex;

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
		if (kIndex != 1) {
			int endKIndex = line.substring(kIndex).indexOf(' ');
			if (endKIndex == -1) {
				return Double
						.parseDouble(line.substring(kIndex, line.length()));
			}
			return Double.parseDouble(line
					.substring(kIndex, kIndex + endKIndex));

		}
		return 0;
	}

	/**
	 * Gets the first reaction element and determines whether the reaction
	 * starts with a 0 or a 1.
	 *
	 * @param line4
	 *            the line4 The very first line that will have the reaction
	 *            equation. The first species that appears here is guaranteed to
	 *            be the first species, which will determine if an offset is
	 *            necessary or not.
	 * @return the first index that corresponds to the species.
	 */
	public int getFirstIndex(String line4) {
		String[] lines = line4.split("->");
		int sIndex = 0;
		int i;
		for (i = 0; i < lines.length; i++) {
			if (lines[i].indexOf('S') != -1) {
				sIndex = lines[i].indexOf('S');
				break;
			}
		}
		int endIndex = lines[i].substring(sIndex).indexOf(' ');
		if (endIndex == -1) {
			endIndex = lines[i].length();
		}
		if (Integer.valueOf(lines[i].substring(sIndex + 1, endIndex)) != 0) {
			firstIndex = 1;
		}

		return firstIndex;
	}

}
