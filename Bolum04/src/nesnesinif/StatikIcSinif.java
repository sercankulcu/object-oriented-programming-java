package nesnesinif;

// static ic sinif: dis sinifin bir ornegi olmadan olusturulur.
public class StatikIcSinif {

	static class Outer {
		// Dis sinifin icinde statik bir ic sinif
		static class StaticInner {
			void display() {
				System.out.println("Statik Ic Sinif");
			}
		}

		public static void main(String[] args) {
			// Dis sinif ornegi olusturmadan erisim
			Outer.StaticInner staticInner = new Outer.StaticInner();
			staticInner.display();   // Statik Ic Sinif
		}
	}

	public static void main(String[] args) {
		Outer.main(args);
	}
}
