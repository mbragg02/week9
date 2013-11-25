package basicFIles;

import java.io.File;
import java.util.Scanner;


/**
 * 2) Write a program that takes a name from the user at the command line and creates a directory with that name. 
 * Remember that the only argument of method main is an array of Strings, each of them an argument written 
 * after the name of the class. 
 * @author Michael Bragg
 *
 */
public class MakeDir {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Please enter a name for a new folder: ");
		String userDir = in.next();

		File dir = new File(userDir);
		dir.mkdir();

		listAll();
		in.close();

	}

	private static void listAll() {
		// List all files and directories to make sure previous mkdir was successful 
		String curr = ".";
		File currDirectory = new File(curr);
		String[] fileList = currDirectory.list();

		for (String f : fileList) {
			System.out.println(f);
		}

	}

}
