import org.junit.Test; 
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/*
 * Java'da JUnit testleri:
 * 
 * Eclipse Properties -> Java Build Path -> Libraries -> Add Library -> JUnit -> JUnit 3/4
 * 
 * */

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@BeforeEach
	public void setUp() {
		// Calculator nesnesini her testten once olustur
		calculator = new Calculator();
	}

	@Test
	public void testAdd() {
		// Toplama islemini test et
		assertEquals(5, calculator.add(2, 3)); // 2 + 3 = 5
		assertEquals(-1, calculator.add(-2, 1)); // -2 + 1 = -1
		assertEquals(0, calculator.add(-2, 2)); // -2 + 2 = 0
	}

	@Test
	public void testSubtract() {
		// Cikarma islemini test et
		assertEquals(1, calculator.subtract(3, 2)); // 3 - 2 = 1
		assertEquals(-3, calculator.subtract(-2, 1)); // -2 - 1 = -3
		assertEquals(0, calculator.subtract(2, 2)); // 2 - 2 = 0
	}

	@Test
	public void testMultiply() {
		// Carpma islemini test et
		assertEquals(6, calculator.multiply(2, 3)); // 2 * 3 = 6
		assertEquals(-2, calculator.multiply(-2, 1)); // -2 * 1 = -2
		assertEquals(0, calculator.multiply(0, 2)); // 0 * 2 = 0
	}

	@Test
	public void testDivide() {
		// Bolme islemini test et
		assertEquals(2, calculator.divide(6, 3)); // 6 / 3 = 2
		assertEquals(-2, calculator.divide(-4, 2)); // -4 / 2 = -2

		// Sifira bolme hatasini test et
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			calculator.divide(1, 0); // 1 / 0 -> Hata
		});

		// Hata mesajinin dogrulugunu kontrol et
		assertEquals("Sifira bolme yapilamaz.", exception.getMessage());
	}

	@Test
	public void testModulus() {
		// Modulus islemini test et
		assertEquals(1, calculator.modulus(5, 2)); // 5 % 2 = 1
		assertEquals(0, calculator.modulus(4, 2)); // 4 % 2 = 0
		assertEquals(-1, calculator.modulus(-5, 2)); // -5 % 2 = -1
		assertEquals(0, calculator.modulus(0, 5)); // 0 % 5 = 0
	}

	@Test
	public void testFactorial() {
		// Faktoriyel islemini test et
		assertEquals(120, calculator.factorial(5)); // 5! = 120
		assertEquals(1, calculator.factorial(0)); // 0! = 1
		assertEquals(1, calculator.factorial(1)); // 1! = 1
		assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1)); // -1! -> Hata
	}

	@Test
	public void testMax() {
		// En buyuk sayiyi test et
		assertEquals(5, calculator.max(3, 5)); // max(3, 5) = 5
		assertEquals(-3, calculator.max(-3, -5)); // max(-3, -5) = -3
		assertEquals(7, calculator.max(7, 7)); // max(7, 7) = 7
	}

	@Test
	public void testMin() {
		// En kucuk sayiyi test et
		assertEquals(3, calculator.min(3, 5)); // min(3, 5) = 3
		assertEquals(-5, calculator.min(-3, -5)); // min(-3, -5) = -5
		assertEquals(7, calculator.min(7, 7)); // min(7, 7) = 7
	}

	@Test
	public void testAverage() {
		// Ortalama islemini test et
		assertEquals(3.0, calculator.average(2, 4), 0.001); // average(2, 4) = 3.0
		assertEquals(5.5, calculator.average(5, 6), 0.001); // average(5, 6) = 5.5
		assertEquals(-2.0, calculator.average(-4, -0), 0.001); // average(-4, 0) = -2.0
	}

	@Test
	public void testPower() {
		// Us alma islemini test et
		assertEquals(8, calculator.power(2, 3), 0.001); // 2^3 = 8
		assertEquals(1, calculator.power(5, 0), 0.001); // 5^0 = 1
		assertEquals(-8, calculator.power(-2, 3), 0.001); // (-2)^3 = -8
		assertEquals(0.25, calculator.power(2, -2), 0.001); // 2^-2 = 0.25
	}

	@Test
	public void testSqrt() {
		// Karekok islemini test et
		assertEquals(3, calculator.squareRoot(9), 0.001); // sqrt(9) = 3
		assertEquals(2, calculator.squareRoot(4), 0.001); // sqrt(4) = 2

		// Negatif sayi icin hata bekle
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			calculator.squareRoot(-4); // sqrt(-4) -> Hata
		});

		// Hata mesajinin dogrulugunu kontrol et
		assertEquals("Negatif sayilarin karekoku hesaplanamaz.", exception.getMessage());
	}
}
