/**
 * Operating System: Windows 8.1
 * Compiler: Eclipse 
 * 
 * 
 * 
 * @author Grant Golden
 * @author Alex Hsu
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver {

	public static void main(String[] args) throws IOException {
	
		int numSimulations = Integer.parseInt(args[0]);
		File iFile = new File(args[1]);
		PrintWriter oFile = new PrintWriter (args[2]);
		
		InputStream read = new FileInputStream(iFile);
		String [] lines = read.toString().split("\n");
		int[] fline = firstLine(lines[0]);
		int[] initNPop = secondLine(lines[1]);
		int[] initDPop = thirdLines(lines[2]);
		
		//Deal with 4th line later
		
		
		
		read.close();
		oFile.close();
	}

	private static int[] thirdLines(String tLine) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[] secondLine(String sLine) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[] firstLine(String fLine) {
		int[] flNumbers = new int[4];
		String[] fInts = fLine.split(" ");
		
		for (int k = 0; k < fInts.length; k++) {
			
		}
		
		return null;
	}
}
