package nesnesinif;

// Anonim ic sinif: adsiz, tek kullanimlik sinif; bir arayuzu
// yerinde gercekler.
public class AnonimIcSinif {

	interface MyInterface {
		void myMethod();
	}

	static class Outer {
		public static void main(String[] args) {
			// Genellikle arayuzleri veya soyut siniflari uygular
			MyInterface myInterface = new MyInterface() {
				@Override
				public void myMethod() {
					System.out.println("Anonim Ic Sinif");
				}
			};
			myInterface.myMethod();   // Anonim Ic Sinif
		}
	}

	public static void main(String[] args) {
		Outer.main(args);
	}
}

/* Beklenen cikti:
Anonim Ic Sinif
*/
