package soyutsiniflar;

// Ornek problemler: soyut sinif ve arayuz kurallari (derlenir mi?) ve
// default metodun kalitimla alinmasi (cikti nedir?).
public class OrnekProblemler {

	// (a) Derlenir: soyut metodu olmayan soyut sinif gecerlidir
	abstract static class A {
		void f() { System.out.println("f"); }
	}

	// (b) class B { abstract void g(); }
	// derleme hatasi: B is not abstract and does not override abstract method g() in B

	// (c) Derlenir, ama I.X++ derlenmez
	interface I { int X = 1; }
	// ...  I.X++;
	// derleme hatasi: cannot assign a value to static final variable X

	// (d) interface J { void h(); }
	//     class C implements J { void h() { } }
	// derleme hatasi: h() in C cannot implement h() in J
	//   attempting to assign weaker access privileges; was public
	interface J { void h(); }
	static class C implements J { public void h() { System.out.println("C.h"); } }

	// (e) Derlenir: E de soyut oldugu icin k()'yi yazmak zorunda degil
	abstract static class D { abstract void k(); }
	abstract static class E extends D { }

	// Ornek Problemler (2)
	interface Sesli {
		default String ses() { return "..."; }
	}

	abstract static class Hayvan implements Sesli {
		Hayvan() { System.out.print("H "); }
		abstract String ad();
	}

	static class Kedi extends Hayvan {
		Kedi() { System.out.print("K "); }
		String ad() { return "kedi"; }
		public String ses() { return "miyav"; }
	}

	static class Balik extends Hayvan {
		String ad() { return "balik"; }
	}

	public static void main(String[] args) {
		// new A(); new E();  derleme hatasi: soyut siniftan nesne olmaz
		new A() { }.f();                // f   (anonim alt sinif ile)
		System.out.println(I.X);        // 1
		new C().h();                    // C.h
		new E() { void k() { System.out.println("k"); } }.k();   // k

		Hayvan[] d = { new Kedi(), new Balik() };
		System.out.println();
		for (Hayvan h : d)
			System.out.println(h.ad() + ": " + h.ses());
		// H K H
		// kedi: miyav
		// balik: ...

		// Sesli s = new Balik(); s.ad();
		// derleme hatasi: cannot find symbol (Sesli yalnizca ses()'i bilir)
	}
}

/* Beklenen cikti:
f
1
C.h
k
H K H
kedi: miyav
balik: ...
*/
