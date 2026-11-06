// Thread sinifini genisletme: run() gecersiz kilinir, nesnenin kendisi start() edilir.
public class Worker2 extends Thread {
	// Is parcaciginin gorevleri burada tanimlanir
	public void run() {
		String ad = getName();   // Thread'den kalitildi
		System.out.println("Worker calisiyor: " + ad);
	}
	public static void main(String[] args) {
		// Is parcacigini olusturma ve baslatma
		Worker2 w = new Worker2();
		w.start();
		System.out.println("main devam ediyor");
		// main devam ediyor
		// Worker calisiyor: Thread-0
		// Not: sira pratikte hep budur ama garanti degildir (iki ayri is parcacigi yaziyor).
	}
}
