package com.cs3114.simulation.p1;


/**
 * The Class NullReaction. This reaction 
 */
public class NullReaction extends Reaction {
	
	/**
	 * Instantiates a new null reaction.
	 */
	public NullReaction() {
		super (0, null, null, -1);
		nullSetUp();
	}
	
	/**
	 * Null set up.
	 */
	private void nullSetUp() {
		this.setCurrentTau(Double.MIN_VALUE);
	}

}
