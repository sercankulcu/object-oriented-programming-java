import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Acik kilitleme: Lock ile kritik bolge; kilit her durumda finally icinde birakilir.
public class Ornek {
	private final Lock kilit = new ReentrantLock();
	private int sayac = 0;
	public void calistir() {
		kilit.lock();
		try {
			// kritik bolge
			sayac++;
		} finally {
			kilit.unlock();
		}
	}
	public static void main(String[] args)
			throws InterruptedException {
		Ornek o = new Ornek();
		Runnable r = () -> {
			for (int i = 0; i < 100_000; i++) o.calistir();
		};
		Thread a = new Thread(r), b = new Thread(r);
		a.start(); b.start();
		a.join(); b.join();
		System.out.println("Sonuc: " + o.sayac);   // Sonuc: 200000
	}
}

/* Beklenen cikti:
Sonuc: 200000
*/
