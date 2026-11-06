import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Istisnalari test etmek: assertThrows istisnayi dondurur, mesaji da denetlenebilir.
// yanlisBeklenti bilerek kalir: cek(50) istisna firlatmaz.
class BankaIstisnaTest {

	@Test
	void fazlaCekmeMesajiDogru() {
		BankaHesabi hesap = new BankaHesabi(100);
		IllegalStateException e = assertThrows(
			IllegalStateException.class, () -> hesap.cek(500));
		assertEquals("Yetersiz bakiye", e.getMessage());
	}

	@Test
	void negatifYatirmaReddedilir() {
		BankaHesabi hesap = new BankaHesabi(100);
		assertThrows(IllegalArgumentException.class,
			() -> hesap.yatir(-10));
	}

	@Test
	void yanlisBeklenti() {
		BankaHesabi hesap = new BankaHesabi(100);
		assertThrows(IllegalStateException.class,
			() -> hesap.cek(50));
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(BankaIstisnaTest.class);
		// KALDI: yanlisBeklenti() -> Expected java.lang.IllegalStateException to be thrown, but nothing was thrown.
	}
}
