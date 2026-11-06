import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// ExecutorService: iki is parcacikli havuz dort gorevi paylasir; Callable deger dondurur,
// Future.get() sonucu bekler. shutdown + awaitTermination havuzu kapatir.
public class HavuzOrnegi {
	static void gorev(int no) {
		String ad = Thread.currentThread().getName();
		System.out.println("Gorev " + no + " -> " + ad);
	}
	public static void main(String[] args) throws Exception {
		Cikti.yakala();   // satirlarin sirasi ve gorevi hangi is parcaciginin aldigi degisebilir
		ExecutorService havuz = Executors.newFixedThreadPool(2);
		for (int i = 1; i <= 4; i++) {
			int no = i;
			havuz.submit(() -> gorev(no));
		}
		// Callable: deger donduren gorev
		Future<Integer> f = havuz.submit(() -> 6 * 7);
		System.out.println("Callable sonucu: " + f.get());
		havuz.shutdown();   // yeni gorev kabul etme
		havuz.awaitTermination(5, TimeUnit.SECONDS);
		// is parcacigi numarasi (1 ya da 2) her calistirmada degisebildigi icin "?" ile gizlenir
		Cikti.siraliYazdir("pool-1-thread-\\d+", "pool-1-thread-?");
		System.out.println("Havuz kapandi");
		// Callable sonucu: 42
		// Gorev 1 -> pool-1-thread-?
		// Gorev 2 -> pool-1-thread-?
		// Gorev 3 -> pool-1-thread-?
		// Gorev 4 -> pool-1-thread-?
		// Havuz kapandi
		// Sunumdaki bir calistirma: Gorev 1 -> pool-1-thread-1, Gorev 2 -> pool-1-thread-2,
		// Gorev 3 -> pool-1-thread-2, Gorev 4 -> pool-1-thread-2.
	}
}
