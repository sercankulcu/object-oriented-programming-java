import java.util.concurrent.Exchanger;

// Exchanger: iki is parcacigi bulusma noktasinda verilerini takas eder; once gelen
// digerini bekler.
public class ExchangerOrnegi {
	static void takas(Exchanger<String> ex, String veri, int ms) {
		try {
			System.out.println("gonderiliyor: " + veri);
			Thread.sleep(ms);
			String alinan = ex.exchange(veri);   // karsiyi bekle
			System.out.println(veri + " sahibi aldi: " + alinan);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Cikti.yakala();   // satirlarin sirasi degisebilir: sonda sirali yazdirilir
		Exchanger<String> exchanger = new Exchanger<>();
		// Ilk is parcacigi "Veri 1" gonderir, 2 sn sonra
		new Thread(() -> takas(exchanger, "Veri 1", 2000)).start();
		// Ikinci is parcacigi "Veri 2" gonderir, 1 sn sonra
		new Thread(() -> takas(exchanger, "Veri 2", 1000)).start();
		Cikti.digerleriniBekle();   // eklendi: is parcaciklari bitene kadar bekle
		Cikti.siraliYazdir();
		// Veri 1 sahibi aldi: Veri 2
		// Veri 2 sahibi aldi: Veri 1
		// gonderiliyor: Veri 1
		// gonderiliyor: Veri 2
		// (zaman sirasi: iki "gonderiliyor", 2 sn sonra iki "sahibi aldi")
	}
}

/* Beklenen cikti:
Veri 1 sahibi aldi: Veri 2
Veri 2 sahibi aldi: Veri 1
gonderiliyor: Veri 1
gonderiliyor: Veri 2
*/
