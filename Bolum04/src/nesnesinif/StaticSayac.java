package nesnesinif;

// static sayac: toplamHesapSayisi butun nesnelerin paylastigi
// tek alandir; her yapici cagrisi onu bir artirir.
public class StaticSayac {

	static class BankaHesabi {
		private String hesapSahibi;
		private static int toplamHesapSayisi = 0;

		public BankaHesabi(String hesapSahibi) {
			this.hesapSahibi = hesapSahibi;
			toplamHesapSayisi++;
		}

		public static int getToplamHesapSayisi() {
			return toplamHesapSayisi;
		}

		public static void main(String[] args) {
			BankaHesabi h1 = new BankaHesabi("Ali");
			BankaHesabi h2 = new BankaHesabi("Ayse");
			BankaHesabi h3 = new BankaHesabi("Can");
			System.out.println(h2.hesapSahibi);   // Ayse
			int sayi = BankaHesabi.getToplamHesapSayisi();
			System.out.println(sayi);             // 3
			System.out.println(h1.hesapSahibi + " " + h3.hesapSahibi);  // Ali Can
		}
	}

	public static void main(String[] args) {
		BankaHesabi.main(args);
	}
}
