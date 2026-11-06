package kalitim;

// Yerine koyma ilkesi (Liskov): Kare, Dikdortgen'in sozlesmesini bozar;
// Dikdortgen bekleyen kod Kare ile yanlis sonuc alir.
public class YerineKoyma {

	static class Dikdortgen {
		protected int en, boy;
		void setEn(int en) { this.en = en; }
		void setBoy(int boy) { this.boy = boy; }
		int alan() { return en * boy; }
	}

	static class Kare extends Dikdortgen {
		@Override void setEn(int k) { en = k; boy = k; }
		@Override void setBoy(int k) { en = k; boy = k; }
	}

	static void genislet(Dikdortgen d) {
		d.setEn(5);
		d.setBoy(4);
		System.out.println("Beklenen 20, bulunan "
			+ d.alan());
	}

	public static void main(String[] args) {
		genislet(new Dikdortgen());   // Beklenen 20, bulunan 20
		genislet(new Kare());         // Beklenen 20, bulunan 16

		// Ornek Problemler (2): sira degisince son cagri kazanir
		Dikdortgen d = new Kare();
		d.setBoy(4);
		d.setEn(5);
		System.out.println(d.alan());   // 25
	}
}
