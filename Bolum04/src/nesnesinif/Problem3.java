package nesnesinif;

// Ornek problem 3: static blok sinif ilk kullanildiginda bir kez,
// ornek ilklendirici ve yapici her nesnede calisir.
public class Problem3 {

	static class A {
		static { System.out.print("S"); }
		{ System.out.print("I"); }
		A() { System.out.print("C"); }
	}

	public static void main(String[] args) {
		System.out.print("M");
		new A();
		new A();
		System.out.println();   // MSICIC
	}
}
