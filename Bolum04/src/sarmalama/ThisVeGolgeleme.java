package sarmalama;

// this ve golgeleme: parametre alanla ayni adi tasiyinca this.en
// yazilmazsa atama parametrenin kendisine yapilir.
public class ThisVeGolgeleme {

	static class DijitalSaat {
		private int saniye;
		public int getSaniye() {
			return saniye;
		}
		public void setSaniye(int saniye) {
			if (saniye >= 0 && saniye < 60) {
				this.saniye = saniye;
			}
		}
	}

	static class Kutu {
		private int en;
		public int getEn() {
			return en;
		}
		public void setEn(int en) {
			en = en;
		}
	}

	public static void main(String[] args) {
		DijitalSaat s = new DijitalSaat();
		s.setSaniye(20);
		System.out.println(s.getSaniye());   // 20

		Kutu k = new Kutu();
		k.setEn(5);
		System.out.println(k.getEn());       // 0
	}
}
