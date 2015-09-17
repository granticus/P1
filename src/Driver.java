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
import heap.Heap;

public class Driver {

	public static void main(String[] args) throws IOException {
	/*
		int numSimulations = Integer.parseInt(args[0]);
		File iFile = new File(args[1]);
		PrintWriter oFile = new PrintWriter (args[2]);
		
		InputStream read = new FileInputStream(iFile);
		String [] lines = read.toString().split("\n");
		int[] fline = getInts(lines[0]);
		int[] initNPop = getInts(lines[1]);
		int[] initDPop = getInts(lines[2]);
		
		//Deal with 4th line later (still not finished and unsure of how to be called.
		
		
		
		read.close();
		oFile.close();
	*/
		Heap h = new Heap(10);
		h.insert(5);
		h.insert(2);
		System.out.println("here");
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
		String [] products = equation[equation.length-1].split(" ");
		if (products[0].split("+").length == 1) {
			//product contains 2 separate species.
		}
		int rateConstant = Integer.parseInt(products[0]);
		
		//TODO Not finished.
	}
}