// Ornek problem 3: dal kapsami %100 icin en az iki test gerekir (negatif ve sifir/pozitif).
public class Mutlak {
	static int mutlak(int x) {
		if (x < 0) {
			return -x;
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println(mutlak(-3));   // 3
		System.out.println(mutlak(5));    // 5
		System.out.println(mutlak(0));    // 0
	}
}
