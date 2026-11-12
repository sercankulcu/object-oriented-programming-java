import java.lang.management.ManagementFactory;

// Kilitlenmeyi onlemek: iki is parcacigi kilitleri ayni sirada (once a, sonra b) alir;
// dongusel bekleme olusmaz.
public class KilitlenmeyiOnleme {
	static final Object a = new Object(), b = new Object();

	static void uyu(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	static void calis(Object x, Object y, String ad) {
		synchronized (x) {        // 1. kilit
			uyu(100);
			synchronized (y) {    // 2. kilit
				System.out.println(ad + " bitti");
			}
		}
	}

	public static void main(String[] args)
			throws InterruptedException {
		Cikti.yakala();   // hangi is parcacigi once biter degisebilir: satirlar sirali yazdirilir
		Thread t1 = new Thread(() -> calis(a, b, "T1"));
		Thread t2 = new Thread(() -> calis(a, b, "T2"));
		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();
		Thread.sleep(500);
		Cikti.siraliYazdir();
		String d = t1.getState() + " " + t2.getState();
		System.out.println(d);
		long[] k = ManagementFactory.getThreadMXBean()
				.findDeadlockedThreads();
		int n = (k == null) ? 0 : k.length;
		System.out.println("Kilitlenmis: " + n);
		// T1 bitti
		// T2 bitti
		// TERMINATED TERMINATED
		// Kilitlenmis: 0
	}
}

/* Beklenen cikti:
T1 bitti
T2 bitti
TERMINATED TERMINATED
Kilitlenmis: 0
*/
