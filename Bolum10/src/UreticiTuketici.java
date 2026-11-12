// Uretici-tuketici: wait/notifyAll ile sinirli kuyruk. Kuyruk doluysa uretici, bossa tuketici
// bekler. Mesgul bekleme (bos dongu) neden kotu oldugu da gosterilir.
public class UreticiTuketici {

	static class BlockingQueue {
		private Object[] veri;
		private int bas = 0;
		private int son = 0;
		private int buyukluk = 0;
		public BlockingQueue(int boyut) {
			veri = new Object[boyut];
		}
		public synchronized int getSize() {
			return buyukluk;
		}
		public synchronized void add(Object oge)
				throws InterruptedException {
			while (buyukluk == veri.length) {
				wait();
			}
			veri[son] = oge;
			son = (son + 1) % veri.length;
			buyukluk++;
			notifyAll();
		}
		public synchronized Object remove()
				throws InterruptedException {
			while (buyukluk == 0) {
				wait();
			}
			Object oge = veri[bas];
			bas = (bas + 1) % veri.length;
			buyukluk--;
			notifyAll();
			return oge;
		}
	}

	// Durum (Kosul) Senkronizasyonu: mesgul bekleme ornegi icin basit kuyruk
	static class MesgulKuyruk {
		private int adet = 0;
		synchronized boolean bosMu() { return adet == 0; }
		synchronized void ekle() { adet++; }
	}

	static void mesgulBekle(MesgulKuyruk kuyruk) {
		while (kuyruk.bosMu()) {
			// bosuna islemci yakar; kilit tutuluyorsa
			// uretici hic ekleyemez
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MesgulKuyruk mk = new MesgulKuyruk();
		mk.ekle();
		mesgulBekle(mk);   // kuyruk bos degil: hemen doner
		System.out.println("mesgul bekleme bitti");   // mesgul bekleme bitti

		Cikti.yakala();   // uretici ile tuketicinin satirlari birbirine karisir: sirali yazdirilir
		BlockingQueue kuyruk = new BlockingQueue(2);
		Thread uretici = new Thread(() -> {
			try {
				for (int i = 1; i <= 4; i++) {
					kuyruk.add(i);
					System.out.println("uretildi: " + i);
				}
			} catch (InterruptedException e) { }
		});
		Thread tuketici = new Thread(() -> {
			try {
				for (int i = 1; i <= 4; i++) {
					Thread.sleep(100);
					Object x = kuyruk.remove();
					System.out.println("tuketildi: " + x);
				}
			} catch (InterruptedException e) { }
		});
		uretici.start();
		tuketici.start();
		uretici.join();
		tuketici.join();
		Cikti.siraliYazdir();
		System.out.println("kalan: " + kuyruk.getSize());
		// tuketildi: 1
		// tuketildi: 2
		// tuketildi: 3
		// tuketildi: 4
		// uretildi: 1
		// uretildi: 2
		// uretildi: 3
		// uretildi: 4
		// kalan: 0
		// Sunumdaki zaman sirasi: uretildi 1, uretildi 2, uretildi 3, tuketildi 1, uretildi 4,
		// tuketildi 2, tuketildi 3, tuketildi 4 (zamanlamaya bagli; burada sirali yazdirildi).
	}
}

/* Beklenen cikti:
mesgul bekleme bitti
tuketildi: 1
tuketildi: 2
tuketildi: 3
tuketildi: 4
uretildi: 1
uretildi: 2
uretildi: 3
uretildi: 4
kalan: 0
*/
