package nesnesinif;

// static kurallari: static metot, nesne olmadan ornege ait metodu
// ya da alani kullanamaz; once bir nesne olusturulmalidir.
public class StaticKurallari {

	static class Selam {
		private String ad = "Ali";
		public void selamVer() {
			System.out.println("Merhaba " + ad);
		}
		public static void main(String[] args) {
			// selamVer();
			// derleme hatasi: non-static method selamVer() cannot be
			// referenced from a static context
			new Selam().selamVer();   // Merhaba Ali
		}
	}

	static class Selam2 {
		private String ad = "Ali";
		public static void yaz() {
			// System.out.println(ad);
			// derleme hatasi: non-static variable ad cannot be
			// referenced from a static context
			System.out.println(new Selam2().ad);
		}
	}

	public static void main(String[] args) {
		Selam.main(args);   // Merhaba Ali
		Selam2.yaz();       // Ali
	}
}

/* Beklenen cikti:
Merhaba Ali
Ali
*/
