// start() ile run() farki: run() dogrudan cagrilirsa kodu main calistirir,
// start() ise yeni bir is parcacigi olusturur.
public class StartRunFarki {
	public static void main(String[] args)
			throws InterruptedException {
		Thread t = new Thread(() -> {
			String ad = Thread.currentThread().getName();
			System.out.println("run() icinde: " + ad);
		});
		t.run();     // YANLIS: main calistirir
		t.start();   // DOGRU: yeni is parcacigi
		t.join();
		// run() icinde: main
		// run() icinde: Thread-0
	}
}
