import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Alex
 * @author Grant
 *
 */
public class InputParserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		InputParser parse = new InputParser();
	}

	@Test
	public void test1() {
		fail("Not yet implemented");
		
		String line1 = "3 4 1 10";
		String line2 = "1000 200 0";
		String line3 = "2";
		String line4 = "-> 100 S1";
		String line5 = "2S1 ->0.001 S2";
		String line6 = "S2 ->0.5 2S1";
		String line7 = "S2 ->0.04 S3";

	}

}
