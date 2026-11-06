package kalitim;

// Yapici zinciri: alt sinif yapicisi once ust sinif yapicisini calistirir.
// super() yazilmazsa derleyici gizlice ekler; super(...) ilk deyim olmalidir.
public class YapiciZinciri {

	static class Hayvan {
		private String isim;
		private double saglik;
		Hayvan(String isim) {
			super();   // Object() cagrilir
			this.isim = isim;
			saglik = 100.0;
			System.out.println("Hayvan yapicisi");
		}
		String getIsim() { return isim; }
		double getSaglik() { return saglik; }
	}

	static class Kedi extends Hayvan {
		private boolean evcil;
		Kedi(String isim, boolean evcil) {
			super(isim);
			this.evcil = evcil;
			System.out.println("Kedi yapicisi");
		}
		boolean isEvcil() { return evcil; }
	}

	// Gizli super() ve Hatalar
	static class Gizli {
		static class Hayvan {
			private String isim;
			Hayvan(String isim) { this.isim = isim; }
			String getIsim() { return isim; }
		}
		static class Kedi extends Hayvan {
			// Hatali hali:
			// Kedi(String isim) {
			//     // derleyici buraya super(); ekler
			//     System.out.println("Kedi");
			// }
			// derleme hatasi: constructor Hayvan in class Hayvan
			//   cannot be applied to given types;
			//   required: String
			//   found:    no arguments
			//
			// Kedi(String isim) {
			//     System.out.println("Kedi");
			//     super(isim);
			// }
			// derleme hatasi: call to super must be first
			//   statement in constructor

			// Duzeltilmis hali: super(isim) ilk deyim
			Kedi(String isim) {
				super(isim);
				System.out.println("Kedi");
			}
		}
	}

	public static void main(String[] args) {
		Kedi kedi = new Kedi("Mavi", true);
		System.out.println("Nesne hazir");
		// Hayvan yapicisi
		// Kedi yapicisi
		// Nesne hazir
		System.out.println(kedi.getIsim() + " " + kedi.getSaglik() + " " + kedi.isEvcil());   // Mavi 100.0 true

		Gizli.Kedi k = new Gizli.Kedi("Tekir");   // Kedi
		System.out.println(k.getIsim());          // Tekir
	}
}
