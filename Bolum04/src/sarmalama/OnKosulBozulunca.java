package sarmalama;

// On kosul bozulunca: setSaniye gecersiz degerde
// IllegalArgumentException firlatir, alan eski degerinde kalir.
public class OnKosulBozulunca {

	static class DijitalSaat {
		private int saniye;

		public int getSaniye() {
			return saniye;
		}

		public void setSaniye(int saniye) {
			if (saniye < 0 || saniye > 59)
				throw new IllegalArgumentException(
						"saniye 0-59 olmali: " + saniye);
			this.saniye = saniye;
		}
	}

	public static void main(String[] args) {
		DijitalSaat s = new DijitalSaat();
		try {
			s.setSaniye(30);
			s.setSaniye(75);
			System.out.println("buraya gelinmez");
		} catch (IllegalArgumentException e) {
			System.out.println("Hata: " + e.getMessage());   // Hata: saniye 0-59 olmali: 75
		}
		System.out.println(s.getSaniye());                   // 30
	}
}
