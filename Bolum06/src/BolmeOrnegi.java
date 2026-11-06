// try-catch akisi: hata olusunca try'in kalani atlanir, catch calisir,
// program catch'ten sonra devam eder.
public class BolmeOrnegi {
	public static void main(String[] args) {
		int pay = 10, payda = 0;
		System.out.println("Basla");                   // Basla
		try {
			System.out.println("Bolme oncesi");        // Bolme oncesi
			int sonuc = pay / payda;
			System.out.println("Sonuc: " + sonuc);
		} catch (ArithmeticException e) {
			System.out.println("Hata: " + e.getMessage()); // Hata: / by zero
		}
		System.out.println("Bitti");                   // Bitti
	}
}
