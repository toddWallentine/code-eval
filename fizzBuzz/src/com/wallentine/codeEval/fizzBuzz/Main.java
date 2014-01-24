package com.wallentine.codeEval.fizzBuzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * The Main program will take the name of a file and run the FizzBuzz solution
 * based upon those inputs. The input file will contain 3 columns:
 * <ol>
 * <li>Number that corresponds to fizz</li>
 * <li>Number that corresponds to buzz</li>
 * <li>Number to count up to</li>
 * </ol>
 * 
 * @author Todd Wallentine todd AT wallentine com
 */
public class Main {

	/**
	 * The only argument will be the name of the data file; if it is not provided an exception will be thrown
	 * (IllegalArgumentException). If the file provided cannot be read, an exception will be thrown (FileNotFoundException).
	 * Otherwise, the file will be read and FizzBuzz will be run on the lines contained in the data file.
	 * 
	 * @param args A single argument is used; the name of the data file.
	 * @throws IllegalArgumentException Thrown when not given a data file name.
	 * @throws java.io.FileNotFoundException Thrown when given a file that cannot be found and read.
	 */
	public static void main(final String[] args) throws Exception {
		if(args.length < 1) throw new IllegalArgumentException("Cannot run the fizz-buzz algorithm without a data file.");
		
		String fileName = args[0];
		File inputFile = new File(fileName);
		if((!inputFile.exists()) || (!inputFile.canRead())) throw new FileNotFoundException("Cannot find or read the given file (" + fileName + ").");
		
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String line;
		while((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, " ");
			String fNumString = st.nextToken();
			String bNumString = st.nextToken();
			String tNumString = st.nextToken();
			
			int fNum = Integer.parseInt(fNumString);
			int bNum = Integer.parseInt(bNumString);
			int tNum = Integer.parseInt(tNumString);
			
			printFizzBuzz(fNum, bNum, tNum);
		}
		
		br.close();
	}
	
	/**
	 * Print the fizz-buzz output to the console using the given fizz number, buzz number, and the
	 * highest number to test (starting from 1).
	 * 
	 * @param fizzNum The fizz number to test with.
	 * @param buzzNum The buzz number to test with.
	 * @param topNum The highest number to test.
	 */
	protected static void printFizzBuzz(final int fizzNum, final int buzzNum, final int topNum) {
		if(topNum > 1) {
			for(int i = 1; i <= topNum; i++) {
				String output = "";
				if(isFizzBuzz(fizzNum, buzzNum, i)) {
					output = "FB";
				} else if(isBuzz(buzzNum, i)) {
					output = "B";
				} else if(isFizz(fizzNum, i)) {
					output = "F";
				} else {
					output = String.valueOf(i);
				}
				System.out.print(output + " ");
			}
		}
		
		System.out.println(); // print a new line as the end of this test case.
	}
	
	/**
	 * Determine if the given number is fizz and buzz.
	 * 
	 * @param fizzNum The fizz number to test with.
	 * @param buzzNum The buzz number to test with.
	 * @param num The number to test.
	 * @return True if the number is fizz and buzz; false otherwise.
	 */
	protected static boolean isFizzBuzz(final int fizzNum, final int buzzNum, final int num) {
		return isFizz(fizzNum, num) && isBuzz(buzzNum, num);
	}

	/**
	 * Determine if the given number is fizz.
	 * 
	 * @param fizzNum The fizz number to test with.
	 * @param num The number to test.
	 * @return True if the number is fizz; false otherwise.
	 */
	protected static boolean isFizz(final int fizzNum, final int num) {
		return num % fizzNum == 0;
	}

	/**
	 * Determine if the given number is buzz.
	 * 
	 * @param buzzNum The buzz number to test with.
	 * @param num The number to test.
	 * @return True if the number is buzz; false otherwise.
	 */
	protected static boolean isBuzz(final int buzzNum, final int num) {
		return num % buzzNum == 0;
	}
}