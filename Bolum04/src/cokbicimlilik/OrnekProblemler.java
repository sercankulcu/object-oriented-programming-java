package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// Ornek problemler: ust sinifin kodundan alt sinif metodunun cagrilmasi,
// donusum kurallari, asiri yukleme ile gecersiz kilmanin birlikte calismasi.
public class OrnekProblemler {

	// Ornek Problem 1
	static class A {
		void yaz() {
			System.out.println("A.yaz");
		}

		void cagir() {
			yaz(); // this.yaz()
		}
	}

	static class B extends A {
		@Override
		void yaz() {
			System.out.println("B.yaz");
		}
	}

	// Ornek Problem 3
	static class Ust {
		void f(Object o) {
			System.out.println("Ust.f(Object)");
		}

		void f(String s) {
			System.out.println("Ust.f(String)");
		}
	}

	static class Alt extends Ust {
		@Override
		void f(Object o) {
			System.out.println("Alt.f(Object)");
		}
	}

	// Ornek Problem 4
	static class Ust4 {
		static class Ust {
			Ust() { goster(); }
			void goster() { System.out.println("Ust"); }
		}
		static class Alt extends Ust {
			private int[] dizi = {1, 2, 3};
			@Override void goster() {
				System.out.println(dizi == null
					? "dizi yok" : "uzunluk " + dizi.length);
			}
		}
	}

	public static void main(String[] args) {
		// Problem 1
		A a = new B();
		a.cagir();          // B.yaz
		new A().cagir();    // A.yaz

		// Kalitim ve Cok Bicimlilik
		A objA = new B(); // B, A gibi davranir
		B objB = (B) objA; // gecerli, ancak
						   // dikkatli kullanilmali
		objB.yaz();         // B.yaz

		// Problem 2: derlenir mi, calisir mi?
		Hayvan h = new Kedi();
		// Kedi k1 = h;              // (1) derleme hatasi: incompatible types
		Kedi k2 = (Kedi) h;          // (2) sorunsuz
		System.out.println(k2 == h); // true
		try {
			Kopek k3 = (Kopek) h;     // (3) calisma zamani hatasi
			k3.havla();
		} catch (ClassCastException e) {
			System.out.println("(3) ClassCastException");   // (3) ClassCastException
		}
		// h.tirmala();              // (4) derleme hatasi: cannot find symbol
		((Kedi) h).tirmala();        // (5) Kedi tirmaliyor
		Object o = new Kopek();
		// o.sesCikar();             // (6) derleme hatasi: Object'te sesCikar() yok
		((Hayvan) o).sesCikar();     // (7) Hav hav!

		// Problem 3
		Ust u = new Alt();
		Object o3 = "merhaba";
		u.f(o3);            // Alt.f(Object)
		u.f("merhaba");     // Ust.f(String)

		// Problem 4
		new Ust4.Alt();             // dizi yok
		new Ust4.Alt().goster();    // dizi yok
									// uzunluk 3
	}
}

/* Beklenen cikti:
B.yaz
A.yaz
B.yaz
true
(3) ClassCastException
Kedi tirmaliyor
Hav hav!
Alt.f(Object)
Ust.f(String)
dizi yok
dizi yok
uzunluk 3
*/
