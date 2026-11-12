// Hata bildirmenin iki yolu: -1 gibi bir donus kodu (kontrol edilmezse
// baska yerde patlar) ve istisna firlatmak (gormezden gelinemez).
public class DonusKodu {

	// Donus Kodu: -1
	public static int indexOf(String[] isimler, String isim) {
		for (int i = 0; i < isimler.length; i++) {
			if (isimler[i].equals(isim)) {
				return i;
			}
		}
		return -1;
	}

	// Istisnalari Kullanin
	public static int bul(String[] isimler, String isim) {
		for (int i = 0; i < isimler.length; i++) {
			if (isimler[i].equals(isim)) {
				return i;
			}
		}
		throw new IllegalArgumentException("Bulunamadi: " + isim);
	}

	public static void main(String[] args) {
		String[] isimler = {"Ali", "Ayse", "Can"};
		System.out.println(indexOf(isimler, "Can"));   // 2
		int k = indexOf(isimler, "Ece");   // k = -1
		try {
			System.out.println(isimler[k]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);   // java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 3
		}

		try {
			System.out.println(bul(isimler, "Ece"));
		} catch (IllegalArgumentException e) {
			System.out.println("Hata: " + e.getMessage());   // Hata: Bulunamadi: Ece
		}
	}
}

/* Beklenen cikti:
2
java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 3
Hata: Bulunamadi: Ece
*/
