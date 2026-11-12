// Kesme (interrupt): sleep() icindeki is parcacigi kesilince InterruptedException alir
// ve dongusunden cikar.
public class KesmeOrnegi {
	public static void main(String[] args)
			throws InterruptedException {
		Thread isci = new Thread(() -> {
			try {
				while (!Thread.interrupted()) {
					// Is parcaciginin calisma mantigi
					System.out.println("calisiyor...");
					Thread.sleep(400);
				}
			} catch (InterruptedException e) {
				System.out.println("Is parcacigi iptal edildi!");
			}
		});
		isci.start();
		Thread.sleep(1000);
		isci.interrupt();   // sleep() icindeyken kes
		isci.join();
		System.out.println("main: bitti");
		// calisiyor...
		// calisiyor...
		// calisiyor...
		// Is parcacigi iptal edildi!
		// main: bitti

		kesmeIzleme();
	}

	// Kesme: Kod Izleme
	static void kesmeIzleme() throws InterruptedException {
		Thread isci = new Thread(() -> {
			try {
				while (!Thread.interrupted()) {
					System.out.println("calisiyor...");
					Thread.sleep(400);
				}
			} catch (InterruptedException e) {
				System.out.println("iptal edildi!");
			}
		});
		isci.start();
		Thread.sleep(1000);
		isci.interrupt();   // isci sleep() icinde
		isci.join();
		System.out.println("main: bitti");
		// calisiyor...
		// calisiyor...
		// calisiyor...
		// iptal edildi!
		// main: bitti
	}
}

/* Beklenen cikti:
calisiyor...
calisiyor...
calisiyor...
Is parcacigi iptal edildi!
main: bitti
calisiyor...
calisiyor...
calisiyor...
iptal edildi!
main: bitti
*/
