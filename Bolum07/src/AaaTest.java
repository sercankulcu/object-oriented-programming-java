import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// AAA duzeni: Hazirla (Arrange), Calistir (Act), Dogrula (Assert).
class AaaTest {

	@Test
	void cekmeBakiyeyiAzaltir() {
		// Hazirla (Arrange)
		BankaHesabi hesap = new BankaHesabi(100);
		// Calistir (Act)
		hesap.cek(30);
		// Dogrula (Assert)
		assertEquals(70.0, hesap.getBakiye(), 0.001);
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(AaaTest.class);   // 1 test, 1 gecti
	}
}

/* Beklenen cikti:
[GECTI] AaaTest > cekmeBakiyeyiAzaltir()
---- Ozet ----
Bulunan test : 1
Gecen        : 1
Kalan        : 0
*/
