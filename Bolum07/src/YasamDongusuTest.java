import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Test yasam dongusu: @BeforeAll/@AfterAll bir kez, @BeforeEach/@AfterEach her testte calisir.
class YasamDongusuTest {

	@BeforeAll
	static void basla() { System.out.println("BeforeAll"); }

	@BeforeEach
	void hazirla() { System.out.println("  BeforeEach"); }

	@Test
	void testA() { System.out.println("    testA"); }

	@Test
	void testB() { System.out.println("    testB"); }

	@AfterEach
	void temizle() { System.out.println("  AfterEach"); }

	@AfterAll
	static void bitir() { System.out.println("AfterAll"); }

	public static void main(String[] args) {
		TestleriCalistir.calistir(YasamDongusuTest.class);
		// BeforeAll
		//   BeforeEach
		//     testA
		//   AfterEach
		//   BeforeEach
		//     testB
		//   AfterEach
		// AfterAll
	}
}
