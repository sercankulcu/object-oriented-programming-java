import java.util.concurrent.atomic.AtomicInteger;

// Atomik siniflar: incrementAndGet kilitsiz ama atomik artis; compareAndSet
// deger beklenen ise degistirir.
public class AtomikSayac {
	public static void main(String[] args)
			throws InterruptedException {
		AtomicInteger sayac = new AtomicInteger(0);
		Runnable r = () -> {
			for (int i = 0; i < 100_000; i++) {
				sayac.incrementAndGet();   // atomik ++sayac
			}
		};
		Thread a = new Thread(r), b = new Thread(r);
		a.start(); b.start();
		a.join(); b.join();
		System.out.println("Sonuc: " + sayac.get());   // Sonuc: 200000
		boolean b1 = sayac.compareAndSet(200000, 0);
		System.out.println(b1 + " " + sayac.get());     // true 0
		boolean b2 = sayac.compareAndSet(5, 10);
		System.out.println(b2 + " " + sayac.get());     // false 0
	}
}
