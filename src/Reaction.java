
public class Reaction {
	private double k;
	private double propensity;
	
	private int[]reactants;
	private int[]netChanges;
	
	public Reaction(double k, int[]reactants, int[]netChanges){
		this.reactants = reactants;
		this.netChanges = netChanges;
		this.k = k;
	}
}
