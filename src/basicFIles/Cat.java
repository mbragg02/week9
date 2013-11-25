package basicFIles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 * 3a) Write a program that takes a name from the user at the command line. If a file with that name exists, 
 * the program must show its contents on screen. If it does not, the program must say so.
 * @author Michael Bragg
 *
 */
public class Cat {

	public static void main(String[] args) {
		System.out.print("Please enter a file to read: ");
		Scanner userIn = new Scanner(System.in);
		String userFile = userIn.next();

		File file = new File(userFile);
		BufferedReader fileReader = null;
		try {
			 fileReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
			}

		} 
		catch (FileNotFoundException e) {
			System.out.println("File " + file + " does not exist in the current directory");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(fileReader);
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
