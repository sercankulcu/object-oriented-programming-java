import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Basarisiz test: tumuNegatifDizi, DiziIslem.enBuyuk'teki hatayi yakalar (bilerek kalir).
class DiziIslemTest {

	@Test
	void pozitifDizi() {
		int[] dizi = {3, 9, 4};
		assertEquals(9, DiziIslem.enBuyuk(dizi));
	}

	@Test
	void tumuNegatifDizi() {
		int[] dizi = {-5, -2, -8};
		assertEquals(-2, DiziIslem.enBuyuk(dizi));
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(DiziIslemTest.class);
		// KALDI: tumuNegatifDizi() -> expected: <-2> but was: <0>
	}
}
