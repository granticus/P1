import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DependencyTableTest {

	private DependencyTable tTable;
	@Before
	public void setUp() throws Exception {
		Reaction [] reactions = new Reaction[3];
		Reaction reac1 = new Reaction(10, new int[]{1, 0, 0}, new int[]{1, 0, 0});
		Reaction reac2 = new Reaction(.01, new int[]{1, 1, 0}, new int[]{-1, 1, 0});
		Reaction reac3 = new Reaction(10, new int[]{0, 1, 0}, new int[]{0, -1, 1}); // FOR NOW, manually set
		reactions[0] = reac1;
		reactions[1] = reac2;
		reactions[2] = reac3;
		tTable = new DependencyTable(reactions, 3);
	}

	@Test
	public void test() {
		
		System.out.println(tTable.getIR());
		assertTrue(true);
	}

}
