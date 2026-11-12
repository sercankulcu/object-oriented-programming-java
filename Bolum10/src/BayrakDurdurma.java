// Bayrak ile durdurma: volatile bir bayrak kaldirilinca is parcacigi dongusunden cikar.
public class BayrakDurdurma {

	static class Worker extends Thread {
		private volatile boolean flag = false;
		public void finish() { flag = true; }
		public void run() {
			while (!flag) {
				System.out.println("calisiyor...");
				try { Thread.sleep(100); }
				catch (InterruptedException e) { return; }
			}
			System.out.println("bayrak goruldu, bitiyor");
		}
	}

	public static void main(String[] args)
			throws InterruptedException {
		Worker w = new Worker();
		w.start();
		Thread.sleep(350);
		w.finish();   // bayragi kaldir
		w.join();     // bitmesini bekle
		System.out.println("main: isci durdu");
		// calisiyor...
		// calisiyor...
		// calisiyor...
		// calisiyor...
		// bayrak goruldu, bitiyor
		// main: isci durdu
	}
}

/* Beklenen cikti:
calisiyor...
calisiyor...
calisiyor...
calisiyor...
bayrak goruldu, bitiyor
main: isci durdu
*/
