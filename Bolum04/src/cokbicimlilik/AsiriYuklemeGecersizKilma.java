package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// Asiri yukleme ve gecersiz kilma birlikte: once derleyici surumu bildirilen
// tipe gore secer, sonra calisirken nesnenin gercek tipindeki metot calisir.
public class AsiriYuklemeGecersizKilma {

	static void yazdir(Hayvan h) {
		System.out.print("yazdir(Hayvan): ");
		h.sesCikar();
	}

	static void yazdir(Kopek k) {
		System.out.print("yazdir(Kopek): ");
		k.sesCikar();
	}

	public static void main(String[] args) {
		Hayvan hayvan = new Kopek();
		Hayvan diger = new Kedi();
		yazdir(hayvan);            // yazdir(Hayvan): Hav hav!
		yazdir(diger);             // yazdir(Hayvan): Miyav!
		yazdir((Kopek) hayvan);    // yazdir(Kopek): Hav hav!
	}
}
