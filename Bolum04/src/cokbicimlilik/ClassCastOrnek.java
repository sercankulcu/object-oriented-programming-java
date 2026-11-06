package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// ClassCastException: asagi donusum derlenir ama nesne o tipte degilse
// calisirken hata verir. instanceof ile once tip kontrolu yapilir.
public class ClassCastOrnek {

	public static void main(String[] args) {
		// ClassCastException
		try {
			Hayvan h4 = new Kedi();
			Kopek k4 = (Kopek) h4; // derlenir!
			k4.havla();
		} catch (ClassCastException e) {
			System.out.println("java.lang.ClassCastException: " + e.getMessage());
			// class cokbicimlilik.OrnekHiyerarsi$Kedi cannot be cast to class cokbicimlilik.OrnekHiyerarsi$Kopek ...
		}
		try {
			Kopek k5 = (Kopek) new Hayvan(); // derlenir!
			k5.havla();
		} catch (ClassCastException e) {
			System.out.println("java.lang.ClassCastException: " + e.getMessage());
			// class cokbicimlilik.OrnekHiyerarsi$Hayvan cannot be cast to class cokbicimlilik.OrnekHiyerarsi$Kopek ...
		}

		// ClassCastException: Kod Izleme
		// Sunumda yakalanmayan hata programi durdurur, "Bitti" yazilmaz.
		try {
			Hayvan h1 = new Kopek();
			Hayvan h2 = new Kedi();
			Kopek k1 = (Kopek) h1;
			k1.havla();                       // Kopek havliyor
			Kopek k2 = (Kopek) h2;            // ClassCastException
			k2.havla();
			System.out.println("Bitti");
		} catch (ClassCastException e) {
			System.out.println("Exception in thread \"main\"");
			System.out.println("java.lang.ClassCastException");
		}

		// instanceof ile Guvenli Donusum
		Hayvan[] hayvanlar = {new Kopek(), new Kedi(), new Hayvan()};
		for (Hayvan x : hayvanlar) {
			if (x instanceof Kopek) {
				Kopek kk = (Kopek) x;
				kk.havla();
			} else if (x instanceof Kedi) {
				((Kedi) x).tirmala();
			} else {
				System.out.println("Ozel davranis yok");
			}
		}
		// Kopek havliyor
		// Kedi tirmaliyor
		// Ozel davranis yok

		for (Hayvan x : hayvanlar) {
			if (x instanceof Kopek kk) {
				kk.havla(); // donusum otomatik
			}
		}
		// Kopek havliyor

		// instanceof ile Guvenli Donusum: Kod Izleme
		Hayvan[] dizi = {new Kedi(), new Hayvan(), new Kopek()};
		for (Hayvan x : dizi) {
			if (x instanceof Kopek) {
				((Kopek) x).havla();
			} else if (x instanceof Kedi) {
				((Kedi) x).tirmala();
			} else {
				System.out.println("Ozel davranis yok");
			}
		}
		// Kedi tirmaliyor
		// Ozel davranis yok
		// Kopek havliyor
	}
}
