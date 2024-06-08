
public class MyRunnableExample implements Runnable {
	
	String message;
	int delay;
	
	public MyRunnableExample(String message, int delay)
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
		Thread t1 = new Thread(new MyRunnableExample("ali", 1000));
		t1.start();
		Thread t2 = new Thread(new MyRunnableExample("veli", 2000));
		t2.start();
		Thread t3 = new Thread(new MyRunnableExample("ayse", 3000));
		t3.start();
	}
}
