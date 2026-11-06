package sarmalama;

// Yapici da dogrulamali: gecersiz baslangic degeriyle nesne hic
// olusmaz; yapici IllegalArgumentException firlatir.
public class YapiciDogrulama {

	static class BankaHesabi {
		private int hesapNumarasi;
		private double bakiye;
		private String hesapTuru;

		public BankaHesabi(int hesapNumarasi,
				double bakiye, String hesapTuru) {
			if (bakiye < 0)
				throw new IllegalArgumentException(
						"Baslangic bakiyesi negatif olamaz");
			if (!hesapTuru.equals("Vadeli")
					&& !hesapTuru.equals("Vadesiz"))
				throw new IllegalArgumentException(
						"Bilinmeyen hesap turu: " + hesapTuru);
			this.hesapNumarasi = hesapNumarasi;
			this.bakiye = bakiye;
			this.hesapTuru = hesapTuru;
		}

		@Override public String toString() {
			return hesapNumarasi + " " + bakiye + " " + hesapTuru;
		}
	}

	static class Sicaklik {
		private final double kelvin;
		public Sicaklik(double kelvin) {
			if (kelvin < 0)
				throw new IllegalArgumentException(
						"Kelvin negatif olamaz");
			this.kelvin = kelvin;
		}
		public double getKelvin() { return kelvin; }
	}

	public static void main(String[] args) {
		System.out.println(new BankaHesabi(1, 100.0, "Vadeli"));   // 1 100.0 Vadeli
		try {
			new BankaHesabi(2, -5.0, "Vadeli");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());   // Baslangic bakiyesi negatif olamaz
		}
		try {
			new BankaHesabi(3, 50.0, "Kredi");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());   // Bilinmeyen hesap turu: Kredi
		}

		// Kod izleme, main icinde:
		Sicaklik a = new Sicaklik(300);
		Sicaklik b = null;
		try {
			b = new Sicaklik(-5);
		} catch (IllegalArgumentException e) {
			System.out.println("Reddedildi: "
					+ e.getMessage());               // Reddedildi: Kelvin negatif olamaz
		}
		System.out.println(a.getKelvin() + " " + b);  // 300.0 null
	}
}
