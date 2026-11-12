import java.util.concurrent.locks.ReentrantLock;

// ReentrantLock: ic ice iki kilit, her biri kendi finally blogunda birakilir; adil kilit secenegi.
public class ReentrantLockOrnegi {
	public static void main(String[] args) {
		ReentrantLock kilit1 = new ReentrantLock();
		// true: adil (fair) kilit
		ReentrantLock kilit2 = new ReentrantLock(true);
		// ...
		kilit1.lock();
		try {
			// kritik bolgeye erisim
			kilit2.lock();
			try {
				// ic ice kritik bolgeye erisim
				System.out.println("iki kilit de alindi");   // iki kilit de alindi
			} finally {  kilit2.unlock();  }
		} finally {  kilit1.unlock();  }
		System.out.println("adil mi? " + kilit2.isFair());   // adil mi? true
	}
}

/* Beklenen cikti:
iki kilit de alindi
adil mi? true
*/
