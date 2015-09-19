import static org.junit.Assert.*;

import org.junit.Test;


public class DriverTest {

	@Test
	public void testMain() {
		
		String testFile = "3 4 3 10\n1000 200 0\n"
				+ "1 2 3\n"
				+ "->100 S1\n"
				+ "2S1 ->0.001 S2\n"
				+ "S2 ->0.5 2S1\n"
				+ "S2 ->0.04 S3";
		
		
		
	}

}
