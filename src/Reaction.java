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

	/** The net changes. */
	private int[] netChanges;

	/**
	 * Instantiates a new reaction.
	 *
	 * @param k
	 *            the k
	 * @param reactants
	 *            the reactants
	 * @param netChanges
	 *            the net changes
	 */
	public Reaction(double k, int[] reactants, int[] netChanges) {
		this.reactants = reactants;
		this.netChanges = netChanges;
		this.k = k;
	}

	/**
	 * Calculate propensity.
	 *
	 * @param populations
	 *            the populations
	 * @return the double
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
	 * Gets the num fired.
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
