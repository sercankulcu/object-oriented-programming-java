// Ornek problemler: finally ve return sirasi, catch secimi (NumberFormatException
// bir IllegalArgumentException'dir), yayilim ve dongu icinde istisna yakalama.
public class OrnekProblemler {

	// Ornek Problemler 1
	static int f() {
		try {
			System.out.print("A");
			int x = 5 / 0;
			System.out.print("B");
			return 1;
		} catch (ArithmeticException e) {
			System.out.print("C");
			return 2;
		} finally {
			System.out.print("D");
		}
	}

	// Ornek Problemler 2
	static void a() {
		System.out.print("a1 ");
		b();
		System.out.print("a2 ");
	}
	static void b() {
		System.out.print("b1 ");
		throw new IllegalStateException("!");
	}

	public static void main(String[] args) {
		System.out.println(" " + f());   // ACD 2

		try {
			String s = "12a";
			int n = Integer.parseInt(s);
			System.out.println("Sayi: " + n);
		} catch (IllegalArgumentException e) {
			System.out.println("IAE");          // IAE
		} catch (Exception e) {
			System.out.println("Exception");
		}

		try {
			a();
			System.out.print("m ");
		} catch (IllegalStateException e) {
			System.out.print("yakalandi" + e.getMessage());
		} finally {
			System.out.println(" son");          // a1 b1 yakalandi! son
		}

		// Ornek Problemler 3
		int[] d = {4, 0, 2};
		int toplam = 0;
		for (int i = 0; i <= d.length; i++) {
			try {
				toplam += 12 / d[i];
			} catch (ArithmeticException e) {
				toplam += 100;
			} catch (ArrayIndexOutOfBoundsException e) {
				toplam += 1000;
			}
		}
		System.out.println(toplam);   // 1109

		// finally calisir ama istisna yine de yukari gider; burada dis try yakalar
		try {
			try {
				throw new RuntimeException("X");
			} finally {
				System.out.println("F");   // F
			}
		} catch (RuntimeException e) {
			System.out.println(e);         // java.lang.RuntimeException: X
		}
	}
}

/* Beklenen cikti:
ACD 2
IAE
a1 b1 yakalandi! son
1109
F
java.lang.RuntimeException: X
*/
