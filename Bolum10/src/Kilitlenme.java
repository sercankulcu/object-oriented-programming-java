import java.lang.management.ManagementFactory;

// Kilitlenme (deadlock): T1 once a'yi, T2 once b'yi alir; sonra her biri digerinin kilidini
// bekler. Is parcaciklari daemon oldugu icin kilitli kalsalar da program biter.
public class Kilitlenme {
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

	// Kilitlenme: Kod Izleme. Is parcaciklari daemon degil: cagrilirsa program ASLA bitmez,
	// bu yuzden main'den cagrilmiyor.
	static void kilitlenmeIzleme() {
		new Thread(() -> calis(a, b, "T1")).start();
		new Thread(() -> calis(b, a, "T2")).start();
	}

	public static void main(String[] args)
			throws InterruptedException {
		Thread t1 = new Thread(() -> calis(a, b, "T1"));
		Thread t2 = new Thread(() -> calis(b, a, "T2"));
		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();
		Thread.sleep(500);
		String d = t1.getState() + " " + t2.getState();
		System.out.println(d);                         // BLOCKED BLOCKED
		long[] k = ManagementFactory.getThreadMXBean()
				.findDeadlockedThreads();
		int n = (k == null) ? 0 : k.length;
		System.out.println("Kilitlenmis: " + n);       // Kilitlenmis: 2
	}
}
