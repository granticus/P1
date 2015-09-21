public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray, int totSpecies) {
		// TODO later
		indexReaction = new int[totSpecies][table.length];
		table = reactionArray;
		setUpTable();
	}

	public Reaction[] updatePropensity(int reactant) {
		
		int [] changePropensity= indexReaction[reactant];
		
		for (int i= 0; i < changePropensity.length;i++) {
			//Update propensity for these reactions.
		}
		
		return table;
	}

	public void setUpTable() {
		for (int i = 0; i < table.length; i++) {
			int index = 0;

			int[] reactants = table[i].getReactants();
			for (int spec = 0; spec < indexReaction.length; spec++) {
				if (reactants[i] != 0) {
					indexReaction[spec][index++] = i;
				}
			}
		}
	}

}