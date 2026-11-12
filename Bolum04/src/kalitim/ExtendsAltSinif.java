package kalitim;

// extends ile alt sinif: Dikdortgen, Sekil'den turer.
// Alt sinif nesnesinin icinde ust sinif parcasi da bulunur.
public class ExtendsAltSinif {

	// Temel sinif (ust sinif)
	public static class Sekil {
		// Temel sinifa ait nitelik ve metotlar
		// ...
	}

	// Yeni sinif (alt sinif), Sekil'den turer
	public static class Dikdortgen extends Sekil {
		// Yeni sinifa ait nitelik ve metotlar
		// ...
	}

	// Alt Sinif Nesnesinin Yapisi: Hayvan() yapicisi Kedi nesnesi icin de calisir
	static class Hayvan {
		Hayvan() {
			System.out.println("Hayvan() icinde: "
				+ getClass().getSimpleName());
		}
	}

	static class Kedi extends Hayvan { }

	public static void main(String[] args) {
		Sekil s = new Dikdortgen();
		System.out.println(s instanceof Dikdortgen);   // true

		new Kedi();     // Hayvan() icinde: Kedi
		new Hayvan();   // Hayvan() icinde: Hayvan
	}
}

/* Beklenen cikti:
true
Hayvan() icinde: Kedi
Hayvan() icinde: Hayvan
*/
