package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// Dinamik baglama: hangi metodun calisacagina calisma zamaninda nesnenin
// gercek tipine bakilarak karar verilir; arama alt siniftan yukari dogru yapilir.
public class DinamikBaglama {

	public static void main(String[] args) {
		// Dinamik Baglama
		Hayvan h = new Kopek();
		h.kos();      // Kopek kosuyor   (Kopek sinifinin metodu)
		h.sesCikar(); // Hav hav!        (Kopek sinifinin metodu)
		h.uyu();      // Hayvan uyuyor   (Kopek'te yok -> Hayvan'inki)

		// Metot Arama: Asagidan Yukari
		Hayvan h3 = new Kopek();
		h3.kos();     // Kopek kosuyor
		h3.uyu();     // Hayvan uyuyor
		System.out.println(h3.toString());
		// cokbicimlilik.OrnekHiyerarsi$Kopek@6b884d57   (sunumda Kopek@6b884d57; hash degisebilir)
		// h3.havla(); -> derleme hatasi

		// Cok Bicimli Dizi: Izleme
		Hayvan[] hayvanlar = new Hayvan[3];
		hayvanlar[0] = new Kopek();
		hayvanlar[1] = new Kedi();
		hayvanlar[2] = new Hayvan();
		for (int i = 0; i < hayvanlar.length; i++) {
			hayvanlar[i].sesCikar();
		}
		// Hav hav!
		// Miyav!
		// Hayvan sesi

		// Perde Arkasi: Metot Tablosu (javap -c ciktisi, derleyici Hayvan tipini yazar)
		// 47: invokevirtual #15  // Method Hayvan.kos:()V
		// 52: invokevirtual #18  // Method Hayvan.sesCikar:()V

		// Metot Tablosu ile Cagri: Kod Izleme
		Hayvan[] d = {new Kopek(), new Kedi()};
		for (Hayvan x : d) {
			x.kos();
			x.sesCikar();
		}
		// Kopek kosuyor
		// Hav hav!
		// Hayvan kosuyor
		// Miyav!
	}
}
