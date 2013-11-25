package basicFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Write a program that takes a name and two strings from the user at the command line. 
 * If a file with that name exists, the program must show its contents on screen, 
 * but substituting any occurrence of the first string by the second string. If the file does not exist, the program must say so.
 * @author Michael Bragg
 *
 */
public class Tr {
	/**
	 * 
	 * @param args A name of a file & two strings
	 */
	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("Please supply a filename followed by two strings");
			return;
		} 

		String filename = args[0];
		String word = args[1];
		String replacementWord = args[2];

		System.out.println("File: " + filename);
		System.out.println("Word to replace: " + word);
		System.out.println("Replacement word: " + replacementWord);

		File file = new File(filename);

		if (!file.isFile()) {
			System.out.println("File: " + file + " not found");
			return;
		} 

		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileReader.readLine()) != null) {
				line = line.replaceAll(word, replacementWord);
				System.out.println(line);
			}
			System.out.println();
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
