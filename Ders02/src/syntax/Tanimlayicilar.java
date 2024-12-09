package syntax;

public class Tanimlayicilar {

	// Metot tanimlama
	void selamVer() { // "selamVer" adinda bir metot tanimlandi
		System.out.println("Merhaba, dunya!");
	}

	public static void main(String[] args) {

		// Degisken tanimlama
		int yas = 30; // "yas" adinda bir degisken tanimlandi

		// Sabit (final) tanimlama
		final double PI = 3.14159; // "PI" adinda bir sabit tanimlandi

		// Sinif tanimlama
		class Ogrenci { // "Ogrenci" adinda bir sinif tanimlandi
			String ad;
			String soyad;
		}

		// Etiket (label) kullanimi
		dongu: for (int i = 1; i <= 5; i++) {
			if (i == 3) {
				continue dongu; // "dongu" etiketini kullanarak donguyu atladi
			}
			System.out.println("Iterasyon " + i);
		}

		// Daha fazla tanimlayici kullanimi...
	}
}
