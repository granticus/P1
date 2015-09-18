
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
	
	public void calculatePropensity(int[] populations){
		propensity = k;
		
		for(int i = 0; i < reactants.length; i++){
			if(reactants[i] > 0){ //we have a reactant at i, and the value is the amount
				for(int count = 0; count < reactants[i]; count++){
					propensity *= populations[i] - count;
				}
			}
		}
	}
}
