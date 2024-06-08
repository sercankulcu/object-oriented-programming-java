
public class MyThreadExample extends Thread {
	
	String message;
	int delay;
	
	public MyThreadExample(String message, int delay)
	{
		this.message = message;
		this.delay = delay;
	}
	
	public void run()
	{
		while(true)
		{
			System.out.println(message);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		Thread t1 = new MyThreadExample("ali", 1000);
		t1.start();
		Thread t2 = new MyThreadExample("veli", 2000);
		t2.start();
		Thread t3 = new MyThreadExample("ayse", 3000);
		t3.start();
	}
}

