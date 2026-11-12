import java.util.concurrent.atomic.AtomicInteger;

// compareAndSet izleme: incrementAndGet'in mantigi; eski degeri oku, yenisini hesapla,
// araya kimse girmediyse yaz, girdiyse tekrar dene.
public class CasIzleme {
	AtomicInteger sayac = new AtomicInteger(5);

	int artir() {                  // incrementAndGet'in mantigi
		while (true) {
			int eski = sayac.get();
			int yeni = eski + 1;
			if (sayac.compareAndSet(eski, yeni))
				return yeni;
			// basarisiz: araya biri girdi, tekrar dene
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CasIzleme c = new CasIzleme();
		System.out.println(c.artir());   // 6
		System.out.println(c.artir());   // 7

		Runnable r = () -> {
			for (int i = 0; i < 100_000; i++) c.artir();
		};
		Thread a = new Thread(r), b = new Thread(r);
		a.start(); b.start();
		a.join(); b.join();
		System.out.println(c.sayac.get());   // 200007
	}
}

/* Beklenen cikti:
6
7
200007
*/
