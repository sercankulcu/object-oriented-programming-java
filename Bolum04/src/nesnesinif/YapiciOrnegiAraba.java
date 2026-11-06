package nesnesinif;

// Yapici ornegi: Araba(model, renk) yapicisi iki nesneye farkli
// ilk degerler verir (new Araba(...): adim adim).
public class YapiciOrnegiAraba {

	static class Araba {
		private String model;
		private String renk;

		public Araba(String model, String renk) {
			this.model = model;
			this.renk = renk;
		}

		public void bilgiYazdir() {
			System.out.println(model + " - " + renk);
		}

		public static void main(String[] args) {
			Araba sporAraba = new Araba("2022", "KIRMIZI");
			Araba klasikAraba = new Araba("2023", "BEYAZ");
			sporAraba.bilgiYazdir();     // 2022 - KIRMIZI
			klasikAraba.bilgiYazdir();   // 2023 - BEYAZ
		}
	}

	public static void main(String[] args) {
		Araba.main(args);
	}
}
