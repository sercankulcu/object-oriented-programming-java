package soyutsiniflar;

// Odeme arayuzu: satinAl() yalnizca OdemeYontemi'ni bilir;
// hangi ode() surumunun calisacagini nesne belirler.
public class OdemeArayuzu {

	interface OdemeYontemi { void ode(double tutar); }

	static class KrediKarti implements OdemeYontemi {
		public void ode(double tutar) {
			System.out.println("Kart: " + tutar + " TL");
		}
	}

	static class Havale implements OdemeYontemi {
		public void ode(double tutar) {
			System.out.println("Havale: " + (tutar + 5) + " TL");
		}
	}

	static void satinAl(OdemeYontemi y, double toplam) {
		y.ode(toplam);
	}

	public static void main(String[] args) {
		satinAl(new KrediKarti(), 250.0);   // Kart: 250.0 TL
		satinAl(new Havale(), 120.0);       // Havale: 125.0 TL
	}
}

/* Beklenen cikti:
Kart: 250.0 TL
Havale: 125.0 TL
*/
