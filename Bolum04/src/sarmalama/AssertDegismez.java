package sarmalama;

// assert ile degismezi denetlemek: assert yalnizca java -ea ile
// calisir; -ea olmadan hata gorulmez, program "bitti" yazar.
public class AssertDegismez {

	static class Sayac {
		private int deger;   // degismez: 0 <= deger <= 9
		void arttir() {
			deger = deger + 1;   // hata: 9'dan sonra 10
			assert deger >= 0 && deger <= 9 : "deger=" + deger;
		}
	}

	public static void main(String[] args) {
		// main icinde:
		Sayac s = new Sayac();
		try {
			for (int i = 0; i < 10; i++) s.arttir();
			System.out.println("bitti");          // bitti (-ea olmadan)
		} catch (AssertionError e) {
			// -ea ile: Exception in thread "main" java.lang.AssertionError: deger=10
			System.out.println(e);
		}
	}
}
