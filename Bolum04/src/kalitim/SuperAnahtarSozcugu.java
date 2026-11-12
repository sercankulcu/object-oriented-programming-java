package kalitim;

// super anahtar sozcugu: super(...) ust sinif yapicisini, super.metot() ust
// sinifin surumunu cagirir. super zinciri: her sinif bir ustunu cagirir.
public class SuperAnahtarSozcugu {

	static class Hayvan {
		private String isim;
		private double saglik;
		Hayvan(String isim) {
			this.isim = isim;
			saglik = 100.0;
		}
		@Override
		public String toString() {
			return "Isim: " + isim + ", Saglik: " + saglik;
		}
	}

	static class Kedi extends Hayvan {
		private boolean evcil;

		Kedi(String isim, boolean evcil) {
			super(isim);         // Hayvan(String)
			this.evcil = evcil;  // kendi verisi
		}

		@Override
		public String toString() {
			return super.toString()   // Hayvan'inki
				   + ", Evcil: " + evcil;
		}
	}

	// super Zinciri: Kod Izleme
	static class Zincir {
		static class Canli {
			void tanit() { System.out.println("Canliyim"); }
		}
		static class Hayvan extends Canli {
			void tanit() {
				super.tanit();
				System.out.println("Hayvanim");
			}
		}
		static class Kedi extends Hayvan {
			void tanit() {
				super.tanit();
				System.out.println("Kediyim");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Kedi("Mavi", true));   // Isim: Mavi, Saglik: 100.0, Evcil: true

		new Zincir.Kedi().tanit();
		// Canliyim
		// Hayvanim
		// Kediyim
	}
}

/* Beklenen cikti:
Isim: Mavi, Saglik: 100.0, Evcil: true
Canliyim
Hayvanim
Kediyim
*/
