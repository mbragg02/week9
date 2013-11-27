package concurrency;

import java.util.Scanner;

public class ResponsiveUI implements Runnable {

	private static int taskNumber;
	private static int duration;

	public ResponsiveUI(int taskNumber) {
		ResponsiveUI.taskNumber = taskNumber;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		

		while (taskNumber < 10) {
			
			System.out.print("Enter the duration (in ms) of task " + taskNumber + ": ");
			duration = in.nextInt();

			ResponsiveUI increaseTask = new ResponsiveUI(taskNumber);
			Thread t = new Thread(increaseTask);
			t.start();
			
			taskNumber++;
			
		}
		in.close();
	}
	

	@Override
	public void run() {
		
		try {
			Thread.sleep(duration); 
		} catch (InterruptedException ex) {
			// Nothing to do in this case, just sleep less... 
		}
		System.out.println("Finished tasks: " + (taskNumber - 1));
	}

}
