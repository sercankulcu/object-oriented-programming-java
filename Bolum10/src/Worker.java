// Is parcacigini baslatma: Runnable uygulayan sinif bir Thread nesnesine verilip start() edilir.
// main, yeni is parcacigini beklemeden devam eder.
public class Worker implements Runnable {
	// Is parcaciginin gorevleri burada tanimlanir
	public void run() {
		String ad = Thread.currentThread().getName();
		System.out.println("Worker calisiyor: " + ad);
	}
	public static void main(String[] args) {
		// Is parcacigini baslatma
		Worker w = new Worker();
		Thread t = new Thread(w);
		t.start();
		System.out.println("main devam ediyor");
		// main devam ediyor
		// Worker calisiyor: Thread-0
		// Not: iki satir farkli is parcaciklarindan gelir; yeni is parcacigi baslayana kadar
		// main yazmis olur, bu yuzden pratikte hep bu siradadir (garanti degildir).
	}
}

/* Beklenen cikti:
main devam ediyor
Worker calisiyor: Thread-0
*/
