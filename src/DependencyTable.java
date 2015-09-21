
public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray, int totSpecies) {
		// TODO later
		indexReaction = new int[totSpecies][table.length];
		table = reactionArray;
	}

	public Reaction[] updatePropensity(int[] reactants) {

		return table;
	}

	public void setUpTable() {
		for (int spec = 0; spec < indexReaction.length; spec++) {

			for (int i = 0; i < table.length; i++) {
				indexReaction [spec][i] = table[i].getReactants();
			}

		}
	}

}