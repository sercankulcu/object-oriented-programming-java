package sarmalama;

// Degistirilemez sinif: final sinif, final alanlar, setter yok;
// ekle yeni bir Para dondurur, eski nesne degismez.
public class DegistirilemezPara {

	public static final class Para {        // alt sinif yok
		private final long kurus;     // bir kez atanir
		private final String birim;
		public Para(long kurus, String birim) {
			this.kurus = kurus;
			this.birim = birim;
		}
		public Para ekle(Para diger) {   // setter yerine
			if (!birim.equals(diger.birim))
				throw new IllegalArgumentException("Birim farkli");
			return new Para(kurus + diger.kurus, birim);
		}
		@Override public String toString() {
			return kurus / 100 + ","
					+ String.format("%02d", kurus % 100) + " " + birim;
		}
	}

	public static void main(String[] args) {
		// main icinde:
		Para a = new Para(1250, "TL");
		a.ekle(new Para(100, "TL"));  // sonuc atildi
		Para b = a.ekle(new Para(375, "TL"));
		System.out.println(a + " | " + b);   // 12,50 TL | 16,25 TL

		try {
			a.ekle(new Para(100, "EUR"));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());   // Birim farkli
		}
	}
}

/* Beklenen cikti:
12,50 TL | 16,25 TL
Birim farkli
*/
