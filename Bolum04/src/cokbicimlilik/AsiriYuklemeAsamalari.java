package cokbicimlilik;

// Asiri yukleme asamalari: 1) genisletme ve alt tip, 2) kutulama/kutudan
// cikarma, 3) degisken sayida arguman. Ilk asamada aday bulunursa digerlerine gecilmez.
public class AsiriYuklemeAsamalari {

	static void p(String s) { System.out.println(s); }

	static void f(long x)    { p("f(long)"); }
	static void f(Integer x) { p("f(Integer)"); }
	static void f(Object x)  { p("f(Object)"); }
	static void f(int... x)  { p("f(int...)"); }

	public static void main(String[] args) {
		byte b = 1;
		f(5);                    // f(long)
		f(b);                    // f(long)
		f(Integer.valueOf(5));   // f(Integer)
		f("x");                  // f(Object)
		f(2.5);                  // f(Object)
		f();                     // f(int...)
		f(1, 2);                 // f(int...)

		// Ornek Problem 4
		short s = 3;
		f(s);                    // f(long)
		f('A');                  // f(long)
		f(Long.valueOf(4));      // f(Object)
	}
}
