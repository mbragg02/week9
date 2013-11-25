package basicFIles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 8) Temperature averages
 * Write a program that reads a file from disk in comma-separated format (CSV). Every line must contain a list of number separated by commas.
 * The program must output the average for every line plus the average for the whole file.
 * @author Michael Bragg
 *
 */
public class Temperatures {

	public static void main(String[] args) {

		String tempretures = "tempretures.txt";
		File file = new File(tempretures);
		BufferedReader fileReader = null;
		List<Double> totalAverage = new ArrayList<Double>();
		List<Double> lineAverage = null;

		try {
			fileReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileReader.readLine()) != null) {
				lineAverage = new ArrayList<Double>();
				String[] lineResult = line.split(",");
				for (int i = 0; i < lineResult.length; i ++) {
					double value = Integer.parseInt(lineResult[i].trim());
					lineAverage.add(value);
					totalAverage.add(value);
				}
				System.out.printf("Line average: %.2f\n", average(lineAverage) );
				lineAverage = null;
			}
			
			System.out.printf("Total everage for file %.2f", average(totalAverage));
			

		} 
		catch (FileNotFoundException e) {
			System.out.println("File " + file + " does not exist in the current directory");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(fileReader);
		}
	}
	
	private static double average(List<Double> list) {
		double result = 0.0;
		int number = list.size();
		for (int i = 0; i < number; i ++) {
			result += list.get(i);
		}
		result = 1d * result / number;
		
		return result;
	}
	
	private static void closeReader(Reader reader) { 
		try {
			if (reader != null) { 
				reader.close();
			}
		} catch (IOException ex) {

			ex.printStackTrace();
		}
	}

}
