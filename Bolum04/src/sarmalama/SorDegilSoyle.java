package sarmalama;

// Sor degil, soyle: kurali her cagiran yerde tekrarlamak yerine
// nesneye ne yapacagini soyle; kural sinifin icinde durur.
public class SorDegilSoyle {

	static class BankaHesabi {
		private double bakiye;
		BankaHesabi(double bakiye) { this.bakiye = bakiye; }
		public double getBakiye() { return bakiye; }
		public void setBakiye(double bakiye) { this.bakiye = bakiye; }
		public void paraCek(double miktar) {   // kural burada
			if (miktar > 0 && bakiye >= miktar) bakiye -= miktar;
		}
	}

	static class Ogrenci {
		private int not;
		public int getNot() { return not; }
		public void setNot(int not) { this.not = not; }
		public void notEkle(int puan) {        // 100 siniri burada
			not = Math.min(100, not + puan);
		}
	}

	public static void main(String[] args) {
		BankaHesabi h = new BankaHesabi(1000.0);
		Ogrenci o = new Ogrenci();
		o.setNot(97);

		// Sor: her para ceken yerde ayni kontrol
		if (h.getBakiye() >= 300) {
			h.setBakiye(h.getBakiye() - 300);
		}
		// ...ve not ekleyen her yerde
		o.setNot(Math.min(100, o.getNot() + 5));
		System.out.println(h.getBakiye() + " " + o.getNot());   // 700.0 100

		// Soyle:
		h.paraCek(300);   // kural BankaHesabi'nda
		o.notEkle(5);     // 100 siniri Ogrenci'de
		System.out.println(h.getBakiye() + " " + o.getNot());   // 400.0 100
	}
}

/* Beklenen cikti:
700.0 100
400.0 100
*/
