package nesnesinif;

// Uye ic sinif (kod izleme): ic nesne, olusturuldugu dis nesnenin
// alanini okur (o2.sayi = 8).
public class UyeIcSinifIzleme {

	static class Outer {
		private int sayi = 5;
		class MemberInner {
			void display() {
				System.out.println("sayi = " + sayi);
			}
		}
		public static void main(String[] args) {
			Outer o1 = new Outer();
			Outer o2 = new Outer();
			o2.sayi = 8;
			Outer.MemberInner m = o2.new MemberInner();
			m.display();             // sayi = 8
			System.out.println(o1.sayi);   // 5
		}
	}

	public static void main(String[] args) {
		Outer.main(args);
	}
}
