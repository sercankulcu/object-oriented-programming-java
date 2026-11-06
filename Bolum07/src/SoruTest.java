import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Ornek problem 1: hangi test gecer, hangisi kalir? (b ve d bilerek kalir)
class SoruTest {
	@Test void a() { assertEquals(7, 3 + 4); }
	@Test void b() { assertEquals(0.3, 0.1 + 0.2); }
	@Test void c() { assertTrue("Java".length() == 4); }
	@Test void d() { assertThrows(ArithmeticException.class,
			() -> System.out.println(10 / 2)); }

	public static void main(String[] args) {
		TestleriCalistir.calistir(SoruTest.class);
		// a gecer; b kalir: expected: <0.3> but was: <0.30000000000000004>; c gecer;
		// d kalir: Expected java.lang.ArithmeticException to be thrown, but nothing was thrown. (5 yazar)
	}
}
