package nesnesinif;

// this(...) ile yapici zinciri: bir yapici ayni sinifin baska
// yapicisini ilk deyim olarak cagirir; ilk degerler tek yerde verilir.
public class YapiciZinciri {

	static class Calisan {
		private String ad;
		private double maas;
		Calisan(String ad) {
			this(ad, 20000.0);   // ayni sinifin yapicisi
		}
		Calisan(String ad, double maas) {
			this.ad = ad;        // ilk degerler tek yerde
			this.maas = maas;
		}
		// Calisan(String ad) {
		//     System.out.println(ad);
		//     this(ad, 20000.0);
		// }
		// derleme hatasi: call to this must be first statement in constructor
		//
		// Calisan(int a) { this(a, 0); }
		// Calisan(int a, int b) { this(a); }
		// derleme hatasi: recursive constructor invocation
	}

	static class Kitap {
		String ad;
		String yazar;
		int sayfaSayisi;
		public Kitap(String ad) {
			this.ad = ad;
		}
		public Kitap(String ad, String yazar) {
			this(ad);  // yapici zincirleme
			this.yazar = yazar;
		}
	}

	public static void main(String[] args) {
		Calisan c1 = new Calisan("Ali");
		Calisan c2 = new Calisan("Ayse", 30000.0);
		System.out.println(c1.ad + " " + c1.maas);   // Ali 20000.0
		System.out.println(c2.ad + " " + c2.maas);   // Ayse 30000.0

		// main icinde:
		Kitap k2 = new Kitap("Nutuk", "Ataturk");
		System.out.println(k2.ad + " / "
				+ k2.yazar + " / " + k2.sayfaSayisi);   // Nutuk / Ataturk / 0
	}
}
