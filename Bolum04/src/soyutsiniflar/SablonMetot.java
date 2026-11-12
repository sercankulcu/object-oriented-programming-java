package soyutsiniflar;

// Sablon metot: final hazirla() adimlarin sirasini sabitler,
// degisen adim (demle) alt sinifa birakilir.
public class SablonMetot {

	abstract static class Icecek {
		final void hazirla() {
			suyuKaynat();
			demle();
			System.out.println("Servis edildi");
		}
		void suyuKaynat() {
			System.out.println("Su kaynadi");
		}
		abstract void demle();
	}

	static class Cay extends Icecek {
		void demle() {
			System.out.println("Cay demlendi");
		}
	}

	public static void main(String[] args) {
		Icecek i = new Cay();
		i.hazirla();
		// Su kaynadi
		// Cay demlendi
		// Servis edildi
	}
}

/* Beklenen cikti:
Su kaynadi
Cay demlendi
Servis edildi
*/
