package kalitim;

// this(...) ve super(...): yapicilar birbirini zincirleme cagirir.
// Ilklendirme sirasi: static bloklar bir kez, sonra her nesnede alanlar ve yapici.
public class ThisVeSuper {

	static class Calisan {
		private String ad;  private double maas;
		Calisan(String ad) {
			this(ad, 20000.0);
			System.out.println("Calisan(String)");
		}
		Calisan(String ad, double maas) {
			this.ad = ad;  this.maas = maas;
			System.out.println("Calisan(String, double)");
		}
		double getMaas() { return maas; }
		String getAd() { return ad; }
	}

	static class Yonetici extends Calisan {
		private double prim;
		Yonetici(String ad) {
			this(ad, 5000.0);
			System.out.println("Yonetici(String)");
		}
		Yonetici(String ad, double prim) {
			super(ad);
			this.prim = prim;
			System.out.println("Yonetici(String, double)");
		}
		double gelir() { return getMaas() + prim; }
	}

	// Ilklendirme Sirasi: Kod Izleme
	static class Ust {
		static { System.out.println("Ust static"); }
		int a = deger("Ust alani");
		Ust() { System.out.print("Ust(), "); }
		static int deger(String s) {
			System.out.print(s + ", ");
			return 1;
		}
	}

	static class Alt extends Ust {
		static { System.out.println("Alt static"); }
		int b = deger("Alt alani");
		Alt() { System.out.println("Alt()"); }
	}

	public static void main(String[] args) {
		Yonetici y = new Yonetici("Ayse");
		System.out.println(y.gelir());
		// Calisan(String, double)
		// Calisan(String)
		// Yonetici(String, double)
		// Yonetici(String)
		// 25000.0

		new Alt();
		new Alt();
		// Ust static
		// Alt static
		// Ust alani, Ust(), Alt alani, Alt()
		// Ust alani, Ust(), Alt alani, Alt()
	}
}

/* Beklenen cikti:
Calisan(String, double)
Calisan(String)
Yonetici(String, double)
Yonetici(String)
25000.0
Ust static
Alt static
Ust alani, Ust(), Alt alani, Alt()
Ust alani, Ust(), Alt alani, Alt()
*/
