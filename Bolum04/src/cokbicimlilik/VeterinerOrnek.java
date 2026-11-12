package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// Cok bicimli parametre ve donus degeri: muayene() her Hayvan alt sinifini
// kabul eder; sahiplen() gercek tipi gizleyerek Hayvan dondurur.
public class VeterinerOrnek {

	static class Veteriner {
		void muayene(Hayvan h) {     // her alt sinif
			System.out.print("Muayene: ");
			h.sesCikar();
		}
		static Hayvan sahiplen(String tur) { // gizli
			if (tur.equals("kedi")) return new Kedi();
			return new Kopek();
		}
	}

	public static void main(String[] args) {
		Veteriner v = new Veteriner();
		v.muayene(new Kedi());                  // Muayene: Miyav!
		Hayvan h = Veteriner.sahiplen("kopek");
		v.muayene(h);                           // Muayene: Hav hav!
		System.out.println(h.getClass().getSimpleName());   // Kopek
	}
}

/* Beklenen cikti:
Muayene: Miyav!
Muayene: Hav hav!
Kopek
*/
