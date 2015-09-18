import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
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
	
	private InputParser parse;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parse = new InputParser();
	}

	@Test
	public void testGetInts() {
		
		int [] expected1 = {3, 4, 1, 10};
		String line1 = "3 4 1 10";
		//assertTrue(Arrays.equals(expected1, parse.getInts(line1)));
		Assert.assertArrayEquals(expected1, parse.getInts(line1));
		
		int [] expected2 = {1000, 200, 0};
		String line2 = "1000 200 0";
		Assert.assertArrayEquals(expected2, parse.getInts(line2)));
		
		int [] expected3 = {2};
		String line3 = "2";
		Assert.assertArrayEquals(expected3, parse.getInts(line3)));

	}
	
	@Test
	public void testParseReaction() {

		String line4 = "-> 100 S1";
		String line5 = "2S1 ->0.001 S2";
		String line6 = "S2 ->0.5 2S1";
		String line7 = "S2 ->0.04 S3";
	}
	
	@Test
	public void testGetReactants() {

		String line4 = "-> 100 S1";
		String line5 = "2S1 ->0.001 S2";
		String line6 = "S2 ->0.5 2S1";
		String line7 = "S2 ->0.04 S3";
		
	}

}
