// throw ile istisna firlatma, CustomException ile kontrolEt, throw/throws
// karisikligi ve kontrol edilen istisnayi bildirmeyi unutmak.
public class ThrowOrnekleri {

	// Uygun Tipi Secmek ve throw: Kod Izleme (ayni metot)
	public static void kontrolEt(int deger)
			throws CustomException {
		if (deger < 0) {
			// Belirli bir durumu kontrol et ve istisna firlat
			throw new CustomException("Deger negatif olamaz!");
		}
		// Deger pozitifse, normal islem devam eder
		System.out.println("Deger uygun: " + deger);
	}

	// throw ve throws
	// if (x < 0) {
	//   throws new IllegalArgumentException("negatif");
	// }
	// derleme hatasi: illegal start of expression (throws degil throw olmali)
	static void g(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("negatif");
		}
	}

	// static void f(int x) {
	//   if (x < 0) throw new Exception("negatif");
	// }
	// derleme hatasi: unreported exception Exception;
	//   must be caught or declared to be thrown
	// Duzeltme: throws Exception ile bildir
	static void f(int x) throws Exception {
		if (x < 0) throw new Exception("negatif");
	}

	public static void main(String[] args) {
		// throw ile Firlatma
		// throw new Exception("Bu bir istisna durumu!");  (tek basina: kontrol edilen, bildirilmeli)
		try {
			throw new Exception("Bu bir istisna durumu!");
		} catch (Exception e) {
			System.out.println(e);   // java.lang.Exception: Bu bir istisna durumu!
		}

		try {
			kontrolEt(5);    // Deger uygun: 5
			kontrolEt(-3);
			kontrolEt(8);
		} catch (CustomException e) {
			System.out.println("Yakalandi: " + e.getMessage());   // Yakalandi: Deger negatif olamaz!
		}

		try {
			g(-1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException: negatif
		}
		try {
			f(-1);
		} catch (Exception e) {
			System.out.println(e);   // java.lang.Exception: negatif
		}
	}
}
