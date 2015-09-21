
public class DependencyTable {

	private Reaction[] table;
	private int[][] indexReaction;

	public DependencyTable(Reaction[] reactionArray) {
		// TODO later

		table = reactionArray;
	}

	public Reaction[] updatePropensity(int[] reactants) {

		return table;
	}

	public void setUpTable(int totSpecies) {
		for (int spec = 0; spec < totSpecies; spec++) {

			for (int i = 0; i < table.length; i++) {
				int [spec][i];
			}

		}
	}

}