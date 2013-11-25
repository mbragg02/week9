package basicFIles;

import java.io.File;

/**
 * 1) Write a program that shows on screen the names of the files in the current directory. (Hint: look at methods from class File).
 * @author Michael Bragg
 *
 */
public class ListFiles {

	public static void main(String[] args) {
		
		String curr = ".";
		File currDirectory = new File(curr);
		System.out.println("Is it a valid directory: " + currDirectory.isDirectory());
		
		File[] fileList = currDirectory.listFiles();
		
		for (File f : fileList) {
			if(f.isFile()){
                System.out.println(f.getName());
            }
            
			
		}
		
	}

}
