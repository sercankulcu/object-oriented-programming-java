import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Canli kilit ve aclik: adil kilit sirayi korur; tryLock zaman asimi ve rastgele
// bekleme, is parcaciklarinin hep ayni anda geri cekilmesini (canli kilit) onler.
public class CanliKilit {
	static final Lock kilit = new ReentrantLock();
	static final Random rnd = new Random(42);
	static int yapilan = 0;

	// Her is parcacigi kilidi alip 3 is yapar; alamazsa rastgele sure bekleyip tekrar dener
	static void calis() {
		try {
			int benim = 0;
			while (benim < 3) {
				if (kilit.tryLock(50, TimeUnit.MILLISECONDS)) {
					// ... is, sonra kilit.unlock()
					try {
						yapilan++;
						benim++;
					} finally {
						kilit.unlock();
					}
				} else {
					int ms;
					synchronized (rnd) { ms = rnd.nextInt(20); }
					Thread.sleep(ms); // rastgele
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Lock adil = new ReentrantLock(true);  // adil
		System.out.println("adil mi? " + ((ReentrantLock) adil).isFair());   // adil mi? true

		Thread t1 = new Thread(CanliKilit::calis);
		Thread t2 = new Thread(CanliKilit::calis);
		t1.start(); t2.start();
		t1.join(); t2.join();
		System.out.println("yapilan is: " + yapilan);   // yapilan is: 6
	}
}

/* Beklenen cikti:
adil mi? true
yapilan is: 6
*/
