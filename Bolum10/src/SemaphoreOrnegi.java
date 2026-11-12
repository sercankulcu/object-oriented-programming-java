import java.util.concurrent.Semaphore;

// Semaphore: 3 izin; ayni anda en fazla 3 is parcacigi iceride olur, digerleri izin bekler.
public class SemaphoreOrnegi {
	public static void main(String[] args) throws InterruptedException {
		Cikti.yakala();   // satirlarin sirasi degisebilir: sonda sirali yazdirilir
		int izin = 3;
		Semaphore semaphore = new Semaphore(izin);
		for (int i = 0; i < 5; i++) {
			int no = i + 1;
			new Thread(() -> {
				try {
					semaphore.acquire();   // izin al
					System.out.println(no + " girdi");
					Thread.sleep(2000);
					System.out.println(no + " cikiyor");
					semaphore.release();   // izni birak
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
		Cikti.digerleriniBekle();   // eklendi: is parcaciklari bitene kadar bekle
		Cikti.siraliYazdir();
		// 1 cikiyor
		// 1 girdi
		// 2 cikiyor
		// 2 girdi
		// 3 cikiyor
		// 3 girdi
		// 4 cikiyor
		// 4 girdi
		// 5 cikiyor
		// 5 girdi
		// Sunumdaki zaman sirasi: 1, 3, 2 girdi; 2, 1 cikiyor; 4, 5 girdi; 3, 4, 5 cikiyor.
	}
}

/* Beklenen cikti:
1 cikiyor
1 girdi
2 cikiyor
2 girdi
3 cikiyor
3 girdi
4 cikiyor
4 girdi
5 cikiyor
5 girdi
*/
