package cokbicimlilik;

// Cok bicimliligin iki turu: asiri yukleme (derleme zamani) ve gecersiz kilma
// (calisma zamani). Hayvan, Kopek, Kedi: destenin ortak sinif hiyerarsisi.
public class OrnekHiyerarsi {

	public static class Hayvan {
		public void sesCikar() { System.out.println("Hayvan sesi"); }
		public void kos()      { System.out.println("Hayvan kosuyor"); }
		public void uyu()      { System.out.println("Hayvan uyuyor"); }
	}

	public static class Kopek extends Hayvan {
		@Override public void sesCikar() { System.out.println("Hav hav!"); }
		@Override public void kos() { System.out.println("Kopek kosuyor"); }
		public void havla() { System.out.println("Kopek havliyor"); }
	}

	public static class Kedi extends Hayvan {
		@Override public void sesCikar() { System.out.println("Miyav!"); }
		public void tirmala() { System.out.println("Kedi tirmaliyor"); }
	}

	static int topla(int a, int b) {
		System.out.println("int surumu");
		return a + b;
	}

	static double topla(double a, double b) {
		System.out.println("double surumu");
		return a + b;
	}

	public static void main(String[] args) {
		topla(5, 3);     // int surumu
		topla(3.5, 2.7); // double surumu

		Hayvan h1 = new Kopek();
		Hayvan h2 = new Kedi();

		h1.sesCikar(); // Hav hav!
		h2.sesCikar(); // Miyav!
	}
}

/* Beklenen cikti:
int surumu
double surumu
Hav hav!
Miyav!
*/
