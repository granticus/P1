package com.cs3114.simulation.p1;

import java.io.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class P1Test {

	P1 project;
	
	@Before
	public void setUp() throws Exception {
		project = new P1();
	}

	@SuppressWarnings("static-access")
	@Test
	public void test() throws IOException {

		createInFile();
		String [] cmdLine = new String[3];
		
		cmdLine[0]="1";
		cmdLine[1]="input.txt";
		cmdLine[2]="output.txt";
		
		project.main(cmdLine);
		
		assertTrue(true);
	}

	private void createInFile() throws IOException {
		File oFile = new File("input.txt");
		oFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				oFile.getAbsoluteFile()));
		
		String in = "3 3 2 10\n"
				+ "1000 1000 0\n"
				+ "1 2\n"
				+ "S1 ->10 2S1\n"
				+ "S1 + S2 ->0.01 2S2\n"
				+ "S2 ->10 S3\n";
		bw.write(in);

		bw.close();
		//return oFile;
	}

}
