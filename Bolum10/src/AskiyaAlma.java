// Askiya alma: suspend/resume yerine bir bayrak ve wait/notifyAll; gorev her adimdan
// once duraklatilmis mi diye bakar, oyleyse devamEt() cagrilana kadar bekler.
public class AskiyaAlma {

	static class Gorev implements Runnable {
		private boolean duraklatildi = false;
		public synchronized void duraklat() {
			duraklatildi = true;
		}
		public synchronized void devamEt() {
			duraklatildi = false;
			notifyAll();   // bekleyeni uyandir
		}
		public void run() {
			try {
				for (int i = 1; i <= 5; i++) {
					synchronized (this) {
						while (duraklatildi) wait();
					}
					System.out.println("adim " + i);
					Thread.sleep(200);
				}
			} catch (InterruptedException e) { }
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Gorev g = new Gorev();
		Thread t = new Thread(g);
		t.start();
		Thread.sleep(500);
		g.duraklat();
		System.out.println("main: duraklatildi");
		Thread.sleep(1000);
		System.out.println("main: devam");
		g.devamEt();
		t.join();
		// adim 1
		// adim 2
		// adim 3
		// main: duraklatildi
		// main: devam
		// adim 4
		// adim 5
	}
}
