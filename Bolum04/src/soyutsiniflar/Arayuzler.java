package soyutsiniflar;

// Arayuz tanimlama, uygulama ve arayuzden kalitim. Arayuz metotlari
// gizlice public abstract, alanlari public static final'dir.
public class Arayuzler {

	public interface GeometrikSekil {
		// Soyut metot (public abstract)
		void ciz();
		// Sabit (public static final)
		int KENAR_SAYISI = 4;
	}

	// Derleyicinin gordugu esdeger yazim
	static class Acik {
		public interface GeometrikSekil {
			public abstract void ciz();
			public static final int KENAR_SAYISI = 4;
		}
	}

	public static class Kare implements GeometrikSekil {
		// ciz metodunu uygulamak zorunlu
		public void ciz() {
			System.out.println("Kare ciziliyor");
		}
	}

	// Arayuzden Kalitim
	public interface KareSekli extends GeometrikSekil {
		// Ek metotlar veya sabitler eklenebilir
		void ozelFonksiyon();
	}

	static class OzelKare implements KareSekli {
		public void ciz() {
			System.out.println("Ozel kare ciziliyor");
		}
		public void ozelFonksiyon() {
			System.out.println("Kosegen: " + Math.sqrt(2));
		}
	}

	public static void main(String[] args) {
		GeometrikSekil g = new Kare();
		g.ciz();                                        // Kare ciziliyor
		System.out.println(GeometrikSekil.KENAR_SAYISI); // 4
		System.out.println(Acik.GeometrikSekil.KENAR_SAYISI); // 4

		KareSekli k = new OzelKare();
		k.ciz();               // Ozel kare ciziliyor
		k.ozelFonksiyon();     // Kosegen: 1.4142135623730951
		GeometrikSekil g2 = k;   // ust arayuze atanabilir
		g2.ciz();              // Ozel kare ciziliyor
	}
}

/* Beklenen cikti:
Kare ciziliyor
4
4
Ozel kare ciziliyor
Kosegen: 1.4142135623730951
Ozel kare ciziliyor
*/
