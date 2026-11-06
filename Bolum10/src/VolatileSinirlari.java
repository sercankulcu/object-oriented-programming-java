// volatile'in sinirlari: gorunurlugu saglar ama sayac++ yine atomik degildir;
// SONUC HER CALISTIRMADA DEGISEBILIR. final ile volatile birlikte kullanilamaz.
public class VolatileSinirlari {
	static volatile int sayac = 0;

	// derleme hatasi: illegal combination of modifiers: final and volatile
	// public class FinalVolatile {
	//     private final volatile int x = 5;
	// }
	static class FinalVolatile {
		private final int x = 5;   // final alan zaten guvenle yayinlanir; volatile gerekmez
	}

	public static void main(String[] args) throws InterruptedException {
		// main icinde:
		Runnable r = () -> {
			for (int i = 0; i < 100_000; i++) sayac++;
		};
		Thread a = new Thread(r), b = new Thread(r);
		a.start(); b.start();
		a.join(); b.join();
		System.out.println("volatile sayac: " + sayac);   // volatile sayac: 163299  (degisir: 164441, 199332, ...)
		System.out.println(new FinalVolatile().x);        // 5
	}
}
