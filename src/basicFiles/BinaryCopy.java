package basicFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 9 Binary Copy: Write a program that takes two names from the user at the command line. 
 * If a file with the first name exists, the program must copy it into a file with the second name. 
 * If the first file does not exist, the program must say so. If the second file does exists, the program must 
 * ask the user whether to overwrite it or not, and act accordingly.
 * This is the same exercise as above with an important difference: 
 * it must be able to copy binary files (use InputStream instead of Reader, etc). 
 * Try it with .class and .exe files and check that the copies work exactly like the originals.
 * @author Michael Bragg
 * @
 *
 */
public class BinaryCopy {

	/**
	 * @param args Two file names. 
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		if (args.length != 2) {
			System.out.print("Please supply two binary files. e.g .class or .exe file names");
			return;
		} else {
			System.out.println(args[0]);
			System.out.println(args[1]);
		}

		String firstFile = args[0];
		String secondFile = args[1];

		File file = new File(firstFile);
		File writeFile = new File(secondFile);

		boolean writeFileExists = writeFile.isFile();

		FileInputStream fileStream = null;
		FileOutputStream outStream = null;

		try {
			fileStream = new FileInputStream(file);
			outStream = new FileOutputStream(writeFile);

			if (writeFileExists) {
				System.out.println("Would you like to overwrite the file " + secondFile + " ? Y or N:");
				String userChoice = userInput.next().toLowerCase();
				if (userChoice.charAt(0) == 'n') {
					System.out.print("Copy Aborted");
					return;
				}
			}


			int val = 0;
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			while (val != -1) {
				val = fileStream.read(buffer, 0, bufferSize);

				if (val == bufferSize) {
					outStream.write(buffer);
				} else {
					outStream.write(buffer, 0, val);
					break;
				}
			}

			System.out.println("." + File.separator + firstFile + " copied to " + "." + File.separator + secondFile + " successfully");

		} 
		catch (FileNotFoundException e) {
			System.out.println("File " + file + " does not exist in the current directory");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(fileStream, outStream);
		}

	}
	
	
	/**
	 * Closes open input and output streams.
	 * @param fileStream
	 * @param outStream
	 */
	private static void closeReader(FileInputStream fileStream, FileOutputStream outStream) { 
		try {
			if (fileStream != null) { 
				fileStream.close();
			}
			if (outStream != null) {
				outStream.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}

