import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// QuickCheck fikri duz JUnit ile: 1000 rastgele metin icin "iki kez ters cevirmek ayni metni verir".
class OzellikTest {

	static String rastgeleMetin(Random r) {
		int uzunluk = r.nextInt(20);  // 0..19
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < uzunluk; i++) {
			sb.append((char) ('a' + r.nextInt(26)));
		}
		return sb.toString();
	}

	@Test
	void ikiKezTersCevirmekAyniMetniVerir() {
		Random r = new Random(42);    // sabit tohum
		for (int k = 0; k < 1000; k++) {
			String s = rastgeleMetin(r);
			String t = MetinIslem.ters(s);
			assertEquals(s, MetinIslem.ters(t));
		}
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(OzellikTest.class);   // 1 test (1000 girdi), 1 gecti
	}
}

/* Beklenen cikti:
[GECTI] OzellikTest > ikiKezTersCevirmekAyniMetniVerir()
---- Ozet ----
Bulunan test : 1
Gecen        : 1
Kalan        : 0
*/
