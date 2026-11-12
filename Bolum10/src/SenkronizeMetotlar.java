// Senkronize metotlar: synchronized ornek metodu this'in, static synchronized metot
// C.class'in monitorunu kullanir. Iki yazim birbirine denktir.
// Sunumdaki metot govdeleri ("...") burada bir sayac artirimi ile dolduruldu.
public class SenkronizeMetotlar {

	// 1) synchronized niteleyicisi ile
	static class Niteleyici {
		static class C {
			int n;
			static int m;
			synchronized void p() { n++; }
			static synchronized void q() { m++; }
			//...
		}
	}

	// 2) Ayni anlam, synchronized blok ile
	static class Blok {
		static class C {
			int n;
			static int m;
			void p() { synchronized (this) { n++; } }
			static void q() { synchronized (C.class) { m++; } }
			//...
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Niteleyici.C c1 = new Niteleyici.C();
		Blok.C c2 = new Blok.C();
		Runnable r = () -> {
			for (int i = 0; i < 50_000; i++) {
				c1.p(); Niteleyici.C.q();
				c2.p(); Blok.C.q();
			}
		};
		Thread a = new Thread(r), b = new Thread(r);
		a.start(); b.start();
		a.join(); b.join();
		System.out.println(c1.n + " " + Niteleyici.C.m);   // 100000 100000
		System.out.println(c2.n + " " + Blok.C.m);         // 100000 100000
	}
}

/* Beklenen cikti:
100000 100000
100000 100000
*/
