package concurrency;



public class Increaser implements Runnable {

	private Counter c;

	public Increaser(Counter counter) {
		this.c = counter;
	}

	public static void main(String[] args) {
		Counter counter = new Counter();

		for (int i = 0; i < 100; i++) {
			Increaser increaseTask = new Increaser(counter);
			Thread t = new Thread(increaseTask);
			t.start();
		}
	}


//	@Override
	public void run() {
		System.err.println("Starting at " + c.getCount()); 

		for (int i = 0; i < 1000; i++) {
			c.increase();
		}

		System.err.println("Stopping at " + c.getCount());
//		counter();
	}

	public void counter() {
		System.out.println("Starting at " + c.getCount()); 

		for (int i = 0; i < 1000; i++) {
			c.increase();
		}

		System.out.println("Stopping at " + c.getCount());
	}







}