package nesnesinif;

// Sinif cesitleri: arac (utility) ve final sinif, singleton,
// soyut sinif, muhurlu (sealed) arayuz ve uygulama sinifi.
public class Cesitler {           // uygulama sinifi

	static final class Araclar {             // arac ve final sinif
		private Araclar() { }         // nesne olusturulamaz
		static int kare(int x) { return x * x; }
	}

	static class Ayarlar {                   // singleton
		private static final Ayarlar TEK = new Ayarlar();
		private Ayarlar() { }
		static Ayarlar getir() { return TEK; }
	}

	abstract static class Sekil {            // soyut sinif
		abstract double alan();
	}

	// muhurlu (sealed, Java 17+)
	sealed interface Hareket permits Yuru, Kos { }
	static final class Yuru implements Hareket { }
	static final class Kos implements Hareket { }

	public static void main(String[] args) {
		System.out.println(Araclar.kare(7));                       // 49
		System.out.println(Ayarlar.getir() == Ayarlar.getir());    // true
		Hareket h = new Kos();
		System.out.println(h instanceof Yuru);                     // false
	}
}
