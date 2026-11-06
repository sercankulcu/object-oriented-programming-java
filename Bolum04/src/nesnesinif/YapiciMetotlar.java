package nesnesinif;

// Yapici metot: sinifla ayni ad, donus turu yok; alanlara
// ilk degerlerini this ile verir.
public class YapiciMetotlar {

	static class Ogrenci {
		private String ad;
		private int numara;

		// Yapici: sinifla ayni ad, donus turu yok
		public Ogrenci(String ad, int numara) {
			this.ad = ad;
			this.numara = numara;
		}
	}

	public static void main(String[] args) {
		// Kullanimi:
		Ogrenci ogr = new Ogrenci("Ali", 2012);
		// ayni dosyadaki main ic sinifin private alanlarini gorebilir
		System.out.println(ogr.ad + " " + ogr.numara);   // Ali 2012
	}
}
