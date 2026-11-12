// Tek kalitim cozumu: sinif zaten bir atadan turediginde Thread'i genisletemez;
// Runnable uygulanir ve Thread bir alan olarak tutulur.
public class TekMirasOrnegi {

	static class Ata {
		public void selamla() {
			System.out.println("Ata sinifindan merhaba");
		}
	}

	static class Worker extends Ata implements Runnable {
		private Thread thread;   // Thread alan olarak
		public void run() {
			String ad = Thread.currentThread().getName();
			System.out.println("run(): " + ad);
		}
		public void start() {
			thread = new Thread(this);
			thread.start();
		}
	}

	public static void main(String[] args) {
		Worker w = new Worker();
		w.selamla();   // Ata'dan kalitilan metot
		w.start();     // kendi start() metodumuz
		// Ata sinifindan merhaba
		// run(): Thread-0
	}
}

/* Beklenen cikti:
Ata sinifindan merhaba
run(): Thread-0
*/
