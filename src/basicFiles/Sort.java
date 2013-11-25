package basicFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that takes a name from the user at the command line. If a file with that name exists, 
 * the program must show its contents on screen, but with the lines shown alphabetically. 
 * If the does not exist, the program must say so.
 * Hint: Remember that Strings in Java implement the interface Comparable<String>.
 * @author Michael Bragg
 *
 */
public class Sort {

	/**
	 * @param args String. The file to read
	 */
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No arguments supplied.");
			return;
		} else {
			System.out.println("File: " + args[0]);
		}

		List<String> list = new ArrayList<String>();

		File file = new File(args[0]);
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileReader.readLine()) != null) {
				if (list.size() == 0) {
					list.add(line);

				} else {
					int order = line.compareTo(list.get(0));
					if (order > 0) {
						list.add(line);
					} else {
						list.add(0, line);
					}
				}

			}
			printList(list);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File " + file + " does not exist in the current directory");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(fileReader);
		}

	}

	private static void printList(List<String> list) {
		for (int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
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
