// Is parcacigi olusturmanin uc yolu: Runnable sinifi, Thread alt sinifi, lambda.
public class UcYol {
	static class Gorev implements Runnable {     // 1)
		public void run() {
			System.out.println("1) Runnable sinifi");
		}
	}
	static class IsParcacigi extends Thread {    // 2)
		public void run() {
			System.out.println("2) Thread alt sinifi");
		}
	}
	public static void main(String[] args)
			throws InterruptedException {
		Thread t1 = new Thread(new Gorev());
		Thread t2 = new IsParcacigi();
		// 3) Lambda (Java 8+)
		Thread t3 = new Thread(
				() -> System.out.println("3) Lambda"));
		t1.start(); t1.join();     // 1) Runnable sinifi
		t2.start(); t2.join();     // 2) Thread alt sinifi
		t3.start(); t3.join();     // 3) Lambda
	}
}

/* Beklenen cikti:
1) Runnable sinifi
2) Thread alt sinifi
3) Lambda
*/
