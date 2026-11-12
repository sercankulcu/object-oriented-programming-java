import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Is parcacigi havuzu ve Future izleme: iki is parcacigi uc gorevi alir; ucuncu gorev
// bir is parcacigi bosalana kadar kuyrukta bekler. get() sonuc hazir olana kadar bekler.
public class FutureIzleme {
	static int is(int ms, int d) throws Exception {
		Thread.sleep(ms);   // uzun suren is yerine
		return d;
	}
	public static void main(String[] args) throws Exception {
		// main icinde:
		ExecutorService havuz = Executors.newFixedThreadPool(2);
		Future<Integer> f1 = havuz.submit(() -> is(300, 10));
		Future<Integer> f2 = havuz.submit(() -> is(100, 20));
		Future<Integer> f3 = havuz.submit(() -> is(100, 30));
		System.out.println(f1.isDone() + " " + f3.isDone());   // false false
		int toplam = f1.get() + f2.get() + f3.get();
		System.out.println("toplam = " + toplam);              // toplam = 60
		System.out.println(f2.isDone() + " " + f3.isDone());   // true true
		havuz.shutdown();
	}
}

/* Beklenen cikti:
false false
toplam = 60
true true
*/
