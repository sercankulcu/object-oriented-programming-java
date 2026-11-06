// Referans ile durdurma: is parcacigi, kendi referansi alanda durdugu surece calisir;
// finish() alani null yapinca dongu biter.
public class ReferansDurdurma {

	static class Worker implements Runnable {
		private volatile Thread thread;
		public void start() {
			thread = new Thread(this);
			thread.start();
		}
		public void finish() { thread = null; }
		public void run() {
			Thread ben = Thread.currentThread();
			while (thread == ben) {   // ... is ...
			}
			System.out.println("run() bitti");
		}
	}

	public static void main(String[] args) throws Exception {
		Worker w = new Worker();
		w.start();
		Thread.sleep(200);
		w.finish();
		Thread.sleep(200);
		System.out.println("main: bitti");
		// run() bitti
		// main: bitti
	}
}
