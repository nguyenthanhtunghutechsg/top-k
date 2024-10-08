package IEEE_Full;


import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class MainBaseLineIEEE {

	public static void main(String[] arg) throws IOException {

		String input ="retail.txt";
		String output = "output.txt";
		int k = 10000;
		for (int l = 0; l < 1; l++) {
			System.out.println("k: "+k);
			// the number of updates to be performed
			int numberOfUpdates = 5;

			// scan the database to count the number of lines
			// for our test purpose
			int linecount = countLines(input);
			int firstLine = 0;// ;
			int lastLine = firstLine + (int) (linecount * 0.9f);
			double addedratio = 0.1d / ((double) numberOfUpdates);
			int linesForeEachUpdate = (int) (addedratio * linecount);


			// Apply the algorithm several times
			AlgoTKINC algo = new AlgoTKINC();
			for (int i = 0; i < numberOfUpdates+1; i++) {
				// Applying the algorithm
				// If this is the last update, we make sure to run until the last line
				if (i == numberOfUpdates) {
					System.out.println("" + (i+1) + ") Run the algorithm using line " + firstLine + " to before line "
							+ linecount + " of the input database.");
					algo.runAlgorithm(input, output,true, k, firstLine, linecount);
				} else {
					// If this is not the last update
					System.out.println("" + (i+1) + ") Run the algorithm using line " + firstLine + " to before line "
							+ lastLine + " of the input database.");
					algo.runAlgorithm(input, output, true,k, firstLine, lastLine);
				}
				algo.printStats();

				firstLine = lastLine;
				lastLine = firstLine+linesForeEachUpdate;

			}
			k -= 1000;

		}
	}

	/**
	 * This methods counts the number of lines in a text file.
	 * 
	 * @param filepath the path to the file
	 * @return the number of lines as an int
	 * @throws IOException Exception if error reading/writting file
	 */
	public static int countLines(String filepath) throws IOException {
		LineNumberReader reader = new LineNumberReader(new FileReader(filepath));
		while (reader.readLine() != null) {
		}
		int count = reader.getLineNumber();
		reader.close();
		return count;
	}

}
