package sarmalama;

// BankaHesabi: gizli alanlar, yalnizca okunan getter'lar; para
// yatirma, cekme, faiz ve transfer kurallari sinifin icindedir.
public class BankaHesabiOrnegi {

	static class BankaHesabi {
		private int hesapNumarasi;  // Hesap numarasi
		private double bakiye;      // Hesap bakiyesi
		private String hesapTuru;   // "Vadesiz" / "Vadeli"

		public BankaHesabi(int hesapNumarasi,
				double bakiye, String hesapTuru) {
			this.hesapNumarasi = hesapNumarasi;
			this.bakiye = bakiye;
			this.hesapTuru = hesapTuru;
		}

		public int getHesapNumarasi() {
			return hesapNumarasi;
		}
		public double getBakiye() {
			return bakiye;
		}
		public String getHesapTuru() {
			return hesapTuru;
		}

		// Para yatirma islemi
		public void paraYatir(double miktar) {
			if (miktar > 0) {
				bakiye += miktar;
				System.out.println(miktar
						+ " TL yatirildi. Yeni bakiye: " + bakiye);
			} else {
				System.out.println("Yatirilan miktar gecersiz.");
			}
		}

		// Para cekme islemi
		public void paraCek(double miktar) {
			if (miktar <= bakiye && miktar > 0) {
				bakiye -= miktar;
				System.out.println(miktar
						+ " TL cekildi. Kalan bakiye: " + bakiye);
			} else if (miktar > bakiye) {
				System.out.println("Yetersiz bakiye.");
			} else {
				System.out.println("Cekilen miktar gecersiz.");
			}
		}

		// Faiz ekleme (yalnizca vadeli hesap)
		public void faizEkle(double oran) {
			if (hesapTuru.equals("Vadeli") && oran > 0) {
				double faiz = bakiye * oran / 100;
				bakiye += faiz;
				System.out.println("Faiz ekleniyor: " + faiz
						+ " TL. Yeni bakiye: " + bakiye);
			} else if (!hesapTuru.equals("Vadeli")) {
				System.out.println(
						"Faiz yalnizca vadeli hesaplarda uygulanabilir.");
			} else {
				System.out.println("Gecersiz faiz orani.");
			}
		}

		// Baska bir hesaba transfer
		public void transfer(BankaHesabi hedefHesap,
							 double miktar) {
			if (miktar <= bakiye && miktar > 0) {
				bakiye -= miktar;
				hedefHesap.paraYatir(miktar);
				System.out.println(miktar
						+ " TL transfer edildi. Yeni bakiye: " + bakiye);
			} else {
				System.out.println(
						"Yetersiz bakiye veya gecersiz miktar.");
			}
		}
	}

	public static void main(String[] args) {
		// main icinde:
		BankaHesabi hesap1 =
				new BankaHesabi(123456, 2000.0, "Vadeli");
		BankaHesabi hesap2 =
				new BankaHesabi(789012, 1500.0, "Vadesiz");
		hesap1.paraYatir(500.0);        // 500.0 TL yatirildi. Yeni bakiye: 2500.0
		hesap2.paraCek(200.0);          // 200.0 TL cekildi. Kalan bakiye: 1300.0
		hesap1.faizEkle(5.0);           // Faiz ekleniyor: 125.0 TL. Yeni bakiye: 2625.0
		hesap1.transfer(hesap2, 300.0); // 300.0 TL yatirildi. Yeni bakiye: 1600.0
										// 300.0 TL transfer edildi. Yeni bakiye: 2325.0
		System.out.println(hesap1.getBakiye());   // 2325.0
		System.out.println(hesap2.getBakiye());   // 1600.0
		System.out.println(hesap1.getHesapNumarasi() + " " + hesap1.getHesapTuru());  // 123456 Vadeli
	}
}
