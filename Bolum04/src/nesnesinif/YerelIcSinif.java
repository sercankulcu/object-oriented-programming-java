package nesnesinif;

// Yerel ic sinif: bir metodun icinde tanimlanir, yalnizca o
// metottan kullanilir.
public class YerelIcSinif {

	static class Outer {
		void outerMethod() {
			class LocalInner {         // metodun icinde tanimlanir
				void display() {
					System.out.println("Yerel Ic Sinif");
				}
			}
			// Yerel ic sinifa yalnizca bu metodun icinden erisilir
			LocalInner localInner = new LocalInner();
			localInner.display();
		}

		public static void main(String[] args) {
			Outer outer = new Outer();
			outer.outerMethod();   // Yerel Ic Sinif
		}
	}

	public static void main(String[] args) {
		Outer.main(args);
	}
}
