package sarmalama;

// DijitalSaat sinifi: private alanlar ve dogrulayan setter;
// gecersiz deger (75) reddedilir, alan eski degerinde kalir.
public class SaatTest {

	static class DijitalSaat {
		private int saat = 0;
		private int dakika = 0;
		private int saniye = 0;

		public int getSaniye() {
			return this.saniye;
		}

		public void setSaniye(int saniye) {
			if (saniye >= 0 && saniye < 60) {
				this.saniye = saniye;
			}
		}
	}

	public static void main(String[] args) {
		// SaatTest.main icinde:
		DijitalSaat s = new DijitalSaat();
		s.setSaniye(45);
		s.setSaniye(75);
		System.out.println(s.getSaniye());        // 45
		System.out.println(s.saat + " " + s.dakika);   // 0 0
	}
}

/* Beklenen cikti:
45
0 0
*/
