// Thread.stop() artik desteklenmiyor: Java 20'den beri UnsupportedOperationException firlatir.
// Derleyici "kaldirilacak API" uyarisi verir; bu bilincli bir ornek.
public class StopOrnegi {
	public static void main(String[] args) {
		Thread t = new Thread(() -> { });
		try {
			t.stop();
		} catch (UnsupportedOperationException e) {
			System.out.println("stop(): desteklenmiyor");   // stop(): desteklenmiyor
		}
	}
}

/* Beklenen cikti:
stop(): desteklenmiyor
*/
