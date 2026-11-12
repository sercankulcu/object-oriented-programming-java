// synchronized blok ve monitor: ayni nesnenin monitorunu ayni anda tek is parcacigi tutar,
// bu yuzden kritik bolgedeki ortak++ kaybolmaz.
public class SenkronizeBlok {
	static final Object o = new Object();
	static int ortak = 0;

	public static void main(String[] args) throws InterruptedException {
		synchronized (o) {
			// o'nun monitoru bu blokta bizde
			System.out.println("monitor bizde mi? " + Thread.holdsLock(o));   // monitor bizde mi? true
		}

		Runnable r = () -> {
			for (int i = 0; i < 50_000; i++) {
				synchronized (o) {   // o'nun monitorunu al
					ortak++;         // kritik bolge
				}                    // monitor birakilir
			}
		};
		// t1 ve t2 ayni kodu calistirir
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(ortak);   // 100000
	}
}

/* Beklenen cikti:
monitor bizde mi? true
100000
*/
