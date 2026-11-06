package kalitim;

// Ornek problemler: yapici sirasi, super.yaz(), dinamik secim, static ve
// ornek ilklendirme bloklarinin this(...) ile birlikte calisma sirasi.
public class OrnekProblemler {

	static class A {
		A() { System.out.println("A"); }
		void yaz() { System.out.println("A.yaz"); }
	}

	static class B extends A {
		B() { System.out.println("B"); }
		@Override void yaz() { System.out.println("B.yaz"); }
	}

	static class C extends B {
		C() { super(); System.out.println("C"); }
		@Override void yaz() {
			super.yaz();
			System.out.println("C.yaz");
		}
	}

	// equals'i gecersiz kilmayan Ogrenci
	static class Ogrenci {
		private String ad;
		Ogrenci(String ad) { this.ad = ad; }
		String getAd() { return ad; }
	}

	// Ornek Problemler (2)
	static class Problem2 {
		static class A {
			static { System.out.print("As "); }
			{ System.out.print("Ab "); }
			A() { System.out.print("A "); }
		}
		static class B extends A {
			static { System.out.print("Bs "); }
			{ System.out.print("Bb "); }
			B() { this(0); System.out.print("B "); }
			B(int x) { System.out.print("B" + x + " "); }
		}
	}

	public static void main(String[] args) {
		C c = new C();                       // A B C (her biri ayri satirda)
		c.yaz();                             // B.yaz C.yaz
		A a = new B();                       // A B
		a.yaz();                             // B.yaz
		System.out.println(c instanceof A);  // true
		Ogrenci o1 = new Ogrenci("Ece");
		Ogrenci o2 = new Ogrenci("Ece");
		System.out.println(o1.equals(o2));   // false (Object'in equals'i referanslari karsilastirir)

		new Problem2.B();
		System.out.println();                // As Bs Ab A Bb B0 B
		new Problem2.B(7);
		System.out.println();                // Ab A Bb B7
	}
}
