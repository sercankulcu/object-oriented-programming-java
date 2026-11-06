package cokbicimlilik;

// Neler dinamik baglanmaz? Alanlar ve static metotlar referansin bildirilen
// tipine gore secilir (gizleme); yalnizca ornek metotlari gecersiz kilinir.
public class DinamikBaglanmayanlar {

	static class Hayvan {
		String tur = "hayvan";

		static void bilgi() {
			System.out.println("Hayvan.bilgi()");
		}

		void tanit() {
			System.out.println("Ben bir " + tur);
		}
	}

	static class Kopek extends Hayvan {
		String tur = "kopek"; // gizler, ezmez

		static void bilgi() {
			System.out.println("Kopek.bilgi()");
		}

		@Override
		void tanit() {
			System.out.println("Ben bir " + tur);
		}
	}

	// Alan Gizleme ve static: Kod Izleme
	static class Izleme {
		static class Hayvan {
			String tur = "hayvan";
			static String bilgi() { return "Hayvan.bilgi"; }
			String tanit() { return "Ben bir " + tur; }
		}
		static class Kopek extends Hayvan {
			String tur = "kopek";            // gizler
			static String bilgi() { return "Kopek.bilgi"; }
			String tanit() { return "Ben bir " + tur; }
		}
	}

	// h.bilgi(): static metodu nesne uzerinden cagirmak sunumun gosterdigi tuzaktir
	@SuppressWarnings("static")
	public static void main(String[] args) {
		Hayvan h = new Kopek();
		System.out.println(h.tur);   // hayvan
		h.bilgi();                   // Hayvan.bilgi()
		h.tanit();                   // Ben bir kopek

		Izleme.Hayvan h2 = new Izleme.Kopek();
		System.out.println(h2.tur);                    // hayvan
		System.out.println(h2.bilgi());                // Hayvan.bilgi
		System.out.println(h2.tanit());                // Ben bir kopek
		System.out.println(((Izleme.Kopek) h2).tur);   // kopek
	}
}
