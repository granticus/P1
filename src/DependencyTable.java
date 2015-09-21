
public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray, int totSpecies) {
		// TODO later
		indexReaction = new int[totSpecies][table.length];
		table = reactionArray;
		setUpTable();
	}

	public Reaction[] updatePropensity(int[] reactants) {

		return table;
	}

	public void setUpTable() {
		for (int spec = 0; spec < indexReaction.length; spec++) {
			int index = 0;
			
			int[] reactants = table[spec].getReactants();
			for (int i = 0; i < reactants.length; i++) {
				if (reactants[i] != 0) {
					indexReaction[spec][index++] = i;
				}
			}

		}
	}

}