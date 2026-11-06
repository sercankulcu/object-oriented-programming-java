import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// tryLock(): kilit hemen alinamazsa beklemeden false doner; zaman asimli surumu
// en fazla verilen sure kadar bekler.
public class TryLockOrnegi {
	static final Lock kilit = new ReentrantLock();

	static void calistir()
			throws InterruptedException {
		if (kilit.tryLock()) {
			// alindi
			try { System.out.println("1: alindi"); }
			finally { kilit.unlock(); }
		} else {
			// alinamadi, baska bir sey yap
			System.out.println("1: alinamadi");
		}
		if (kilit.tryLock(3, TimeUnit.SECONDS)) {
			try { System.out.println("2: alindi"); }
			finally { kilit.unlock(); }
		} else {
			// 3 saniye icinde alinamadi
			System.out.println("2: alinamadi");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		kilit.lock();   // kilidi main tutuyor
		Thread t = new Thread(() -> {
			try { calistir(); }
			catch (InterruptedException e) { }
		});
		t.start();
		Thread.sleep(1000);
		System.out.println("main: kilidi birakiyor");
		kilit.unlock();
		t.join();
		// 1: alinamadi
		// main: kilidi birakiyor
		// 2: alindi
	}
}
