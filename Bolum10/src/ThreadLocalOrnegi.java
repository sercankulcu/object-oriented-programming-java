// ThreadLocal: her is parcacigi degiskenin kendi kopyasini gorur; main hic set etmedigi
// icin null okur.
public class ThreadLocalOrnegi {
	static final ThreadLocal<String> deger =
			new ThreadLocal<>();
	public static void main(String[] args)
			throws InterruptedException {
		Cikti.yakala();   // iki is parcacigindan hangisi once yazar degisebilir
		Thread thread1 = new Thread(() -> {
			// Ilk is parcacigi
			deger.set("Deger 1");
			System.out.println("thread1: " + deger.get());
		});
		Thread thread2 = new Thread(() -> {
			// Ikinci is parcacigi
			deger.set("Deger 2");
			System.out.println("thread2: " + deger.get());
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		Cikti.siraliYazdir();
		System.out.println("main: " + deger.get());
		// thread1: Deger 1
		// thread2: Deger 2
		// main: null
	}
}

/* Beklenen cikti:
thread1: Deger 1
thread2: Deger 2
main: null
*/
