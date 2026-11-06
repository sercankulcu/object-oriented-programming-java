import java.util.concurrent.CountDownLatch;

// CountDownLatch: main, sayac sifira inene (uc olay gerceklesene) kadar await() ile bekler.
public class CountDownLatchOrnegi {
	public static void main(String[] args)
			throws Exception {
		Cikti.yakala();   // olaylarin sirasi degisebilir: satirlar sirali yazdirilir
		int sayac = 3;
		CountDownLatch mandal = new CountDownLatch(sayac);
		for (int i = 0; i < sayac; i++) {
			int no = i + 1;   // lambda icin kopya
			new Thread(() -> {
				System.out.println(no + ". olay gerceklesti");
				// Olay gerceklestiginde sayac azaltilir.
				mandal.countDown();
			}).start();
		}
		// is parcaciklarinin tamamlanmasi beklenir.
		mandal.await();
		Cikti.siraliYazdir();
		System.out.println("Tum olaylar tamamlandi!");
		// 1. olay gerceklesti
		// 2. olay gerceklesti
		// 3. olay gerceklesti
		// Tum olaylar tamamlandi!
		// (sunumdaki calistirmada sira 1, 3, 2)
	}
}
