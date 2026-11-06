package nesnesinif;

// Uye ic sinif: dis sinifin bir ornegine baglidir ve onun private
// alanlarina erisir; outer.new MemberInner() ile olusturulur.
public class UyeIcSinif {

	static class Outer {
		private int sayi = 5;          // dis sinifin ozel alani

		class MemberInner {            // uye ic sinif
			void display() {
				System.out.println("Uye Ic Sinif, sayi = " + sayi);
			}
		}

		public static void main(String[] args) {
			// Dis sinif ornegi uzerinden uye ic sinifa erisim
			Outer outer = new Outer();
			Outer.MemberInner memberInner = outer.new MemberInner();
			memberInner.display();   // Uye Ic Sinif, sayi = 5
			// MemberInner m = new MemberInner();
			// derleme hatasi: non-static variable this cannot be
			// referenced from a static context
		}
	}

	public static void main(String[] args) {
		Outer.main(args);
	}
}
