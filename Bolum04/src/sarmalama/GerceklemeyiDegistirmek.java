package sarmalama;

// Gerceklemeyi degistirmek: DijitalSaat'in ic temsili (iki alan ->
// tek toplamSaniye) degisir, public metotlar ve sonuc ayni kalir.
public class GerceklemeyiDegistirmek {

	static class Eski {
		static class DijitalSaat {
			private int dakika = 0;
			private int saniye = 0;
			public int getDakika() {
				return dakika;
			}
			public int getSaniye() {
				return saniye;
			}
			public void setDakika(int dakika) {
				if (dakika >= 0 && dakika < 60) {
					this.dakika = dakika;
				}
			}
			public void setSaniye(int saniye) {
				if (saniye >= 0 && saniye < 60) {
					this.saniye = saniye;
				}
			}
		}
	}

	static class Yeni {
		static class DijitalSaat {
			// gece yarisindan beri gecen saniye
			private int toplamSaniye = 0;
			public int getDakika() {
				return toplamSaniye / 60 % 60;
			}
			public int getSaniye() {
				return toplamSaniye % 60;
			}
			public void setDakika(int dakika) {
				if (dakika >= 0 && dakika < 60) {
					int fark = dakika - getDakika();
					toplamSaniye += fark * 60;
				}
			}
			public void setSaniye(int saniye) {
				if (saniye >= 0 && saniye < 60) {
					toplamSaniye += saniye - getSaniye();
				}
			}
		}
	}

	public static void main(String[] args) {
		Eski.DijitalSaat e = new Eski.DijitalSaat();
		e.setDakika(12);
		e.setSaniye(45);
		e.setSaniye(75);
		e.setSaniye(9);
		System.out.println(e.getDakika() + ":"
				+ e.getSaniye());   // 12:9

		// Kod izleme (yeni gercekleme), main:
		Yeni.DijitalSaat s = new Yeni.DijitalSaat();
		s.setDakika(12);
		s.setSaniye(45);
		s.setSaniye(75);
		s.setSaniye(9);
		System.out.println(s.getDakika() + ":"
				+ s.getSaniye());   // 12:9
	}
}
