package basicFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;


/**
 * 4 cp b) Modify the program so that it takes many file names at the command line. When this happens, 
 * the last name must be a directory (otherwise, your program should complain). 
 * If it is a directory, your program has to copy all files (i.e. the other arguments) into that directory.
 * @author Michael Bragg
 * @
 *
 */
public class CopyDirectories {

	/**
	 * @param args Multiple file names. 
	 */
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.print("No files or directories supplied");
			return;
		}

		int noInputs = args.length;
		File dir = new File(args[noInputs - 1]);


		if (!dir.isDirectory()) {
			System.out.println("Last argument is not a directory. Exiting");
			return;
		} else {
			System.out.println("Directory to copy to is: " + "." + File.separator + dir);
		}
		
//		listAll();

		for (int i = 0; i < args.length - 1; i ++) {

			String fileName = args[i];
			File currentFile = new File(fileName);

			BufferedReader fileReader = null;
			PrintWriter out = null;
			
			try {
				fileReader = new BufferedReader(new FileReader(currentFile));
				System.out.println("currentFile: " + currentFile);

				String line;
				out = new PrintWriter("." + File.separator + dir + File.separator + fileName);
				while ((line = fileReader.readLine()) != null) {
					System.out.println(line);
					out.write(line);
					out.write("\n");
				}
				System.out.println("." + File.separator + fileName + " copied to " + "." + File.separator + dir + File.separator + fileName + " successfully");

			} catch (FileNotFoundException e) {
				System.out.println("File " + currentFile + " does not exist in the current directory");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeReader(fileReader);
				out.close();
			}
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
	
//	private static void listAll() {
//		String curr = ".";
//		File currDirectory = new File(curr);
//		String[] fileList = currDirectory.list();
//
//		for (String f : fileList) {
//			System.out.println(f);
//		}
//
//	}

}

