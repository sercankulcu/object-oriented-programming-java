/*
 * Here is an example of a class that demonstrates the basics of threading 
 * in Java using the Runnable interface:
 * 
 * To use this class, you would create an instance of MyThread and pass it a message, 
 * then start a new thread using that instance:
 * */

public class MyThread implements Runnable {
	private String message;

	public MyThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(message);
		}
	}

	public static void main(String[] args)
	{
		MyThread thread1 = new MyThread("Hello");
		Thread t1 = new Thread(thread1);
		t1.start();

		MyThread thread2 = new MyThread("World");
		Thread t2 = new Thread(thread2);
		t2.start();

	}
}
