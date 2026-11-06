import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Parametreli testler: ayni test metodu her CSV satiri icin bir kez calisir,
// sinir degerleri tek metotla sinanir (junit-jupiter-params gerekir).
class NotTest {

	@ParameterizedTest
	@CsvSource({"0, FF", "49, FF", "50, CC", "59, CC",
				"60, CB", "89, BA", "90, AA", "100, AA"})
	void sinirDegerleri(int puan, String beklenen) {
		assertEquals(beklenen, Not.harfNotu(puan));
	}

	@Test
	void aralikDisiPuanReddedilir() {
		assertThrows(IllegalArgumentException.class,
			() -> Not.harfNotu(-1));
		assertThrows(IllegalArgumentException.class,
			() -> Not.harfNotu(101));
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(NotTest.class);
		// [GECTI] sinirDegerleri(int, String) > [1] 0, FF
		// ... [8] 100, AA ve aralikDisiPuanReddedilir() dahil 9 test, 9 gecti
	}
}
