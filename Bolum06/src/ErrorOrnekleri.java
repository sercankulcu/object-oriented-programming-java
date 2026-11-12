// Error ornekleri: StackOverflowError, OutOfMemoryError ve assert.
// assert varsayilan olarak kapali (-ea yok); acik hali (-ea) AssertAcik sinifinda gosterilir.
public class ErrorOrnekleri {

	static void sonsuz() {
		sonsuz();          // durma kosulu yok
	}

	public static void main(String[] args) {
		try {
			sonsuz();
		} catch (StackOverflowError e) {
			System.out.println("SOE -> " + e);   // SOE -> java.lang.StackOverflowError
		}
		try {
			long[] dizi = new long[Integer.MAX_VALUE];
		} catch (OutOfMemoryError e) {
			System.out.println("OOM -> " + e);   // OOM -> java.lang.OutOfMemoryError: Requested array size exceeds VM limit
		}
		int yas = -5;
		assert yas >= 0 : "Yas negatif: " + yas;
		System.out.println("assert gecti");      // assert gecti (-ea olmadan)

		// java -ea ile calistirilsaydi: AssertionError: Yas negatif: -5
		ErrorOrnekleri.class.getClassLoader()
			.setClassAssertionStatus("AssertAcik", true);   // sinif yuklenmeden once
		try {
			AssertAcik.kontrol(yas);
		} catch (AssertionError e) {
			System.out.println(e);               // java.lang.AssertionError: Yas negatif: -5
		}
	}
}

// Assert'i yalnizca bu sinif icin acip -ea ile alinacak ikinci ciktiyi gostermek icin.
// Ust duzey sinif olmali: ic sinifin assert durumu dis siniftan gelir.
class AssertAcik {
	static void kontrol(int yas) {
		assert yas >= 0 : "Yas negatif: " + yas;
		System.out.println("assert gecti");
	}
}

/* Beklenen cikti:
SOE -> java.lang.StackOverflowError
OOM -> java.lang.OutOfMemoryError: Requested array size exceeds VM limit
assert gecti
java.lang.AssertionError: Yas negatif: -5
*/
