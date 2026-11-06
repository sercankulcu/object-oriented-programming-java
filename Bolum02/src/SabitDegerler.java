// Sabit degerler (literals) ve ondalik sayilarin hassasligi.
public class SabitDegerler {

	// Sabit Degerler
	static void sabitDegerler() {
		System.out.println(2.5e3);        // 2500.0
		System.out.println(7.68e-2);      // 0.0768
		System.out.println(1_000_000);    // 1000000
		System.out.println(0x1F);         // 31
		System.out.println(0b1010);       // 10
		System.out.println(3000000000L);  // 3000000000
		System.out.println("Ali\tVeli\n\"Java\"");  // Ali<sekme>Veli / "Java"
	}

	// Ondalik Sayilarin Hassasligi
	static void hassaslik() {
		System.out.println(1.0 / 3.0);                // 0.3333333333333333
		System.out.println(1.0/3 + 1.0/3 + 1.0/3);    // 1.0
		System.out.println(0.1 + 0.2);                // 0.30000000000000004
		System.out.println(0.1 + 0.2 == 0.3);         // false
		double t = 0.0;
		for (int i = 0; i < 10; i++) t += 0.1;
		System.out.println(t);                        // 0.9999999999999999
		double fark = (0.1 + 0.2) - 0.3;
		System.out.println(Math.abs(fark) < 1e-9);    // true
	}

	public static void main(String[] args) {
		sabitDegerler();
		hassaslik();
	}
}
