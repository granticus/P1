
public class NullReaction extends Reaction {
	
	public NullReaction() {
		super (0, null, null);
		nullSetUp();
	}
	
	private void nullSetUp() {
		this.setCurrentTau(Integer.MIN_VALUE);
	}

}
