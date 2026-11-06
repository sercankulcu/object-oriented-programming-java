package nesnesinif;

// Sinif tanimlama ve kullanimi: Araba sinifinin alanlari ve metotlari,
// iki ayri nesne olusturup metotlarini cagirmak.
public class AracTesti {

	static class Araba {
		// Alanlar (fields)
		String marka;
		String model;
		int yil;
		String renk;

		// Metotlar (methods)
		void ilerle() {
			System.out.println(marka + " ilerliyor.");
		}

		void dur() {
			System.out.println(marka + " durdu.");
		}

		void sinyalVer() {
			System.out.println(marka + " sinyal veriyor.");
		}
	}

	public static void main(String[] args) {
		Araba araba1 = new Araba();
		araba1.marka = "Toyota";
		araba1.model = "Corolla";
		araba1.yil = 2022;
		araba1.renk = "Gri";

		Araba araba2 = new Araba();
		araba2.marka = "Ford";
		araba2.model = "Mustang";
		araba2.yil = 2023;
		araba2.renk = "Mavi";

		araba1.ilerle();       // Toyota ilerliyor.
		araba2.sinyalVer();    // Ford sinyal veriyor.
		araba1.dur();          // Toyota durdu.
	}
}
