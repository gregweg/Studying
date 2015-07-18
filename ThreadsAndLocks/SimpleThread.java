package ThreadsAndLocks;

public class SimpleThread implements Runnable {

	public void run() {
		while (true) beep();
	}
	
	public void beep() {
		System.out.println("Beep!");
	}
	
	public static void main(String[] args) {
		SimpleThread foo = new SimpleThread();
		Thread myThread = new Thread(foo);
		myThread.start();
	}
}
