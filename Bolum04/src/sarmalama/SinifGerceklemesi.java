package sarmalama;

// Arayuz ve gercekleme: Araba arayuzu NE yapildigini, SporAraba
// sinifi NASIL yapildigini tanimlar.
public class SinifGerceklemesi {

	public interface Araba {
		// Sinif arayuzu: NE yapilir?
		public void hareketEt();

		public void dur();
	}

	public static class SporAraba implements Araba {
		// Sinif gerceklemesi: NASIL yapilir?
		private String marka;
		private int hiz;

		public SporAraba(String marka) {
			this.marka = marka;
		}

		public void hareketEt() {
			hiz = 100;
			System.out.println(marka + " hareket ediyor: "
					+ hiz + " km/sa");
		}

		public void dur() {
			hiz = 0;
			System.out.println(marka + " durdu.");
		}
	}

	public static void main(String[] args) {
		// main icinde:
		Araba araba = new SporAraba("Ruzgar");
		araba.hareketEt();   // Ruzgar hareket ediyor: 100 km/sa
		araba.dur();         // Ruzgar durdu.
	}
}

/* Beklenen cikti:
Ruzgar hareket ediyor: 100 km/sa
Ruzgar durdu.
*/
