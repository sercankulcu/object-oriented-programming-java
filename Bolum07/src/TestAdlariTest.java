import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Davranisi anlatan test adlari: test1 bir sey soylemez, altiUrundeIndirimVar soyler.
// Sunumda yalnizca test adlari var; govdeler icin kucuk bir Sepet sinifi eklendi.
class TestAdlariTest {

	// Yardimci: 6 ve daha fazla urunde indirim uygulanir
	static class Sepet {
		private int urunSayisi;
		void ekle(int adet) { urunSayisi += adet; }
		boolean indirimVar() { return urunSayisi >= 6; }
	}

	@Test void test1() {                       // kotu ad: neyi sinadigi belli degil
		Sepet s = new Sepet();
		s.ekle(6);
		assertTrue(s.indirimVar());
	}
	@Test void altiUrundeIndirimVar() {        // iyi ad: davranisi anlatir
		Sepet s = new Sepet();
		s.ekle(6);
		assertTrue(s.indirimVar());
	}
	@Test void besUrundeIndirimYok() {
		Sepet s = new Sepet();
		s.ekle(5);
		assertFalse(s.indirimVar());
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(TestAdlariTest.class);   // 3 test, 3 gecti
	}
}

/* Beklenen cikti:
[GECTI] TestAdlariTest > test1()
[GECTI] TestAdlariTest > besUrundeIndirimYok()
[GECTI] TestAdlariTest > altiUrundeIndirimVar()
---- Ozet ----
Bulunan test : 3
Gecen        : 3
Kalan        : 0
*/
