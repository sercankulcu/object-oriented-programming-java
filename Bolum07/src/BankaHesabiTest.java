import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// @BeforeEach: her testten once yeni bir hesap hazirlanir; testler birbirini etkilemez.
class BankaHesabiTest {
	private BankaHesabi hesap;

	@BeforeEach
	void hazirla() {
		hesap = new BankaHesabi(100);
	}

	@Test
	void yatirmaBakiyeyiArtirir() {
		hesap.yatir(50);
		assertEquals(150.0, hesap.getBakiye(), 0.001);
	}

	@Test
	void fazlaCekmeIstisnaFirlatir() {
		assertThrows(IllegalStateException.class,
			() -> hesap.cek(500));
		assertEquals(100.0, hesap.getBakiye(), 0.001);
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(BankaHesabiTest.class);   // 2 test, 2 gecti
	}
}
