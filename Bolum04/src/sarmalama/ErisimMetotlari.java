package sarmalama;

// Erisim metotlari: her alan icin get ve dogrulayan set;
// gecersiz degerler reddedilir, saat bozulmaz.
public class ErisimMetotlari {

	static class DijitalSaat {
		private int saat = 0;      // 0..23
		private int dakika = 0;    // 0..59
		private int saniye = 0;    // 0..59

		public int getSaat() { return saat; }
		public int getDakika() { return dakika; }
		public int getSaniye() { return saniye; }

		public void setSaat(int saat) {
			if (saat >= 0 && saat < 24) this.saat = saat;
		}
		public void setDakika(int dakika) {
			if (dakika >= 0 && dakika < 60) this.dakika = dakika;
		}
		public void setSaniye(int saniye) {
			if (saniye >= 0 && saniye < 60) this.saniye = saniye;
		}

		public void goster() {
			System.out.printf("%02d:%02d:%02d%n",
					saat, dakika, saniye);
		}
	}

	public static void main(String[] args) {
		DijitalSaat s = new DijitalSaat();
		s.setSaat(9);
		s.setDakika(5);
		s.setSaniye(30);
		s.goster();          // 09:05:30
		s.setSaat(24);     // reddedilir
		s.setDakika(-3);   // reddedilir
		s.goster();          // 09:05:30
		System.out.println(s.getSaat() + " " + s.getDakika() + " " + s.getSaniye());  // 9 5 30
	}
}
