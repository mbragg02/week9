package basicFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

/**
 * 4 cp a) Write a program that takes two names from the user at the command line. If a file with the first name exists, 
 * the program must copy it into a file with the second name. 
 * If the first file does not exist, the program must say so. If the second file does exists, 
 * the program must ask the user whether to overwrite it or not, and act accordingly.
 * @author Michael Bragg
 * @
 *
 */
public class Copy {

	/**
	 * @param args Two file names. 
	 */
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		if (args.length == 0) {
			System.out.print("No files supplied");
			return;
		}
		
		String firstFile = args[0];
		String secondFile = args[1];
		
		File file = new File(firstFile);
		File writeFile = new File(secondFile);
		
		boolean writeFileExists = writeFile.isFile();
		
		BufferedReader fileReader = null;
		PrintWriter out = null;
		
		try {
			fileReader = new BufferedReader(new FileReader(file));
			String line;
			out = new PrintWriter(secondFile);

			if (writeFileExists) {
				System.out.println("Would you like to overwrite the file " + secondFile + " ? Y or N:");
				String userChoice = userInput.next().toLowerCase();
				if (userChoice.charAt(0) == 'n') {
					System.out.print("Copy aborted");
					return;
				}
			}
			
			while ((line = fileReader.readLine()) != null) {
				out.write(line);
				out.write("\n");
			}
			System.out.println(firstFile + " copied to " + secondFile + " successfully");

		} 
		catch (FileNotFoundException e) {
			System.out.println("File " + file + " does not exist in the current directory");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(fileReader);
			out.close();
		}

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
