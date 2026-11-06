package nesnesinif;

// this ile selam: ayni metot hangi nesne uzerinden cagrilirsa
// this o nesneyi gosterir.
public class ThisSelam {

	static class Ogrenci {
		private String ad;

		public Ogrenci(String ad) {
			this.ad = ad;
		}

		public void selamVer() {
			System.out.println("Merhaba, ben " + this.ad);
		}

		public static void main(String[] args) {
			Ogrenci ogrenci1 = new Ogrenci("Ali");
			Ogrenci ogrenci2 = new Ogrenci("Ayse");
			ogrenci1.selamVer();   // Merhaba, ben Ali
			ogrenci2.selamVer();   // Merhaba, ben Ayse
		}
	}

	public static void main(String[] args) {
		Ogrenci.main(args);
	}
}
