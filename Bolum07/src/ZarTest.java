import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Ayni tohumla kurulan iki zar 100 atista da ayni sonucu verir: test her calismada ayni sonuclanir.
class ZarTest {

	@Test
	void ayniTohumAyniSonuclar() {
		Zar z1 = new Zar(new Random(42));
		Zar z2 = new Zar(new Random(42));
		for (int i = 0; i < 100; i++) {
			assertEquals(z1.at(), z2.at());
		}
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(ZarTest.class);   // 1 test, 1 gecti
	}
}
