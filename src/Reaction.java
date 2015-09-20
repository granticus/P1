
public class Reaction {
	private double k;
	private double propensity;
	
	private int numFired;
	
	private double currentTau;
	
	private int[]reactants;
	private int[]netChanges;
	
	public Reaction(double k, int[]reactants, int[]netChanges){
		this.reactants = reactants;
		this.netChanges = netChanges;
		this.k = k;
	}
	
	public double calculatePropensity(int[] populations){
		propensity = k;
		
		for(int i = 0; i < reactants.length; i++){
			if(reactants[i] > 0){ //we have a reactant at i, and the value is the amount
				for(int count = 0; count < reactants[i]; count++){
					propensity *= populations[i] - count;
				}
			}
		}
		
		return propensity;
	}
	
	public int getNumFired(){
		return numFired;
	}
	
	public void incrementFired(){
		numFired++;
	}
	
	public void setCurrentTau(double t){
		currentTau = t;
	}
	public double getCurrentTau(){
		return currentTau;
	}
	public int[] getNetChanges(){
		return netChanges;
	}
}
