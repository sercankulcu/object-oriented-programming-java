import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Kilidi finally blogunda ac: istisna olsa da kilit birakilir. finally olmazsa kilit
// tutulu kalir; hic alinmamis kilidi birakmak IllegalMonitorStateException firlatir.
public class KilitFinally {

	public static void calistir() {
		Lock kilit = new ReentrantLock();   // sunumda: Lock kilit = ...;
		kilit.lock();
		try {
			// korunan kaynaga erisim
			System.out.println("kritik bolgede");
		} finally {
			kilit.unlock();
		}
	}

	static void islemYap() {
		throw new IllegalStateException("islem basarisiz");
	}

	public static void main(String[] args) {
		calistir();                                         // kritik bolgede

		// YANLIS: unlock finally icinde degil
		ReentrantLock kilit = new ReentrantLock();
		try {
			kilit.lock();
			islemYap();      // istisna firlatirsa...
			kilit.unlock();  // ...bu satira hic gelinmez
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());             // islem basarisiz
		}
		System.out.println("kilit hala tutulu mu? " + kilit.isLocked());   // kilit hala tutulu mu? true

		// Hic alinmamis kilidi birakmak
		try {
			Lock kilit2 = new ReentrantLock();
			kilit2.unlock();   // hic alinmamis kilit
		} catch (IllegalMonitorStateException e) {
			System.out.println(e.getClass().getName());     // java.lang.IllegalMonitorStateException
		}
	}
}

/* Beklenen cikti:
kritik bolgede
islem basarisiz
kilit hala tutulu mu? true
java.lang.IllegalMonitorStateException
*/
