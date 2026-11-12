import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// ReadWriteLock: birden cok okuyucu ayni anda okuyabilir, yazici tek basina calisir.
public class AyarTablosu {
	private final Map<String, String> tablo =
			new HashMap<>();
	private final ReadWriteLock kilit =
			new ReentrantReadWriteLock();

	public String oku(String anahtar) {
		kilit.readLock().lock();   // okuma kilidi al
		try {
			return tablo.get(anahtar);   // veriyi oku
		} finally {
			kilit.readLock().unlock();
		}
	}
	public void yaz(String anahtar, String deger) {
		kilit.writeLock().lock();  // yazma kilidi al
		try {
			tablo.put(anahtar, deger);   // veriyi yaz
		} finally {
			kilit.writeLock().unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AyarTablosu a = new AyarTablosu();
		a.yaz("dil", "tr");
		Cikti.yakala();   // iki okuyucunun sirasi degisebilir: satirlar sirali yazdirilir
		Runnable okuyucu = () -> System.out.println(
				Thread.currentThread().getName()
				+ ": " + a.oku("dil"));
		Thread o1 = new Thread(okuyucu, "Okuyucu-1");
		Thread o2 = new Thread(okuyucu, "Okuyucu-2");
		o1.start(); o2.start();
		o1.join(); o2.join();
		Cikti.siraliYazdir();
		// Okuyucu-1: tr
		// Okuyucu-2: tr
		// (sunumdaki calistirmada Okuyucu-2 once yazmis)
	}
}

/* Beklenen cikti:
Okuyucu-1: tr
Okuyucu-2: tr
*/
