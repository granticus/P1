package com.cs3114.simulation.p1;

public class NullReaction extends Reaction {
	
	public NullReaction() {
		super (0, null, null);
		nullSetUp();
	}
	
	private void nullSetUp() {
		this.setCurrentTau(Double.MIN_VALUE);
	}

}
