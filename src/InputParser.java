import java.io.*;


public class InputParser {
	
	public InputParser() {};
	
	public int[] getInts(String line) {
		int[] num = new int[4];
		String[] strInts = line.split(" ");
		
		for (int k = 0; k < strInts.length; k++) {
			num[k] = Integer.parseInt(strInts[k]);
		}
		return null;
	}
/*
  		 * ei. :
		  
		  	3 3 2 10
			1000 1000 0
			1 2
			
			S1 ->10 2S1
			S1 + S2 ->0.01 2S2
			S2 ->10 S3
			2S2
			
			S1	S2	S3 	k
			1	0	0	10
			-1	1	0	.01
			0	-1	1	10

		 */
	
	public int [][] reacAndProd(String line, int equationNumber, int[][] rTable) {
		String [] elements = line.split(" ");
		int side = 0;
		int kIndex = rTable.length;
		
		for (int i = 0; i < elements.length; i++) {
			
			int numSpecies = 1;
			int species = 0;
			int sIndex = elements[i].indexOf('S');
			
			if (elements[i].substring(0, 2).equals("->")) {
				side = 1;
				rTable[kIndex][equationNumber] = Integer.valueOf(elements[i].substring(3));
				break;
			}
			else if (elements[i].substring(0, 1).equals("+")) {
				break;
			}
			else if (elements[i].matches("\\d+S\\d+")) {
				numSpecies = Integer.valueOf(elements[i].substring(0, sIndex));
			}
			
			species = Integer.valueOf(elements[i].substring(sIndex+1)); //careful,sometimes the reaction starts at zero.
			
			if (side == 0) {
				rTable[species][equationNumber]-=numSpecies;
			}
			else if (side == 1) {
				rTable[species][equationNumber]+=numSpecies;
			}
		}
			
		return rTable;
	}
	
}
