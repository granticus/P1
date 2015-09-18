
public class Reaction {
	private double k;
	private double propensity;
	
	private int[]reactants;
	private int[]netChange;
	
	public Reaction(double k, int numSpecies){
		reactants = new int[numSpecies];
		this.k = k;
	}
}
