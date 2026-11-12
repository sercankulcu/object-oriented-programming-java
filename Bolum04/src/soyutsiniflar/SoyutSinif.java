package soyutsiniflar;

// Soyut sinif: somut ve soyut metot birlikte bulunabilir; soyut siniftan
// nesne olusturulamaz, alt sinif soyut metotlari uygulamak zorundadir.
public class SoyutSinif {

	public abstract static class Sekil {
		// Soyut olmayan (somut) metot
		void tasi(int x, int y) {
			System.out.println("(" + x + ", " + y + ") noktasina tasindi");
		}
		// Soyut metot (alt siniflarca uygulanmali)
		abstract void ciz();
	}

	// ciz()'i uygulayan somut alt sinif
	static class Ucgen extends Sekil {
		void ciz() { System.out.println("Ucgen ciziliyor"); }
	}

	// Soyut Metotlar: ciz() public abstract
	static class Ayri {
		public abstract static class Sekil {
			// Soyut metot
			public abstract void ciz();
		}

		// Ayri bir dosyada:
		public static class Cember extends Sekil {
			// ciz metodunu uygulamak zorunlu
			public void ciz() {
				System.out.println("Cember ciziliyor");
			}
		}
	}

	// Soyut Siniftan Nesne Olmaz / new Kare(3) Izleme
	static class IsimliSekil {
		static abstract class Sekil {
			private String isim;
			Sekil(String isim) {
				this.isim = isim;
				System.out.println(isim + " kuruldu");
			}
			abstract double alan();
		}
		static class Kare extends Sekil {
			private double kenar;
			Kare(double kenar) {
				super("Kare");
				this.kenar = kenar;
			}
			double alan() { return kenar * kenar; }
		}
	}

	public static void main(String[] args) {
		Sekil u = new Ucgen();
		u.ciz();          // Ucgen ciziliyor
		u.tasi(3, 4);     // (3, 4) noktasina tasindi

		Ayri.Sekil c = new Ayri.Cember();
		c.ciz();          // Cember ciziliyor

		// IsimliSekil.Sekil s1 = new IsimliSekil.Sekil("?");     // HATA
		// derleme hatasi: Sekil is abstract; cannot be instantiated
		IsimliSekil.Sekil s2 = new IsimliSekil.Kare(3);        // Kare kuruldu   (degiskenin turu soyut olabilir)
		IsimliSekil.Sekil[] dizi = new IsimliSekil.Sekil[3];   // dizi yalnizca referans tutar
		System.out.println(dizi[0] + " " + s2.alan());         // null 9.0

		IsimliSekil.Sekil s = new IsimliSekil.Kare(3);
		System.out.println(s.alan());
		// Kare kuruldu
		// 9.0
	}
}

/* Beklenen cikti:
Ucgen ciziliyor
(3, 4) noktasina tasindi
Cember ciziliyor
Kare kuruldu
null 9.0
Kare kuruldu
9.0
*/
