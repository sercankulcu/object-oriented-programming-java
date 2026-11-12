package kalitim;

// Ornek: urun hiyerarsisi. GidaUrunu KDV oranini, IndirimliUrun satis
// fiyatini ve toString'i gecersiz kilar; sepet tek dongude yazdirilir.
public class UrunHiyerarsisi {

	static class Urun {
		private String ad;
		private double fiyat;
		Urun(String ad, double fiyat) {
			this.ad = ad; this.fiyat = fiyat;
		}
		double kdvOrani() { return 0.20; }
		double satisFiyati() { return fiyat * (1 + kdvOrani()); }
		@Override public String toString() {
			double f = Math.round(satisFiyati() * 100) / 100.0;
			return ad + ": " + f + " TL";
		}
	}

	static class GidaUrunu extends Urun {
		GidaUrunu(String ad, double fiyat) { super(ad, fiyat); }
		@Override double kdvOrani() { return 0.01; }
	}

	static class IndirimliUrun extends Urun {
		private double indirim;
		IndirimliUrun(String ad, double fiyat, double indirim) {
			super(ad, fiyat);
			this.indirim = indirim;
		}
		@Override double satisFiyati() {
			return super.satisFiyati() * (1 - indirim);
		}
		@Override public String toString() {
			return super.toString()
				+ " (%" + (int) (indirim * 100) + " indirim)";
		}
	}

	public static void main(String[] args) {
		Urun[] sepet = {new Urun("Kalem", 50),
			new GidaUrunu("Ekmek", 10),
			new IndirimliUrun("Kulaklik", 1000, 0.25)};
		for (Urun u : sepet) System.out.println(u);
		// Kalem: 60.0 TL
		// Ekmek: 10.1 TL
		// Kulaklik: 900.0 TL (%25 indirim)
	}
}

/* Beklenen cikti:
Kalem: 60.0 TL
Ekmek: 10.1 TL
Kulaklik: 900.0 TL (%25 indirim)
*/
