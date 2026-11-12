// Gorunurluk sorunu: volatile olmayan bayragi baska bir is parcacigi hic gormeyebilir
// (JIT degiskeni donguden disari alabilir). SONUC CALISTIRMAYA VE JVM'E GORE DEGISEBILIR.
// Is parcacigi daemon oldugu icin hic durmasa da program 2,5 saniyede biter.
public class GorunurlukSorunu {
	static boolean dur = false;   // volatile DEGIL!
	public static void main(String[] args)
			throws InterruptedException {
		Thread t = new Thread(() -> {
			long tur = 0;
			while (!dur) {
				tur++;
			}
			System.out.println("is parcacigi durdu");
		});
		t.setDaemon(true);
		t.start();
		Thread.sleep(500);
		dur = true;
		System.out.println("main: dur = true");
		t.join(2000);   // en cok 2 sn bekle
		boolean canli = t.isAlive();
		System.out.println("hala calisiyor mu? " + canli);
		// Cogu calistirmada:            Bazen:
		// main: dur = true              main: dur = true
		// hala calisiyor mu? true       is parcacigi durdu
		//                               hala calisiyor mu? false
	}
}

/* Beklenen cikti:
main: dur = true
hala calisiyor mu? true
*/
