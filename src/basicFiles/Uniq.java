package basicFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Write a program that takes a name from the user at the command line. 
 * If a file with that name exists, the program must show its contents on screen, but removing duplicates lines 
 * (showing on screen only one line for each set of duplicated lines). If the does not exist, the program must say so.
 * @author Michael Bragg
 *
 */
public class Uniq {

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

		Set<String> list = new TreeSet<String>();

		File file = new File(args[0]);
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileReader.readLine()) != null) {
//				if (!list.contains(line)) {
					list.add(line);
//				} 
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

	
	
	private static void printList(Set<String> list) {
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
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

