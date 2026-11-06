// Is parcacigi durumlarini gozlemlemek: NEW, TIMED_WAITING (sleep), WAITING (join),
// BLOCKED (kilit bekliyor) ve TERMINATED.
public class DurumGozlem {
	static final Object kilit = new Object();

	static void uyu(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	static void katil(Thread t) {
		try {
			t.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] args) {
		Thread uyuyan = new Thread(() -> uyu(1000));
		System.out.println("1) " + uyuyan.getState());      // 1) NEW
		uyuyan.start();
		uyu(100);
		System.out.println("2) " + uyuyan.getState());      // 2) TIMED_WAITING
		Thread bekleyen = new Thread(() -> katil(uyuyan));
		bekleyen.start();
		uyu(100);
		System.out.println("3) " + bekleyen.getState());    // 3) WAITING
		Thread engellenen = new Thread(() -> {
			synchronized (kilit) { }
		});
		synchronized (kilit) {
			engellenen.start();
			uyu(100);
			System.out.println("4) " + engellenen.getState());  // 4) BLOCKED
		}
		katil(bekleyen);
		System.out.println("5) " + uyuyan.getState());      // 5) TERMINATED
		katil(engellenen);
	}
}
