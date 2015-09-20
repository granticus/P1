// TODO: Auto-generated Javadoc
/**
 * The Class Reaction. This will store the information about each separate
 * reaction. The information stored is the propensity, the reactants, and the
 * whole equation. This class will keep track of the number of reactions fired
 * and the current tau of the reaction.
 */
public class Reaction {

	/** The k. */
	private double k;

	/** The propensity. */
	private double propensity;

	/** The number of reactions that this reaction fired. */
	private int numFired;

	/** The current tau. */
	private double currentTau;

	/** The reactants. */
	private int[] reactants;

	/** The net changes. A net sum of the equation to see which pops change. */
	private int[] netChanges;

	/**
	 * Instantiates a new reaction. This requires the data to already be parsed and inserts it in the class.
	 *
	 * @param k
	 *            the k constant that affects the propensity.
	 * @param reactants
	 *            the reactants that will be changing.
	 * @param netChanges
	 *            the net changes The net population that will decreased or increased in the whole reaction.
	 */
	public Reaction(double k, int[] reactants, int[] netChanges) {
		this.reactants = reactants;
		this.netChanges = netChanges;
		this.k = k;
	}

	/**
	 * Calculates propensity. This depends on the populations of the reactants, as the population will be decreasing if multiple reactants are used. 
	 *
	 * @param populations
	 *            the current populations of all the species 
	 * @return propensity
	 * 			  Affects the next tau time
	 */
	public double calculatePropensity(int[] populations) {
		propensity = k;

		for (int i = 0; i < reactants.length; i++) {
			if (reactants[i] > 0) { // we have a reactant at i, and the value is
									// the amount
				for (int count = 0; count < reactants[i]; count++) {
					propensity *= populations[i] - count;
				}
			}
		}

		return propensity;
	}

	/**
	 * Gets the number that this reaction has fired.
	 *
	 * @return the num fired
	 */
	public int getNumFired() {
		return numFired;
	}

	/**
	 * Increment fired.
	 */
	public void incrementFired() {
		numFired++;
	}

	/**
	 * Sets the current tau.
	 *
	 * @param t
	 *            the new current tau
	 */
	public void setCurrentTau(double t) {
		currentTau = t;
	}

	/**
	 * Gets the current tau.
	 *
	 * @return the current tau
	 */
	public double getCurrentTau() {
		return currentTau;
	}

	/**
	 * Gets the net changes.
	 *
	 * @return the net changes
	 */
	public int[] getNetChanges() {
		return netChanges;
	}
}
