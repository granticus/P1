import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Alex Hsu
 * @author Grant Golden
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
		parse.getFirstIndex("->100 S1");
	}

	@Test
	public void testGetInts() {
		
		int [] expected1 = {3, 4, 1, 10};
		String line1 = "3 4 1 10";
		//assertTrue(Arrays.equals(expected1, parse.getInts(line1)));
		Assert.assertArrayEquals(expected1, parse.getInts(line1));
		
		int [] expected2 = {1000, 200, 0};
		String line2 = "1000 200 0";
		Assert.assertArrayEquals(expected2, parse.getInts(line2));
		
		int [] expected3 = {2};
		String line3 = "2";
		Assert.assertArrayEquals(expected3, parse.getInts(line3));

	}
	
	@Test
	public void testGetEquation() {

		//Total Species is 3
		int totalSpecies = 3;
		
		int [] expected4 = {1, 0, 0};
		String line4 = "->100 S1";
		Assert.assertArrayEquals(expected4, parse.getEquation(line4, totalSpecies));
		
		int [] expected5 = {-2, 1, 0};
		String line5 = "2S1 ->0.001 S2";
		Assert.assertArrayEquals(expected5, parse.getEquation(line5, totalSpecies));
		
		int [] expected6 = {2, -1, 0};
		String line6 = "S2 ->0.5 2S1";
		Assert.assertArrayEquals(expected6, parse.getEquation(line6, totalSpecies));
		
		int [] expected7 = {0, -1, 1};
		String line7 = "S2 ->0.04 S3";
		Assert.assertArrayEquals(expected7, parse.getEquation(line7, totalSpecies));
	}
	
	@Test
	public void testGetReactants() {

		int totalSpecies = 3;


		int [] expected4 = {0, 0, 0};
		String line4 = "->100 S1";
		Assert.assertArrayEquals(expected4, parse.getReactants(line4, totalSpecies));
		
		int [] expected5 = {2, 0, 0};
		String line5 = "2S1 ->0.001 S2";
		Assert.assertArrayEquals(expected5, parse.getReactants(line5, totalSpecies));
		
		int [] expected6 = {0, 1, 0};
		String line6 = "S2 ->0.5 2S1";
		Assert.assertArrayEquals(expected6, parse.getReactants(line6, totalSpecies));
		
		int [] expected7 = {0, 1, 0};
		String line7 = "S2 ->0.04 S3";
		Assert.assertArrayEquals(expected7, parse.getReactants(line7, totalSpecies));

		int [] expected8 = {0, 1, 0};
		String line8 = "S2 ->10 S3";
		Assert.assertArrayEquals(expected8, parse.getReactants(line8, totalSpecies));
		
		int [] expected9 = {1, 1, 0};
		String line9 = "S1 + S2 ->0.01 2S2";
		Assert.assertArrayEquals(expected9, parse.getReactants(line9, totalSpecies));
		
	}
	
	@Test
	public void testGetConstant() {

		String line4 = "->100 S1";
		assertTrue(100.0 == parse.getKConstant(line4));

		String line5 = "2S1 ->0.001 S2";
		assertTrue(0.001 == parse.getKConstant(line5));
		
		String line6 = "S2 ->0.5 2S1";
		assertTrue(0.5 == parse.getKConstant(line6));
		
		String line7 = "S2 ->0.04 S3";
		assertTrue(0.04 == parse.getKConstant(line7));
	}

}
