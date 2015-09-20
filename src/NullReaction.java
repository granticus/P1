
public class NullReaction extends Reaction {
	
	public NullReaction() {
		super (0, null, null);
	}
	
	public NullReaction(double k, int[] reactants, int[] netChanges) {
		super(k, reactants, netChanges);
		this.setCurrentTau(Integer.MIN_VALUE);
	}

}
