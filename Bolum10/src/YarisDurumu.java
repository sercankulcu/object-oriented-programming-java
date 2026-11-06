// Yaris durumu: iki is parcacigi ayni sayaci kilitsiz artirir; sayac++ atomik olmadigi icin
// artislar kaybolur. SONUC HER CALISTIRMADA DEGISEBILIR (bu ornekte bilerek).
public class YarisDurumu {
	static int sayac = 0;   // paylasilan veri

	// sayac++ islemcide uc adimdir:
	static void arttirAdimAdim() {
		int yazmac = sayac;     // 1) oku
		yazmac = yazmac + 1;    // 2) 1 ekle
		sayac = yazmac;         // 3) yaz
	}

	public static void main(String[] args)
			throws InterruptedException {
		Runnable arttir = () -> {
			for (int i = 0; i < 100_000; i++) {
				sayac++;   // oku, 1 ekle, yaz: atomik DEGIL
			}
		};
		Thread t1 = new Thread(arttir);
		Thread t2 = new Thread(arttir);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Beklenen: 200000");     // Beklenen: 200000
		System.out.println("Bulunan : " + sayac);   // Bulunan : 138001  (degisir: 135352, 136776, ...)

		// Tek is parcacigiyla uc adim sorunsuz calisir
		sayac = 0;
		for (int i = 0; i < 5; i++)
			arttirAdimAdim();
		System.out.println("Tek is parcacigi: " + sayac);   // Tek is parcacigi: 5
	}
}
