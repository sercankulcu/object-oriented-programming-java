import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Alistirmalar: diziyi iki yariya bolup iki is parcacigiyla toplama;
// havuzda 1..5 sayilarinin karelerini hesaplayip Future'lardan toplama.
public class Alistirmalar {

	static long kare(int n) {
		return (long) n * n;
	}

	public static void main(String[] args) throws Exception {
		// Alistirmalar (1): dizi 1, 2, ..., 1000
		int[] dizi = new int[1000];
		for (int i = 0; i < dizi.length; i++) dizi[i] = i + 1;
		long[] parca = new long[2];
		Thread sol = new Thread(() -> {
			for (int i = 0; i < 500; i++) parca[0] += dizi[i];
		});
		Thread sag = new Thread(() -> {
			for (int i = 500; i < 1000; i++) parca[1] += dizi[i];
		});
		sol.start(); sag.start();
		sol.join(); sag.join();
		System.out.println(parca[0] + " + " + parca[1] + " = " + (parca[0] + parca[1]));
		// 125250 + 375250 = 500500

		// Alistirmalar (2)
		ExecutorService havuz = Executors.newFixedThreadPool(3);
		List<Future<Long>> sonuclar = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			int n = i;
			sonuclar.add(havuz.submit(() -> kare(n)));
		}
		long toplam = 0;
		for (Future<Long> f : sonuclar) toplam += f.get();
		havuz.shutdown();
		System.out.println("Karelerin toplami: " + toplam);   // Karelerin toplami: 55
	}
}
