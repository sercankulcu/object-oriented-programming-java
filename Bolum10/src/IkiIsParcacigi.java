// Iki is parcacigi ayni gorevi calistirir; satirlarin birbirine karisma sirasi
// her calistirmada degisebilir. main, join ile ikisini de bekler.
public class IkiIsParcacigi {
	static void gorev() {
		String ad = Thread.currentThread().getName();
		for (int i = 1; i <= 2; i++) {
			System.out.println(ad + ": adim " + i);
		}
	}
	public static void main(String[] args)
			throws InterruptedException {
		Cikti.yakala();   // is parcaciklarinin satirlari yakalanip sirali yazdirilir
		Thread a = new Thread(() -> gorev(), "A");
		Thread b = new Thread(() -> gorev(), "B");
		a.start();
		b.start();
		a.join();
		b.join();
		Cikti.siraliYazdir();
		System.out.println("main: bitti");
		// A: adim 1
		// A: adim 2
		// B: adim 1
		// B: adim 2
		// main: bitti
		// Sunumdaki bir calistirma sirasi: A: adim 1, B: adim 1, A: adim 2, B: adim 2.
		// Gercek sira zamanlamaya bagli oldugu icin burada satirlar sirali yazdiriliyor.
	}
}

/* Beklenen cikti:
A: adim 1
A: adim 2
B: adim 1
B: adim 2
main: bitti
*/
