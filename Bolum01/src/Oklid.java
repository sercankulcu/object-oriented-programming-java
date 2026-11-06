// Oklid algoritmasi: EBOB(48, 18) kalanlarla bulunur.
public class Oklid {
	public static void main(String[] args) {
		int a = 48, b = 18;   // a >= b
		int r = a % b;        // kalan
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		System.out.println("EBOB = " + b);  // EBOB = 6
	}
}
