package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// Referans tipi ve nesne tipi: bir nesneyi birden cok tipte referans gosterebilir.
// Yukari donusum otomatiktir; asagi donusum acik yazilir.
public class ReferansTipleri {

	public static void main(String[] args) {
		// Bir Nesne, Uc Referans
		// Kopek nesnesine referans
		Kopek kopek = new Kopek();
		// Hayvan referansi Kopek'i gosterebilir
		Hayvan hayvan = kopek;
		// Object referansi da gosterebilir
		Object nesne = hayvan;
		System.out.println(kopek == hayvan);    // true
		System.out.println(hayvan == nesne);    // true
		System.out.println(nesne.getClass());
		// class cokbicimlilik.OrnekHiyerarsi$Kopek   (sunumda: class Kopek)

		// Referans Tipi ve Nesne Tipi
		Hayvan h = new Kopek();
		// bildirilen tur: Hayvan
		// gercek tur:     Kopek
		h.sesCikar();   // Hav hav!
		// hayvan.havla(); // derleme hatasi
		// derleme hatasi: cannot find symbol
		//   symbol:   method havla()
		//   location: variable hayvan of type Hayvan

		// Referans Kurali
		// Kopek, Hayvan'in alt turudur
		Hayvan hayvan2 = new Kopek();
		Object nesne2 = new Kedi();
		System.out.println(hayvan2 instanceof Kopek && nesne2 instanceof Kedi);   // true
		// Hayvan, Kopek'in ust sinifidir
		// Kopek kopek = new Hayvan();
		// derleme hatasi: incompatible types:
		//   Hayvan cannot be converted to Kopek

		// Yukari ve Asagi Donusum
		Hayvan h0 = kopek;          // yukari: otomatik
		Hayvan h1 = (Hayvan) kopek; // gereksiz
		System.out.println(h0 == h1);   // true
		Kopek k = (Kopek) h;        // asagi: acik
		k.havla();                  // Kopek havliyor

		// Asagi Donusum (Downcasting)
		Hayvan h2 = new Kopek();
		Kopek k2 = (Kopek) h2;
		k2.havla();                 // Kopek havliyor
		((Kopek) h2).havla();       // Kopek havliyor   (tek satirda)
		// (Kopek) h2.havla();   // hatali
		// derleme hatasi: not a statement
		// String s = (Kopek) h2.isim();
		// // h2.isim() once aranir -> Hayvan'da yok
		// derleme hatasi: cannot find symbol
		//   symbol:   method isim()
		//   location: variable h2 of type Hayvan
	}
}

/* Beklenen cikti:
true
true
class cokbicimlilik.OrnekHiyerarsi$Kopek
Hav hav!
true
true
Kopek havliyor
Kopek havliyor
Kopek havliyor
*/
