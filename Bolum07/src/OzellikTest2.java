import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Ozellik testi DiziIslem.enBuyuk'un ilk surumundeki hatayi bulur (bilerek kalir):
// butun elemanlari negatif bir dizide sonuc dizide yoktur.
class OzellikTest2 {

	@Test
	void enBuyukDizininEnBuyukElemanidir() {
		Random r = new Random(7);
		for (int k = 0; k < 1000; k++) {
			int[] dizi = new int[1 + r.nextInt(5)];
			for (int i = 0; i < dizi.length; i++) {
				dizi[i] = r.nextInt(201) - 100;     // -100..100
			}
			int enb = DiziIslem.enBuyuk(dizi);
			boolean dizideVar = false;
			for (int x : dizi) {
				assertTrue(enb >= x);               // ozellik 1
				if (x == enb) dizideVar = true;
			}
			assertTrue(dizideVar,                   // ozellik 2
				"Karsi ornek: " + Arrays.toString(dizi));
		}
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(OzellikTest2.class);
		// KALDI: enBuyukDizininEnBuyukElemanidir() -> Karsi ornek: [-60, -69, -39, -65, -13] ==> expected: <true> but was: <false>
	}
}

/* Beklenen cikti:
[KALDI] OzellikTest2 > enBuyukDizininEnBuyukElemanidir()
---- Ozet ----
Bulunan test : 1
Gecen        : 0
Kalan        : 1
  KALDI: enBuyukDizininEnBuyukElemanidir() -> Karsi ornek: [-60, -69, -39, -65, -13] ==> expected: <true> but was: <false>
*/
