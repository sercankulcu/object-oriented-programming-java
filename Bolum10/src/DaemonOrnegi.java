// Arka plan (daemon) is parcacigi: JVM, yalnizca daemon is parcaciklari kaldiginda kapanir.
// saat her 300 ms'de bir tik yazar; main 1 saniye sonra biter.
public class DaemonOrnegi {
	public static void main(String[] args)
			throws InterruptedException {
		Thread saat = new Thread(() -> {
			int s = 0;
			while (true) {
				System.out.println("tik " + s++);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					return;
				}
			}
		});
		saat.setDaemon(true);   // start()'tan ONCE
		saat.start();
		Thread.sleep(1000);
		System.out.println("main bitti, JVM kapaniyor");
		// tik 0
		// tik 1
		// tik 2
		// tik 3
		// main bitti, JVM kapaniyor

		// Eklendi: saat'i kesip bitmesini bekle (cikti degismez; daemon olmasa da program biterdi)
		saat.interrupt();
		saat.join();
	}
}

/* Beklenen cikti:
tik 0
tik 1
tik 2
tik 3
main bitti, JVM kapaniyor
*/
