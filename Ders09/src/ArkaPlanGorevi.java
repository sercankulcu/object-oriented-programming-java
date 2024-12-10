/*
 * Birden fazla arka plan gorevini thread kullanarak paralel olarak calistiran ve belirli
 * bir sure sonunda gorevleri sonlandiran genisletilmis Java programi.
 */

public class ArkaPlanGorevi implements Runnable {

	private String gorevAdi; // Gorevin ismi
	private volatile boolean calisiyor = true; // Thread'in calisma durumu

	// Constructor: Gorev ismini belirler
	public ArkaPlanGorevi(String gorevAdi) {
		this.gorevAdi = gorevAdi;
	}

	// Arka plan gorevini calistiracak metod
	public void run() {
		int sayac = 0;
		while (calisiyor && sayac < 10) {
			System.out.println(gorevAdi + " calisiyor: " + sayac); // Gorev mesajini yazdir
			try {
				Thread.sleep(400); // 0.4 saniye uyur
			} catch (InterruptedException e) {
				System.out.println(gorevAdi + " kesildi.");
				return; // Thread sonlandirilir
			}
			sayac++;
		}
		System.out.println(gorevAdi + " tamamlandi.");
	}

	// Thread'i durdurma metodu
	public void durdur() {
		calisiyor = false;
	}

	// Programin ana metodu
	public static void main(String[] args) {
		// Arka plan gorevleri olustur
		ArkaPlanGorevi gorev1 = new ArkaPlanGorevi("Gorev-1");
		ArkaPlanGorevi gorev2 = new ArkaPlanGorevi("Gorev-2");
		ArkaPlanGorevi gorev3 = new ArkaPlanGorevi("Gorev-3");

		// Thread'leri olustur ve adlandir
		Thread thread1 = new Thread(gorev1, "Thread-1");
		Thread thread2 = new Thread(gorev2, "Thread-2");
		Thread thread3 = new Thread(gorev3, "Thread-3");

		// Thread'leri baslat
		thread1.start();
		thread2.start();
		thread3.start();

		// Ana thread'de baska isler yap
		for (int i = 0; i < 5; i++) {
			System.out.println("Ana thread is yapiyor: " + i);
			try {
				Thread.sleep(500); // 0.5 saniye uyur
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Belirli bir sure sonra tum thread'leri durdur
		try {
			Thread.sleep(5000); // 5 saniye bekle
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Tum gorevler durduruluyor...");
		gorev1.durdur();
		gorev2.durdur();
		gorev3.durdur();

		// Tum thread'lerin tamamlanmasini bekle
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Tum isler tamamlandi. Program sonlandi.");
	}
}
