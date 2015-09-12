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
		int[] fline = getInts(lines[0]);
		int[] initNPop = getInts(lines[1]);
		int[] initDPop = getInts(lines[2]);
		
		//Deal with 4th line later
		
		
		
		read.close();
		oFile.close();
	}

	private static int[] getInts(String line) {
		int[] num = new int[4];
		String[] strInts = line.split(" ");
		
		for (int k = 0; k < strInts.length; k++) {
			num[k] = Integer.parseInt(strInts[k]);
		}
		return null;
	}
	
	private static void getReactions(String line) {
		String [] equation = line.split("->");
		//products will be equation.length - 1;
		
		
		
	}
}
