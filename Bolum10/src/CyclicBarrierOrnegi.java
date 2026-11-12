import java.util.concurrent.CyclicBarrier;

// CyclicBarrier: uc is parcacigi bariyerde bulusur; sonuncusu gelince eylem calisir
// ve hepsi devam eder.
public class CyclicBarrierOrnegi {
	public static void main(String[] args) throws InterruptedException {
		Cikti.yakala();   // satirlarin sirasi degisebilir: sonda sirali yazdirilir
		int parti = 3;
		Runnable eylem = () -> {
			System.out.println("Parti tamamlandi!");
		};
		CyclicBarrier bariyer =
				new CyclicBarrier(parti, eylem);
		for (int i = 0; i < parti; i++) {
			int no = i + 1;
			new Thread(() -> {
				try {
					System.out.println(no + " bekliyor");
					// is parcaciklarini bekle
					bariyer.await();
					System.out.println(no + " devam ediyor");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
		Cikti.digerleriniBekle();   // eklendi: is parcaciklari bitene kadar bekle
		Cikti.siraliYazdir();
		// 1 bekliyor
		// 1 devam ediyor
		// 2 bekliyor
		// 2 devam ediyor
		// 3 bekliyor
		// 3 devam ediyor
		// Parti tamamlandi!
		// Gercek zaman sirasi: once uc "bekliyor", sonra "Parti tamamlandi!", sonra uc "devam ediyor"
		// (sunumda: 1, 2, 3 bekliyor; Parti tamamlandi!; 3, 1, 2 devam ediyor).
	}
}

/* Beklenen cikti:
1 bekliyor
1 devam ediyor
2 bekliyor
2 devam ediyor
3 bekliyor
3 devam ediyor
Parti tamamlandi!
*/
