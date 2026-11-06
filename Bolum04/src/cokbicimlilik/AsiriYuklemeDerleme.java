package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// Asiri yukleme derleme zamaninda secilir: argumanin bildirilen tipine bakilir,
// uyan surumlerden en ozel olani alinir.
public class AsiriYuklemeDerleme {

	static void yazdir(Hayvan h) {
		System.out.println("yazdir(Hayvan)");
	}

	static void yazdir(Kopek k) {
		System.out.println("yazdir(Kopek)");
	}

	// Asiri Yukleme: En Ozel Surum
	static void goster(Object o) { System.out.println("goster(Object)"); }
	static void goster(Hayvan h) { System.out.println("goster(Hayvan)"); }
	static void goster(String s) { System.out.println("goster(String)"); }

	public static void main(String[] args) {
		Kopek kopek = new Kopek();
		Hayvan hayvan = kopek;
		yazdir(kopek);            // yazdir(Kopek)
		yazdir(hayvan);           // yazdir(Hayvan)
		yazdir((Kopek) hayvan);   // yazdir(Kopek)

		goster(new Kedi());       // goster(Hayvan)
		goster("a");              // goster(String)
		Object o = "a";
		goster(o);                // goster(Object)
		goster((Hayvan) null);    // goster(Hayvan)
		// goster(null);
		// derleme hatasi: reference to goster is ambiguous
		//   both method goster(Hayvan) in Ana and
		//   method goster(String) in Ana match
	}
}
