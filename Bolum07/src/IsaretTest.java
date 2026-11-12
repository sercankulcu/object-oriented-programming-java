import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Iki test de gecer ama isaret(0) dali hic sinanmaz: kapsam %100 degildir.
class IsaretTest {
	@Test
	void pozitif() {
		assertEquals("pozitif", Isaret.isaret(5));
	}

	@Test
	void negatif() {
		assertEquals("negatif", Isaret.isaret(-3));
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(IsaretTest.class);   // 2 test, 2 gecti
	}
}

/* Beklenen cikti:
[GECTI] IsaretTest > pozitif()
[GECTI] IsaretTest > negatif()
---- Ozet ----
Bulunan test : 2
Gecen        : 2
Kalan        : 0
*/
