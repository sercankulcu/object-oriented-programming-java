import java.math.BigDecimal;
import java.util.Random;

// Aritmetik ornekleri: tamsayi bolmede sifir hatasi, double'da NaN/Infinity
// (hata yok), Math.addExact tasmasi, Random.nextInt(0), BigDecimal sifira bolme.
public class AritmetikOrnekleri {
	public static void main(String[] args) {
		try {
			int result = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);   // java.lang.ArithmeticException: / by zero
		}
		double dresult = Math.sqrt(-1);
		System.out.println(dresult);     // NaN
		System.out.println(10.0 / 0);    // Infinity
		try {
			int t = Math.addExact(Integer.MAX_VALUE, 1);
		} catch (ArithmeticException e) {
			System.out.println(e);   // java.lang.ArithmeticException: integer overflow
		}
		Random random = new Random(42);
		try {
			int randomNumber = random.nextInt(0);
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException: bound must be positive
		}
		BigDecimal num1 = new BigDecimal("10");
		BigDecimal num2 = BigDecimal.ZERO;
		try {
			BigDecimal bresult = num1.divide(num2);
		} catch (ArithmeticException e) {
			System.out.println(e);   // java.lang.ArithmeticException: Division by zero
		}
	}
}

/* Beklenen cikti:
java.lang.ArithmeticException: / by zero
NaN
Infinity
java.lang.ArithmeticException: integer overflow
java.lang.IllegalArgumentException: bound must be positive
java.lang.ArithmeticException: Division by zero
*/
